//@author: Melissa Chen
//@date: 2025 June 28
//@purpose: array practice

package labs.example.arrays;

public class Main {
    public static void main(String[] args) {
        ArrayOperations ops = new ArrayOperations();

        // Part 1: Create new array
        ops.createNewArray(5); //creates a new integer array of size 10, where each element is initialized to 5

        // Part 2
        int[] unsorted = {50, 23, 13, 8, 47, 1, 6, 33, 29, 44, 3, 38, 9, 5, 24,
                          27, 32, 17, 19, 2, 45, 11, 26, 10, 15, 35, 4, 20, 46,
                          14, 22, 21, 40, 31, 18, 36, 39, 7, 12, 25, 37, 16, 30,
                          34, 43, 28, 42, 48, 49, 41}; //the array contains values ranging from 1 to 50 in a random order

        ops.sortArray(unsorted);

        // Part 3
        ops.getDaysAndMonths(); //displays the number of days in each month
    }
}


