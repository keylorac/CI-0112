public class MatrizAsociativa {
    private int[][] M; // Matriz de conteo
    public double[][] S; // Matriz de similitud

    public MatrizAsociativa(int tam) {
        M = new int[tam][tam];
        S = new double[tam][tam];
    }

    public void agregarRelacion(int i, int j) {
        M[i][j]++;
    }

    public void calcularProbabilidades() {
        int n = M.length;
        for (int i = 0; i < n; i++) {
            int total = 0;
            for (int j = 0; j < n; j++) {
                total += M[i][j];
            }
            for (int j = 0; j < n; j++) {
                if (total > 0) {
                    S[i][j] = (double) M[i][j] / total;
                } else {
                    S[i][j] = 0.0;
                }
            }
        }
    }
}