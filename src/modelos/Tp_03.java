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
public class Tp_03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mazo mazo = new Mazo();
        Repartidor repartidor = new Repartidor("Don","Cangrejo",23);
        Mesa mesa = new Mesa(repartidor);
        repartidor.setMazo(mazo);
        repartidor.setMesa(mesa);
        mazo.addObserver(mesa);
        repartidor.start();
        Jugador a = new Jugador("A","A",1);
        Jugador b = new Jugador("B","B",1);
        Jugador c = new Jugador("C","C",1);
        Jugador d = new Jugador("D","D",1);
        a.setMesa(mesa);
        b.setMesa(mesa);
        c.setMesa(mesa);
        d.setMesa(mesa);
        a.start();
        b.start();
        c.start();
        d.start();
                
    }
    
}
