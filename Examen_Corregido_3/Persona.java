//Keylor Arley Castro B80733
// Clase Persona 
// Esta clase representa una persona que puede ser registrada en el sistema
package Examen_Corregido_3;
public class Persona {
    // Atributos privados de cada persona
    private int id;              // Identificador único para la persona
    private String nombre;       // Nombre de la persona
    private String apellidos;    // Apellidos de la persona
    private int mejorAmigo;      // Id del mejor amigo (se establece más adelante)

    // Constructor: se llama cuando se crea una nueva persona
    public Persona(int id, String nombre, String apellidos) {
        this.id = id;                   // Se asigna el id dado
        this.nombre = nombre;          // Se guarda el nombre
        this.apellidos = apellidos;    // Se guardan los apellidos
        this.mejorAmigo = -1;          // Se inicializa sin mejor amigo (-1 significa ninguno)
    }

    // Método para obtener el id de la persona
    public int getId() {
        return id;
    }

    // Método para obtener el nombre
    public String getNombre() {
        return nombre;
    }

    // Método para obtener los apellidos
    public String getApellidos() {
        return apellidos;
    }

    // Método para establecer el mejor amigo (se le pasa el id del amigo)
    public void setMejorAmigo(int idAmigo) {
        mejorAmigo = idAmigo;
    }

    // Método para obtener el id del mejor amigo
    public int getMejorAmigo() {
        return mejorAmigo;
    }

    // Método que devuelve el nombre completo uniendo nombre y apellidos
    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }
}
