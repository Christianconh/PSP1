/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import estimacionproducto.Lectura;
import estimacionproducto.estimacionTamProducto;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author christian
 */
public class testEstimacionProducto {
    
    public testEstimacionProducto() {
    }
    
    @Test
    public void testExisteArchivo()
    {
        Lectura prueba = new Lectura();
        assertEquals(true, prueba.comprobarArchivo("filas.csv"));
        
    }
    
     @Test
    public void testNoExisteArchivo()
    {
        Lectura prueba = new Lectura();
        assertEquals(false, prueba.comprobarArchivo("file.csv"));
        
    }
    
    @Test
    public void testDatosCorretos()
    {
       estimacionTamProducto producto = new estimacionTamProducto();
        producto.ObtenciondeDatos("filas.csv");   
        assertEquals(382.8,producto.promedioLOCxi(),0.001);        
    }
    
    @Test
    public void testDatosINCorretos()
    {
       estimacionTamProducto prueba = new estimacionTamProducto();
        prueba.ObtenciondeDatos("filasW.csv");   
        assertEquals(442.5,prueba.promedioLOCyi(),0.001);        
    }
    
    
    @Test
    public void testPromedioLOCxiCorrecto()
    {
        estimacionTamProducto producto = new estimacionTamProducto();
        producto.ObtenciondeDatos("filas.csv");   
        assertEquals(382.8,producto.promedioLOCxi(),0.001);
    }
    
    @Test
    public void testPromedioLOCyiCorrecto()
    {
        estimacionTamProducto producto = new estimacionTamProducto();
        producto.ObtenciondeDatos("filas.csv");   
        assertEquals(638.9,producto.promedioLOCyi(),0.001);
    } 
    
    @Test
    public void testFormulaBeta1Correcto()
    {
        estimacionTamProducto producto = new estimacionTamProducto();
        producto.ObtenciondeDatos("filas.csv");
        
        assertEquals(1.727932426,producto.beta1(),0.001);
    }
    
    @Test
    public void testFormulaBeta0Correcto()
    {
        estimacionTamProducto producto = new estimacionTamProducto();
        producto.ObtenciondeDatos("filas.csv");
        assertEquals(-22.55253275,producto.beta0(),0.001);
    }
    
    @Test
    public void testFormulaDesviacionEstandarCorrecto()
    {
        estimacionTamProducto producto = new estimacionTamProducto();
        producto.ObtenciondeDatos("filas.csv");
        assertEquals(197.8955801,producto.desviacionEstandar(),0.001);
    }
    
    //Prueba con rango 90%
    @Test
    public void testRangoCorrecto90()
    {
        estimacionTamProducto producto = new estimacionTamProducto(386,1.86);
        producto.ObtenciondeDatos("filas.csv");
        assertEquals(386.0532936,producto.rango(),0.01);
    }
    
    //Prueba con rango 70%
    @Test
    public void testRangoCorrecto70()
    {
        estimacionTamProducto producto = new estimacionTamProducto(386,1.108);
        producto.ObtenciondeDatos("filas.csv");
        assertEquals(229.971531879365,producto.rango(),0.01);
    }
    
    
    
    
}
