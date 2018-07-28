package classes;

public class Casilla {
    private Integer fila;
    private Integer columna;
    private PilaDeMonedas monedas;

    public Casilla(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.monedas = new PilaDeMonedas(4);
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
