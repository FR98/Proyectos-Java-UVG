package main;

import classes.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Boolean continuar = true;
        Menu menus = new Menu();
        ArrayList<Nivel> niveles = new ArrayList<>();

        do {
            System.out.println("\nAdministración Academica");
            System.out.println(menus.menuPrincipal());
            Scanner input = new Scanner(System.in);
            int opcion = input.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del nivel: ");
                    input = new Scanner(System.in);
                    String nameNivel = input.nextLine();
                    niveles.add(new Nivel(nameNivel));
                    //System.out.println(niveles);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del nivel: ");
                    input = new Scanner(System.in);
                    nameNivel = input.nextLine();

                    for (Nivel nivel : niveles) {
                        if (nivel.getNombre().equals(nameNivel)) {
                            //System.out.println(i.getNombre());
                            System.out.println("Ingrese el nombre del grado: ");
                            input = new Scanner(System.in);
                            String nameGrado = input.nextLine();
                            nivel.newGrado(new Grado(nameGrado));
                        } else {
                            System.out.println("Nivel no encontrado");
                        }
                    }

                    break;
                case 3:
                    System.out.println("Ingrese el nombre del nivel: ");
                    input = new Scanner(System.in);
                    nameNivel = input.nextLine();

                    for (Nivel nivel : niveles) {
                        if (nivel.getNombre().equals(nameNivel)) {
                            System.out.println("Ingrese el nombre del grado: ");
                            input = new Scanner(System.in);
                            String nameGrado = input.nextLine();

                            ArrayList<Grado> grados = nivel.getGrados();

                            for (Grado grado : grados){
                                if (grado.getNombre().equals(nameGrado)) {
                                    System.out.println("Ingrese el nombre del estudiante: ");
                                    input = new Scanner(System.in);
                                    String nameEstudiante = input.nextLine();
                                    System.out.println("Ingrese el codigo del estudiante: ");
                                    input = new Scanner(System.in);
                                    Integer codeEstudiante = input.nextInt();

                                    grado.addEstudiante(new Estudiante(nameEstudiante, codeEstudiante));

                                } else {
                                    System.out.println("Grado no encontrado");
                                }
                            }

                        } else {
                            System.out.println("Nivel no encontrado");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del nivel: ");
                    input = new Scanner(System.in);
                    nameNivel = input.nextLine();

                    for (Nivel nivel : niveles) {
                        if (nivel.getNombre().equals(nameNivel)) {
                            System.out.println(nivel.getGrados());
                        } else {
                            System.out.println("Nivel no encontrado");
                        }
                    }

                    break;
                case 5:


                    break;
                case 6:
                    continuar = false;
                    System.out.println("Adios");
                    break;
            }
        } while (continuar);
    }
}
