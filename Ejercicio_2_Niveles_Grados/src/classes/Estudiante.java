package classes;

public class Estudiante {
    //Atributos
    private final String nombre;
    private final Integer codigo;

    //Metodos
    public Estudiante(String name, Integer code) {
        this.nombre = name;
        this.codigo = code;
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
                "Nombre: " + this.nombre +
                "Codigo: " + this.codigo;
    }
}