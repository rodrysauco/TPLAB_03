/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Stack;

/**
 *
 * @author usuario
 */
public class Mazo extends Observable{
    private List<Carta> cartas;

    public Mazo(){
        this.cartas = new ArrayList();
        int p;
        for (p = 1; p<5; p++){
            int n;
            for(n=1; n<13;n++){
                Carta carta = new Carta (n,p);
                this.cartas.add(carta);
            }
        }
        this.mezclar();
    }
    protected void mezclar (){
        ArrayList<Carta> aux = new ArrayList<>();
        while(!cartas.isEmpty()) {
            int loc=(int)(Math.random()*cartas.size());
            aux.add(cartas.get(loc));
            cartas.remove(loc);   
        }
       this.cartas = aux;
    }
    public Carta getCarta (){
        Carta aux = this.cartas.remove(this.cartas.size()-1);
        return aux;
    }
    public int size(){
        return this.cartas.size();
    }
    public boolean isEmpty(){
        setChanged();
        notifyObservers(!this.cartas.isEmpty());
        return this.cartas.isEmpty();
    }
}