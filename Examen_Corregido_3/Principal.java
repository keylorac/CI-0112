// Nombre: Keylor Arley Castro
// Carné: B80733
// Descripción: Programa principal para registrar personas, procesar observaciones (fotos) y asignar el mejor amigo según coincidencias en fotos.

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Paso 1: Solicita al usuario cuántas personas va a registrar
        System.out.println("Ingrese cuántas personas desea registrar:");
        int max = sc.nextInt(); // Cantidad máxima de personas
        sc.nextLine(); // Limpia el salto de línea

        // Crea una lista para guardar las personas registradas
        ListaDePersonas lista = new ListaDePersonas(max);

        // Paso 2: Registrar cada persona una por una
        for (int i = 0; i < max; i++) {
            System.out.println("Nombre de la persona #" + (i + 1) + ":");
            String nombre = sc.nextLine();
            System.out.println("Apellidos de la persona #" + (i + 1) + ":");
            String apellidos = sc.nextLine();

            // Agrega la persona a la lista
            lista.agregarPersona(nombre, apellidos);
        }

        // Crea la matriz donde se guardan las relaciones de amistad
        MatrizAmistad matriz = new MatrizAmistad(max);

        // Paso 3: Registro de fotos (observaciones)
        String continuar = "si"; // Para controlar el bucle de ingreso de fotos
        while (continuar.equals("si")) {
            System.out.println("\n¿Cuántas personas hay en la foto?");
            int cantidadEnFoto = sc.nextInt();
            sc.nextLine();

            int[] ids = new int[cantidadEnFoto]; // Vector para guardar los IDs de personas en la foto
            int index = 0; // Límite real del vector si hay personas no encontradas

            // Solicita el nombre y apellido de cada persona en la foto
            for (int i = 0; i < cantidadEnFoto; i++) {
                System.out.println("Nombre de la persona #" + (i + 1) + ":");
                String nombre = sc.nextLine();
                System.out.println("Apellidos:");
                String apellidos = sc.nextLine();

                // Busca el ID de la persona registrada
                int id = lista.buscarIdPorNombre(nombre, apellidos);

                if (id != -1) {
                    ids[index] = id; // Agrega el ID al vector
                    index++;
                } else {
                    System.out.println("Persona no encontrada. Se ignora.");
                }
            }

            // Copia solo los IDs que sí se encontraron
            int[] idsValidos = new int[index];
            for (int i = 0; i < index; i++) {
                idsValidos[i] = ids[i];
            }

            // Agrega la relación entre todos los IDs de la foto (incluyéndose a sí mismos)
            matriz.agregarRelacion(idsValidos);

            // Pregunta si se desea seguir agregando más fotos
            System.out.println("¿Desea ingresar otra foto? (si/no)");
            continuar = sc.nextLine();
        }

        // Paso 4: Cálculo de mejores amigos según las relaciones
        matriz.calcularMejoresAmigos(lista);

        // Paso 5: Mostrar en pantalla todas las personas con su mejor amigo
        lista.imprimirPersonasConAmigos();
    }
}
