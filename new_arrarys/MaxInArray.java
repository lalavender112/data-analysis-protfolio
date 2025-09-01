//@author: Melissa Chen
//@date: 2025 July 3rd
//@purpose: Lab 6 part 3

package labs.example.new_arrarys;

public class MaxInArray {

    public int findMax() {
        int[] myArray = new int[50]; //creating an array that has a size of 50
        for (int i = 0; i < 50; i++) { //fill in the array with random integers between 0-99
            myArray[i] = (int)(Math.random() * 100);
        }

        int max = myArray[0]; //max is initialized to the first element of array

        for (int i = 0; i < myArray.length - 1; i++) { //compare current element with current maximum value, if current is larger, max is updated
            if (myArray[i + 1] > max) {
                max = myArray[i + 1];
            }
        }

        return max;
    }
    public static void main(String[] args) {
        MaxInArray FindMax = new MaxInArray();  
        int maxValue = FindMax.findMax(); 
        System.out.println("The highest value in the myArray object is " + maxValue); //printing the results
    }
}
