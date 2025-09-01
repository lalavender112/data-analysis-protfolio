//@author: Melissa Chen
//@date: 2025 June 13
//@purpose: Lab 3; call the mammal from the Mammal.java so I can print the values given

package labs.example.mammals;

public class Main {
    public static void main(String[] args) throws InterruptedException { //entry point of the program
        Mammal myMammal = new Mammal();
        
        //calls the getMammalDetails() method on the myMammal object; prints the mammal's properties
        myMammal.getMammalDetails();

        //  sit() method is invoked on the myMammal object; simulates the mammal sitting down and then standing up after 15secs
        myMammal.sit();

        //  After 15 seconds, prints that the mammal is not sitting anymore
        System.out.println("The mammal is no longer sitting.");
    }
}
