package classes;

public class Casilla {
    private Integer fila;
    private Integer columna;
    private PilaDeMonedas monedas;

    public Casilla(int fila, int columna, int cantidad) {
        this.fila = fila;
        this.columna = columna;
        this.monedas = new PilaDeMonedas(cantidad);
    }

    public PilaDeMonedas getPilaMonedas() {
        return monedas;
    }

    public Integer getColumna() {
        return columna;
    }

    public Integer getFila() {
        return fila;
    }
}
