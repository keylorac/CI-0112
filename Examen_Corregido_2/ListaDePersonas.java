
// Clase ListaDePersonas: almacena y gestiona un arreglo de personas
public class ListaDePersonas {
    private Persona[] personas;
    private int cantidad;

    public ListaDePersonas(int max) {
        personas = new Persona[max];
        cantidad = 0;
    }

    public void agregarPersona(String nombre, String apellidos) {
        personas[cantidad] = new Persona(nombre, apellidos, cantidad);
        cantidad++;
    }

    public Persona getPersona(int id) {
        return personas[id];
    }

    public int getCantidad() {
        return cantidad;
    }

    public int buscarIdPorNombre(String nombre, String apellidos) {
        // Convertimos los nombres a minúsculas para comparar
        String nombreBuscado = (nombre + " " + apellidos).toLowerCase();

        for (int i = 0; i < cantidad; i++) {
            String nombreActual = personas[i].getNombreCompleto().toLowerCase();
            if (nombreActual.equals(nombreBuscado)) {
                return personas[i].getId();
            }
        }

        return -1; // No se encontró
    }

    public void imprimirPersonasConAmigos() {
        for (int i = 0; i < cantidad; i++) {
            Persona p = personas[i];
            String amigo = "Ninguno";
            if (p.getMejorAmigoId() != -1) {
                amigo = personas[p.getMejorAmigoId()].getNombreCompleto();
            }
            System.out.println("Persona: " + p.getNombreCompleto() + " | Mejor amigo: " + amigo);
        }
    }
}
