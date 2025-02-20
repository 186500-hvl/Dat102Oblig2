package v2;
import java.util.Random;
import java.util.Arrays;

public class Oppgave1 {
    
    public static void insertionSort(int[] a) {
        int n = a.length;
        
      
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] < a[minIndex]) {
                minIndex = i;
            }
        }
        swap(a, 0, minIndex);

       
        for (int i = 1; i < n; i++) {
            int temp = a[i];
            int j = i - 1;

            
            while (j >= 0 && a[j] > temp) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp; 
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

   
        System.out.println("Siste 20 elementer etter sortering: " + Arrays.toString(Arrays.copyOfRange(arrayCopy, arrayCopy.length - 20, arrayCopy.length)));
    }
    
    private static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                System.out.println("Feil sortering ved indeks " + i + ": " + a[i - 1] + " > " + a[i]);
                return false;
            }
        }
        return true;
    }
}
