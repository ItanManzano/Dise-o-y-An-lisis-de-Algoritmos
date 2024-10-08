package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese el array A
        System.out.print("Introduce los números del array A separados por comas: ");
        String arrayInput = scanner.nextLine();
        int[] arrayA = parseInputToArray(arrayInput);

        // Solicitar al usuario que ingrese el patrón P
        System.out.print("Introduce los números del patrón P separados por comas: ");
        String patternInput = scanner.nextLine();
        int[] patternP = parseInputToArray(patternInput);

        // Llamar a la función para verificar si el patrón aparece en el array
        if (containsPattern(arrayA, patternP)) {
            System.out.println("El patrón P aparece en el array A.");
        } else {
            System.out.println("El patrón P no aparece en el array A.");
        }

        scanner.close();
    }

    // Función para convertir la entrada de cadena a un array de enteros
    private static int[] parseInputToArray(String input) {
        String[] parts = input.split(",");
        int[] result = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            result[i] = Integer.parseInt(parts[i].trim());
        }
        return result;
    }

    // Función para verificar si el patrón aparece en el array
    private static boolean containsPattern(int[] arrayA, int[] patternP) {
        // Convertir los arrays a cadenas para facilitar la comparación
        StringBuilder arrayStr = new StringBuilder();
        for (int num : arrayA) {
            arrayStr.append(num).append(",");
        }

        StringBuilder patternStr = new StringBuilder();
        for (int num : patternP) {
            patternStr.append(num).append(",");
        }

        // Verificar si el patrón aparece en el array
        return arrayStr.toString().contains(patternStr.toString());
    }
}
