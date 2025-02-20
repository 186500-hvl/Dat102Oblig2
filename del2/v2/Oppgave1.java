package v2;

import java.util.Random;
import java.util.Arrays;

public class Oppgave1 {

    public static void improvedInsertionSort(int[] a) {
        int n = a.length;
        
        // Finn minste element og flytt det til første posisjon
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] < a[minIndex]) {
                minIndex = i;
            }
        }
        swap(a, 0, minIndex);

        // Modifisert insertion sort - setter inn to elementer samtidig
        for (int i = 2; i < n; i += 2) {
            int smaller, larger;
            
            // Identifiser minste og største av de to som skal settes inn
            if (a[i] < a[i - 1]) {
                smaller = a[i];
                larger = a[i - 1];
            } else {
                smaller = a[i - 1];
                larger = a[i];
            }

            // Sett inn det største først
            int j = i - 1;
            while (j > 0 && a[j] > larger) {
                a[j + 2] = a[j];
                j--;
            }
            a[j + 2] = larger;

            // Sett inn det minste
            while (j > 0 && a[j] > smaller) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = smaller;
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
        improvedInsertionSort(arrayCopy);
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
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                System.out.println("Feil sortering ved indeks " + i + ": " + a[i - 1] + " > " + a[i]);
                return false;
            }
        }
        return true;
    }
}