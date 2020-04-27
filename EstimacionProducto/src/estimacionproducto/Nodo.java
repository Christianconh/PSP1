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
public class Nodo {
     double numero;
    Nodo siguiente;
    
    public Nodo(double num)
    {
        numero=num;
    }
    
    public void siguiente(Nodo n)
    {
        siguiente = n;
    }
    
    public Nodo obtenerSig()
    {
        return siguiente;
    }
    
    public double obtenerNum()
    {
        return numero;
    }
}
