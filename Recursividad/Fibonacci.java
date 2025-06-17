public class Fibonacci {
    public static int calcularFibonacci (int n){
        // casos base: retorna n si es 0 o 1
        if(n==0 || n == 1){
            return n;
        }
        else{
            return calcularFibonacci(n-1) + calcularFibonacci(n-2);
        }
    }
    public static void main(String[] args) {
        int numero = 5;
        int resultado = calcularFibonacci(numero);
        System.out.println("El número de Fibonacci en la posición " + numero + " es" + resultado);
    }
    
}
