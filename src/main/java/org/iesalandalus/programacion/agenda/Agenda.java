/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.agenda;

import javax.naming.OperationNotSupportedException;
import utilidades.Entrada;

/**
 *
 * @author Jaime
 */
//Creada la clase Agenda + Atributos
public class Agenda 
{   
    private static final int MAX_CONTACTOS = 10; 
    private int numContactos=0; 
    private Contacto [] agenda;
    
    //P.dfcto
    public Agenda()
    { 
        agenda = new Contacto[MAX_CONTACTOS];
    }
    
    public Contacto[] getContactos()
     {
         Contacto[] copiaAgenda = agenda.clone();
         return copiaAgenda;
     }      
     
    public int getNumContactos() {
         numContactos=0;
         for (int i=0;i<agenda.length && agenda[i]!=null;i++)
         {
             numContactos++;
         }
         return numContactos;
     }
     
    public void anadir(Contacto contacto) throws OperationNotSupportedException
     {  
         int i; 
            try  {
                i=buscarPrimerIndiceComprobandoExistencia(contacto);
                }
           catch(OperationNotSupportedException e)
                {
                throw new OperationNotSupportedException("Ya existe un contacto con ese nombre.");
                }
                 if (indiceNoSuperaTamano(i))
                 {
                 this.agenda[i] = contacto;
                 }
                 else   
                 { throw new OperationNotSupportedException("El array de contactos está lleno.");}
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
    
    public Contacto buscar(String nombre)  
    { 
         int i;
         i=buscarIndiceCliente(nombre);
         Contacto aBuscar = null;
         if (i==-1) return null;
        else
             aBuscar = agenda[i];
             System.out.println("El contacto se encuentra en la posición "+i);
             return aBuscar;
     }
    
    private int buscarIndiceCliente(String nombreContacto) 
    {
         int indice=-1;
        
        for(int i=0;i<agenda.length;i++)
        {
            if (agenda[i].getNombre()!=null && agenda[i].getNombre().equals(nombreContacto))
                return indice=i;            
        }
        return indice;
    }
    
    public void borrar(String contacto) throws OperationNotSupportedException {   
        int i;
        //Usare el metodo de buscarIndiceCliente
        i = buscarIndiceCliente(contacto);
        if (i < MAX_CONTACTOS+1) {
            agenda[i] = null;
            desplazarUnaPosicionHaciaIzquierda(i);
        } else {
            throw new OperationNotSupportedException("El contacto que quieres borrar no existe.");
        }
    }
     private void desplazarUnaPosicionHaciaIzquierda(int posicion) {
        for (int i=posicion; posicion<MAX_CONTACTOS -1 && agenda[i] != null;i++) {
            agenda[i] = agenda[i+1];
        }
    } 
}
