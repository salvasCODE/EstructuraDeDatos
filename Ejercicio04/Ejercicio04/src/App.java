//Clase que representa un nodo en una lista circular.
class Nodo {
    String palabra;
    Nodo siguiente;

    //Constructor de la clase Nodo.
    public Nodo(String palabra) {
        this.palabra = palabra;
        this.siguiente = null;
    }
}

//Clase que representa una lista circular de palabras.
class ListaCircular {
    Nodo puntero;

    //Constructor de la clase ListaCircular.
    public ListaCircular() {
        this.puntero = null;
    }

    //Verifica si la lista está vacía.
    public boolean vacia() {
        return puntero == null;
    }

    //Metodo para añadir una nueva palabra a la lista en orden alfabético.
    public void añadirPalabra(String nuevaPalabra) {
        Nodo nuevoNodo = new Nodo(nuevaPalabra);

        if (vacia()) {
            nuevoNodo.siguiente = nuevoNodo;
            puntero = nuevoNodo;
        } else if (nuevaPalabra.compareTo(puntero.palabra) > 0) {
            nuevoNodo.siguiente = puntero.siguiente;
            puntero.siguiente = nuevoNodo;
            puntero = nuevoNodo;
        } else {
            Nodo actual = puntero.siguiente;
            Nodo anterior = null;

            while (actual != puntero && nuevaPalabra.compareTo(actual.palabra) > 0) {
                anterior = actual;
                actual = actual.siguiente;
            }

            nuevoNodo.siguiente = actual;
            anterior.siguiente = nuevoNodo;
        }
    }

    //Metodo para eliminar una palabra de la lista.
    public void eliminarPalabra(String palabraEliminar) {
        if (vacia()) {
            return;
        }

        Nodo actual = puntero.siguiente;
        Nodo anterior = puntero;

        do {
            if (actual.palabra.equals(palabraEliminar)) {
                anterior.siguiente = actual.siguiente;

                if (actual == puntero) {
                    puntero = anterior;
                }

                return;
            }

            anterior = actual;
            actual = actual.siguiente;
        } while (actual != puntero.siguiente);
    }

    //Metodo para imprimir los elementos de la lista en orden.
    public void imprimirLista() {
        if (vacia()) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo actual = puntero.siguiente;

        do {
            System.out.println(actual.palabra);
            actual = actual.siguiente;
        } while (actual != puntero.siguiente);
    }
}

//Clase principal que contiene el método main para ejecutar el programa.
public class App {
    public static void main(String[] args) throws Exception {
        ListaCircular lista = new ListaCircular();

        lista.añadirPalabra("ComputaciónCientífica");
        lista.añadirPalabra("Estadística");
        lista.añadirPalabra("InvestigaciónOperativa");
        lista.añadirPalabra("Sistemas");

        System.out.println("Lista original:");
        lista.imprimirLista();

        System.out.println("Añadimos una nueva palabra:");
        lista.añadirPalabra("Matemática");
        lista.imprimirLista();

        System.out.println("Eliminamos una palabra:");
        lista.eliminarPalabra("Estadística");

        System.out.println("Lista después de eliminar 'Estadística':");
        lista.imprimirLista();
    }
}