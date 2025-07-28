package com.piero.Conversor.principal;

import com.piero.Conversor.modelos.Transformacion;
import com.piero.Conversor.servicios.ConversorMonedaService;
import com.piero.Conversor.utils.inputUtils;
import com.piero.Conversor.utils.MenuUtils;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorMonedaService conversorService = new ConversorMonedaService();
        int opcion;

        do {
            MenuUtils.mostrarMenu();
            opcion = MenuUtils.leerOpcion(scanner);

            switch (opcion) {
                case 1 -> convertir(conversorService, "usd", "ars", scanner);
                case 2 -> convertir(conversorService, "ars", "usd", scanner);
                case 3 -> convertir(conversorService, "usd", "brl", scanner);
                case 4 -> convertir(conversorService, "brl", "usd", scanner);
                case 5 -> convertir(conversorService, "usd", "cop", scanner);
                case 6 -> convertir(conversorService, "cop", "usd", scanner);
                case 7 -> conversionPersonalizada(conversorService, scanner);
                case 8 -> System.out.println("Finalizando el programa.");
                default -> System.out.println("Opción no válida. Por favor, inténtelo nuevamente.");
            }
        } while (opcion != 8);


        scanner.close();
    }

    /**
     * Lógica para realizar conversiones predefinidas.
     */
    private static void convertir(ConversorMonedaService service, String monedaOrigen, String monedaDestino, Scanner scanner) {
        System.out.print("Ingrese la cantidad a convertir: ");
        double cantidad = inputUtils.leerCantidad(scanner);
        Transformacion resultado = service.convertirMoneda(monedaOrigen, monedaDestino, cantidad);
        System.out.println("Resultado: " + resultado);
    }

    /**
     * Lógica para realizar conversiones personalizadas.
     */
    private static void conversionPersonalizada(ConversorMonedaService service, Scanner scanner) {
        System.out.print("Ingrese el tipo de moneda que desea cambiar: ");
        String monedaOrigen = inputUtils.leerTexto(scanner);

        System.out.print("Ingrese el tipo de moneda al que desea cambiar: ");
        String monedaDestino = inputUtils.leerTexto(scanner);

        System.out.print("Ingrese la cantidad a convertir: ");
        double cantidad = inputUtils.leerCantidad(scanner);

        Transformacion resultado = service.convertirMonedaPersonalizada(monedaOrigen, monedaDestino, cantidad);
        System.out.println(resultado);
    }
}