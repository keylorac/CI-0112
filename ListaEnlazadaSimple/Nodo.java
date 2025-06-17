package ListaEnlazadaSimple;

public class Nodo {
    //atributos
    private Nodo siguiente; //"apuntador al siguiente nodo"
    private int elemento; //elemento(s) 

    //constructor de la clase nodo por defecto
    public Nodo(){
        elemento = 0;
        siguiente = null;
    }

    //constructor de la clase nodo
    public Nodo (int elem, Nodo sig){
        elemento = elem;
        siguiente = sig;
    }

    //get para el elemento 
    public int getElemento(){
        return elemento; 
    }

    //get pata el siguiente en la lista
    public Nodo getSig(){
        return siguiente;
    }

    public void setElemento(int elem){
        elemento = elem;
    }

    public void setSig(Nodo sig){
        siguiente = sig;
    }
    
}
