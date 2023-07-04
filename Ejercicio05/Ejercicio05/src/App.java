//Clase Nodo, con atributos valor y siguiente.
//Valor: almacena el valor del nodo.
//Siguiente: indica el siguiente nodo en la lista.
class Nodo{
    int valor;
    Nodo siguiente;

    //Constructor de la clase Nodo.
    public Nodo(int valor){
        this.valor = valor;
        this.siguiente = null;
    }
}

//Clase Pila, con atributos tamanio y cima.
//Tamanio: tamaño de la pila.
//Cima: nodo superior de la pila.
class Pila{
    int tamanio;
    Nodo cima;

    //Constructor de la clase Pila.
    public Pila(){
        this.tamanio = 0;
        this.cima = null;
    }

    //Verifica si la pila esta vacia.
    public boolean vacia(){
        return cima == null;
    }

    //Metodo para empilar un elemento a la cima de la pila. 
    //Crea un nuevo nodo con el valor asignado.
    public void empilar(int valor){
        Nodo nuevoNodo = new Nodo(valor);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
        tamanio++;
    }

    ////Metodo para desempilar un elemento de la cima de la pila.
    public int desempilar(){
        if(vacia()){
            System.out.print("La pila esta vacia.");
            return -1; //Valor invalido.
        }

        int auxiliar = cima.valor;
        cima = cima.siguiente;
        tamanio--;
        return auxiliar; 
    }
 
    //Retorna el valor del elemento en cima de la pila.
    public int cima(){
        if(vacia()){
            System.out.print("La pila esta vacia.");
            return -1; //Valor invalido.
        }

        return cima.valor;
    }

    //Retorna el tamaño de la pila.
    public int tamanio(){
        if(tamanio > 0){
            return tamanio;
        }else{
            return 0;
        }
    }

    //Metodo para invertir el orden de los elementos en la pila.
    //Este metodo usa la recursion para invertir la pila.
    public void invertirPila(){
        if(vacia()){
            return;
        }

        int elemento = desempilar();
        invertirPila();
        insertarAlFondo(elemento);
    }

    //Ingresa un elemeton al fondo de la pila.
    //Este metodo desempila la Pila para ingresar el elemento al fondo.
    public void insertarAlFondo(int elemento){
        if(vacia()){
            empilar(elemento);
        }else{
            int cima = desempilar();
            insertarAlFondo(elemento);
            empilar(cima);
        }
    }

    //Metodo para mostrar en pantalla los elementos de la pila.
    //Imprime la pila en orden, desde la cima hasta el fondo.
    public void imprimir(){
        if(vacia()){
            System.out.println("La pila esta vacia.");
        }

        Nodo nodoActual = cima;
        while(nodoActual != null){
            System.out.print(nodoActual.valor + " ");
            nodoActual = nodoActual.siguiente;
        }

        System.out.println();
    }
}

//Clase principal del programa.
public class App {
    public static void main(String[] args) throws Exception {
        //Creamos la pila.
        Pila pila = new Pila();

        //Se agregan valores a la pila.
        pila.empilar(1);
        pila.empilar(2);
        pila.empilar(3);
        pila.empilar(4);
        pila.empilar(5);

        //Se imprime la pila inicialmente.
        System.out.println("Pila: ");
        pila.imprimir();

        //Se invierte la pila.
        pila.invertirPila();

        //Se imprime la pila invertida.
        System.out.println("Pila invertida: ");
        pila.imprimir();
    }
}