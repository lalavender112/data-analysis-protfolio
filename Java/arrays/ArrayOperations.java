//@author: Melissa Chen
//@date: 2025 June 28
//@purpose: array practice

package labs.example.arrays;

public class ArrayOperations {
    
    //Part 1
    public void createNewArray(int x){
        int[] array = new int[10]; //creates a new integer array of size 10 
        
        for (int i = 0; i < array.length; i++) { //for loop assigns values to the element
            array[i] = x + i;
        }

        displayArray(array); 
    }
    //calls displacyArray(array) to print the array's contents
    private void displayArray(int[] arr) {
        System.out.println("I created a new array and it now has " + arr.length + " items in it.");
        System.out.println("The array items and their values are listed below:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Index " + i + ": " + arr[i]);
        }
    }
     // Part 2: Bubble sort
     public void sortArray(int[] arr) {
        int n = arr.length; //determines the length of the array(n) using arr.length
        boolean swapped; //if no swaps occur, the array is sorted already

        for (int i = 0; i < n - 1; i++) { //loop runs n-1 times because after that many passes, the elements will all be sorted
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) { //compares adjacent elements j and j+1 and swaps them if j is bigger than j+1
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) break; //if no swap occurs, the array is already sorter and the outer loop breaks
        }

        System.out.println("Sorted array:"); //prints the sorted array
        for (int num : arr) {
            System.out.print(num + " "); //makes sure that theres a space between each element
        }
        System.out.println();
    }

    // Part 3: Days and months
    public void getDaysAndMonths() {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //this int array contains the number of days in each month
        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

        for (int i = 0; i < months.length; i++) { //alinging the number of days with their corresponding months
            System.out.println("There are " + days[i] + " days in " + months[i]);
        }
    }
}
