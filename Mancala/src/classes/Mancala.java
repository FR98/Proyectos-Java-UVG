package classes;

public class Mancala {
    private Casilla[][] tablero;
    private boolean esTurnoJugador1;
    private String jugador1;
    private String jugador2;

    public Mancala(String j1, String j2) {
        this.tablero = new Casilla[2][8];
        esTurnoJugador1 = false;
        this.jugador1 = j1;
        this.jugador2 = j2;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 0 && j == 7) {
                    this.tablero[i][j] = null;
                } else if (i == 1 && j == 0) {
                    this.tablero[i][j] = null;
                } else if (i == 1 && j == 7) {
                    this.tablero[i][j] = new Casilla(i, j, 0);
                } else if (i == 0 && j == 0) {
                    this.tablero[i][j] = new Casilla(i, j, 0);
                } else {
                    this.tablero[i][j] = new Casilla(i, j, 4);
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

    public void turno(Casilla casilla) {
        boolean repetirTurno = false;
        boolean robarMonedas = false;
        if (casilla.getPilaMonedas().getCantidad() != 0) {
            int monedas = casilla.getPilaMonedas().getCantidad();
            casilla.getPilaMonedas().empty();

            int fila = casilla.getFila();
            int columna = casilla.getColumna();

            if (fila == 0) {
                for (int j = (columna - 1); j >= 0; j--) {
                    if (monedas > 0) {
                        if (j == 0 && !esTurnoJugador1) {
                            System.out.print("");
                        } else {
                            if (monedas == 1 && j == 0 && esTurnoJugador1) {
                                repetirTurno = true;
                            } else if (monedas == 1 && this.tablero[0][j].getPilaMonedas().getCantidad() == 0 && this.tablero[1][j].getPilaMonedas().getCantidad() != 0) {
                                if (esTurnoJugador1) {
                                    this.tablero[0][0].getPilaMonedas().setCantidad(this.tablero[0][0].getPilaMonedas().getCantidad() + 1 + this.tablero[1][j].getPilaMonedas().getCantidad());
                                    this.tablero[1][j].getPilaMonedas().setCantidad(0);
                                    this.tablero[0][j].getPilaMonedas().setCantidad(0);
                                    robarMonedas = true;
                                }
                            }
                            if (robarMonedas) {
                                monedas -= 1;
                            } else {
                                this.tablero[0][j].getPilaMonedas().addMoneda();
                                monedas -= 1;
                            }
                        }
                    } else {
                        break;
                    }
                }
            } else {
                for (int j = (columna + 1); j <= 7; j++){
                    if (monedas > 0) {
                        if (j == 7 && esTurnoJugador1) {
                            System.out.print("");
                        } else {
                            if (monedas == 1 && j == 7 && !esTurnoJugador1) {
                                repetirTurno = true;
                            } else if (monedas == 1 && this.tablero[1][j].getPilaMonedas().getCantidad() == 0 && this.tablero[0][j].getPilaMonedas().getCantidad() != 0) {
                                if (!esTurnoJugador1) {
                                    this.tablero[1][7].getPilaMonedas().setCantidad(this.tablero[1][7].getPilaMonedas().getCantidad() + 1 + this.tablero[0][j].getPilaMonedas().getCantidad());
                                    this.tablero[1][j].getPilaMonedas().setCantidad(0);
                                    this.tablero[0][j].getPilaMonedas().setCantidad(0);
                                    robarMonedas = true;
                                }
                            }
                            if (robarMonedas) {
                                monedas -= 1;
                            } else {
                                this.tablero[1][j].getPilaMonedas().addMoneda();
                                monedas -= 1;
                            }
                        }
                    } else {
                        break;
                    }
                }
            }

            if (monedas > 0) {
                do {
                    fila = fila == 1 ? 0 :  1;
                    if (fila == 0) {
                        for (int j = 6; j >= 0; j--){
                            if (monedas > 0) {
                                if (j == 0 && !esTurnoJugador1) {
                                    System.out.print("");
                                } else {
                                    if (monedas == 1 && j == 0 && esTurnoJugador1) {
                                        repetirTurno = true;
                                    } else if (monedas == 1 && this.tablero[0][j].getPilaMonedas().getCantidad() == 0 && this.tablero[1][j].getPilaMonedas().getCantidad() != 0) {
                                        if (esTurnoJugador1) {
                                            this.tablero[0][0].getPilaMonedas().setCantidad(this.tablero[0][0].getPilaMonedas().getCantidad() + 1 + this.tablero[1][j].getPilaMonedas().getCantidad());
                                            this.tablero[1][j].getPilaMonedas().setCantidad(0);
                                            this.tablero[0][j].getPilaMonedas().setCantidad(0);
                                            robarMonedas = true;
                                        }
                                    }
                                    if (robarMonedas) {
                                        monedas -= 1;
                                    } else {
                                        this.tablero[0][j].getPilaMonedas().addMoneda();
                                        monedas -= 1;
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                    } else {
                        for (int j = 1; j <= 7; j++) {
                            if (monedas > 0) {
                                if (j == 7 && esTurnoJugador1) {
                                    System.out.print("");
                                } else {
                                    if (monedas == 1 && j == 7 && !esTurnoJugador1) {
                                        repetirTurno = true;
                                    } else if (monedas == 1 && this.tablero[1][j].getPilaMonedas().getCantidad() == 0 && this.tablero[0][j].getPilaMonedas().getCantidad() != 0) {
                                        if (!esTurnoJugador1) {
                                            this.tablero[0][0].getPilaMonedas().setCantidad(this.tablero[0][0].getPilaMonedas().getCantidad() + 1 + this.tablero[0][j].getPilaMonedas().getCantidad());
                                            this.tablero[1][j].getPilaMonedas().setCantidad(0);
                                            this.tablero[0][j].getPilaMonedas().setCantidad(0);
                                            robarMonedas = true;
                                        }
                                    }
                                }
                                if (robarMonedas) {
                                    monedas -= 1;
                                } else {
                                    this.tablero[1][j].getPilaMonedas().addMoneda();
                                    monedas -= 1;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                } while (monedas > 0);
            }
            if (!repetirTurno) {
                this.esTurnoJugador1 = !this.esTurnoJugador1;
            }
        }
    }

    public boolean hayGanador() {
        int suma1 = 0;
        int suma2 = 0;
        for (int j = 1; j < 7; j++) {
            suma1 += this.tablero[0][j].getPilaMonedas().getCantidad();
            suma2 += this.tablero[1][j].getPilaMonedas().getCantidad();
        }
        if ((suma1 + suma2) == 0) {
            return true;
        } else if (suma1 == 0) {
            this.tablero[1][7].getPilaMonedas().setCantidad(this.tablero[1][7].getPilaMonedas().getCantidad() + suma2);
            return true;
        } else if (suma2 == 0) {
            this.tablero[0][0].getPilaMonedas().setCantidad(this.tablero[0][0].getPilaMonedas().getCantidad() + suma1);
            return true;
        }
        return false;
    }

    public String checkGanador() {
        if (this.tablero[0][0].getPilaMonedas().getCantidad() > this.tablero[1][7].getPilaMonedas().getCantidad()) {
            return "Ganador: " + this.jugador1;
        } else if (this.tablero[0][0].getPilaMonedas().getCantidad() < this.tablero[1][7].getPilaMonedas().getCantidad()) {
            return "Ganador: " + this.jugador2;
        } else {
            return "Empate";
        }
    }

    @Override
    public String toString() {
        String mancala = "\n    A  B  C  D  E  F   \n";
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 0 && j == 7) {
                    mancala += "|  ";
                } else if (i == 1 && j == 0) {
                    mancala += "|  ";
                } else {
                    mancala += "|" + this.tablero[i][j].getPilaMonedas().getCantidad() + (this.tablero[i][j].getPilaMonedas().getCantidad() < 10 ? " " : "");
                }
            }
            mancala += "|\n";
        }
        mancala += "Turno de " + (this.esTurnoJugador1 ? this.jugador1 : this.jugador2);
        return mancala;
    }
}
