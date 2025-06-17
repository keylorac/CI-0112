package PilasColasArboles;

public class Pila<T> {

    private Nodo<T> top;
    private int tamano;

    /*
     * otro constructor valido
     * public Pila(){
     * this.top = null;
     * this.tamano = 0;
     * }
     */
    public Pila(Nodo<T> nodo 1){ //constructor de la pila
        this.top = nodo1;
        this.tamano = 1;
    }

    public void push(T dato){
        Nodo<T> nodoV = new Nodo<>(dato);
        nodoV.setSiguiente(this.top);
        this.top = nodoV;
        tamano ++;
    }

    /*public T pop(T dato){ //tiene que retornar el tipo de dato, si yo quiero quitar un plato de una pila de datos, voy a querer ese plato cuando lo quito
        Nodo<T> nodoV = new Nodo<>(dato);
        if (this.top != null){
            this.top = this.top.getSiguiente();
            tamano --;
        }
        else{
            return null;
        }*/

    public boolean estaVacia(){
        //return this.tamano =< 0; otra manera de hacerlo
        return this.top == null;
    }

    public T pop(){
        if(this.estaVacia()){
            return null;
        }
        else{
            Nodo aux = this.top;
            this.top = aux.getSiguiente();
            this.tamano --;
            return aux.getDato();

        }
    }
    }


    
}
