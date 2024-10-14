package Funciones;

import Modelos.Conversion;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Archivo {
    private File archivo = new File("Conversiones.txt");

    public void guardar(Conversion conversion) throws IOException {
        FileWriter fw = new FileWriter(this.archivo, true);
        BufferedWriter escritor = new BufferedWriter(fw);
        LocalDateTime tiempoActual = LocalDateTime.now();
        DateTimeFormatter formatoDeFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy 'a las' h:mm:ss");
        String fechaFormateada = tiempoActual.format(formatoDeFecha);

        escritor.write(fechaFormateada + " | "+ conversion +"\n");
        escritor.close();
    }

    public void leer() throws IOException {
        FileReader fr = new FileReader(this.archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea = br.readLine();
        while (linea != null) {
            System.out.println(linea);
            linea = br.readLine();
        }
    }

}
