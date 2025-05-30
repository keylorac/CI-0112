//Main con el menu de los juegos batalla naval y ahorcado
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        //Menu donde el usuario puede elegir el juego a jugar
        do {
            System.out.println(" Menu de juegos ");
            System.out.println("\n _____________________");
            System.out.println("1. Jugar Batalla Naval");
            System.out.println("2. Jugar Juego del Ahorcado");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); //limpieza del scanner
                //usamos estructuras de control vistas en clase para el menú

                switch(opcion)
                {
                    case 1:
                        //Creamos una instancia del juego BatallaNaval y se inicializa
                        JugadorBatallaNaval[] jugadores = JugadorBatallaNaval.registrarJugadores();
                        BatallaNaval batallaNaval = new BatallaNaval(jugadores[0], jugadores[1]);
                        batallaNaval.iniciarJuego();
                        break;


                    case 2:
                    JuegoAhorcadoN ahorcado = new JuegoAhorcadoN();
                    ahorcado.jugar();
                    break;

                    case 0:
                        //Se sale del programa
                        System.out.println("Gracias por jugar");
                        break;
                    default:
                        //Control de errores con un mensaje en caso de eerror
                        System.out.println("Por favor, intente de nuevo.");
                }
            } catch (InputMismatchException e){
                System.out.println("Debe ingresar un número, no letras. Intentar nuevamente.");
                scanner.nextLine();
            }
        } while (opcion != 0);

        scanner.close();//cerrar al final el scanner

    }

}