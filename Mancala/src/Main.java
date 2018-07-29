//Francisco Rosal 18676

import classes.Mancala;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\tMANCALA");
        System.out.println("Ingrese el nombre del jugador 1: ");
        String jugador1 = input.nextLine();
        System.out.println("Ingrese el nombre del jugador 2: ");
        String jugador2 = input.nextLine();
        Mancala nuevoMancala = new Mancala(jugador1, jugador2);

        do {
            System.out.println(nuevoMancala);
            System.out.println("Ingrese la posicion: ");
            String pos = input.nextLine();
            nuevoMancala.seleccionarCasilla(pos);
        } while (!nuevoMancala.hayGanador());

        System.out.println("\n" + nuevoMancala.checkGanador());
    }
}
