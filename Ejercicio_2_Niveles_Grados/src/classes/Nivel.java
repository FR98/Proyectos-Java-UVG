package classes;

import java.util.ArrayList;

public class Nivel {
    //Atributos
    private String nombre;
    private ArrayList<Grado> grados = new ArrayList<>();

    //Metodos
    public Nivel(String nameNivel) {
        this.nombre = nameNivel;
    }

    public String getNombre() {
        return this.nombre;
    }

    public ArrayList getGrados() {
        return this.grados;
    }

    public void newGrado(Grado nuevoGrado) {
        this.grados.add(nuevoGrado);
    }

    @Override
    public String toString() {
        return "Nivel: " + this.nombre;
    }
}
