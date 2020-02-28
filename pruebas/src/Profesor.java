
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;

/**
 *
 * @author dell
 */
public class Profesor implements Serializable
{
    
    private int edad;
    private String nombre;
    private String salon;

    public Profesor(String nombre, int edad, String salon) {
        this.edad = edad;
        this.nombre = nombre;
        this.salon = salon;
    }
    
    

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }
    
    

    
    
}
