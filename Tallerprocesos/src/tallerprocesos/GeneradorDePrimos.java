/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerprocesos;

/**
 *
 * @author mac
 */
public class GeneradorDePrimos {
 
    private static int dim;  private static boolean esPrimo[];  
    private static int primos[];
    public static int[] generarPrimos (int max) {       
        if (max < 2) {      
            return new int[0];
        }  // Vector vacío   
         else { 
            inicializarCandidatos(max);   
            eliminarMultiplos();     
            obtenerCandidatosNoEliminados();
            
            //inicializarCriba(max);      
            //cribar();      
            //rellenarPrimos();
            return primos;    
        }
    }
    
    
    private static void inicializarCandidatos (int max)   {    
        int i;    esPrimo = new boolean[max+1];     
        esPrimo[0] = esPrimo[1] = false;    
        for (i=2; i<esPrimo.length; i++)      
            esPrimo[i] = true; 
    }
    
    /* METODO DE LA VERSION 2
    private static void eliminarMultiplos () {
        // ANTIGUO METODO CRIBAR
        int i,j;
        for (i=2; i<Math.sqrt(dim)+1; i++) {
            if (esPrimo[i]) {
                // Eliminar los múltiplos de i
                for (j=2*i; j<dim; j+=i)    
                    esPrimo[j] = false;         
            } 
        }
    }*/
    
    
    private static void obtenerCandidatosNoEliminados (){
        // ANTIGUO METODO DE RELLENARPRIMOS
        int i, j, cuenta;
        // Contar primos    
        cuenta = 0;      
        for (i=0; i<dim; i++)
            if (esPrimo[i])   cuenta++;    
        // Rellenar el vector de números primos
        primos = new int[cuenta]; 
        for (i=0, j=0; i<dim; i++)    
            if (esPrimo[i])   
                primos[j++] = i;            
    }
    
    
    private static void inicializarCriba (int max)   {
        int i;
        dim = max + 1;
        esPrimo = new boolean[dim];
        for (i=0; i<dim; i++)   
            esPrimo[i] = true;
            esPrimo[0] = esPrimo[1] = false; 
    }
    
    
    /* METODO DE LA VERSION 1
    private static void cribar ()   {
        int i,j;
        for (i=2; i<Math.sqrt(dim)+1; i++) {
            if (esPrimo[i]) {
                // Eliminar los múltiplos de i
                for (j=2*i; j<dim; j+=i)    
                    esPrimo[j] = false;         
            } 
        } 
    }*/
    
    /* METODO DE LA VERSION 1
    private static void rellenarPrimos () 
    {    int i, j, cuenta;
    // Contar primos    
    cuenta = 0;      
    for (i=0; i<dim; i++)
        if (esPrimo[i])   cuenta++;    
    // Rellenar el vector de números primos
    primos = new int[cuenta]; 
    for (i=0, j=0; i<dim; i++)    
        if (esPrimo[i])   
            primos[j++] = i;    
    }*/
    
    
    
    // METODOS ADICIONALES
    
    private static void eliminarMultiplos ()   { 
        int i;    for (i=2; i<maxFactor(); i++)         
            if (esPrimo[i]) eliminarMultiplosDe(i); 
    } 
    
    private static int maxFactor ()  {   
        return (int) Math.sqrt(esPrimo.length) + 1;  
    } 
    private static void eliminarMultiplosDe (int i)  {
        int multiplo;   
            for ( multiplo=2*i; multiplo<esPrimo.length; multiplo+=i)
                esPrimo[multiplo] = false;   
    }
    
    
}
    
