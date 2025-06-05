// Nombre: Keylor Arley Castro
// Carné: B80733
// Descripción: Programa principal para registrar personas, procesar observaciones (fotos)
//              y asignar el mejor amigo según coincidencias en fotos registradas.
package Examen_Corregido_3;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Paso 1: Se le pide al usuario cuántas personas se van a registrar
        System.out.println("Ingrese cuántas personas desea registrar:");
        int max = sc.nextInt(); // Número total de personas
        sc.nextLine(); // Limpiamos el salto de línea que deja el nextInt

        // Se crea una lista de personas con el tamaño ingresado
        ListaDePersonas lista = new ListaDePersonas(max);

        // Paso 2: Registrar la información de cada persona
        for (int i = 0; i < max; i++) {
            System.out.println("Nombre de la persona #" + (i + 1) + ":");
            String nombre = sc.nextLine();
            System.out.println("Apellidos de la persona #" + (i + 1) + ":");
            String apellidos = sc.nextLine();

            // Se agrega la persona a la lista
            lista.agregarPersona(nombre, apellidos);
        }

        // Se crea la matriz que guardará las relaciones entre personas
        MatrizAmistad matriz = new MatrizAmistad(max);

        // Paso 3: Registrar observaciones (fotos)
        String continuar = "si"; // El ciclo continúa mientras el usuario escriba "si"
        while (continuar.toLowerCase().equals("si")) { // Se compara todo en minúscula para evitar errores de mayúscula
            System.out.println("\n¿Cuántas personas hay en la foto?");
            int cantidadEnFoto = sc.nextInt();
            sc.nextLine(); // Limpia el salto de línea

            int[] ids = new int[cantidadEnFoto]; // Vector para guardar los IDs que aparecen en la foto
            int index = 0; // Contador real de personas válidas encontradas

            // Se piden los datos de cada persona que aparece en la foto
            for (int i = 0; i < cantidadEnFoto; i++) {
                System.out.println("Nombre de la persona #" + (i + 1) + ":");
                String nombre = sc.nextLine();
                System.out.println("Apellidos:");
                String apellidos = sc.nextLine();

                // Busca el ID de esa persona registrada previamente
                int id = lista.buscarIdPorNombre(nombre, apellidos);

                if (id != -1) {
                    ids[index] = id; // Se guarda el ID válido
                    index++;
                } else {
                    System.out.println("Persona no encontrada. Se ignora.");
                }
            }

            // Se crea un nuevo vector con los IDs válidos
            int[] idsValidos = new int[index];
            for (int i = 0; i < index; i++) {
                idsValidos[i] = ids[i];
            }

            // Se agregan las relaciones entre todos los IDs de la observación
            matriz.agregarRelacion(idsValidos);

            // Pregunta al usuario si desea ingresar otra foto
            System.out.println("¿Desea ingresar otra foto? (si/no)");
            continuar = sc.nextLine(); // Se guarda la respuesta para continuar o salir
        }

        // Paso 4: Se calcula el mejor amigo de cada persona usando la matriz
        matriz.calcularMejoresAmigos(lista);

        // Paso 5: Se muestra en pantalla la lista de personas y su mejor amigo
        lista.imprimirPersonasConAmigos();

        sc.close(); // Se cierra el Scanner (buena práctica)
    }
}
