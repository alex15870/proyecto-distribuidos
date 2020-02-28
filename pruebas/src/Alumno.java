/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;

/**
 *
 * @author migue
 */
public class Alumno implements Serializable{
    private int edad;
    private String nombre;
    private String salon;

    public Alumno(int edad, String nombre, String salon) {
        this.edad = edad;
        this.nombre = nombre;
        this.salon = salon;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSalon() {
        return salon;
    }

    @Override
    public String toString() {
        return "Alumno{" + "edad=" + edad + ", nombre=" + nombre + ", salon=" + salon + '}';
    }
    
    
    
    
}
