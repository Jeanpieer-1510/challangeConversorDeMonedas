import com.piero.Conversor.conexiones.ConsultaApi;
import com.piero.Conversor.modelos.Monedas;

import java.util.Scanner;

public class main extends ConsultaApi{
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese la moneda de origen (ejemplo: USD): ");
        var moneda = teclado.nextLine();
        System.out.println("Ingrese la moneda de destino (ejemplo: EUR): ");
        var moneda2 = teclado.nextLine();
        System.out.println("Ingrese la cantidad a convertir: ");
        var cantidad =Integer.parseInt(teclado.nextLine());

        ConsultaApi consulta = new ConsultaApi();
        Monedas monedas = consulta.convertirMoneda(moneda, moneda2, cantidad);
        System.out.println(monedas);
    }
}
