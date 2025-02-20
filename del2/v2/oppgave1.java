package v2;

import java.util.Random;
import java.util.Arrays;

public class oppgave1 {
    
    public static void insertionSort(int[] a) {
        int n = a.length;
        
        // Finn minste element og flytt det til første posisjon
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] < a[minIndex]) {
                minIndex = i;
            }
        }
        swap(a, 0, minIndex);

        // Sorter resten ved å sette inn to elementer om gangen
        for (int i = 2; i < n; i += 2) {
            int min, max;
            if (a[i - 1] < a[i]) {
                min = a[i - 1];
                max = a[i];
            } else {
                min = a[i];
                max = a[i - 1];
            }

            int j = i - 2;

            // Flytt elementer for å sette inn "max"
            while (j >= 0 && a[j] > max) {
                a[j + 2] = a[j];
                j--;
            }
            a[j + 2] = max;

            // Flytt elementer for å sette inn "min"
            while (j >= 0 && a[j] > min) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = min;
        }

        
        if (n % 2 != 0) {
            int last = a[n - 1];
            int j = n - 2;
            while (j >= 0 && a[j] > last) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = last;
        }
    }
    
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static void main(String[] args) {
        int size = 150000; 
        int[] array = new Random().ints(size, 1, 150000).toArray(); 
        
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        
        long startTime = System.nanoTime();
        insertionSort(arrayCopy);
        long endTime = System.nanoTime();
        
        System.out.println("Sorteringstid: " + (endTime - startTime) / 1e9 + " sekunder");
        
        
        boolean sorted = isSorted(arrayCopy);
        System.out.println("Sortert korrekt: " + sorted);

       
        System.out.println("Første 20 elementer etter sortering: " + Arrays.toString(Arrays.copyOf(arrayCopy, 20)));
    }
    
    private static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i - 1] > a[i]) {
            	return false;
            }
        }
        return true;
    }
}