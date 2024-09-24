package org.example.modelo;

public class nodoBST{
    private Alumnos alumno;
    private nodoBST izquierdo;
    private nodoBST derecho;

    public nodoBST(Alumnos alumno){
        this.alumno = alumno;
        this.izquierdo = null;
        this.derecho = null;
    }

    public Alumnos getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
    }

    public nodoBST getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(nodoBST izquierdo) {
        this.izquierdo = izquierdo;
    }

    public nodoBST getDerecho() {
        return derecho;
    }

    public void setDerecho(nodoBST derecho) {
        this.derecho = derecho;
    }
}

