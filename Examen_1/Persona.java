package Examen_1;

public class Persona {
    private String nombre; // nombre de la persona agregada
    private String apellidos; // apellido de la persona agregada
    private int id; // identificación de la persona agregada
    private int idMejorAmigo = -1; // -1 indica que aún no tiene mejor amigo ()

    public Persona(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }

    public void setMejorAmigo(int idMejorAmigo) {
        this.idMejorAmigo = idMejorAmigo;
    }

    public int getMejorAmigo() {
        return this.idMejorAmigo;
    }
}