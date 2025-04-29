import java.util.Scanner; // La biblioteca Scanner es para leer datos del usuario
import java.util.Random; // La biblioteca Random es para generar valores aleatorios
import java.util.InputMismatchException; // La biblioteca InputMismatchException es para el manejo de excepciones (El profe nos dijo que usaramos en la medida de lo posible)


public class JuegoBatalla // Clase que maneja el juego en sí
{
    // Creamos un array que guardará los robots
    private Robot[] robots;

    // Se crea el primer método solicitado para iniciar la batalla entre robots
    public void iniciarBatalla() 
    {
        Random random = new Random(); // Se crea una varible random para números aleatorios
        Scanner scanner = new Scanner(System.in);
        int cantidadRobotsVivos = robots.length; // También se crea una variable para medir la cantidad inicial de robots vivos

        // Mientras haya más de un robot vivo, el juego continua
        while (cantidadRobotsVivos > 1) 
        {
            // Recorremos todos los robots
            for (int i = 0; i < robots.length; i++) 
            {
                if (robots[i] != null && robots[i].estaVivo()) // Esta línea lo que fuerza es a que si el robot existe y además está vivo se ejecute el ataque aleatorio
                {
                    // Elegimos un robot aleatorio para atacar
                    int indiceObjetivo = random.nextInt(robots.length); // Variable local que me da el número aleatorio entre 0 y tamaño de array - 1

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
            
            // Preguntamos al usuario si quiere pausar
            System.out.println("Presione ENTER para continuar o escriba 'STOP' para ver el estado de los robots:");
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("STOP"))
            {
                mostrarEstadoRobots();
                System.out.println("¿Desea salir del juego completamente? (si/no)");
                String respuesta = scanner.nextLine();
                if (respuesta.equalsIgnoreCase("si"))
                {
                    return; // Salimos del juego
                }
            }
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


    // Método para mostrar el estado de todos los robots
    private void mostrarEstadoRobots()
    {
        System.out.println("======= Estado actual de los robots =======");
        for (int i = 0; i < robots.length; i++)
        {
            if (robots[i] != null)
            {
                System.out.println("- " + robots[i].getNombre() +
                                   " | Vida: " + robots[i].getPuntosVida() +
                                   " | Ataque: " + robots[i].getAtaque() +
                                   " | Defensa: " + robots[i].getDefensa() +
                                   (robots[i].estaVivo() ? " | Vivo" : " | Muerto"));
            }
        }
        System.out.println("===========================================");
    }
    

    // Método principal donde empieza todo
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in); // Para leer datos del usuario
        Random random = new Random(); // Para generar números aleatorios

        JuegoBatalla juego = new JuegoBatalla(); // Creamos un nuevo juego

        System.out.println("Bienvenida y bienvenido al Simulador de Batalla de Robots!");

        int cantidad = 0; // Variable para almacenar la cantidad de robots

        // Acá solicitamos antidad de robots usando manejo de excepciones (try-catch vistas en clase)
        while (true) 
        {
            try 
            {
                System.out.println("Cuantos robots desea crear? (Maximo 10)");
                double entradaUsuario = input.nextDouble(); // Se lee un número

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
                System.out.println("No ha ingresado un numero valido.");
                input.next(); // Limpiar el scanner
            }
        }

        
        juego.robots = new Robot[cantidad]; // El array de robots con la cantidad indicada

        // Bucle para pedir los datos de cada robot
        for (int i = 0; i < cantidad; i++) 
        {
            System.out.println("Ingrese el nombre del robot #" + (i + 1) + ":");
            String nombre = input.next(); // Leemos el nombre

            // Asignamos vida y ataque aleatorios
            int puntosVida = 50 + random.nextInt(51); // Número entre 50 y 100
            int defensa = random.nextInt(11); //De 10 a 20
            int ataque = 10 + random.nextInt(11); // Número entre 10 y 20

            // Creamos un nuevo robot y lo guardamos en el array
            juego.robots[i] = new Robot(nombre, puntosVida, ataque, defensa);

            // Mostramos los valores asignados
            System.out.println("Robot creado: " + nombre + " | Vida: " + puntosVida + " | Ataque: " + ataque + "| Defensa: " + defensa );
        }

        // Iniciamos la batalla
        juego.iniciarBatalla();
    }
}
