import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=== MENÚ PRINCIPAL === ");
            System.out.println("1. Jugar Batalla Naval");
            System.out.println("2. Jugar Ahorcado");
            System.out.println("3. Salir");
            System.out.println("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    BatallaNaval juegoBatallaNaval = new BatallaNaval();
                    juegoBatallaNaval.iniciarJuego();
                    break;

                case 2:
                    JuegoAhorcadoN ahorcado = new JuegoAhorcadoN();
                    ahorcado.jugar();
                    break;

                case 3:
                    System.out.println("Gracias por jugar. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opcion invalida");

            }
        } while (opcion != 4);
        scanner.close();
    }

}
