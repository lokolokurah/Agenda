package org.iesalandalus.programacion.agenda;

import java.util.regex.Pattern;
import javax.naming.OperationNotSupportedException;
import utilidades.Entrada;
import org.iesalandalus.programacion.agenda.Agenda;
import org.iesalandalus.programacion.agenda.Contacto;

public class MainApp {
                
        private static final String ERROR = "ERROR";
        private static final String EXITO = "OPERACIÓN REALIZADA CON ÉXITO";
        private static Contacto [] agenda =new Contacto[10];
            
        public static void main(String[] args) 
        {/*
        System.out.println("Programa para gestionar una agenda de contactos:");
                 int opcion;
	do 
        {
            mostrarMenu();
            opcion = elegirOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != 0);	
	System.out.println("Fin del trabajo con la Agenda");
    }
    
    private static void mostrarMenu() 
    {
        System.out.println("");
        System.out.println("");
        System.out.println("---------------------");
	System.out.println("AGENDA");
	System.out.println("---------------------");
	System.out.println("");
        System.out.println("Menú:");
        System.out.println("1. Añadir contacto");
        System.out.println("2. Buscar contacto");
        System.out.println("3. Borrar contacto");
        System.out.println("4. Mostrar contactos");
        System.out.println("5. Listar contactos nulos");
        System.out.println("0. Salir");
    }
    
        private static int elegirOpcion() 
    {
	int opcion;
	do 
        {
            System.out.println("Elige una opción (0-5): ");
            opcion = Entrada.entero();
	} while (opcion < 0 || opcion > 5);
         return opcion;
    }
    
    private static void ejecutarOpcion(int opcion) 
    {       
	switch (opcion) 
        {
            
            case 1:
                try 
                {
                    anadirContacto();
                } 
                catch (OperationNotSupportedException e) 
                {
                    System.out.println("ERROR:" + e.getMessage());
                }
		break;   
            case 2:                        
                try 
                {
                    buscarContacto();
                } 
                catch (OperationNotSupportedException e) 
                {
                    System.out.println("ERROR: "+ e.getMessage());
                }
                break;
                
            case 3:                
                      		
                try 
                {
                    borrarContacto();
                } 
                catch (OperationNotSupportedException e) 
                {
			System.out.println("ERROR: " + e.getMessage());
		}
        
		break;
            case 4:       
                listarAgenda();
        }
    }
    
     
    private static void anadirContacto() throws OperationNotSupportedException
    {
        String nombre,telefono,correo;
         
        System.out.println("NUEVO CONTACTO");
        System.out.println("===========");
        
        System.out.println("Por favor, introduzca los datos del contacto.");  
        
        System.out.println("Nombre: ");
        nombre=Entrada.cadena();
        System.out.println("Teléfono: ");
        telefono=Entrada.cadena();
        System.out.println("Correo: ");
        correo=Entrada.cadena();
        //Creamos el contacto
        Contacto contacto=new Contacto(nombre,telefono,correo);
        //Usamos el método que añadirá el contacto
        agenda.anadir(contacto);
    } 
    
    private static void buscarContacto() throws OperationNotSupportedException {
        try{
        String nombre;
        System.out.println("Inserte el nombre a buscar: ");
        nombre = Entrada.cadena();
        agenda.buscar(nombre);
        }catch(OperationNotSupportedException e) 
                {
                    System.out.println("ERROR: "+e.getMessage());
                }
    }
    
    private static void borrarContacto() throws OperationNotSupportedException {
        try{
        String nombre;
        System.out.println("Inserte el nombre a borrar: ");
        nombre = Entrada.cadena();
        agenda.borrar(nombre);
        }catch(OperationNotSupportedException e) 
                {
                    System.out.println("ERROR: "+e.getMessage());
                }
    }
        private static void listarAgenda(){  
            for (int i=0;i<agenda.getContactos().length;i++)
            {System.out.println(agenda.getContactos[i]);}
     */}
	
}
