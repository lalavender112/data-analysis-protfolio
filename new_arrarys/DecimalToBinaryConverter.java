//@author: Melissa Chen
//@date: 2025 July 3rd
//@purpose: Lab 6 part 5

package labs.example.new_arrarys;

public class DecimalToBinaryConverter {

    public static String convertToBinary(int number) {
        if (number == 0) return "0"; //checking if input number is 0
        StringBuilder binary = new StringBuilder();  //StringBuilder is efficient for string manupulations

        while (number > 0) {
            binary.insert(0, number % 2); //insert method ensures the digits are constructed in the right order
            number /= 2; //shift the number to the right in binary terms 
        }//the process continues until number becomes 0

        return binary.toString(); //converts StringBuilder into a String
    }

    public static void main(String[] args) {
        int num = 156;
        String binary = convertToBinary(num); 
        System.out.println("The binary form of " + num + " is: " + binary); //returning and displaying the result
    }
}