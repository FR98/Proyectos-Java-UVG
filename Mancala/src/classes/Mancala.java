package classes;

public class Mancala {
    private Casilla[][] tablero;
    private boolean esTurnoJugador1;

    public Mancala() {
        this.tablero = new Casilla[2][8];
        esTurnoJugador1 = true;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 0 && j == 7) {
                    this.tablero[i][j] = null;
                } else if (i == 1 && j == 0) {
                    this.tablero[i][j] = null;
                } else {
                    this.tablero[i][j] = new Casilla(i, j);
                }
            }
        }
    }

    public boolean seleccionarCasilla(String posicion){
        switch (posicion) {
            case "A":
                turno(this.esTurnoJugador1 ? this.tablero[0][1] : this.tablero[1][1]);
                return true;
            case "B":
                turno(this.esTurnoJugador1 ? this.tablero[0][2] : this.tablero[1][2]);
                return true;
            case "C":
                turno(this.esTurnoJugador1 ? this.tablero[0][3] : this.tablero[1][3]);
                return true;
            case "D":
                turno(this.esTurnoJugador1 ? this.tablero[0][4] : this.tablero[1][4]);
                return true;
            case "E":
                turno(this.esTurnoJugador1 ? this.tablero[0][5] : this.tablero[1][5]);
                return true;
            case "F":
                turno(this.esTurnoJugador1 ? this.tablero[0][6] : this.tablero[1][6]);
                return true;
            default:
                return false;
        }
    }

    public boolean turno(Casilla casilla) {
        if (casilla.getPilaMonedas().getCantidad() != 0) {
            int monedas = casilla.getPilaMonedas().getCantidad();
            casilla.getPilaMonedas().empty();

            int fila = casilla.getFila();
            int columna = casilla.getColumna();

            if (fila == 0) {
                for (int j = (columna - 1); j >= 0; j--) {
                    this.tablero[0][j].getPilaMonedas().addMoneda();
                    monedas -= 1;
                }
            } else {
                for (int j = (columna + 1); j <= 7; j++){
                    this.tablero[1][j].getPilaMonedas().addMoneda();
                    monedas -= 1;
                }
            }

            if (monedas > 0) {
                do {
                    fila = fila == 1 ? 0 : 1;
                    if (fila == 0) {
                        for (int j = 6; j >= 0; j--){
                            this.tablero[0][j].getPilaMonedas().addMoneda();
                            monedas -= 1;
                        }
                    } else {
                        for (int j = 1; j <= 7; j++) {
                            this.tablero[0][j].getPilaMonedas().addMoneda();
                            monedas -= 1;
                        }
                    }
                } while (monedas > 0);
            }
            return true;
        }
        return false;
    }
}
