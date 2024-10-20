# -*- coding: utf-8 -*-
"""MonedaDivideyVenceras.ipynb

Automatically generated by Colab.

Original file is located at
    https://colab.research.google.com/drive/1sSV9sCI6gMI2a5iu4fl2J-F8nv48CfRW
"""

import sys

def min_monedas_divide_venceras(monedas, cantidad):

    if cantidad == 0:
        return 0

    if cantidad < 0:
        return sys.maxsize

    minimo = sys.maxsize

    for moneda in monedas:
        resultado = min_monedas_divide_venceras(monedas, cantidad - moneda)
        if resultado != sys.maxsize:
            minimo = min(minimo, resultado + 1)

    return minimo

monedas = [1, 2, 5]
cantidad = 27

respuesta = min_monedas_divide_venceras(monedas, cantidad)

if respuesta == sys.maxsize:
    print("No es posible formar la cantidad dada.")
else:
    print(f"Mínimo número de monedas: {respuesta}")

#Complejidad del Algoritmo
#Tiempo: O(m^n), donde n es la cantidad y m es el número de monedas.

#Espacio: 𝑂(𝑛) por el uso del stack de llamadas recursivas.