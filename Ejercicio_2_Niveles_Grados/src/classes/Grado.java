package classes;

import java.util.ArrayList;

public class Grado {
    //Atributos
    private final String nombre;
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();

    //Metodos
    public Grado(String nameGrado) {
        this.nombre = nameGrado;
    }

    public String getNombre() {
        return this.nombre;
    }

    public ArrayList getEstudiantes() {
        return this.estudiantes;
    }

    public void addEstudiante(Estudiante nuevoEstudiante) {
        this.estudiantes.add(nuevoEstudiante);
    }

    @Override
    public String toString() {
        return "" + this.nombre;
    }
}