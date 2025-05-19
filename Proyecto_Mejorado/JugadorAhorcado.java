import java.util.Scanner;

public class JugadorAhorcado {
    //Atributos del jugador 
    private String nombre;
    private int puntos;

    // Contructor de Jugador
    public JugadorAhorcado(String nombre) {
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
    public static JugadorAhorcado[] registrarJugadores() {
        Scanner scanner = new Scanner(System.in);

        // Registra el jugador #1
        System.out.println("Jugador #1, cuál es su nombre? ");
        String nombre1 = scanner.nextLine();
        

        // Registra al jugador #2
        System.out.println("Jugador #2, cuál es su nombre? ");
        String nombre2 = scanner.nextLine();

        JugadorAhorcado jugador1 = new JugadorAhorcado(nombre1);
        JugadorAhorcado jugador2 = new JugadorAhorcado(nombre2);

        return new JugadorAhorcado[] { jugador1, jugador2 };

    }

}
