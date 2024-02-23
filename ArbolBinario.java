package Parcial1;

/*Nombre: Alexa Cristina Pérez Sánchez*/

public class ArbolBinario {
    private Nodo raizArbol;

    public static class Nodo {
        int nombre;
        Nodo nodoIzq;
        Nodo nodoDer;

        public Nodo(int nombre) {
            this.nombre = nombre;
            this.nodoIzq = null;
            this.nodoDer = null;
        }
    }

    public ArbolBinario() {
        this.raizArbol = null;
    }

    public boolean vacio() {
        return raizArbol == null;
    }

    public Nodo buscarNodo(int nombre) {
        return buscarNodoRecursivo(raizArbol, nombre);
    }

    private Nodo buscarNodoRecursivo(Nodo actual, int nombre) {
        if (actual == null) {
            return null;
        }
        if (nombre == actual.nombre) {
            return actual;
        }
        return nombre < actual.nombre 
            ? buscarNodoRecursivo(actual.nodoIzq, nombre)
            : buscarNodoRecursivo(actual.nodoDer, nombre);
    }

    public void insertar(int nombre) {
        raizArbol = insertarRecursivo(raizArbol, nombre);
    }

    private Nodo insertarRecursivo(Nodo actual, int nombre) {
        if (actual == null) {
            return new Nodo(nombre);
        }
        if (nombre < actual.nombre) {
            actual.nodoIzq = insertarRecursivo(actual.nodoIzq, nombre);
        } else if (nombre > actual.nombre) {
            actual.nodoDer = insertarRecursivo(actual.nodoDer, nombre);
        }
        return actual;
    }

    public void imprimirArbolBinario() {
        imprimirRecursivo(raizArbol);
    }

    private void imprimirRecursivo(Nodo nodo) {
        if (nodo != null) {
            imprimirRecursivo(nodo.nodoIzq);
            System.out.print(" " + nodo.nombre);
            imprimirRecursivo(nodo.nodoDer);
        }
    }

    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.insertar(1);
        arbol.insertar(7);
        arbol.insertar(2);
        arbol.insertar(4);
        arbol.insertar(6);

        arbol.imprimirArbolBinario();
        
        if (arbol.buscarNodo(6) != null) {
            System.out.println("\nNodo 6 encontrado en el arbol binario");
        } else {
            System.out.println("\nNodo 6 no encontrado en el arbol binario");
        }
    }
}