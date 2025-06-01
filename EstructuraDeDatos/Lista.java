package EstructuraDeDatos;

public class Lista {
    
    private Nodo primero;

    public Lista(){
        this.primero = null;
    }

    public Lista(Nodo primerNodoP){
        this.primero = primerNodoP;
    }

    public boolean buscar(int valor){
        Nodo actual = this.primero;
        while (actual != null){
            if(actual.getDato()==valor){
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }
    
}

//Tarea: 
