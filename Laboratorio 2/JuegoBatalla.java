import java.util.Scanner; // Importamos Scanner para leer datos del usuario
import java.util.Random; // Importamos Random para generar valores aleatorios
import java.util.InputMismatchException; // Importamos para el manejo de excepciones

// Clase que maneja toda la lógica del juego
public class JuegoBatalla
{
    // Atributo: array que guardará los robots
    private Robot[] robots;

    // Método para iniciar la batalla entre robots
    public void iniciarBatalla() 
    {
        Random random = new Random(); // Creamos objeto para números aleatorios
        int cantidadRobotsVivos = robots.length; // Cantidad inicial de robots vivos

        // Mientras haya más de un robot vivo, sigue la batalla
        while (cantidadRobotsVivos > 1) 
        {
            // Recorremos todos los robots
            for (int i = 0; i < robots.length; i++) 
            {
                if (robots[i] != null && robots[i].estaVivo()) // Si el robot existe y está vivo
                {
                    // Elegimos un robot aleatorio para atacar
                    int indiceObjetivo = random.nextInt(robots.length); // Número aleatorio entre 0 y tamaño de array - 1

                    // Asegurarnos de que no se ataque a sí mismo y que el objetivo esté vivo
                    while (indiceObjetivo == i || robots[indiceObjetivo] == null || !robots[indiceObjetivo].estaVivo()) 
                    {
                        indiceObjetivo = random.nextInt(robots.length); // Volver a escoger
                    }

                    // El robot actual ataca al robot objetivo
                    robots[i].atacar(robots[indiceObjetivo]);
                }
            }

            // Contamos cuántos robots siguen vivos
            cantidadRobotsVivos = contarRobotsVivos();
        }

        // Mostrar al ganador
        mostrarGanador();
    }

    // Método para contar los robots vivos
    private int contarRobotsVivos() 
    {
        int vivos = 0; // Contador de vivos
        for (int i = 0; i < robots.length; i++) 
        {
            if (robots[i] != null && robots[i].estaVivo()) 
            {
                vivos++;
            }
        }
        return vivos;
    }

    // Método para mostrar el robot ganador
    public void mostrarGanador() 
    {
        for (int i = 0; i < robots.length; i++) 
        {
            if (robots[i] != null && robots[i].estaVivo()) 
            {
                System.out.println("¡El ganador es: " + robots[i].getNombre() + " con " + robots[i].getPuntosVida() + " puntos de vida restantes!");
                break;
            }
        }
    }

    // Método principal donde empieza todo
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in); // Para leer datos del usuario
        Random random = new Random(); // Para generar números aleatorios

        JuegoBatalla juego = new JuegoBatalla(); // Creamos un nuevo juego

        System.out.println("¡Bienvenido al Simulador de Batalla de Robots!");

        int cantidad = 0; // Variable para almacenar la cantidad de robots

        // Pedir la cantidad de robots usando manejo de excepciones
        while (true) 
        {
            try 
            {
                System.out.println("¿Cuántos robots desea crear? (Máximo 10)");
                double entradaUsuario = input.nextDouble(); // Leemos un número

                // Casting manual como enseñó el profesor
                cantidad = (int) entradaUsuario;

                // Validamos que la cantidad esté en el rango permitido
                if (cantidad >= 2 && cantidad <= 10) 
                {
                    break; // Salimos del ciclo si está correcto
                } 
                else 
                {
                    System.out.println("Debe ingresar un número entre 2 y 10.");
                }
            } 
            catch (InputMismatchException e) 
            {
                System.out.println("No ha ingresado un número válido.");
                input.next(); // Limpiar el scanner
            }
        }

        // Creamos el array de robots con la cantidad indicada
        juego.robots = new Robot[cantidad];

        // Bucle para pedir los datos de cada robot
        for (int i = 0; i < cantidad; i++) 
        {
            System.out.println("Ingrese el nombre del robot #" + (i + 1) + ":");
            String nombre = input.next(); // Leemos el nombre

            // Asignamos vida y ataque aleatorios
            int puntosVida = 50 + random.nextInt(51); // Número entre 50 y 100
            int ataque = 10 + random.nextInt(11); // Número entre 10 y 20

            // Creamos un nuevo robot y lo guardamos en el array
            juego.robots[i] = new Robot(nombre, puntosVida, ataque);

            // Mostramos los valores asignados
            System.out.println("Robot creado: " + nombre + " | Vida: " + puntosVida + " | Ataque: " + ataque);
        }

        // Iniciamos la batalla
        juego.iniciarBatalla();
    }
}
