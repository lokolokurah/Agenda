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
    private static final String MENSAJE_EXCEPCION = " Debería haber saltado la excepción. ";
    private static final String MENSAJE_NO_EXCEPCION = " No debería haber saltado la excepción. ";
    
    private static final int MAX_CONTACTOS = 5; 
    private int numContactos; 
    private Contacto [] contactos;
    
    //P.dfcto
     public Agenda()
    {
        contactos = new Contacto[MAX_CONTACTOS];
    }
     
     public void anadir(Contacto contacto)
        {
             int indice;
             try {
                indice = buscarPrimerIndiceComprobandoExistencia(contacto);
                if(indiceNoSuperaTamano(indice)) {
                    this.contactos[indice] = contacto;
                } else {
                    throw new IllegalArgumentException( " El array está lleno " );
                }
                } catch (OperationNotSupportedException e) {
                    System.out.println(" Operación  no soportada ");
                    e.getMessage();
                }   
        }
            
        private int buscarPrimerIndiceComprobandoExistencia(Contacto contacto) throws OperationNotSupportedException
        {
            int indice=0;
            boolean encontradoContacto=false;
             for(int i=0;i<contactos.length && !encontradoContacto;i++)
            {
                if (contactos[i]==null)
                {
                    encontradoContacto=true;
                    indice = i;
                }
                else if (contactos[i].equals(contacto))
                {
                    throw new OperationNotSupportedException(" Ya existe un contacto con ese nombre. ");
                }               
            }
             return indice;
        }
        
         private boolean indiceNoSuperaTamano(int i)
        {
            if (i<MAX_CONTACTOS)
                return true;
           else
                return false;     
        }
        
        public Agenda buscar(Contacto contacto)
        {
            contacto.getNombre();
            if(contacto.getNombre()!=null)
                    {
                        System.out.println(contacto);
                    }
        return null;
        }
    
    public Agenda(int numContactos)
    {        
        if (numContactos>0)
        {
            this.numContactos = numContactos;
         }
        else
            throw new IllegalArgumentException(" ERROR: Ha introducido un número de páginas no válido ");
        }
    
     public int getNumContactos() {
        return numContactos;
    }
     
     //Get que devuelve una copia del array de contactos
    public Contacto[] getContacto() {
        return this.contactos;
    }

}
