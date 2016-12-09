/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Pablo
 */
public class Lectura { 
    private Scanner entrada;
    // metodo para abrir el archivo
    public void abrirArchivo() {
        try {
            entrada = new Scanner(new File("estudiantes.txt"));
        } // fin de try
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del metodo abrirArchivo
    public void leer_informacion() {
        try
        {
            Datos c = new Datos();
            c.abrir_archivo();
            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
                //System.out.println(linea);
                ArrayList<String> linea_partes = new ArrayList<String>(Arrays.asList(linea.split("\\|")));
                //System.out.println(linea_partes);
                int anioNacido = Integer.parseInt(linea_partes.get(2));
                int anio = 2016;
                int edadActual = anio - anioNacido;
                System.out.printf("%s|%s|%d\n", linea_partes.get(0),linea_partes.get(1),edadActual);
                c.agregar_informacion(linea_partes.get(0),linea_partes.get(1),edadActual);
            } // fin de while
            c.cerrar_archivo();
        } // fin de try
        catch (NoSuchElementException elementException) {
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } // fin de catch
        catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch
    }
    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close(); // cierra el archivo
        }
    } // fin del metodo cerrarArchivo
}

