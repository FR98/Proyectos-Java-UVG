package classes;

public class Estudiante {
    //Atributos
    private String nombre;
    private Integer codigo;

    //Metodos
    public Estudiante() {

    }

    public String getNombre() {
        return this.nombre;

    }

    public int getCodigo() {
        return this.codigo;
    }

    @Override
    public String toString() {
        return "Estudiante:" +
                "Nombre: " + nombre +
                "Codigo: " + codigo;
    }
}