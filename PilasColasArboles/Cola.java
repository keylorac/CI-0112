package PilasColasArboles;

public class Cola <T> {
    private Nodo<T> head;
    private Nodo<T> tail;
    private int tamano;

    public Cola(){
        this.head = null;
        this.tamano = 0;
        this.tail = null;
    }
    
    public boolean estaVacia(){
        return this.tamano =< 0;
        //o
        return this.top == null;
    }

    public void enqueue(T dato){
        Nodo<T> nodoV = new Nodo<> (dato);
        if(estaVacia()){
            this.head = nodoV;
            this.tail = nodoV;
            this.tamano ++;
        } 
        else{
            this.tail.setSiguiente(nodoV);
            this.tail = nodoV;
            this.tamano ++;
        }
        //this.tamano ++; tambien lo podemos hacer aqui
    }
}

//Hacer de tarea: el dequeue (en el dequeue no se puede quitar elementos de cualquier manera, hay un orden que seguir, el orden de la cola)
