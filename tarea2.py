# -*- coding: utf-8 -*-
"""Tarea2.ipynb

Automatically generated by Colab.

Original file is located at
    https://colab.research.google.com/drive/1OaWvLiZiSoUWWwhPchJ_kx0ynkUCIgmp
"""

def genera_comb(arr):
    total_comb = 0

    # Imprimir la entrada
    print(f"Arreglo: {arr}")

    # Generar las combinaciones con repetición
    #Complejidad temp T(n):O(n^2), debido a que hay dos bubles anidados,
    #cada uno de ellos iterado n veces donde n es el tamaño del arreglo
    for i in arr:
        for j in arr:
            print(i, j)
            total_comb += 1  # Incremento el contador

    # total de combinaciones
    print(f"Final: {total_comb}")

#Ejercicio
arr = [1, 2, 3]
genera_comb(arr)

# Complejidad temporal T(n):
# Este algoritmo tiene una complejidad temporal de O(n^2), donde n es el número de elementos en el arreglo.
# Esto es debido a que para cada elemento i en el arreglo, el algoritmo itera nuevamente a través de
# todos los elementos j, generando pares ordenados de cada combinación posible.