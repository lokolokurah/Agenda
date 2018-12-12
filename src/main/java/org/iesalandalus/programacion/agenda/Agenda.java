/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.agenda;

import javax.naming.OperationNotSupportedException;

/**
 *
 * @author Jaime
 */
//Creada la clase Agenda + Atributos
public class Agenda 
{   
    private static final int MAX_CONTACTOS = 10; 
    private int numContactos=0; 
    private Contacto [] agenda=null;
    
    //P.dfcto
    public Agenda()
    {
        numContactos=10;  
        agenda = new Contacto[MAX_CONTACTOS];
    }
    
    public Contacto[] getContactos()
     {
 
         Contacto[] copiaAgenda = agenda.clone();
        
         return copiaAgenda;
     }      
     
    public int getNumContactos() {
         numContactos=0;
         for (int i=0;i<agenda.length;i++)
         {
             numContactos++;
         }
         return numContactos;
     }
     
    public void añadir(Contacto contacto) throws OperationNotSupportedException
     {
         
         int i;
                 
            try  {i=buscarPrimerIndiceComprobandoExistencia(contacto);
            
                 if (indiceNoSuperaTamano(i))
                 {
                 this.agenda[i] = contacto;
                 }
         
                 else
                     
                 { throw new OperationNotSupportedException("El array de contactos está lleno.");}
                 
                 }catch (OperationNotSupportedException e) {
                     System.out.println("Ya existe un contacto con ese nombre.");
                     e.getMessage();} 
         
     }    
            
    private int buscarPrimerIndiceComprobandoExistencia(Contacto contactoYaExistente) throws OperationNotSupportedException
     {
         int indiceLibre=0;
         boolean encontradoContacto=false;
         
         for(int i=0;i<agenda.length && !encontradoContacto;i++)
         {
             if (agenda[i]==null)
             {
                 encontradoContacto=true;
                 indiceLibre=i;
             }
             else if (agenda[i].equals(contactoYaExistente))
             {
                 throw new OperationNotSupportedException("Ya existe un contacto con ese nombre.");
             }               
         }
         
         return indiceLibre;
     }
    
    private boolean indiceNoSuperaTamano(int i) {
 
         boolean noSuperaTamano = false;
         if (i < MAX_CONTACTOS) {
             noSuperaTamano = true;
         } else {
             noSuperaTamano = false;
         }
         return noSuperaTamano;
     }
    
    public Contacto buscar(String nombre) {
 
         int i;
         Contacto aBuscar = null;
         i = buscarIndiceCliente(nombre);
         if (i < MAX_CONTACTOS+1) {
             aBuscar = agenda[i];
             System.out.println("El contacto encontrado: " + nombre);
             return aBuscar;
         } else {
             System.out.println("No se encuentra el contacto");
         }
         return aBuscar;
     }
    
    private int buscarIndiceCliente(String cliente) {
 
         
         int i = 0;
         for (Contacto contacto:agenda) {
             if (contacto.getNombre().equals(cliente)) {
                 return i;
             }
            i++;
        }
            return MAX_CONTACTOS+1;
    }
    
}
