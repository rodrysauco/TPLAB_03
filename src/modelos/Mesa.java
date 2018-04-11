/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import persistencia.MYSQL;

/**
 *
 * @author usuario
 */
public class Mesa implements Observer{
    private boolean mesaAbierta;
    private Carta cartaEnMesa;
    private Repartidor repartidor;
    private List <Jugador> jugadores;
    private MYSQL persistencia;
        
    public Mesa (Repartidor repartidor){
        this.repartidor = repartidor;
        this.mesaAbierta = true;
        this.jugadores = new ArrayList();
        this.persistencia = MYSQL.getInstance();
    }
    public boolean getStatus(){
        return this.mesaAbierta;
    }
    public synchronized void repartir(){
        while(cartaEnMesa != null){
            try {
                wait();
            } catch (InterruptedException ex) {
                System.err.println(""+ ex.getMessage());
            }
        }
        this.cartaEnMesa = repartidor.repartir();
        notifyAll();
    }
    public synchronized Carta agarrar(){
        Carta aDevolver = null;
        while(cartaEnMesa == null){
            try {
                Thread.sleep(50);
                wait();
            } catch (InterruptedException ex) {
                System.err.println(""+ ex.getMessage());
            }
        }
        if(mesaAbierta){
            aDevolver = this.cartaEnMesa;
            this.cartaEnMesa = null;
            notifyAll();
        }
        return aDevolver;
    }
    public void addPlayer(Jugador a){
        this.jugadores.add(a);
    }
    public void selectingWinner(){
        Jugador aux = new Jugador("aux","aux",1);
        for(Jugador a : this.jugadores){
            if(aux.getPuntos()< a.getPuntos()){
                aux = a;
            }
        }
        System.out.println("Ganó "+aux.getname()+" con "+aux.getPuntos()+" puntos");
        if(aux.getname().compareTo("aux") != 0 ){
            System.out.println("Guardando");
            this.persistencia.guardarWinner(aux);
        }
    }
    @Override
    public void update(Observable o, Object arg) {
        
        if (arg instanceof Boolean){
            Boolean a = (Boolean) arg;
            this.mesaAbierta = a.booleanValue();
            if(a.booleanValue() == false){
              selectingWinner();
            }
        }
    }
}
