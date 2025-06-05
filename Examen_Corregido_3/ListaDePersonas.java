// Nombre: Keylor Arley Castro
// Carné: B80733
// Descripción: Clase para manejar una lista de personas, buscar por nombre completo,
//              y mostrar el mejor amigo de cada persona registrada.

// Clase ListaDePersonas hecha por un estudiante
package Examen_Corregido_3;

public class ListaDePersonas {
    private Persona[] personas; // Arreglo que guarda las personas registradas
    private int cantidad;       // Contador de cuántas personas hay en la lista

    // Constructor: recibe el tamaño máximo del arreglo y lo inicializa
    public ListaDePersonas(int max) {
        personas = new Persona[max]; // Se crea el arreglo con ese tamaño
        cantidad = 0; // Al principio no hay personas registradas
    }

    // Método para agregar una nueva persona a la lista
    public void agregarPersona(String nombre, String apellidos) {
        personas[cantidad] = new Persona(cantidad, nombre, apellidos); // Se crea la persona con su ID
        cantidad++; // Se aumenta el contador de personas
    }

    // Método que busca el ID de una persona usando su nombre y apellidos
    public int buscarIdPorNombre(String nombre, String apellidos) {
        for (int i = 0; i < cantidad; i++) {
            // Se construyen los nombres completos para comparar
            String completoGuardado = personas[i].getNombre() + " " + personas[i].getApellidos();
            String completoBuscado = nombre + " " + apellidos;

            // Compara exactamente el nombre completo
            if (completoGuardado.equals(completoBuscado)) {
                return personas[i].getId(); // Devuelve el ID si se encontró
            }
        }
        return -1; // Si no se encontró, devuelve -1
    }

    // Método para obtener una persona usando su ID
    public Persona getPersonaPorId(int id) {
        // Verifica que el ID esté dentro del rango válido
        if (id >= 0 && id < cantidad) {
            return personas[id];
        }
        return null; // Si el ID no es válido, retorna null
    }

    // Método para imprimir todas las personas y su mejor amigo
    public void imprimirPersonasConAmigos() {
        for (int i = 0; i < cantidad; i++) {
            Persona p = personas[i]; // Se toma cada persona de la lista
            System.out.print(p.getNombreCompleto()); // Imprime su nombre completo

            if (p.getMejorAmigo() != -1) {
                // Si tiene mejor amigo, se busca por ID
                Persona amigo = getPersonaPorId(p.getMejorAmigo());
                System.out.println(" tiene como mejor amigo a " + amigo.getNombreCompleto());
            } else {
                // Si no tiene mejor amigo asignado
                System.out.println(" no tiene mejor amigo.");
            }
        }
    }
}
