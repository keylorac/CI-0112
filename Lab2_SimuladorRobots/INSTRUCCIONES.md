# INSTRUCCIONES.md

## Batalla de Robots

LINK GITHUB: https://github.com/keylorac/CI-0112/tree/main/Lab2_SimuladorRobots

Este programa simula una pelea entre varios robots creados por el usuario. La idea es que se ataquen entre ellos hasta que solo uno quede en pie.



### ¿Cómo funciona?

1. Al iniciar el programa pregunta cuántos robots quieres crear (mínimo 2, máximo 10).
2. A cada robot se le asignan valores aleatorios para la vida (de 50 a 100), ataque (de 10 a 20) y defensa (de 0 a 10).
3. Los robots se atacan entre ellos de manera aleatoria. Cada ataque descuenta vida al otro, dependiendo de su defensa.
4. Después de cada ronda puede presionar ENTER para seguir, o escribir `STOP` si quiere ver cómo van los robots. Si escribe `STOP`, también pregunta si quiere salir del juego.
5. El último robot vivo es el ganador.

---

### Archivos que usé

- `Robot.java`: aquí está la clase del robot, con su vida, ataque, defensa y todo eso.
- `JuegoBatalla.java`: este archivo controla el juego como tal. Crea los robots, los hace pelear y muestra el ganador.
- `INSTRUCCIONES.md`: este archivo es un resumen de todo.

---

### ¿Cómo se corre?

Primero compila `Robot.java`, después `JuegoBatalla.java` y le da run a ese último. Lo puede hacer desde un IDE como BlueJ, NetBeans o incluso desde consola si estesta usando algo más básico.

---

### Comentario final
 
Le metí varios comentarios para entender bien cada parte del código.

Espero que funcione bien y que lo disfruten viendo  los robots
