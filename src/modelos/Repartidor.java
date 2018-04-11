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
public class Repartidor extends Persona{
    
    private Mazo mazo;
    private Mesa mesa;
    
    public Repartidor(String name, String surname, int edad) {
        super(name, surname, edad);
    }
    public void setMazo(Mazo mazo){
        this.mazo = mazo;
    }
    public void setMesa(Mesa mesa){
        this.mesa = mesa;
    }
    public Carta repartir (){
        Carta rta = null;
        if(!mazo.isEmpty()){
            rta = mazo.getCarta();
        }
        return rta;
    }
    
    @Override
    public void run(){
        while(!mazo.isEmpty()){
            System.out.println("Reparte, quedan "+ mazo.size());
            this.mesa.repartir();
        }
        
    }
}
