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
public class Carta {
    private int palo;
    private int numero;
       
    public Carta (int numero, int palo){
        this.setNumero(numero);
        this.setPalo(palo);
    }
    protected void setNumero(int numero){
        this.numero = numero;
    }
    protected void setPalo(int palo){
        this.palo = palo;
    }
    public int getPalo (){
        return this.palo;
    }
    public int getNumero (){
        return this.numero;
    }
}
