//@author: Melissa Chen
//@date: 2025 July 3rd
//@purpose: Lab 6 main

package labs.example.new_arrarys;

public class Main {

    public static void main(String[] args) {

        // Compare Arrays 
        CompareArrays compare = new CompareArrays();

        int[] firstArray = compare.createNewArray1();
        int[] secondArray = compare.createNewArray2(); //these two methods are called to generate two random integer arrays, containing 100 elements with randum values ranging from 0-99

        boolean sameLength = firstArray.length == secondArray.length; //compare length
        boolean sameContent = compare.arraysEqual(firstArray.clone(), secondArray.clone()); //compare values

        if (sameLength) {//displaying the results
            System.out.println("Yes, these arrays are the same length.");
        } else {
            System.out.println("No, these arrays are not the same length.");
        }

        if (sameContent) {
            System.out.println("Yes, these arrays contain the same values.");
        } else {
            System.out.println("No, these arrays do not contain the same values.");
        }

        //  Credit Card Check ---
        CreditCardCheck checker = new CreditCardCheck();
        String cardNumber = "4539578763621486"; //inputing a credit card number for check

        boolean isValid = checker.isValidCreditCard(cardNumber);

        System.out.println("Credit Card " + cardNumber + 
            (isValid ? " is valid." : " is not valid.")); //displaing validation results
    }
}
