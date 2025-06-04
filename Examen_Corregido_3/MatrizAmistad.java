
// Clase MatrizAmistad hecha por un estudiante
public class MatrizAmistad {
    private int[][] matriz;
    private int tam;

    public MatrizAmistad(int cantidad) {
        tam = cantidad;
        matriz = new int[cantidad][cantidad];
    }

    public void agregarRelacion(int[] ids) {
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < ids.length; j++) {
                matriz[ids[i]][ids[j]]++;
            }
        }
    }

    public void calcularMejoresAmigos(ListaDePersonas lista) {
        for (int i = 0; i < tam; i++) {
            int mejor = -1;
            int valor = -1;
            for (int j = 0; j < tam; j++) {
                if (i != j && matriz[i][j] > valor) {
                    mejor = j;
                    valor = matriz[i][j];
                }
            }
            lista.getPersonaPorId(i).setMejorAmigo(mejor);
        }
    }
}
