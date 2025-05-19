//Primero notamos que debemos crear un tablero (La clase Tablero) que debe contener una dimension de 5x5 (array de dos dimensiones con longitud 5 en cada dimension)
//Son dos jugadores (un jugador actual y su oponente)
//El programa debe mostras ambos tableros, el del jugador actual (con sus barcos) e impactos recibidos y el del oponente (mostrando solo los diparos realizados y sus resultados)

//Lo primero que hacemos es crear una clase llamada batalla naval, donde van a venir los atributos (los barcos y tableros), además del constructor de la clase con los métodos (disparosRealizados y disparosAcertados)
import java.util.Scanner; //Importamos la biblioteca Scanner
public class BatallaNaval 
{
    //Atributos
    private JugadorBatallaNaval jugador1;
    private JugadorBatallaNaval jugador2;

    private Scanner scanner = new Scanner(System.in);

    public BatallaNaval(JugadorBatallaNaval j1, JugadorBatallaNaval j2) {
        this.jugador1 = j1;
        this.jugador2 = j2;
        jugador1.inicializarParaJuego();
        jugador2.inicializarParaJuego();
    }

    public void iniciarJuego()
    {
        System.out.println("Inicio del juego Batalla Naval \n");
        colocarBarcos(jugador1);
        colocarBarcos(jugador2);
       
        //Para hacer la parte de los turnos, hacemos un while con los turnos
        int turno = 1; //Creamos una variable turno = 1, que significa turno del jugador 1
        while(jugador1.getBarcosRestantes() > 0 && jugador2.getBarcosRestantes() > 0) //Mientras que la cantidad de barcos del jugador 1 y del jugador 2 sea mayor a 0 (existan barcos)
        {
            JugadorBatallaNaval actual;
            JugadorBatallaNaval oponente;
            if (turno == 1) {
                actual = jugador1;
                oponente = jugador2;
            } else {
                actual = jugador2;
                oponente = jugador1;
            }

            System.out.println("\nTurno de " + actual.getNombre()); //Empieza el jugador 1
            mostrarTablero(actual.getTableroVisible(), true);
            //Mostramos tablero del oponente con disparos pero ocultando los barcos
            //Aqui el problema es que tenemos que hacer una condicion donde si el turno es del jugador 1, mostramos el tablero del jugador 2, sino el del jugador 1
            System.out.print("Ingrese la fila en la que quiere disparar (0-4): ");
            int fila = scanner.nextInt();
            System.out.print("Ingrese la columna en la que quiere disparar (0-4): ");
            int columna = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            boolean impacto = disparar(fila, columna, actual, oponente);
            if (impacto) {
                oponente.hundirBarco();
            }

            turno = (turno == 1) ? 2 : 1;
        }

        //Ahora tenemos que determinar quien gano. Usamos otro condicional con una variable local llamada ganador
        String ganador;
        if (jugador1.getBarcosRestantes() == 0) {
            ganador = jugador2.getNombre();
        } else {
            ganador = jugador1.getNombre();
        }
        System.out.println("\nJuego terminado. Ganador: " + ganador);
    }


    //Necesitamos los metodos relacionados con los disparos, osea, leer las coordenadas en las que los jugadores posicionan a los barcos y leer la coordenada en la que se selecciona por el oponente
    //Como pienso esto es como sigue:
    //Tenemos una matriz de 5x5, que represente 2 coordenadas: coordenada i y j. Si la persona jugadora 1 posiciona su barco 1 en la posición i=5 y j=2, y la persona oponente dispara a la coordenada i=5 y j=2, entonces el resultado es que hunde el barco 1
    //Ahora imaginemos que la persona jugadora 2 posiciona su barco 1 en la posición i=1 y j=1. Si la persona oponente dispara en la coordenada i=1 y j=1 hunde el barco 1 de la persona 2. Esto se repite sucesivamente maximo 6 veces, un turno por persona con su 3 barcos. Minimo se repite 1 vez, en caso de que la persona gane a la primera.   
    //}


    private void colocarBarcos(JugadorBatallaNaval jugador) {
        System.out.println("Colocar barcos para " + jugador.getNombre());
        int count = 0;
        int[][] tablero = jugador.getTableroPropio();
        while (count < 3) {
            System.out.print("Barco " + (count + 1) + " fila (0-4): ");
            int f = scanner.nextInt();
            System.out.print("Columna (0-4): ");
            int c = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea
            if (f >= 0 && f < 5 && c >= 0 && c < 5 && tablero[f][c] == 0) {
                tablero[f][c] = 1;
                count++;
            } else {
                System.out.println("Posición inválida u ocupada, intente de nuevo.");
            }
        }
    }    

    //El siguiente metodo es para leer los disparos, tiene que recibir coordenas i y j, el tablero (del oponente) y el jugador actual
    private boolean disparar(int fila, int columna,
                             JugadorBatallaNaval actual,
                             JugadorBatallaNaval oponente) {
        int[][] propio = oponente.getTableroPropio();
        int[][] visible = actual.getTableroVisible();

        if (fila < 0 || fila >= 5 || columna < 0 || columna >= 5) {
            System.out.println("Coordenadas fuera de rango.");
            return false;
        }

        if (propio[fila][columna] == 1) {
            propio[fila][columna] = 2;
            visible[fila][columna] = 2;
            System.out.println("¡Impacto!");
            return true;
        } else {
            if (propio[fila][columna] == 0) {
                propio[fila][columna] = -1;
                visible[fila][columna] = -1;
                System.out.println("Agua.");
            } else {
                System.out.println("Ya disparado aquí.");
            }
            return false;
        }
    }

    private void mostrarTablero(int[][] tablero, boolean ocultar) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                int val = tablero[i][j];
                char simbolo;
                if (val == 1 && !ocultar) {
                    simbolo = 'B';
                } else if (val == 1 && ocultar) {
                    simbolo = '~';
                } else if (val == 2) {
                    simbolo = 'X';
                } else if (val == -1) {
                    simbolo = '*';
                } else {
                    simbolo = '~';
                }
                System.out.print(simbolo + " ");
            }
            System.out.println();
        }

    }
}