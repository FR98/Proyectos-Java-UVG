//Francisco Rosal

import classes.Mancala;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Mancala");
        Mancala nuevoMancala = new Mancala();
        Scanner input = new Scanner(System.in);

        boolean ganador = nuevoMancala.hayGanador();

        do {
            System.out.println(nuevoMancala);
            System.out.println("Ingrese la posicion: ");
            String pos = input.nextLine();
            nuevoMancala.seleccionarCasilla(pos);
        } while (!ganador);

    }
}
