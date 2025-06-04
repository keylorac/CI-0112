
import java.util.Scanner;

// Programa principal hecho por un estudiante
public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("¿Cuántas personas desea registrar?");
        int max = sc.nextInt();
        sc.nextLine(); // Limpia el salto de línea

        ListaDePersonas lista = new ListaDePersonas(max);

        // Se registran las personas
        for (int i = 0; i < max; i++) {
            System.out.println("Nombre de la persona #" + (i + 1) + ":");
            String nombre = sc.nextLine();
            System.out.println("Apellidos de la persona #" + (i + 1) + ":");
            String apellidos = sc.nextLine();
            lista.agregarPersona(nombre, apellidos);
        }

        MatrizAmistad matriz = new MatrizAmistad(max);

        // Se registran las observaciones (fotos)
        String seguir = "si";
        while (seguir.equals("si") || seguir.equals("SI") || seguir.equals("Si") || seguir.equals("sI")) {
            System.out.println("¿Cuántas personas hay en la foto?");
            int enFoto = sc.nextInt();
            sc.nextLine();

            int[] ids = new int[enFoto];
            int cuantos = 0;

            for (int i = 0; i < enFoto; i++) {
                System.out.println("Nombre de la persona #" + (i + 1) + ":");
                String nombre = sc.nextLine();
                System.out.println("Apellidos:");
                String apellidos = sc.nextLine();

                int id = lista.buscarIdPorNombre(nombre, apellidos);
                if (id != -1) {
                    ids[cuantos] = id;
                    cuantos++;
                } else {
                    System.out.println("No se encontró la persona.");
                }
            }

            int[] idsReales = new int[cuantos];
            for (int i = 0; i < cuantos; i++) {
                idsReales[i] = ids[i];
            }

            matriz.agregarRelacion(idsReales);

            System.out.println("¿Desea ingresar otra foto? (si/no)");
            seguir = sc.nextLine();
        }

        matriz.calcularMejoresAmigos(lista);
        lista.imprimirPersonasConAmigos();
    }
}
