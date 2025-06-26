public class Main {
    public static void main(String[] args){
        ListaEnlazada lista = new ListaEnlazada();

        lista.insertar(10);
        lista.insertar(20);
        lista.insertar(30);

        lista.mostrar(); //10 -> 20 -> 30 -> null 

        System.out.println("Esta el 20? " + lista.buscar(20)); //true

        lista.eliminar(20);
        lista.mostrar(); // 10 -> 30 -> null
    }
}
