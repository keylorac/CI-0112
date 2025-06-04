//Keylor Arley Castro B80733
package Examen_1;

public class ListaDePersonas {
    private Persona[] personas;
    private int cantidad;

    public ListaDePersonas(int capacidad) {
        personas = new Persona[capacidad];
        cantidad = 0;
    }

    public void agregarPersona(Persona p) {
        p.setId(cantidad);
        personas[cantidad] = p;
        cantidad++;
    }

    public int buscarIdPorNombre(String nombre, String apellidos) {
        for (int i = 0; i < cantidad; i++) {
            if (personas[i].getNombreCompleto().equalsIgnoreCase(nombre + " " + apellidos)) {
                return personas[i].getId();
            }
        }
        return -1;
    }

    public void asignarMejorAmigo(int idPersona, int idAmigo) {
        personas[idPersona].setMejorAmigo(idAmigo);
    }

    public int obtenerCantidad() {
        return cantidad;
    }

    public void mostrarInformacion() {
        for (int i = 0; i < cantidad; i++) {
            String nombre = personas[i].getNombreCompleto();
            int idAmigo = personas[i].getMejorAmigo();
            String nombreAmigo = (idAmigo != -1) ? personas[idAmigo].getNombreCompleto() : "Ninguno";
            System.out.println(nombre + " -> Mejor amigo: " + nombreAmigo);
        }
    }
}