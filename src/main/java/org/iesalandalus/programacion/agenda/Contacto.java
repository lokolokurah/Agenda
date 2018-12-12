/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.agenda;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 *
 * @author Jaime
 */
//Clase contacto + Atributos
public class Contacto 
{
    private final String ER_TELEFONO="[69][0-9]{8}";
    private final String ER_CORREO="([a-zA-z0-9.-_]{1,})(\\@[a-zA-z]{1,})(\\.[a-z]{2,3})";
    private String nombre;
    private String telefono;
    private String correo;
 
    public Contacto(String nombre, String telefono, String correo)
    {
        setNombre(nombre);
        setTelefono(telefono);
        setCorreo(correo);
    }
    
     public String getNombre() {
        return nombre;
    }
     
     private void setNombre(String nombre) {
       if (nombre == null || nombre.length()<1) { throw new IllegalArgumentException("El nombre de un contacto no puede ser nulo o vacío.");}
 
                {
                   this.nombre = nombre; 
                   this.nombre = nombre.replaceAll("\\s{2,}", " ").trim(); 
                }  
    }
     
     public String getTelefono() {
        return telefono;
    }
     
     public void setTelefono(String telefono) {
        if (telefono == null || telefono.length()<1) { throw new IllegalArgumentException("El teléfono de un contacto no puede ser nulo o vacío.");}
        else if (telefono.matches(ER_TELEFONO))
                {
                   this.telefono = telefono; 
                 }  
         else 
                 {
                     throw new IllegalArgumentException("El teléfono no tiene un formato válido.");
                 }
    }
     public String getCorreo() {
        return correo;
    }
     
     public void setCorreo(String correo) {
         if (correo == null || correo.length()<1) { throw new IllegalArgumentException("El correo de un contacto no puede ser nulo o vacío."); }
         else if (correo.matches(ER_CORREO))
                 {
                     this.correo = correo;
                 }
         else 
                 {
                     throw new IllegalArgumentException("El correo no tiene un formato válido.");
                 } 
     }
     
     @Override
    public String toString() {
        String iniciales = getIniciales(nombre.toUpperCase());
        return iniciales+" ["+telefono + ", " + correo + ']';     
    }
    
    public String getIniciales(String nombre)
    {
        String []palabra=nombre.split(" ");
         String iniciales="";
         for (int i=0;i<palabra.length;i++)
             
         {iniciales+=palabra[i].charAt(0);}
         return iniciales;
    }
    
      @Override
     public int hashCode() {
         int hash = 3;
         hash = 53 * hash + Objects.hashCode(this.nombre);
         hash = 53 * hash + Objects.hashCode(this.telefono);
         hash = 53 * hash + Objects.hashCode(this.correo);
         return hash;
     }
    
     @Override
    public boolean equals(Object obj) {
         if (this == obj) {
             return true;
         }
         if (obj == null) {
             return false;
         }
         if (getClass() != obj.getClass()) {
             return false;
         }
         final Contacto other = (Contacto) obj;
         if (!Objects.equals(this.nombre.toUpperCase(), other.nombre.toUpperCase())) {
             return false;
         }
 
         return true;
    }
}
