//@author: Melissa Chen
//@date: 2025 July 3rd
//@purpose: Lab 6 part 1

package labs.example.new_arrarys;

import java.util.Random;
import java.util.stream.IntStream;

public class CompareArrays {

    public int[] createNewArray1() { //generate random array1
        return IntStream.generate(() -> new Random().nextInt(100)).limit(100).toArray();
    }

    public int[] createNewArray2() { //generate random array 2
        return IntStream.generate(() -> new Random().nextInt(100)).limit(100).toArray();
    }

    // Bubble sort method
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no elements were swapped, array is sorted
            if (!swapped) break;
        }
    }

    // Compare if arrays contain the same values (after sorting)
    public boolean arraysEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;

        // Sort both arrays before comparison
        bubbleSort(arr1);
        bubbleSort(arr2);

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
