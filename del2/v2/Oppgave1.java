package v2;
import java.util.Random;
import java.util.Arrays;

public class Oppgave1 {
    
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

        // Standard insertion sort, men starter fra indeks 1 (fordi vi har flyttet minste element)
        for (int i = 1; i < n; i++) {
            int temp = a[i];
            int j = i - 1;

            // Flytter elementer større enn `temp` ett hakk til høyre
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
        
        // Verifiser at arrayet er sortert
        boolean sorted = isSorted(arrayCopy);
        System.out.println("Sortert korrekt: " + sorted);

        // Skriv ut de første 20 elementene etter sortering
        System.out.println("Første 20 elementer etter sortering: " + Arrays.toString(Arrays.copyOf(arrayCopy, 20)));

        // Skriv ut de siste 20 elementene for feilsøking
        System.out.println("Siste 20 elementer etter sortering: " + Arrays.toString(Arrays.copyOfRange(arrayCopy, arrayCopy.length - 20, arrayCopy.length)));
    }
    
    private static boolean isSorted(int[] a) {
<<<<<<< HEAD:del2/v2/Oppgave1.java
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                System.out.println("Feil sortering ved indeks " + i + ": " + a[i - 1] + " > " + a[i]);
                return false;
=======
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i - 1] > a[i]) {
            	return false;
>>>>>>> 1ef9fd768fd7f35bf4388516fc1889954d9d3f22:del2/v2/oppgave1.java
            }
        }
        return true;
    }
}
