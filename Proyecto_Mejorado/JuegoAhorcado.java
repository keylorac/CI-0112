import java.util.Scanner;
import java.util.Random;

public class JuegoAhorcado {
    private final int intentosMaximos = 6;

    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Registrar jugadores
        Jugador[] jugadores = Jugador.registrarJugadores();
        Jugador jugador1 = jugadores[0];
        Jugador jugador2 = jugadores[1];

        // Ronda 1 y 2
        System.out.println(
                "\n RONDA 1: " + jugador1.getNombre() + " pone la palabra, " + jugador2.getNombre() + " adivina");
        jugarRonda(jugador1, jugador2, scanner);

        System.out.println(
                "\n RONDA 2: " + jugador2.getNombre() + " pone la palabra, " + jugador1.getNombre() + " adivina");
        jugarRonda(jugador2, jugador1, scanner);

        // Mostrar resultados
        System.out.println("\n Fin del juego. Resultados finales:");
        

        if (jugador1.getPuntos() > jugador2.getPuntos()) {
            System.out.println(" Gana " + jugador1.getNombre() + "!");
        } else if (jugador2.getPuntos() > jugador1.getPuntos()) {
            System.out.println(" Gana " + jugador2.getNombre() + "!");
        } else {
            System.out.println(" ¡Empate! Se jugará una ronda extra de desempate.");

            // Desempate aleatorio
            boolean jugador1PonePalabra = random.nextBoolean();
            Jugador quienPone = jugador1PonePalabra ? jugador1 : jugador2;
            Jugador quienAdivina = jugador1PonePalabra ? jugador2 : jugador1;

            System.out.println("\n Sorteo: " + quienPone.getNombre() + " pone la palabra, " + quienAdivina.getNombre()
                    + " la adivina.");
            jugarRonda(quienPone, quienAdivina, scanner);

            System.out.println("\n Puntos totales tras desempate:");
            System.out.println(jugador1);
            System.out.println(jugador2);

            if (jugador1.getPuntos() > jugador2.getPuntos()) {
                System.out.println(" Gana " + jugador1.getNombre() + "!");
            } else if (jugador2.getPuntos() > jugador1.getPuntos()) {
                System.out.println(" Gana " + jugador2.getNombre() + "!");
            } else {
                System.out.println(" ¡Empate incluso en el desempate! Ambos ganan.");
            }
        }
    }

    // Jugar una ronda de Ahorcado
    private void jugarRonda(Jugador quienPonePalabra, Jugador quienAdivina, Scanner scanner) {
        String palabraSecreta = leerPalabraSecreta(scanner, quienPonePalabra.getNombre());

        StringBuilder progreso = new StringBuilder();
        for (int i = 0; i < palabraSecreta.length(); i++) {
            progreso.append('_');
        }

        int intentosRestantes = intentosMaximos;

        while (intentosRestantes > 0 && progreso.indexOf("_") != -1) {
            System.out.println("\nPalabra: " + progreso);
            System.out.println("Turno de " + quienAdivina.getNombre() + " (Puntos: " + quienAdivina.getPuntos() + ")");
            char letra = leerLetra(scanner);

            boolean acierto = false;
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra && progreso.charAt(i) == '_') {
                    progreso.setCharAt(i, letra);
                    acierto = true;
                    quienAdivina.sumarPuntos();
                }
            }

            if (acierto) {
                System.out.println(" Letra correcta.");
            } else {
                intentosRestantes--;
                System.out.println(" Letra incorrecta. Intentos restantes: " + intentosRestantes);
            }
        }

        System.out.println("\n Palabra final: " + progreso);
        if (progreso.indexOf("_") == -1) {
            System.out.println(" ¡" + quienAdivina.getNombre() + " adivinó la palabra!");
        } else {
            System.out.println(" Se acabaron los intentos. La palabra era: " + palabraSecreta);
        }
    }

    // Validar palabra secreta
    private String leerPalabraSecreta(Scanner scanner, String nombre) {
        String palabra;
        do {
            System.out.println("\n" + nombre + ", ingresa la palabra secreta:");
            System.out.print("Palabra (solo letras, sin espacios): ");
            palabra = scanner.nextLine().trim().toLowerCase();
            if (!palabra.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ]+")) {
                System.out.println(" La palabra debe contener solo letras. Intenta de nuevo.");
                palabra = "";
            }
        } while (palabra.isEmpty());
        return palabra;
    }

    // Validar letra
    private char leerLetra(Scanner scanner) {
        String entrada;
        do {
            System.out.print("Ingresa una letra: ");
            entrada = scanner.nextLine().trim().toLowerCase();
            if (!entrada.matches("[a-zñáéíóú]") || entrada.length() != 1) {
                System.out.println(" Debes ingresar una sola letra válida.");
                entrada = "";
            }
        } while (entrada.isEmpty());
        return entrada.charAt(0);
    }
}
