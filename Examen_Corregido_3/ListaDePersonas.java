
// Clase ListaDePersonas hecha por un estudiante
public class ListaDePersonas {
    private Persona[] personas;
    private int cantidad;

    public ListaDePersonas(int max) {
        personas = new Persona[max];
        cantidad = 0;
    }

    public void agregarPersona(String nombre, String apellidos) {
        personas[cantidad] = new Persona(cantidad, nombre, apellidos);
        cantidad++;
    }

    public int buscarIdPorNombre(String nombre, String apellidos) {
        for (int i = 0; i < cantidad; i++) {
            String completoGuardado = personas[i].getNombre() + " " + personas[i].getApellidos();
            String completoBuscado = nombre + " " + apellidos;
            if (completoGuardado.equals(completoBuscado)) {
                return personas[i].getId();
            }
        }
        return -1;
    }

    public Persona getPersonaPorId(int id) {
        if (id >= 0 && id < cantidad) {
            return personas[id];
        }
        return null;
    }

    public void imprimirPersonasConAmigos() {
        for (int i = 0; i < cantidad; i++) {
            Persona p = personas[i];
            System.out.print(p.getNombreCompleto());
            if (p.getMejorAmigo() != -1) {
                Persona amigo = getPersonaPorId(p.getMejorAmigo());
                System.out.println(" tiene como mejor amigo a " + amigo.getNombreCompleto());
            } else {
                System.out.println(" no tiene mejor amigo.");
            }
        }
    }
}
