
// Clase Persona hecha por un estudiante
public class Persona {
    private int id;
    private String nombre;
    private String apellidos;
    private int mejorAmigo;

    public Persona(int id, String nombre, String apellidos) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.mejorAmigo = -1;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setMejorAmigo(int idAmigo) {
        mejorAmigo = idAmigo;
    }

    public int getMejorAmigo() {
        return mejorAmigo;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }
}
