public class Ejercicio1 {

    // Definir el laberinto
    static char[][] laberinto = {
        {'E', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'},
        {'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'},
        {'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'},
        {'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'},
        {'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'},
        {'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'},
        {'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 's'},
    };

    // Posiciones de movimiento (derecha, abajo)
    static int[] movimientoDerecha = {0, 3}; // Avanza 3 casillas hacia la derecha
    static int[] movimientoAbajo = {2, 0};   // Avanza 2 casillas hacia abajo

    // Coordenadas iniciales (posición de E)
    static int inicioX = 0;
    static int inicioY = 0;

    public static void main(String[] args) {
        // Empezar el recorrido del robot
        if (moverRobot(inicioX, inicioY)) {
            System.out.println("Se encontró una solución:");
            imprimirLaberinto();
        } else {
            System.out.println("No se encontró solución.");
        }
    }

    // Método para mover al robot según las reglas
    public static boolean moverRobot(int x, int y) {
        // Si llegamos a la salida, marcar y retornar
        if (laberinto[x][y] == 's') {
            laberinto[x][y] = 'x';  // Marcar la salida como parte del recorrido
            return true;
        }

        // Marcar la casilla actual como parte del recorrido
        laberinto[x][y] = 'x';

        // Intentar mover hacia la derecha
        if (esValido(x, y + 3)) {
            if (moverRobot(x, y + 3)) {
                return true;
            }
        }

        // Si no se pudo mover a la derecha, intentar mover hacia abajo
        if (esValido(x + 2, y)) {
            if (moverRobot(x + 2, y)) {
                return true;
            }
        }

        // Si no hay camino válido, desmarcar la casilla y retornar falso
        laberinto[x][y] = 'c';
        return false;
    }

    // Verificar si una posición es válida para moverse
    public static boolean esValido(int x, int y) {
        return x >= 0 && x < laberinto.length &&
               y >= 0 && y < laberinto[0].length &&
               laberinto[x][y] != 'x';  // No puede visitar una casilla ya recorrida
    }

    // Imprimir el laberinto después de encontrar la solución
    public static void imprimirLaberinto() {
        for (char[] fila : laberinto) {
            for (char celda : fila) {
                System.out.print(celda + " ");
            }
            System.out.println();
        }
    }
}
