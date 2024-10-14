package Modelos;

public class Moneda {
    private String clave;
    private String nombreDeLaMoneda;

    public Moneda(String clave, String nombreDeLaMoneda) {
        this.clave = clave;
        this.nombreDeLaMoneda = nombreDeLaMoneda;
    }

    public String getClave() {
        return clave;
    }

    public String getNombreDeLaMoneda() {
        return nombreDeLaMoneda;
    }
}
