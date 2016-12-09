/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class Factura {
    private Formatter salida; 
    // permite al usuario abrir el archivo
    public void abrir_archivo() {
        try {
            salida = new Formatter("factura.txt");
        } // fin de try
        catch (SecurityException securityException) {
            System.err.println(
                    "No tiene acceso de escritura a este archivo.");
            System.exit(1);
        } // fin de catch
        catch (FileNotFoundException filesNotFoundException) {
            System.err.println("Error al crear el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del metodo abrir_archivo
    public void agregar_informacion() {
        String n = null;
        String ciudad = null;
        String producto = "   ";
        String continuar;
        double prec = 0;
        int cant = 0; 
        int i = 0;
        double subtotal = 0;
        double total, iva; 
        Scanner entrada = new Scanner(System.in);
        {
            try 
            {
                // obtiene los datos que se van a enviar
                System.out.print("Nombre: ");//agregar informacion de cliente
                n = entrada.next();//almacenar nombre
                System.out.print("Ciudad: ");//agregar ciudad
                ciudad = entrada.next();//almacenar ciudad
                salida.format("\tComercial Ventas Y Reventas\n"
                        + "Nombre: %s\n"
                        + "Ciudad: %s\n"
                        + "------------------------------\n"
                        + "Producto\tCantidad\tPrecio\n", n,ciudad);
                do {//ciclo repetitivo para elejir opciones varias veces
                    System.out.println("Productos en Venta **\n"
                            + "1) Arroz; costo del kilo $2.50\n"
                            + "2) AzÃºcar; costo del kilo $1.50\n"
                            + "3) Aceite; costo $ 1.30 por unidad\n"
                            + "4) Tallarines; costo $ 1.50 por unidad\n"
                            + "5) Sal; costo del kilo $1.00");
                    System.out.print("Que opcion de producto desea: ");
                    int opcion = entrada.nextInt();//para almacenar la opcion elejida
                    if (opcion == 1) {//Si se elije la primera opcion ,pregunta la cantidad y la multiplica por el precio
                        System.out.print("Que cantidad desea: ");
                        cant = entrada.nextInt();
                        prec = cant * 2.5;
                        producto = "Arroz";
                    }
                    if (opcion == 2) {//Si se elije la segunda opcion ,pregunta la cantidad y la multiplica por el precio
                        System.out.print("Que cantidad desea: ");
                        cant = entrada.nextInt();
                        prec = cant * 1.50;
                        producto = "AzÃºcar";
                    }
                    if (opcion == 3) {//Si se elije la tercera opcion ,pregunta la cantidad y la multiplica por el precio
                        System.out.print("Que cantidad desea: ");
                        cant = entrada.nextInt();
                        prec = cant * 1.30;
                        producto = "Aceite";
                    }
                    if (opcion == 4) {//Si se elije la cuarta opcion ,pregunta la cantidad y la multiplica por el precio
                        System.out.print("Que cantidad desea: ");
                        cant = entrada.nextInt();
                        prec = cant * 1.50;
                        producto = "Tallarin";
                    }
                    if (opcion == 5) {//Si se elije la quinta opcion ,pregunta la cantidad y la multiplica por el precio
                        System.out.print("Que cantidad desea: ");
                        cant = entrada.nextInt();
                        prec = cant * 1.00;
                        producto = "Sal";
                    }
                    subtotal = prec;
                    salida.format("%s\t\t%d\t%.2f\n", producto, cant, prec);
                    System.out.print("Desea elejir otra opcion del menu (si/no): ");
                    continuar = entrada.next();
                } while (continuar.equals("si"));
                iva = (subtotal * 0.14);
                total = iva + subtotal;
                // escribe el nuevo registro (escribe en el archivo
                salida.format("------------------------------\n" +
                        "\tSubtotal: %.2f\n" +
                        "\tIVA 14: %.2f\n" +
                        "\tTotal: %.2f\n", subtotal, iva, total);
            } // fin de try
            catch (FormatterClosedException formatterClosedException) {
                System.err.println("Error al escribir en el archivo.");
                return;
            } // fin de catch
            catch (NoSuchElementException elementException) {
                System.err.println("Entrada invalida. Intente de nuevo.");
                entrada.nextLine(); // descarta la entrada para que el usuario intente de nuevo
            } // fin de catch
        } // fin de while
    } 
// cierra el arrchivo
    public void cerrar_archivo() {
        if (salida != null) {
            salida.close();
        }
    } // fin del metodo cerrarArchivo
}

