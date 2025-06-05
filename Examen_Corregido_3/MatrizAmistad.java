// Nombre: Keylor Arley Castro
// Carné: B80733
// Descripción: Clase que maneja una matriz para contar cuántas veces han sido observadas juntas dos personas.
//              También asigna a cada persona su mejor amigo, que es con quien más ha aparecido en fotos.

package Examen_Corregido_3;
public class MatrizAmistad {
    private int[][] matriz; // Matriz para contar las veces que cada persona ha estado con otra
    private int tam;        // Tamaño de la matriz (número de personas)

    // Constructor: crea la matriz cuadrada de tamaño cantidad x cantidad
    public MatrizAmistad(int cantidad) {
        tam = cantidad;                          // Guarda el tamaño
        matriz = new int[cantidad][cantidad];    // Crea la matriz de enteros
    }

    // Método para agregar relaciones de amistad a partir de una foto
    // Cada vez que dos personas aparecen en una misma foto, se suma 1 en su relación
    public void agregarRelacion(int[] ids) {
        // Recorre todos los pares de personas en la foto
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < ids.length; j++) {
                matriz[ids[i]][ids[j]]++; // Aumenta la relación entre ellos (incluso consigo mismos)
            }
        }
    }

    // Método que calcula el mejor amigo de cada persona
    public void calcularMejoresAmigos(ListaDePersonas lista) {
        // Para cada persona
        for (int i = 0; i < tam; i++) {
            int mejor = -1; // Variable para guardar el ID del mejor amigo
            int valor = -1; // Variable para guardar la cantidad más alta de coincidencias

            // Revisa todas las demás personas para ver con quién apareció más veces
            for (int j = 0; j < tam; j++) {
                if (i != j && matriz[i][j] > valor) {
                    mejor = j;            // Actualiza el mejor amigo si hay un valor más alto
                    valor = matriz[i][j]; // Guarda ese nuevo valor
                }
            }

            // Asigna el mejor amigo a esa persona
            lista.getPersonaPorId(i).setMejorAmigo(mejor);
        }
    }
}
