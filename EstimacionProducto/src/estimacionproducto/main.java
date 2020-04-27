/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estimacionproducto;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author christian
 */
public class main {
    static String XK;
    static String T;
    static String T2;
    static Scanner sc = new Scanner(System.in);
    
    
    public static void main(String[] args) {
       Scanner c= new Scanner(System.in);
       boolean salir = false;
       int opcion;
               
       while (!salir) {
 
            System.out.println("1. Saber la estimacion de tamaño de un proyecto");
            System.out.println("2. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = c.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado Conocer la estimacion de un proyecto");
                            pedirDatos();                       
                 
                        break;

                    
                    case 2:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números 1 y 2");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                c.next();
            }
        }
    }
    
     public static void pedirDatos()
    {
        System.out.println("Ingresar valor Xk:");
        XK = sc.nextLine();

        System.out.println("Ingresa el valor t1: ");
        T = sc.nextLine();
        
        System.out.println("Ingresa el valor t2: ");
        T2 = sc.nextLine();

        System.out.println("Ingresa el nombre del archivo .csv donde estan los datos");
        String datos = sc.nextLine();
        
        estimacionTamProducto producto1 = new estimacionTamProducto(Integer.valueOf(XK),Double.valueOf(T));
        producto1.ObtenciondeDatos(datos);
        System.out.println("El rango1 es: " + producto1.rango());
        System.out.println("Mínimo: "+producto1.min());
        System.out.println("Máximo: "+producto1.max()+"/n");
        
        estimacionTamProducto producto2 = new estimacionTamProducto(Integer.valueOf(XK),Double.valueOf(T2));
        producto2.ObtenciondeDatos(datos);
        System.out.println("El rango2 es: " + producto2.rango());
        System.out.println("Mínimo: "+producto2.min());
        System.out.println("Máximo: "+producto2.max());   
       
    }
}
