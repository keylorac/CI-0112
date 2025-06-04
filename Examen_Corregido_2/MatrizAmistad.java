
// Clase MatrizAmistad: representa la matriz con los puntos de amistad entre personas
public class MatrizAmistad {
    private int[][] matriz;
    private int tamaño;

    public MatrizAmistad(int tamaño) {
        this.tamaño = tamaño;
        matriz = new int[tamaño][tamaño];
    }

    public void agregarRelacion(int[] ids) {
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < ids.length; j++) {
                int a = ids[i];
                int b = ids[j];
                matriz[a][b]++; // Se suma 1 por aparecer juntos (incluye a sí mismos)
            }
        }
    }

    public int obtenerPuntos(int a, int b) {
        return matriz[a][b];
    }

    public void calcularMejoresAmigos(ListaDePersonas lista) {
        for (int i = 0; i < tamaño; i++) {
            int mejor = -1;
            int puntosMax = -1;
            for (int j = 0; j < tamaño; j++) {
                if (i != j && matriz[i][j] > puntosMax) {
                    puntosMax = matriz[i][j];
                    mejor = j;
                }
            }
            lista.getPersona(i).setMejorAmigoId(mejor);
        }
    }
}
