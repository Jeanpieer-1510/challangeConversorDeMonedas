package com.piero.Conversor.utils;

import java.util.Scanner;

public class MenuUtils {

    /**
     * Muestra el menú principal.
     */
    public static void mostrarMenu() {
        System.out.println("***********************************************");
        System.out.println("Sea bienvenido/a al Conversor de Moneda\n");
        System.out.println("1) Dólar => Peso argentino");
        System.out.println("2) Peso argentino => Dólar");
        System.out.println("3) Dólar => Real brasileño");
        System.out.println("4) Real brasileño => Dólar");
        System.out.println("5) Dólar => Peso colombiano");
        System.out.println("6) Peso colombiano => Dólar");
        System.out.println("7) Otras opciones de conversión");
        System.out.println("8) Salir");
        System.out.println("\nElija una opción valida: ");
        System.out.println("***********************************************");
    }

    /**
     * Lee una opción ingresada por el usuario.
     */
    public static int leerOpcion(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("La opción debe ser un número. Intente de nuevo: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
