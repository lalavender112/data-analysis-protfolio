//@author: Melissa Chen
//@date: 2025 July 3rd
//@purpose: Lab 6 part 2

package labs.example.new_arrarys;

public class ArraySumComparison {

    public static void main(String[] args) {
        int[] arr1 = new int[25]; //create an array with size of 25
        int[] arr2 = new int[25];
        int[] arr3 = new int[25];
    
        // Fill arrays with values that equal to i, i+1, i+2
        for (int i = 0; i < 25; i++) {
            arr1[i] = i;
            arr2[i] = i + 1;
            arr3[i] = i + 2;
        }
    
        // Sum arr1
        int sum1 = 0;
        for (int i = 0; i < 25; i++) {
            sum1 += arr1[i];
        }
    
        // Sum arr2
        int sum2 = 0;
        for (int i = 0; i < 25; i++) {
            sum2 += arr2[i];
        }
    
        // Sum arr3
        int sum3 = 0;
        for (int i = 0; i < 25; i++) {
            sum3 += arr3[i];
        }
    
        // Print the sums
        System.out.println("Sum of arr1: " + sum1);
        System.out.println("Sum of arr2: " + sum2);
        System.out.println("Sum of arr3: " + sum3);

        // Compare sums to find the highest
        if (sum1 >= sum2 && sum1 >= sum3) {
            System.out.println("arr1 has the highest sum: " + sum1);
        } else if (sum2 >= sum1 && sum2 >= sum3) {
            System.out.println("arr2 has the highest sum: " + sum2);
        } else {
            System.out.println("arr3 has the highest sum: " + sum3);
        }
    }
}
