import java.util.ArrayList;
import java.util.List;

public class Ejercicio1_1 {

    // Laberinto modificado
    static char[][] laberinto = {
        {'E', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'},
        {'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'},
        {'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'},
        {'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'},
        {'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'},
        {'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'},
        {'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 's'},
    };

    // Posiciones de movimiento
    static int[] movimientoDerecha = {0, 3}; // Avanza 3 casillas hacia la derecha
    static int[] movimientoAbajo = {2, 0};   // Avanza 2 casillas hacia abajo

    static int inicioX = 0, inicioY = 0;

    // Lista para almacenar todos los caminos posibles
    static List<List<String>> caminos = new ArrayList<>();

    public static void main(String[] args) {
        List<String> caminoActual = new ArrayList<>();
        buscarCaminos(inicioX, inicioY, caminoActual);

        // Imprimir todos los caminos encontrados
        if (caminos.isEmpty()) {
            System.out.println("No se encontraron soluciones.");
        } else {
            System.out.println("Caminos posibles:");
            for (int i = 0; i < caminos.size(); i++) {
                System.out.println("Camino " + (i + 1) + ": " + caminos.get(i));
            }
        }
    }

    // Método recursivo para buscar caminos
    public static void buscarCaminos(int x, int y, List<String> caminoActual) {
        // Si llegamos a la salida, registrar el camino
        if (laberinto[x][y] == 's') {
            caminoActual.add("(" + x + "," + y + ")");
            caminos.add(new ArrayList<>(caminoActual));
            caminoActual.remove(caminoActual.size() - 1); // Quitar la última casilla después de añadir el camino
            return;
        }

        // Marcar la casilla actual como recorrida
        laberinto[x][y] = 'x';
        caminoActual.add("(" + x + "," + y + ")");

        // Intentar mover hacia la derecha
        if (esValido(x, y + 3)) {
            buscarCaminos(x, y + 3, caminoActual);
        }

        // Intentar mover hacia abajo
        if (esValido(x + 2, y)) {
            buscarCaminos(x + 2, y, caminoActual);
        }

        // Desmarcar la casilla actual (backtracking)
        laberinto[x][y] = 'c';
        caminoActual.remove(caminoActual.size() - 1); // Eliminar la última casilla del camino
    }

    // Verificar si una posición es válida para moverse
    public static boolean esValido(int x, int y) {
        return x >= 0 && x < laberinto.length &&
               y >= 0 && y < laberinto[0].length &&
               laberinto[x][y] != 'x'; // No puede visitar una casilla ya recorrida
    }
}
