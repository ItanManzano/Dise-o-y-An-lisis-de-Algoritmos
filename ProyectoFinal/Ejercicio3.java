import java.util.Arrays;
import java.util.Random;

public class Ejercicio3{

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // Insertion Sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Función para medir el tiempo de ejecución
    public static double tiempo(Runnable sortFunction, int[] arr) {
        long start = System.nanoTime();
        sortFunction.run();
        long end = System.nanoTime();
        return (end - start) / 1e6; // Tiempo en milisegundos
    }

    public static void main(String[] args) {
        int[] sizes = {10, 100, 1000, 10000, 100000};
        Random random = new Random();

        System.out.println("N\tBubble Sort\tSelection Sort\tInsertion Sort\tMerge Sort");

        for (int size : sizes) {
            int[] arr = random.ints(size, 0, 10000).toArray();

            double bubbleTime = tiempo(() -> bubbleSort(arr.clone()), arr);
            double selectionTime = tiempo(() -> selectionSort(arr.clone()), arr);
            double insertionTime = tiempo(() -> insertionSort(arr.clone()), arr);
            double mergeTime = tiempo(() -> mergeSort(arr.clone()), arr);

            System.out.printf("%d\t%.4f ms\t%.4f ms\t%.4f ms\t%.4f ms%n",
                    size, bubbleTime, selectionTime, insertionTime, mergeTime);
        }
    }
}
