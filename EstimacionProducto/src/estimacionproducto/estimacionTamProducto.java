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
public class estimacionTamProducto {

    /**
     * @param args the command line arguments
     */
    ListaEnlazada LOCxi;
    ListaEnlazada LOCyi;
    int Xk;
    double Yk;
    float Beta0;
    float Beta1;
    float DesviacionEstandar;
    double Rango;
    double T;
    double min;
    double max;

    public estimacionTamProducto()
    {
        Beta1 = 0;
        Beta0 = 0;
        DesviacionEstandar = 0;
        Rango = 0;
        Xk = 0;
        Yk = 0;
        min = 0;
        max = 0;
    }
    
    public estimacionTamProducto(int xk,double t)
    {
        Beta1 = 0;
        Beta0 = 0;
        DesviacionEstandar = 0;
        Rango = 0;
        Xk = xk;
        Yk = 0;
        T = t;
    }
    
     public void ObtenciondeDatos(String nombre)
    {
        LOCxi = new ListaEnlazada();
        LOCyi = new ListaEnlazada();
        Lectura datos = new Lectura();
        datos.comprobarArchivo(nombre);
        datos.leeArchivo(LOCxi, LOCyi);   
    }
    
    public double promedioLOCxi()
    {
        return LOCxi.promedio();
    }
    
    public double promedioLOCyi()
    {
        return LOCyi.promedio();
    }
    
    public float beta1()
    {
        float sumatoria = 0;
        for(int i = 0; i < LOCxi.size(); i++)
        {
            sumatoria = (float) (sumatoria + (LOCxi.obtener(i) * LOCyi.obtener(i)));
        }
        float numerador = (float) (sumatoria - (LOCxi.size() * LOCxi.promedio() * LOCyi.promedio()));
       
        sumatoria = 0;
        for(int i = 0; i < LOCxi.size(); i++)
        {
            sumatoria = (float) (sumatoria + (LOCxi.obtener(i) * LOCxi.obtener(i)));
        }
        
        float denominador = (float) (sumatoria - (LOCxi.size() * (LOCxi.promedio() * LOCxi.promedio())));
        
        Beta1 = numerador/denominador;
        
        return Beta1; 
    }
    
    public float beta0()
    {
        if(Beta1 == 0)
        {
            beta1();
        }
        Beta0 = (float) (LOCyi.promedio() - (Beta1 * LOCxi.promedio()));
        return Beta0;
    }
    
    
    public float desviacionEstandar()
    {
        if(Beta1 == 0)
        {
            beta1();
        }
        if(Beta0 == 0)
        {
            beta0();
        }
        float sumatoria = 0;
        for(int i = 0 ; i < LOCxi.size(); i++)
        {
            sumatoria = (float) (sumatoria + ( Math.pow((LOCyi.obtener(i) - Beta0 - (Beta1 * LOCxi.obtener(i))),2)));
        }
        DesviacionEstandar = (float)Math.sqrt(((float)1/(LOCxi.size()-2)) * sumatoria);
        return DesviacionEstandar;
    }
    
    
    
    public double rango()
    {
        if(Beta1 == 0)
        {
            beta1();
        }
        if(Beta0 == 0)
        {
            beta0();
        }
        if(DesviacionEstandar == 0)
        {
            desviacionEstandar();
        }
        float sumatoria = 0;
        for(int i = 0 ; i < LOCxi.size(); i++)
        {
            sumatoria = (float) (sumatoria + Math.pow((LOCxi.obtener(i) * LOCxi.promedio()), 2));
        }
        float parte1 =  (float) Math.sqrt(1 + ((float) 1/LOCxi.size()) + (Math.pow(Xk-LOCxi.promedio(), 2)/sumatoria));
        Rango = (double) (T * DesviacionEstandar * parte1);
        return Rango;
    }
    
    public double yk()
    {
        Yk = Beta0 + Beta1 * Xk;
        return Yk;
    }

    public double min()
    {
        min = yk() - Rango;
        return min;
    }
    
    public double max()
    {
        max = yk() + Rango;
        return max;
    }
}
