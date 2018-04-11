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
public abstract class Persona extends Thread{
    private String name;
    private String surname;
    private int edad;
    
    public Persona(String name, String surname, int edad){
        this.edad = edad;
        this.name = name;
        this.surname = surname;
    }
    
    public String getname(){
        return this.name;
    }
}
