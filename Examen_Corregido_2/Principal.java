
import java.util.Scanner;

// Programa principal
public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese cuántas personas desea registrar:");
        int max = sc.nextInt();
        sc.nextLine();

        ListaDePersonas lista = new ListaDePersonas(max);

        // Registro de personas
        for (int i = 0; i < max; i++) {
            System.out.println("Nombre de la persona #" + (i + 1) + ":");
            String nombre = sc.nextLine();
            System.out.println("Apellidos de la persona #" + (i + 1) + ":");
            String apellidos = sc.nextLine();
            lista.agregarPersona(nombre, apellidos);
        }

        MatrizAmistad matriz = new MatrizAmistad(max);

        // Registro de observaciones (fotos)
        String continuar = "si";
        while (continuar.equalsIgnoreCase("si")) {
            System.out.println("¿Cuántas personas hay en la foto?");
            int cantidadEnFoto = sc.nextInt();
            sc.nextLine();

            int[] ids = new int[cantidadEnFoto];
            int index = 0;

            for (int i = 0; i < cantidadEnFoto; i++) {
                System.out.println("Nombre de la persona #" + (i + 1) + ":");
                String nombre = sc.nextLine();
                System.out.println("Apellidos:");
                String apellidos = sc.nextLine();

                int id = lista.buscarIdPorNombre(nombre, apellidos);
                if (id != -1) {
                    ids[index] = id;
                    index++;
                } else {
                    System.out.println("Persona no encontrada. Se ignora.");
                }
            }

            // Ajustar el tamaño real del vector si hubo personas no encontradas
            int[] idsValidos = new int[index];
            for (int i = 0; i < index; i++) {
                idsValidos[i] = ids[i];
            }

            matriz.agregarRelacion(idsValidos);

            System.out.println("¿Desea ingresar otra foto? (si/no)");
            continuar = sc.nextLine();
        }

        matriz.calcularMejoresAmigos(lista);
        lista.imprimirPersonasConAmigos();
    }
}
