//Primero notamos que debemos crear un tablero (La clase Tablero) que debe contener una dimension de 5x5 (array de dos dimensiones con longitud 5 en cada dimension)
//Son dos jugadores (un jugador actual y su oponente)
//El programa debe mostras ambos tableros, el del jugador actual (con sus barcos) e impactos recibidos y el del oponente (mostrando solo los diparos realizados y sus resultados)

//Lo primero que hacemos es crear una clase llamada batalla naval, donde van a venir los atributos (los barcos y tableros), además del constructor de la clase con los métodos (disparosRealizados y disparosAcertados)
import java.util.Scanner; //Importamos la biblioteca Scanner
public class BatallaNaval 
{
    //Atributos
    //Los 3 barcos del jugador 1
    private int barcosJugador1 = 3;
    //Los 3 barcos del juagdor 2
    private int barcosJugador2 = 3;
    //Recordamos que los arrays multidimensionales son comunmente usados para representar tablas de valores (en este caso serían las coordenadas de cada barco en un tablero de 5 columnas y 5 filas)
    private int [][] tableroJugador1 = new int [5][5]; //Siguiendo la esctructura del libro pag.296: arrayType[][] arrayName = new arrayType[numRows][numColumns];
    private int [][] tableroJugador2 = new int [5][5];
    private Scanner scanner = new Scanner(System.in);

    public void iniciarJuego()
    {
        System.out.println("Inicio del juego Batalla Naval \n");
        //Realizamos un metodo para la colocacion de los barcos y lo llamamos de aqui para que el jugador pueda ir colocando los 3 barcos
        System.out.println("Hola jugador 1, por favor posicione sus 3 barcos");
        posicionBarco(tableroJugador1, 1);

        System.out.println("\n Hola jugador 2, por favor posicione sus 3 barcos");
        posicionBarco(tableroJugador2, 2);
       
        //Para hacer la parte de los turns, hacemos un while con los turnos
        private int turno = 1; 
        while(barcosJugador1 > 0 && barcosJugador2 > 0)
        {
            System.out.println("\n Turno del jugador " = turno);
            
        }
        
    }


    //Necesitamos los metodos relacionados con los disparos, osea, leer las coordenadas en las que los jugadores posicionan a los barcos y leer la coordenada en la que se selecciona por el oponente
    //Como pienso esto es como sigue:
    //Tenemos una matriz de 5x5, que represente 2 coordenadas: coordenada i y j. Si la persona jugadora 1 posiciona su barco 1 en la posición i=5 y j=2, y la persona oponente dispara a la coordenada i=5 y j=2, entonces el resultado es que hunde el barco 1
    //Ahora imaginemos que la persona jugadora 2 posiciona su barco 1 en la posición i=1 y j=1. Si la persona oponente dispara en la coordenada i=1 y j=1 hunde el barco 1 de la persona 2. Esto se repite sucesivamente maximo 6 veces, un turno por persona con su 3 barcos. Minimo se repite 1 vez, en caso de que la persona gane a la primera.   
    //}


    public void posicionBarco(int[][] tablero, int jugador) //No hace falta devolver un int desde esta clase, el objetivo es modificar el tablero, no retornad un valor, las entradas, tablero y jugador que recibe esta clase se solicitan al iniciar juego
    {
        int barcosPosicionados = 0;
        while (barcosPosicionados < 3)
        {
            System.out.println("Ingrese la fila para el barco " + (barcosPosicionados + 1) + " (0-4): "); //Le indicamos al usuario que tenemos que elegir la fila i en un rango de 0 a 4, como barcoColocados inicia en 0, se coloca (barcosColocados +1)
            int fila = scanner.nextInt();
            System.out.println("Ingrese la columna para el barco " + (barcosPosiciones + 1) + " (0-4): "); //Igualmente le informamos al usuario que tiene que elegir la otra coordenada j en un rango de 0 a 4,
            int columna = scanner.nextInt();

            if(tablero[fila][columna] == 0) //si el tablero en la fila = i y columna = j no tiene barcos (el 0 representa que no hay barco)
            {
                tablero[fila][columna] = 1; //entonces podemos posicionar 1 barco, lo representamos con 1
                barcosPosicionados ++;
            }
            else //caso que ya haya un barco imprimimos que ya hay un barco en esa posicion
            {
                System.out.println("Ya hay un barco posicionado en esas coordenadas. Intentar de nuevo.");
            }
        }

        
    }

    //El siguiente metodo es para leer los disparos, tiene que recibir coordenas i y j, el tablero (del oponente) y el jugador actual
    public boolean disparar(int fila, int columna, int [][] tableroOponente) //el método disparar nos tiene que devolver true or false en caso de que el disparo sea o no certero
    {
        if(tableroOponente[fila][columna] ==1)//se tiene que verificar si en la posicion dada i=fila y j=columna existe un barco (se usa el valor 1 para representar que existe un barco)
        {
            //Si hay un barco, lo tenemos que identificar como hundido, usaremos el numero 2 para identificarlo y mostramos el mensaje de que el jugadorActual tuvo acierto
            tableroOponente[fila][columna] = 2;
            System.out.println("El jugador acertó un disparo!");
            return true; //jugadorActual acertó el disparo
        }
        else if (tableroOponente[fila][columna] == 0) //0 indica que no existe un barco
        {
            tableroOponente[fila][columna] = -1; // Usaremos el numero -1 para representar que no acertó el disparo
            System.out.println("El jugador ha fallado el disparo.");
        }
        else
        {
            //Si no hay un barco en la coordenada i=fila y j=columna, entonces no hay acierto, se retorna un false y se asigna un valor nuevo en tableroOponente
            System.out.println("Esa posición fue atacada antes");
        }
        return false; //no acertó el disparo
    }

    public void mostrarTablero(int [][] tablero, boolean ocultarBarcos)
    {
        for (int i =0; i < tablero.length; i ++) //recorrido por las filas
        {
            for (int j = 0; j < tablero.length; j++) //recorrido por las columnas
            {
                if(tablero[i][j]==1 && ocultarBarcos)
                {
                    System.out.print("0 "); //oculatmos los barcos
                }
                else
                {
                    System.out.print(tablero[i][j] + " ");
                }
            }
            System.out.println();
        }

    }
}