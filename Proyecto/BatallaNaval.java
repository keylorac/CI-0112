//Primero notamos que debemos crear un tablero (La clase Tablero) que debe contener una dimension de 5x5 (array de dos dimensiones con longitud 5 en cada dimension)
//Son dos jugadores (un jugador actual y su oponente)
//El programa debe mostras ambos tableros, el del jugador actual (con sus barcos) e impactos recibidos y el del oponente (mostrando solo los diparos realizados y sus resultados)

//Lo primero que hacemos es crear una clase llamada batalla naval, donde van a venir los atributos (los barcos y tableros), además del constructor de la clase con los métodos (disparosRealizados y disparosAcertados)
import java.util.Scanner; //Importamos la biblioteca Scanner
public class BatallaNaval 
{
    //Atributos
    //Los 3 barcos del jugador 1
    private int [] barco1Jugador1 = {0,0}; //cada barco tendra una coordenada i y j en el tablero, las inicializamos en i=fila=0 y j=columna=0, luego la persona usuaria las modificara en el main
    private int [] barco2Jugador1 = {0,0};
    private int [] barco3Jugador1 = {0,0};
    //Los 3 barcos del juagdor 2
    private int [] barco1Jugador2 = {0,0}; 
    private int [] barco2Jugador2 = {0,0};
    private int [] barco3Jugador2 = {0,0};
    //Recordamos que los arrays multidimensionales son comunmente usados para representar tablas de valores (en este caso serían las coordenadas de cada barco en un tablero de 5 columnas y 5 filas)
    private int [][] tableroJugador1 = new int [5][5]; //Siguiendo la esctructura del libro pag.296: arrayType[][] arrayName = new arrayType[numRows][numColumns];
    private int [][] tableroJugador2 = new int [5][5];

    //Metodos de la clase BatallaNaval
    public BatallaNaval(int [] barco1Jugador1P, int [] barco2Jugador1P, int [] barco3Jugador1P, int [] barco1Jugador2P, int [] barco2Jugador2P, int [] barco3Jugador2P, int [][] tableroJugador1P, int [][] tableroJugador2P) //Metodo constructor
    {
        this.barco1Jugador1 = barco1Jugador1P;
        this.barco2Jugador1 = barco2Jugador1P;
        this.barco3Jugador1 = barco3Jugador1P;
        this.barco1Jugador2 = barco1Jugador2P;
        this.barco2Jugador2 = barco2Jugador2P;
        this.barco3Jugador2 = barco3Jugador2P;
        this.tableroJugador1 = tableroJugador1P;
        this.tableroJugador2 = tableroJugador2P;
    }
    //Necesitamos los metodos relacionados con los disparos, osea, leer las coordenadas en las que los jugadores posicionan a los barcos y leer la coordenada en la que se selecciona por el oponente
    //Como pienso esto es como sigue:
    //Tenemos una matriz de 5x5, que represente 2 coordenadas: coordenada i y j. Si la persona jugadora 1 posiciona su barco 1 en la posición i=5 y j=2, y la persona oponente dispara a la coordenada i=5 y j=2, entonces el resultado es que hunde el barco 1
    //Ahora imaginemos que la persona jugadora 2 posiciona su barco 1 en la posición i=1 y j=1. Si la persona oponente dispara en la coordenada i=1 y j=1 hunde el barco 1 de la persona 2. Esto se repite sucesivamente maximo 6 veces, un turno por persona con su 3 barcos. Minimo se repite 1 vez, en caso de que la persona gane a la primera.   
    //}
    public void posicionBarco(int fila, int columna, int[][] tablero, int jugador) //No hace falta devolver un int desde esta clase, el objetivo es modificar el tablero, no retornad un valor, las entradas fila, tablero y jugador que recibe esta clase se solicitan al inicio en el main
    {
        if(jugador == 1)
            tablero[fila][columna] = 1; //si el jugador escribe 1 en el main, el tablero sera el tablero del ljugador 1
        else
            tablero[fila][columna] = 2; //si el jugador escribe 2 en el main, el tablero sera el tablero del jugador 2
    }
    //El siguiente metodo es para leer los disparos, tiene que recibir coordenas i y j, el tablero (del oponente) y el jugador actual
    public boolean disparar(int fila, int columna, int [][] tableroOponente, int jugadorActual) //el método disparar nos tiene que devolver true or false en caso de que el disparo sea o no certero
    {
        if(tableroOponente[fila][columna] ==1)//se tiene que verificar si en la posicion dada i=fila y j=columna existe un barco (se usa el valor 1 para representar que existe un barco)
        {
            //Si hay un barco, lo tenemos que identificar como hundido, usaremos el numero 2 para identificarlo y mostramos el mensaje de que el jugadorActual tuvo acierto
            tableroOponente[fila][columna] = 2;
            System.out.println("Jugador " + jugadorActual + " acertó un disparo!");
            return true; //jugadorActual acertó el disparo
        }
        else
        {
            //Si no hay un barco en la coordenada i=fila y j=columna, entonces no hay acierto, se retorna un false y se asigna un valor nuevo en tableroOponente
            if(tableroOponente[fila][columna] == 0) //se usa el valor 0 para representar que no existe un barco en i=fila y j=columna
            {
                tableroOponente[fila][columna] = -1; //asignamos un valor de -1 para indicar que no tuvo acierto
            }
            System.out.println("Jugador " + jugadorActual + " falló el disparo!");
            return false; //no acertó el disparo
        }
    }
        //Primero tenemos que leer si ya hay un barco o no hay un barco en una posición dada
        if(tablero[fila][columna] == 0)
        {
            tablero[fila][columna] = 1;
        } else
        {
            System.out.println("Ya hay un barco en esa posición!");
        }

        //Recorrido por las filas
        for (int fila = 0; fila < tableroJugador1.length; fila++)
        {
            //Recorrido por las columnas
            for (int columna = 0; columna < tableroJugador1[fila].length; columna++)
            {
                System.out.printf("%d ", tableroJugador1[fila][columna]);
                tableroJugador1[fila][columna] = barco1Jugador1P;
            }
            System.out.println();
        }
        return barco1Jugador1P;
    }

    public int disparos(int [][] coordenadasDisparo) //Método para disparos
    {
        int disparo = coordenadasDisparo[0][0]; //Asumimos que inicia el disparo en posicion i=vacio, j=vacio
        //Aqui realizo la lectura del disparo de la persona jugadora y lo posiciono en una coordenada i y j del tablero de la persona jugadora oponente
        return disparo;
    }

    public void mostrarTablero(int [][] tablero)
    {

    }
}