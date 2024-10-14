import Funciones.ApiRequest;
import Funciones.CrearOpciones;
import Funciones.Archivo;
import Modelos.Conversion;

import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Lector de órdenes de teclado
        Scanner teclado = new Scanner(System.in);

        while (true) {
            HashMap<Integer, String[]> opciones = new CrearOpciones().presentarMenu();

            System.out.println("\nSelecciona la conversión que deseas realizar." +
                    "O selecciona 0 para ver el historial de las conversiones que has hecho: ");
            try {
                int opcion = (int) teclado.nextInt();
                if (opcion > opciones.size() || opcion < 0) {
                    System.out.println("Opción no válida");
                } else if (opcion == 0) {
                    new Archivo().leer();
                } else {
                    String monedaInicial = opciones.get(opcion)[0];
                    String monedaFinal = opciones.get(opcion)[1];
                    System.out.printf("Ingresa el monto a convertir: (%s -> %s)%n", monedaInicial, monedaFinal);
                    double monto = teclado.nextDouble();

                    Conversion resultado = new ApiRequest().realizarConversion(monedaInicial, monedaFinal, monto);
                    System.out.println("El resultado de la operación es:");
                    System.out.println(resultado);
                    new Archivo().guardar(resultado);

                    System.out.println("Desea realizar otra conversion? 1 (SI) | 0 (NO)");
                    opcion = teclado.nextInt();
                    if (opcion != 1) {
                        break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("La opción que introdujo no es válida. Favor de Revisar.");
            } catch (IOException e) {
                System.out.println("Error al guardar en archivo.");
            } catch (RuntimeException e) {
                System.out.println("Error en el sistema");
            }
        }
    }
}
