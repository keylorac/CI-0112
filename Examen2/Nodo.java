//Una lista enlazada es una estructura de datos dinámica formada por nodos
//Cada nodo almacena:
//1. Un dato (ej: un libro, un cliente, etc.)
//2. Una referencia al siguiente nodo (es decir, a quién viene después)
//A diferencia de un arreglo, puede crecer o reducirse dinámicamente sin necesidad de redimensionar

public class Nodo{ //definimos el nodo
    int dato;
    Nodo siguiente;

   public Nodo(int dato){
    this.dato = dato;
    this.siguiente = null;
   }
}


