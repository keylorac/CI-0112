//Implementamos la lista
public class ListaEnlazada{
    private Nodo cabeza; //creamos un atributo llamado cabeza que puede apuntar a un nodo, en este punto cabeza apunta a null (no apunta a ningún objeto aún). Tengo una etiqueta lista, pero vacía.

    public ListaEnlazada(){
        this.cabeza = null;
    }

    //Método Insertar al final
    public void insertar(int dato){
        Nodo nuevo = new Nodo(dato); //aquí sí estamos creando un objeto Nodo real con new. Le pego la etiqueta de un nodo real.
        if (cabeza == null){ //si cabeza == null significa que no hay nodos todavía. Si está vacía, entonces este nuevo nodo será el primer nodo de la lista
            cabeza = nuevo; //se asigna cabeza = nuevo, es decir, el nuevo nodo es ahora el inicio de la lista
        }else {
            Nodo temp = cabeza;//temp es una variable tipo Nodo (una clase que yo cree) y el recorre la lista. Vamos a crear la variable tipo Nodo de nombre temp que es igual a cabeza, y los dos ahora apuntan al mismo nodo
            while (temp.siguiente != null){
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
        }
    }
    
    //Buscar un elemento en la lista enlazada
    //Para ver esto línea por línea tenemos que hacer
    public boolean buscar(int dato){//public boolean buscar(dato que queremos buscar en la lista enlazada)
        Nodo temp = cabeza; //Creamos un puntero llamado temp que empieza en la cabeza de la lista
        while (temp != null){ //Mientras temp no sea null, significa que todavía hay nodos por revisar
            if (temp.dato == dato){ //Si el dato que tiene este nodo es igual al que estoy buscando
                return true;//Retornamos true: encontramos el dato en la lista
            } else { //Si no lo encontramos en este nodo, seguimos con el siguiente
                temp = temp.siguiente; //temp = temp.siguiente quiere decir que me muevo al siguiente nodo
            }
        }
        return false; //Si llegamos hasta aquí, es porque recorrimos toda la lista y no encontramos el dato
    }

    //Eliminar un elemento en la lista enlazada
    public void eliminar(int dato){
        if(cabeza == null){ //Si la lista está vacía, osea cabeza == null
            return; //No hay nada que eliminar
        }
        //Si el dato que quiero eliminar está en el primer nodo (cabeza)
        if(cabeza.dato == dato){
            //Muevo la cabeza al siguiente nodo (eliminando el primero)
            cabeza = cabeza.siguiente;
            return;
        }
        
        //Si el dato a eliminar no está al inicio, recorre nodo por nodo hasta encontrar el dato
        //Creamos un nodo temporal para recorrer la lista
        Nodo actual = cabeza;

        //Mientras no estemos al final y el siguiente nodo no tenga el dato que buscamos borrar
        while (actual.siguiente != null && actual.siguiente.dato != dato){
            //Avanzamos al siguiente nodo
            actual = actual.siguiente;
        }

        //Si encontramos el nodo que contiene el dato que queremos eliminar
        if (actual.siguiente != null){
            //Saltamos al nodo que queremos eliminar
            actual.siguiente = actual.siguiente.siguiente; //Cuando lo encuentra, se lo salta (lo desconecta)
        }
    }

    //Mostrar la lista
    public void mostrar(){
        Nodo temp = cabeza;
        while (temp != null){
            System.out.print(temp.dato + " -> ");
            temp = temp.siguiente;
        }
        System.out.println("null");
    }
}