/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estimacionproducto;

/**
 *
 * @author christian
 */
public class ListaEnlazada {
    Nodo principal;
    int size;
    double promedio;
    
    public ListaEnlazada()
    {
        principal = null;
        size = 0;
    }
    
    public double obtener(int index)
    {
        int contador = 0;
        Nodo temporal = principal;
        while(contador<index)
        {
            temporal = temporal.obtenerSig();
            contador++;
        }
        return temporal.obtenerNum();
        
    }
    
    public void add(double number)
    {
        if(principal == null)
        {
            principal = new Nodo(number);
            
        }
        else
        {
            Nodo temp = principal;
            Nodo nuevo = new Nodo(number);
            nuevo.siguiente(temp);
            principal = nuevo;
            
        }
        size++;
    }
    
    public void mostrar()
    {
        if(principal == null)
        {
            System.out.println("La pila está vacía");
        }
        else
        {
            Nodo nuevo = principal;
            while(nuevo != null)
            {
                System.out.println(nuevo.obtenerNum()+"-");
                nuevo = nuevo.obtenerSig();
            }
        }
    }
    
    public int size()
    {
        return size;
        
    }
    
    public boolean isEmpty()
    {
        return(principal==null)?true:false;
    }
    
      public double promedio()
    {
        double suma = 0;
        for(int i=0; i<size; i++)
        {
            suma=suma+obtener(i);
        }
        promedio = suma/size;
        return promedio;
    }
}
