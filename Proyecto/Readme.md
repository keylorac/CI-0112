# Proyecto de Juegos por Consola

Este proyecto incluye dos juegos programados en Java:

-  **Batalla Naval**
-  **Juego del Ahorcado**

## ¿Cómo ejecutar el proyecto?

1. Debe de tener Java instalado.
2. Compile los archivos:
   ```bash
   javac Main.java BatallaNaval.java JuegoAhorcado.java
3. Ejecute el programa:
    java Main

Al ejecutar el programa verá el siguiente menú:

 Menu de juegos
 _____________________
1. Jugar Batalla Naval
2. Jugar Juego del Ahorcado
0. Salir
Seleccione una opción:


Ingrese el número correspondiente al juego que desea jugar:

## Batalla Naval
Dos jugadores colocan 3 barcos en un tablero de 5x5.

Luego, se turnan para disparar a posiciones del tablero enemigo.

Gana el jugador que hunda todos los barcos del oponente.

## Símbolos del tablero:

1 = Barco (solo se ve para el jugador que lo colocó)

2 = Impacto

-1 = Agua (disparo fallido)

0 = Casilla vacía

## Ahorcado
Adivina una palabra letra por letra.

Cada error suma una parte del "ahorcado".

El juego termina si aciertas toda la palabra o fallás demasiadas veces.

## Información adicional
Proyecto desarrollado con fines educativos.

El código está documentado y separado por clases.

No se requiere conexión a internet para jugar.
