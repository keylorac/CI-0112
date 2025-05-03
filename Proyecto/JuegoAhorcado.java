import java.util.Scanner;

public class JuegoAhorcado {
    private Palabra palabra; // Instancia de la clase Palabra (la palabra que se va a adivinar)
    private int intentosMaximos = 6; // Cantidad maxima de intentos permitidos
    private int intentosActuales = 0; // Cuenta los intentos hechos
    private Scanner scanner = new Scanner(System.in); // Lee la entrada de datos ingresados por el usuario

    public void iniciarJuego() {
        System.out.println("¡Bienvenido a jugar ahorcado!!");

        // Pedir al usuario que ingrese la palabra secreta
        System.out.println("Jugador 1, ingresa la palabra a adivinar: ");
        String palabraIngresada = scanner.nextLinr().toLowerCase();

        // Limpiar simuladamente
        for (int i = 0; i < 50; i++)
            System.out.println(); // Simula limpiar la consola

        // Crear una nueva palabra para adivinar
        palabra = new Palabra(palabraIngresada);

        // Bucle principal del juego
        while (!palabra.estaCompleta() && intentosActuales < intentosMaximos) {
            System.out.println("\nPalabra: " + palabra.obtenerProgreso());
            System.out.println("Intentos restantes: " + (intentosMaximos - intentosActuales));
            System.out.println("Ingresa una letra: ");

            // Leer la letra ingresada por el usuario
            char letra = scanner.next().toLowerCase().charAt(0);

            // Verificar si la letra esta en la palabra
            if (!palabra.intentarLetra(letra)) {
                System.out.println("¡Letra incorrecta!!");
            } else {
                System.out.println("¡Bien! Letra correcta. ");
            }
            intentosActuales++; // Aumenta los intentos si la letra no esta en la palabra
        }

        // Fin del juego: ¿Gano o perdio?
        if (palabra.estaCompleta()) {
            System.out.println("\nFelicidades! Adinaste la palabra: " + palabra.obtenerPalabra());

        } else {
            System.out.println("\n ¡Has perdido. La palabra era: " + palabra.obtenerPalabra());
        }
    }
}