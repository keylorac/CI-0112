import java.util.Scanner;

//Atributos del jugador 
public class Jugador {
    private String nombre;
    private int puntos;

    // Contructor de Jugador
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    // Funcion de sumar puntos a los jugadores
    public void sumarPuntos() {
        puntos++;
    }
        //Validación de Nombres 
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






    // Registro de jugadores
    public static Jugador[] registrarJugadores() {
        Scanner scanner = new Scanner(System.in);

        // Registra el jugador #1
        System.out.println("Jugador #1, cuál es su nombre? ");
        String nombre1 = scanner.nextLine();
        scanner.nextLine();

        // Registra al jugador #2
        System.out.println("Jugador #2, cuál es su nombre? ");
        String nombre2 = scanner.nextLine();

        Jugador jugador1 = new Jugador(nombre1);
        Jugador jugador2 = new Jugador(nombre2);

        return new Jugador[] { jugador1, jugador2 };

    }

}
