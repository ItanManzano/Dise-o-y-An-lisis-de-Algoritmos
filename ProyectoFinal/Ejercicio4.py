def leer_puestos(archivo_entrada):
    postes = []
    with open(archivo_entrada, "r") as file:
        while True:
            linea = file.readline().strip()
            x, y = map(int, linea.split())
            if x == -1 and y == -1:
                break
            postes.append((x, y))
    return postes

def calcular_area(x1, y1, x2, y2, x3, y3):
    return abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2

def encontrar_triangulo_max_area(postes):
    n = len(postes)
    max_area = 0
    triangulo_max = ()

    # Iteramos sobre todas las combinaciones de 3 postes
    for i in range(n):
        for j in range(i + 1, n):
            for k in range(j + 1, n):
                x1, y1 = postes[i]
                x2, y2 = postes[j]
                x3, y3 = postes[k]

                # Calculamos el área del triángulo
                area = calcular_area(x1, y1, x2, y2, x3, y3)

                # Verificamos si es el triángulo de mayor área encontrado
                if area > max_area:
                    max_area = area
                    triangulo_max = (postes[i], postes[j], postes[k])

    return triangulo_max

def escribir_resultado(triangulo_max, archivo_salida):
    with open(archivo_salida, "w") as file:
        for x, y in triangulo_max:
            file.write(f"{x} {y}\n")

# Función principal
def main():
    archivo_entrada = "C:/Users/bruno/OneDrive/Escritorio/De todo/ProyectoFinal/campo.in"
    archivo_salida = "C:/Users/bruno/OneDrive/Escritorio/De todo/ProyectoFinal/campo.out"


    postes = leer_puestos(archivo_entrada)
    triangulo_max = encontrar_triangulo_max_area(postes)
    escribir_resultado(triangulo_max, archivo_salida)

if __name__ == "__main__":
    main()


