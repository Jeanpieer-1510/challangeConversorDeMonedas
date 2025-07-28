package com.piero.Conversor.utils;

import java.util.Scanner;

public class inputUtils {

    /**
     * Lee y valida una cantidad en formato double ingresada por el usuario.
     */
    public static double leerCantidad(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("La cantidad debe ser un número. Intente de nuevo: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    /**
     * Lee una línea de texto ingresada por el usuario.
     */
    public static String leerTexto(Scanner scanner) {
        scanner.nextLine(); // Limpiar buffer
        return scanner.nextLine();
    }
}
