
package com.miguel.mongodbconector;

/**
 *
 * @author MIGUEL ACOSTA
 */
public class Persona {
    
    
    String nombre;
    String pellido;
    
    public Persona(String nombre, String pellido) {
        this.nombre = nombre;
        this.pellido = pellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPellido() {
        return pellido;
    }

    public void setPellido(String pellido) {
        this.pellido = pellido;
    }
    
    
    
    
}
