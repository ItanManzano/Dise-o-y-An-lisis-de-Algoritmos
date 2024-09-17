# -*- coding: utf-8 -*-
"""Tarea 5.ipynb

Automatically generated by Colab.

Original file is located at
    https://colab.research.google.com/drive/17_1fDC72ouj7OuDkaWRXw5MKaFQhIeht
"""



def busqueda_lineal_bucket(arr, valor, num_buckets=5):
    n = len(arr)
    if n == 0:
        return -1

    # Crear los buckets
    max_value = max(arr)
    min_value = min(arr)
    bucket_size = (max_value - min_value) / num_buckets

    buckets = [[] for _ in range(num_buckets)]

    # Distribuir los elementos en buckets
    for elem in arr:
        bucket_index = int((elem - min_value) / bucket_size)
        if bucket_index == num_buckets:
            bucket_index -= 1  # En caso de que caiga justo en el límite superior
        buckets[bucket_index].append(elem)

    # Buscar el valor en el bucket correspondiente
    bucket_index = int((valor - min_value) / bucket_size)
    if bucket_index == num_buckets:
        bucket_index -= 1

    for i, elem in enumerate(buckets[bucket_index]):
        if elem == valor:
            return i  # Retorna el índice dentro del bucket
    return -1

def busqueda_lineal_centinela_bucket(arr, valor, num_buckets=5):
    n = len(arr)
    if n == 0:
        return -1

    # Crear los buckets
    max_value = max(arr)
    min_value = min(arr)
    bucket_size = (max_value - min_value) / num_buckets

    buckets = [[] for _ in range(num_buckets)]

    # Distribuir los elementos en buckets
    for elem in arr:
        bucket_index = int((elem - min_value) / bucket_size)
        if bucket_index == num_buckets:
            bucket_index -= 1  # En caso de que caiga justo en el límite superior
        buckets[bucket_index].append(elem)

    # Agregar el centinela al bucket correspondiente
    bucket_index = int((valor - min_value) / bucket_size)
    if bucket_index == num_buckets:
        bucket_index -= 1
    buckets[bucket_index].append(valor)

    # Realizar la búsqueda con centinela en el bucket correspondiente
    i = 0
    while buckets[bucket_index][i] != valor:
        i += 1

    buckets[bucket_index].pop()  # Remover el centinela

    if i < len(buckets[bucket_index]):
        return i  # Retorna el índice dentro del bucket
    else:
        return -1

def busqueda_binaria_quick(arr, valor):
    if len(arr) == 0:
        return -1

    # Base case
    if len(arr) == 1:
        return 0 if arr[0] == valor else -1

    # Elegir pivote (usamos el último elemento)
    pivot = arr[-1]

    if valor == pivot:
        return len(arr) - 1
    elif valor < pivot:
        return busqueda_binaria_quick(arr[:-1], valor)
    else:
        return busqueda_binaria_quick(arr[:-1], valor)


# Función principal para probar los algoritmos
def main():
    arreglo = [33, 10, 55, 71, 29, 5, 42, 90, 12, 41]
    valor_buscar = 41

    print("Búsqueda Lineal basada en Buckets:")
    resultado = busqueda_lineal_bucket(arreglo, valor_buscar)
    print(f"Índice de {valor_buscar} en bucket:", resultado)

    print("\nBúsqueda Lineal con Centinela basada en Buckets:")
    resultado = busqueda_lineal_centinela_bucket(arreglo, valor_buscar)
    print(f"Índice de {valor_buscar} en bucket con centinela:", resultado)

    # Ordenar el arreglo para la búsqueda binaria basada en Quick Sort
    arreglo_ordenado = sorted(arreglo)
    print("\nArreglo ordenado:", arreglo_ordenado)

    print("\nBúsqueda Binaria estilo Quick Sort:")
    resultado = busqueda_binaria_quick(arreglo_ordenado, valor_buscar)
    print(f"Índice de {valor_buscar} en búsqueda binaria:", resultado)
if __name__ == "__main__":
    main()