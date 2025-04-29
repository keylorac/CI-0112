////////////////////////////////////////////////////////////////////
//Lo primero que tenemos que hacer es notar que tenemos 2 clases:
//  -Clase Robot
//  -Clase JuegoBatalla
//Además se solicita que cada robot tenga los atributos siguientes:
//  -nombre
//  -puntosVida
//  -ataque
//////////////////////////////////////////////////////////////////

//Clase que representa un Robot en la batalla

public class Robot 
{
    //Atributos de la clase Robot
    private String nombre; //El nombre del robot
    private int puntosVida; //La cantidad de vida (entre 50 y 100)
    private int ataque; //La cantidad de dano que puede causar (entre 10 y 20)


    //Constructor
    public Robot(String nombre, int puntosVida, int ataque) //El método constructor debe tener el mismo nombre de la clase
    {
        this.nombre = nombre; //Se asigna el nombre
        this.puntosVida = puntosVida; //Se asigna los puntos de vida
        this.ataque = ataque; //Se asigna ataque
    }


    //Métodos que puede realizar la clase Robot
    public void atacar(Robot otroRobot) //Reduce los puntos de vida del otro robot según el ataque del robot
    {
        //Tomamos el otro robot y disminuimos los puntos de vida del otro robot
        otroRobot.puntosVida -= this.ataque;
        //Ahora se muestra en pantalla
        System.out.println("El robot " + this.nombre + " atacó al robot " + otroRobot.nombre + " y le causó " + this.ataque + " de daño en este ataque.");

        //En caso de que el otro Robot quede sin vida
        if(otroRobot.puntosVida <= 0)
        {
            System.out.println(otroRobot.nombre + " ha sido eliminado.");
        }
    } 

    public boolean estaVivo() //Retorna true si el robot tiene puntos de vida mayores a 0, false en caso contrario.
    {
        return this.puntosVida > 0; //Si puntosVida es mayor a 0 el robot está vivo, si es menor a 0 el robot está muerto.
    }

    public String getNombre() //Getter 1: obtener nombre (String) del robot
    {
        return nombre;
    }

    public int getPuntosVida() //Getter 2: obtener los puntos (int) de vida del robot
    {
        return puntosVida;
    }
}
