// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.Random;
import java.util.Scanner;

public class JuegoAhorcadoN {
   private final int intentosMaximos = 6;

   public JuegoAhorcadoN() {
   }

   public void jugar() {
      Scanner var1 = new Scanner(System.in);
      Random var2 = new Random();
      JugadorAhorcado[] var3 = JugadorAhorcado.registrarJugadores();
      JugadorAhorcado var4 = var3[0];
      JugadorAhorcado var5 = var3[1];
      System.out.println("\n RONDA 1: " + var4.getNombre() + " pone la palabra, " + var5.getNombre() + " adivina");
      this.jugarRonda(var4, var5, var1);
      System.out.println("\n RONDA 2: " + var5.getNombre() + " pone la palabra, " + var4.getNombre() + " adivina");
      this.jugarRonda(var5, var4, var1);
      System.out.println("\n Fin del juego. Resultados finales:");
      if (var4.getPuntos() > var5.getPuntos()) {
         System.out.println(" Gana " + var4.getNombre() + "!");
      } else if (var5.getPuntos() > var4.getPuntos()) {
         System.out.println(" Gana " + var5.getNombre() + "!");
      } else {
         System.out.println(" ¡Empate! Se jugará una ronda extra de desempate.");
         boolean var6 = var2.nextBoolean();
         JugadorAhorcado var7 = var6 ? var4 : var5;
         JugadorAhorcado var8 = var6 ? var5 : var4;
         System.out.println("\n Sorteo: " + var7.getNombre() + " pone la palabra, " + var8.getNombre() + " la adivina.");
         this.jugarRonda(var7, var8, var1);
         System.out.println("\n Puntos totales tras desempate:");
         System.out.println(var4);
         System.out.println(var5);
         if (var4.getPuntos() > var5.getPuntos()) {
            System.out.println(" Gana " + var4.getNombre() + "!");
         } else if (var5.getPuntos() > var4.getPuntos()) {
            System.out.println(" Gana " + var5.getNombre() + "!");
         } else {
            System.out.println(" ¡Empate incluso en el desempate! Ambos ganan.");
         }
      }

   }

   private void jugarRonda(JugadorAhorcado var1, JugadorAhorcado var2, Scanner var3) {
      String var4 = this.leerPalabraSecreta(var3, var1.getNombre());
      StringBuilder var5 = new StringBuilder();

      int var6;
      for(var6 = 0; var6 < var4.length(); ++var6) {
         var5.append('_');
      }

      var6 = 6;

      while(var6 > 0 && var5.indexOf("_") != -1) {
         System.out.println("\nPalabra: " + var5);
         System.out.println("Turno de " + var2.getNombre() + " (Puntos: " + var2.getPuntos() + ")");
         char var7 = this.leerLetra(var3);
         boolean var8 = false;

         for(int var9 = 0; var9 < var4.length(); ++var9) {
            if (var4.charAt(var9) == var7 && var5.charAt(var9) == '_') {
               var5.setCharAt(var9, var7);
               var8 = true;
               var2.sumarPuntos();
            }
         }

         if (var8) {
            System.out.println(" Letra correcta.");
         } else {
            --var6;
            System.out.println(" Letra incorrecta. Intentos restantes: " + var6);
         }
      }

      System.out.println("\n Palabra final: " + var5);
      if (var5.indexOf("_") == -1) {
         System.out.println(" ¡" + var2.getNombre() + " adivinó la palabra!");
      } else {
         System.out.println(" Se acabaron los intentos. La palabra era: " + var4);
      }

   }

   private String leerPalabraSecreta(Scanner var1, String var2) {
      String var3;
      do {
         System.out.println("\n" + var2 + ", ingresa la palabra secreta:");
         System.out.print("Palabra (solo letras, sin espacios): ");
         var3 = var1.nextLine().trim().toLowerCase();
         if (!var3.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ]+")) {
            System.out.println(" La palabra debe contener solo letras. Intenta de nuevo.");
            var3 = "";
         }
      } while(var3.isEmpty());

      return var3;
   }

   private char leerLetra(Scanner var1) {
      String var2;
      do {
         System.out.print("Ingresa una letra: ");
         var2 = var1.nextLine().trim().toLowerCase();
         if (!var2.matches("[a-zñáéíóú]") || var2.length() != 1) {
            System.out.println(" Debes ingresar una sola letra válida.");
            var2 = "";
         }
      } while(var2.isEmpty());

      return var2.charAt(0);
   }
}
