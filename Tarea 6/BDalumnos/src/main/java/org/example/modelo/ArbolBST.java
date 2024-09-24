package org.example.modelo;

public class ArbolBST {
    private nodoBST raiz;

    // Constructor
    public ArbolBST() {
        this.raiz = null;
    }

    // Método para insertar un nuevo alumno en el BST usando numeroCuenta como clave
    public void insertar(Alumnos alumno) {
        raiz = insertarRecursivo(raiz, alumno);
    }

    // Método recursivo para insertar el alumno en la posición correcta
    private nodoBST insertarRecursivo(nodoBST nodo, Alumnos alumno) {
        if (nodo == null) {
            return new nodoBST(alumno); // Crear un nuevo nodo si se encuentra un lugar vacío
        }

        // Comparar los números de cuenta para determinar la posición en el árbol
        if (alumno.getNumeroC() < nodo.getAlumno().getNumeroC()) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), alumno));
        } else if (alumno.getNumeroC() > nodo.getAlumno().getNumeroC()) {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), alumno));
        }

        return nodo;
    }

    // Método para buscar un alumno por su número de cuenta
    public Alumnos buscar(int numeroC) {
        return buscarRecursivo(raiz, numeroC);
    }

    // Método recursivo para buscar el alumno en el árbol
    private Alumnos buscarRecursivo(nodoBST nodo, int numeroC) {
        // Si no se encuentra el nodo (llegamos a un nodo vacío)
        if (nodo == null) {
            return null;
        }

        // Si encontramos el número de cuenta
        if (numeroC == nodo.getAlumno().getNumeroC()) {
            return nodo.getAlumno();
        }

        // Si el número de cuenta buscado es menor, buscamos en el subárbol izquierdo
        if (numeroC < nodo.getAlumno().getNumeroC()) {
            return buscarRecursivo(nodo.getIzquierdo(), numeroC);
        } else {
            // Si es mayor, buscamos en el subárbol derecho
            return buscarRecursivo(nodo.getDerecho(), numeroC);
        }
    }
}
