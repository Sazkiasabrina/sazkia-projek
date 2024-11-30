package asd;
import java.util.Scanner;

public class SortingComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan ukuran array: ");
        int n = scanner.nextInt();
        int[] originalArray = new int[n];
        
        System.out.println("Masukkan elemen-elemen array:");
        for (int i = 0; i < n; i++) {
            originalArray[i] = scanner.nextInt();
        }
        
        int[] bubbleArray = originalArray.clone(); 
        long startBubble = System.nanoTime();
        bubbleSort(bubbleArray);
        long endBubble = System.nanoTime();
        long timeBubble = endBubble - startBubble;

        int[] mergeArray = originalArray.clone(); 
        long startMerge = System.nanoTime();
        mergeSort(mergeArray, 0, mergeArray.length - 1);
        long endMerge = System.nanoTime();
        long timeMerge = endMerge - startMerge;

        System.out.println("Hasil Bubble Sort: ");
        printArray(bubbleArray);
        System.out.println("Waktu eksekusi Bubble Sort: " + timeBubble + " nanodetik");

        System.out.println("Hasil Merge Sort: ");
        printArray(mergeArray);
        System.out.println("Waktu eksekusi Merge Sort: " + timeMerge + " nanodetik");
        
        scanner.close();
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap elemen
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Implementasi Merge Sort
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = array[left + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = array[mid + 1 + i];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    // Fungsi untuk mencetak array
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
