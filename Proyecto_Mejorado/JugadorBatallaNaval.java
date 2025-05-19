//Acá tendremos los atributos y los métodos necesarios de la clase jugador
//La clase jugador se usará en el momento que uno de los juegos inicie a correr

//Clase jugador que guarda el nombre del jugador, puntosJugador, tableroJugador, tableroOculto, palabraJugador

import java.util.Scanner;

public class JugadorBatallaNaval
{
    //Atributos
    private String nombre;
    private int [][] tableroPropio;
    private int [][] tableroVisible;
    private int barcosRestantes;

    //Métodos
    //Los métodos de la clase jugador deben ser el constructor de cada jugador, el registro de puntos de cada jugador

    //Constructor que inicializa las variables de la instancia
    public JugadorBatallaNaval(String nombre)
    {
        this.nombre = nombre;
        this.barcosRestantes = 3;//numero inicial de barcos
        this.tableroPropio = new int [5][5];
        this.tableroVisible = new int [5][5];
    }
    public void inicializarParaJuego() {
        for (int i = 0; i < tableroPropio.length; i++) {
            for (int j = 0; j < tableroPropio[i].length; j++) {
                tableroPropio[i][j] = 0;
                tableroVisible[i][j] = 0;
            }
        }
        barcosRestantes = 3;
    }

    public boolean colocarBarco(int fila, int columna){ //colocar los barcos en filas y columnas válidas y rangos libres
        if(fila < 0 || fila >= 5 || columna < 0 || columna >= 5){
            System.out.println("Coordenadas fuera de rango. Deben estar entre 0 y 4.");
            return false;
        }
        if(tableroPropio[fila][columna] == 0){
            tableroPropio[fila][columna] = 1;
            return true;
        }
        System.out.println("Posición ocupada, intente de nuevo.");
        return false;
    }

    public void marcarImpacto(int fila, int columna, boolean acierto){
        tableroVisible[fila][columna] = acierto ? 2 : -1; //los aciertos se marcan con 2 y los fallos con -1
    }

    public void setNombre(String nombre){ //setea el nombre del jugador
        this.nombre = nombre;
    }

    public String getNombre(){ //devuelve el nombre del jugador
        return nombre;
    } 

    public int getBarcosRestantes(){ //devuelve los puntos del jugador
        return barcosRestantes;
    }

    public void hundirBarco(){ //reduce el contador de barcos restantes
        if(barcosRestantes > 0){
            barcosRestantes--;
        }
    }

    public int [][] getTableroPropio(){ //devuelve el tablero del jugador
        return tableroPropio;
    }

    public int [][] getTableroVisible(){ //devuelve el tablero del oponente
        return tableroVisible;
    }

    private static String leerNombreValido(Scanner scanner, String mensaje) {
        String nombre;
        do {
            System.out.print(mensaje);
            nombre = scanner.nextLine().trim();
            if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                System.out.println(" Solo se permiten letras. Intenta de nuevo.");
                nombre = "";
            }
        } while (nombre.isEmpty());
        return nombre;
    }

    public static JugadorBatallaNaval[] registrarJugadores() {
        Scanner scanner = new Scanner(System.in);

        String nombre1 = leerNombreValido(scanner, "Jugador #1, cuál es su nombre? ");
        String nombre2 = leerNombreValido(scanner, "Jugador #2, cuál es su nombre? ");

        JugadorBatallaNaval jugador1 = new JugadorBatallaNaval(nombre1);
        JugadorBatallaNaval jugador2 = new JugadorBatallaNaval(nombre2);

        return new JugadorBatallaNaval[] { jugador1, jugador2 };
    }


} //end class jugador