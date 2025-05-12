//Main con el menu de los juegos batalla naval y ahorcado
import java.util.Scanner;

public class Main {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        //Menu donde el usuario puede elegir el juego a jugar
        do {
            System.out.println("\n-------------------------");
            System.out.println(" Menú de juegos ");
            System.out.println("\n-------------------------");
            System.out.println("1. Jugar Batalla Naval");
            System.out.println("2. Jugar Juego del Ahorcado");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
        }

        // Crea una instancia el juego y lo inicia
        JuegoAhorcado juego = new JuegoAhorcado();
        juego.iniciarJuego();
    }

}