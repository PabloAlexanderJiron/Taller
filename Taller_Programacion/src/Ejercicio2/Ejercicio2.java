/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

/**
 *
 * @author Pablo
 */
public class Ejercicio2 {
    
    public static void main(String[] args) {
        
        Estudiantes aplicacion = new Estudiantes();
        aplicacion.abrirArchivo();
        aplicacion.leer_informacion();
        aplicacion.cerrarArchivo();
    }
}