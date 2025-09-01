//@author: Melissa Chen
//@date: 2025 June 13
//@purpose: Lab 3; give values to mammal details; make mammal sitting down and standing up

package labs.example.mammals;

public class Mammal {
    // declaring the values of the properties
    String hairColor = "brown";
    String eyeColor = "green";
    double bodyTemp = 78.4;
    String furColor = "white";
    double height = 168.2;
    double weight = 140.5;

    // Lab 3, printing mammal details
    public void getMammalDetails() {
        System.out.println("Mammal Details:");
        System.out.println("Hair Color: " + hairColor);
        System.out.println("Eye Color: " + eyeColor);
        System.out.println("Body Temperature: " + bodyTemp);
        System.out.println("Fur Color: " + furColor);
        System.out.println("Height: " + height);
        System.out.println("Weight: " + weight);
    }

    // Lab 2 existing methods. the lines describe/print what the mammal is doing 
    //these don't print because I don't call them at the Main.java file
    public void run() {
        System.out.println("The mammal is running.");
    }

    public void eat() {
        System.out.println("The mammal is eating.");
    }

    public void sleep() {
        System.out.println("The mammal is sleeping.");
    }

    public void scratch() {
        System.out.println("The mammal is scratching.");
    }

    public void drink() {
        System.out.println("The mammal is drinking.");
    }

    public void yawn() {
        System.out.println("The mammal is yawning.");
    }

    public void jump() {
        System.out.println("The mammal is jumping.");
    }

    public void laydown() {
        System.out.println("The mammal is laying down.");
    }

    // sit() method; simulates a mammal sitting down the standing after 15 seconds
    public void sit() throws InterruptedException { //the sit() method declares the execption in its signature using the throws keyword; it means that any code calling sit() must handle the InterruptedExecption
        System.out.println("The mammal is sitting.");
        Thread.sleep(15000); // sleep for 15 seconds
        stand(); //stands after sleeping
    }    

    // stand() method
    public void stand() {
        System.out.println("The mammal is now standing and barking!");
    }
}
    //these parts of the code has to be called in the Main.java file to have its values printed