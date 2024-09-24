import org.example.modelo.Alumnos;
import org.example.modelo.ArbolBST;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArbolBST arbol = new ArbolBST(); // Crear una instancia del árbol
        Scanner scanner = new Scanner(System.in);

        // Preguntar al usuario cuántos alumnos quiere ingresar
        System.out.println("¿Cuántos alumnos quieres ingresar?");
        int numeroAlumnos = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        // Bucle para ingresar los datos de los alumnos
        for (int i = 0; i < numeroAlumnos; i++) {
            System.out.println("Ingrese los datos del alumno " + (i + 1) + ":");

            // Capturar datos del alumno
            int numeroCuenta;
            while (true) {
                System.out.print("Número de cuenta (9 dígitos): ");
                numeroCuenta = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                // Validar que el número de cuenta tenga 9 dígitos
                if (String.valueOf(numeroCuenta).length() == 9) {
                    break; // Salir del bucle si es válido
                } else {
                    System.out.println("Error: El número de cuenta debe tener exactamente 9 dígitos.");
                }
            }

            System.out.print("Nombre completo: ");
            String nombre = scanner.nextLine();

            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            System.out.print("Correo electrónico: ");
            String correo = scanner.nextLine();

            int semestre;
            while (true) {
                System.out.print("Semestre (1-9): ");
                semestre = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                // Validar que el semestre esté entre 1 y 9
                if (semestre >= 1 && semestre <= 9) {
                    break; // Salir del bucle si es válido
                } else {
                    System.out.println("Error: El semestre debe estar entre 1 y 9.");
                }
            }

            // Ingresar las materias
            String[] materias = new String[5];
            for (int j = 0; j < 5; j++) {
                System.out.print("Materia " + (j + 1) + ": ");
                materias[j] = scanner.nextLine();
            }

            System.out.print("Promedio general: ");
            double promedio = scanner.nextDouble();
            scanner.nextLine(); // Consumir el salto de línea

            // Crear un objeto Alumnos con los datos ingresados
            Alumnos alumno = new Alumnos(numeroCuenta, nombre, edad, correo, semestre, materias, promedio);

            // Insertar el alumno en el árbol
            arbol.insertar(alumno);
        }

        // Consulta al final de la inserción
        System.out.print("Ingrese el número de cuenta del alumno que desea buscar: ");
        int numeroCuentaBuscar = scanner.nextInt();

        Alumnos alumnoBuscado = arbol.buscar(numeroCuentaBuscar);
        if (alumnoBuscado != null) {
            System.out.println("Alumno encontrado: ");
            System.out.println("Nombre: " + alumnoBuscado.getNombre());
            System.out.println("Promedio: " + alumnoBuscado.getPromedio());
            System.out.println("Materias:");
            for (String materia : alumnoBuscado.getMaterias()) {
                System.out.println("- " + materia);
            }
        } else {
            System.out.println("Alumno no encontrado.");
        }
    }
}
