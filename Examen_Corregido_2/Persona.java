
// Clase Persona: representa una persona con nombre, apellidos, ID y mejor amigo
public class Persona {
    private String nombre;
    private String apellidos;
    private int id;
    private int mejorAmigoId; // ID del mejor amigo

    public Persona(String nombre, String apellidos, int id) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.id = id;
        this.mejorAmigoId = -1; // Sin mejor amigo al inicio
    }

    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }

    public int getId() {
        return id;
    }

    public void setMejorAmigoId(int id) {
        this.mejorAmigoId = id;
    }

    public int getMejorAmigoId() {
        return mejorAmigoId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
}
