package ListaEnlazadaSimple;

public class ListaSimple {
    //atributos
    private Nodo inicio; //apuntador al primer elemento de la lista
    private int numElem; //contador de elementos de la lista

    //constructor de la clase, inicializa el apuntador a siguiente en null y el valor del elemento en 0
    public ListaSimple(){
        this.inicio = null;
        this.numElem = 0;
    }
    
    //Rectorna la cantidad actual de elementos de la lista

    public int getNumeroElementos (){
        return this.numElem;
    }

     //Insertar un nodo nuevo al principio de la lista

     public void insertarInicio(int elemento){ //la inserción al inicio es la más básica
        //nodo nuevo = new nodo(elemento, this.inicio); //usando el constructor con parámetros

        Nodo nuevo = new Nodo(); //constructor por defecto, creamos un nuevo nodo y le damos memoria
        nuevo.setElemento(elemento); //inicializar el atr elemento con el valor, estamos creando un nodo con el primer constructor que hicimos
        nuevo.setSig(this.inicio); //hacer que el siguiente del nuevo nodo apunte al inicio de la lista
        this.inicio = nuevo; //ahora el nuevo inicio es el nuevo nodo
        this.numElem++; //sumamos uno a la cantidad de elementos
     }

     public void insertalFinal(int elemento){
        /*Hacemos un equivalente a lo que ya teníamos:
         *  Nodo nuevo = new Nodo(); //constructor por defecto
         *  nuevo.setElemento(elemento);
         *  nuevo.setSig(null); // solamente que setSig no será "inicio", será "final", que en programación se llama "null", pues el puntero que va hacia el final
         *  TODO ESTO DE Nodo nuevo = new Nodo(); se nuevo.setElemento(elemento); nuevo.setSig(null) se puede simplemente escribir como Nodo nuevo = new Nodo (elemento, null);
         */
        Nodo nuevo = new Nodo(elemento, null); //creamos un nuevo nodo que apunta a null, le pasamos el elemento que tenemos y le pasamos null como puntero
        if(this.inicio == null){ //validamos si la lista está vacía, this.inicio es el atributo del inicio de mi clase lista. La lista está vacía. 
            this.inicio = nuevo;
            numElem++;
        }
        else { //Si no está vacía usamos un nodo auxiliar para empezar a recorrer, para que este Nodo auxiliar pueda empezar a pasar la lista hasta llegar al último elemento. 
            Nodo aux = this.inicio; // Nodo auxiliar para recorrer la lista
            while (aux.getSig() != null){ //no es el ultimo, le preguntamos si el elemento que auxiliar no llega al ultimo elemento entonces tenemos que igualarlo.
                aux = aux.getSig(); //avanzamos al siguiente nodo
            }
            aux.setSig(nuevo); //como ya estamos en el ultimo elemento de la lista, procedemos a insertar el nuevo. Procedemos a ingresar el elemento de la ultima lista.
            this.numElem++;
        }
     }
     
     public void imprimirElementos(){
        if (this.inicio != null){ //validamos qye la lista no esté vacía
            Nodo actual = this.inicio;
            int cont = 1;
            while (actual.getSig() != null){ //recorrer la lista elemento por elemento hasta llegar al final. Cuando getSig sea nulo, pues ya llegamos al ultimo elemento
                System.out.println("Elemento " + String.valueOf(cont) + ": " + actual.getElemento());
                actual = actual.getSig();
                cont ++; //sumamos en el contador
            }
            System.out.println("Elemento " + String.valueOf(cont) + ": " + actual.getElemento());
        }
        else{
            //la lista está vacía
            System.out.println("La lista tiene " + this.numElem + " elementos");
        }
     }

     //Ahora vamos a borrar de la lista
     //auxilia.siguiente debe apuntar a nulo. El otro se lo tiene que llevar la basura
     //Al final de cuentas, es pasar el auilixiar del inicio.

     //BORRADO AL PRINCIPIO
     public void eliminarAlInicio(){
        if (this.inicio != null){
            this.inicio = this.inicio.getSig();
            this.numElem--;
        }
        else{
            System.out.println("La lista tiene " + this.numElem + " elementos, no se puede borrar");
        }
     }

     //BORRADO AL FINAL DE LA LISTA
     public void eliminarAlFinal(){
        if (this.inicio != null){
            //if(this.inicio.getSig() != null){
            }
            if(this.numElem > 1){

            }
        }
}
