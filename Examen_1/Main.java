import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDePersonas lista = new ListaDePersonas(100);

        // Registro de personas
        while (true) {
            System.out.print("¿Desea registrar una persona? (sí/no): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("no")) break;

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Apellidos: ");
            String apellidos = scanner.nextLine();

            Persona nueva = new Persona(nombre, apellidos);
            lista.agregarPersona(nueva);
        }

        // Crear matriz asociativa
        int total = lista.obtenerCantidad();
        MatrizAsociativa matriz = new MatrizAsociativa(total);

        // Registro de observaciones (fotos)
        while (true) {
            System.out.print("¿Desea registrar una foto? (sí/no): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("no")) break;

            System.out.print("¿Cuántas personas aparecen en la foto?: ");
            int cantidad = Integer.parseInt(scanner.nextLine());
            int[] ids = new int[cantidad];

            for (int i = 0; i < cantidad; i++) {
                System.out.println("Persona #" + (i + 1));
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Apellidos: ");
                String apellidos = scanner.nextLine();

                int id = lista.buscarIdPorNombre(nombre, apellidos);
                if (id == -1) {
                    System.out.println("No se encontró esa persona. Intente de nuevo.");
                    i--;
                } else {
                    ids[i] = id;
                }
            }

            for (int i = 0; i < cantidad; i++) {
                for (int j = 0; j < cantidad; j++) {
                    matriz.agregarRelacion(ids[i], ids[j]);
                }
            }
        }

        // Calcular probabilidades de amistad y asignar mejor amigo
        matriz.calcularProbabilidades();

        for (int i = 0; i < total; i++) {
            double mayor = -1;
            int mejorId = -1;

            for (int j = 0; j < total; j++) {
                if (i != j && matriz.S[i][j] > mayor) {
                    mayor = matriz.S[i][j];
                    mejorId = j;
                }
            }

            lista.asignarMejorAmigo(i, mejorId);
        }

        // Mostrar resultado final
        System.out.println("\n--- RESULTADO FINAL ---");
        lista.mostrarInformacion();
    }
}