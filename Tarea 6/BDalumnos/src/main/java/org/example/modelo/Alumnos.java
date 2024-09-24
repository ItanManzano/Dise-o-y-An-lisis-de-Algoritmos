package org.example.modelo;

import java.util.Arrays;

public class Alumnos extends Object{
    private int numeroC;
    private String nombre;
    private int edad;
    private String correoE;
    private int semestre;
    private String[] materias;
    private double promedio;

    public int getNumeroC() {
        return numeroC;
    }

    public void setNumeroC(int numeroC) {
        this.numeroC = numeroC;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreoE() {
        return correoE;
    }

    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String[] getMaterias() {
        return materias;
    }

    public void setMaterias(String[] materias) {
        this.materias = materias;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    //constructor
    public Alumnos(int numeroC, String nombre, int edad, String correoE, int semestre, String[] materias, double promedio) {
        this.numeroC = numeroC;
        this.nombre = nombre;
        this.edad = edad;
        this.correoE = correoE;
        this.semestre = semestre;
        this.materias = materias;
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Alumnos{" +
                "numeroC=" + numeroC +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", correoE='" + correoE + '\'' +
                ", semestre=" + semestre +
                ", materias=" + Arrays.toString(materias) +
                ", promedio=" + promedio +
                '}';
    }

    //metodo para mostrat la informacion del alumno
    public void mostrarInfo(){
        System.out.println("Nombre "+nombre);
        System.out.println("Materias: ");
        for (String materia : materias){
            System.out.println(materia);
        }
        System.out.println("Promedio general: "+promedio);
    }
}
