package org.example;

import java.util.HashMap;
import java.util.Map;

public class cambioMonedas {

    public static int cambioMonedas(int[] monedas, int cantidadObjetivo, Map<Integer, Integer> monedasUsadas) {
        // Si la cantidad objetivo es 0, no se necesita ninguna moneda
        if (cantidadObjetivo == 0) {
            return 0;
        }

        // Si la cantidad objetivo es negativa, no es posible formar esa cantidad
        if (cantidadObjetivo < 0) {
            return Integer.MAX_VALUE; // Infinito, para representar una solución inválida
        }

        // Inicializamos la mínima cantidad de monedas como un valor grande
        int resultadoMinimo = Integer.MAX_VALUE;
        Map<Integer, Integer> mejorCombinacion = new HashMap<>();

        // Intentamos con cada moneda
        for (int moneda : monedas) {  // Corregido de moneda a monedas
            Map<Integer, Integer> monedasUsadasTemp = new HashMap<>(monedasUsadas);
            int resultado = cambioMonedas(monedas, cantidadObjetivo - moneda, monedasUsadasTemp);

            // Si el resultado no es infinito, significa que es una solución válida
            if (resultado != Integer.MAX_VALUE) {
                monedasUsadasTemp.put(moneda, monedasUsadasTemp.getOrDefault(moneda, 0) + 1);

                // Tomamos el mínimo entre el resultado actual y el resultado más una moneda usada
                if (resultado + 1 < resultadoMinimo) {
                    resultadoMinimo = resultado + 1;
                    mejorCombinacion = monedasUsadasTemp;
                }
            }
        }

        // Actualizamos el mapa de monedas usadas con la mejor combinación encontrada
        monedasUsadas.clear();
        monedasUsadas.putAll(mejorCombinacion);

        return resultadoMinimo;
    }

    public static void main(String[] args) {
        int[] monedas = {1, 2, 5};
        int cantidadObjetivo = 27;

        // Mapa para almacenar cuántas monedas de cada tipo se usan
        Map<Integer, Integer> monedasUsadas = new HashMap<>();

        // Llamar a la función para encontrar el mínimo número de monedas
        int resultado = cambioMonedas(monedas, cantidadObjetivo, monedasUsadas);

        // Si no se encontró una solución válida, imprimir mensaje
        if (resultado == Integer.MAX_VALUE) {
            System.out.println("No tenemos tanto cambio.");
        } else {
            System.out.println("El número mínimo de monedas es: " + resultado);
            System.out.println("Monedas usadas:");
            for (Map.Entry<Integer, Integer> entry : monedasUsadas.entrySet()) {
                System.out.println("Moneda de " + entry.getKey() + ": " + entry.getValue() + " monedas");
            }
        }
    }
}
