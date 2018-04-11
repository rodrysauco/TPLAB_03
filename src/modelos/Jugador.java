/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author usuario
 */
public class Jugador extends Persona{
    
    private int puntos;
    private Carta carta;
    private Mesa mesa;
    
    public Jugador(String name, String surname, int edad) {
        super(name, surname, edad);
        this.puntos = 0;
    }
    protected void setPuntos(int punto){
        this.puntos = punto;
    }
    public int getPuntos (){
        return this.puntos;
    }
    private void setCarta(Carta cartita){
        this.carta = cartita;
    }
    public Carta getCarta(){
        return this.carta;
    }
    public void agarrarCarta(Carta carta){
       setCarta(carta);
       setPuntos(getPuntos() + carta.getNumero());
    }
    public void setMesa(Mesa mesa){
        this.mesa = mesa;
    }
    
    @Override
    public void run(){
        while(this.mesa.getStatus() == true){
            this.mesa.addPlayer(this);
            Carta aux = this.mesa.agarrar();
            if(aux != null){
                agarrarCarta(aux);
            }
        }
    }
}
