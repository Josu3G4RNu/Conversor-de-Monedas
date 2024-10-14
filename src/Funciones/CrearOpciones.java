package Funciones;
import Modelos.Moneda;
import java.util.ArrayList;
import java.util.HashMap;

public class CrearOpciones {
    private ArrayList<Moneda> listaDeMonedas = new ArrayList<>();
    private HashMap<Integer, String[]> opciones = new HashMap<>();
    private int contador = 1;

    public HashMap<Integer, String[]> presentarMenu(){
        // Lista de Monedas
        listaDeMonedas.add(new Moneda("ARS", "Peso Argentino"));
        listaDeMonedas.add(new Moneda("COP", "Peso Colombiano"));
        listaDeMonedas.add(new Moneda("CLP", "Peso Chileno"));
        listaDeMonedas.add(new Moneda("MXN", "Peso Mexicano"));
        listaDeMonedas.add(new Moneda("BRL", "Real de Brasil"));
        listaDeMonedas.add(new Moneda("USD", "Dolar Estadounidense"));
        listaDeMonedas.add(new Moneda("EUR", "Euro"));

        for (int i = 0; i < listaDeMonedas.size(); i++) {
            for (int j = 0; j < listaDeMonedas.size(); j++) {
                if (listaDeMonedas.get(i).equals(listaDeMonedas.get(j))){continue;}
                System.out.println(contador + ") " + listaDeMonedas.get(i).getNombreDeLaMoneda() + " a " + listaDeMonedas.get(j).getNombreDeLaMoneda());
                opciones.put(contador, new String[]{listaDeMonedas.get(i).getClave(), listaDeMonedas.get(j).getClave()});
                contador ++;
            }
        }
        return opciones;
    }

}
