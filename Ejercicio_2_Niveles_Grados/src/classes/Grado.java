package classes;

import java.awt.*;
import java.util.ArrayList;

public class Grado {
    //Atributos
    private final String nombre;
    private ArrayList estudiantes;

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
        estudiantes.add(nuevoEstudiante);
    }
}