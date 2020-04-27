package estimacionproducto;

import java.io.*;
public class Lectura {
    String nombreArchivo;
    
    public boolean comprobarArchivo(String nom)
    {
        if(nom.endsWith(".csv")) // buscamos que sea archivos csv
        {
            File dir = new File(nom);
            if(dir.exists()) // Comprobamos si existe ese archivo
            {
                nombreArchivo =  nom;
                return true;
            }
            else
            {
                System.out.println("El archivo especificado no se ha podido encontrar");
                return false;
            }
            
        }
        else
        {
            System.out.println("Solo se aceptan archivos .csv");
            return false;
            
        }
    }
   
    public void leeArchivo(ListaEnlazada xi, ListaEnlazada yi)
    {
        int filas = 0;
        File archivo;
        FileReader fr = null;
        try
        {
            archivo = new File(nombreArchivo);
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while(linea != null)
            {
                filas++;
                if(!linea.startsWith("#"))
                {
                    String [] aux = linea.split(",");
                    if(aux.length == 2 )
                    {
                        try{
                             xi.add(Double.valueOf(aux[0]));
                             /*System.out.println("xi: ------->"+aux[0]);
                             System.out.println("-------------------------------------"+xi.promedio());*/
                        }catch(NumberFormatException e)
                        {
                           throw new RuntimeException("Error: En la fila: " + filas + "el primer dato no es un numero");
                        }
                         try{
                              yi.add(Double.valueOf(aux[1]));
                              //System.out.println("yi: ------->"+aux[1]);
                        }catch(NumberFormatException e)
                        {
                           throw new RuntimeException("Error: En la fila: " + filas + "el segundo dato no es un numero");
                        }
                    }
                    else
                    {
                        throw new RuntimeException("Error de sintaxis  en la fila: " + filas );
                    }
                    
                }
                linea = br.readLine();
            } 
        }catch(IOException | RuntimeException e)
        {
        }finally{
            try{
                if( null != fr)
                {
                    fr.close();
                }

            }catch(IOException e2)
            {
            }
        }
    }
 }

