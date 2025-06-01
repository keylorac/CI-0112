package EstructuraDeDatos;

public class Nodo{
    private int dato;
    private Nodo siguiente;

    public Nodo(int datoP){
        this.dato = datoP;
        this.siguiente = null;
    }

    public void setDato(int dato){
        this.dato = dato;
    }
    public int getDato(){
        return dato;
    }

    public void setSiguiente(Nodo siguiente){
        this.siguiente = siguiente;
    }
    public Nodo getSiguiente(){
        return siguiente;
    }
}