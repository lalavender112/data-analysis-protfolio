//@author: Melissa Chen
//@date: 2025 July 3rd
//@purpose: Lab 6 part 4

package labs.example.new_arrarys;

public class CreditCardCheck {

    public void run(String cardNumber) {
        if (isValidCreditCard(cardNumber)) { //printing the results of the check
            System.out.println("Credit Card " + cardNumber + " is valid.");
        } else {
            System.out.println("Credit Card " + cardNumber + " is not valid.");
        }
    }

    public boolean isValidCreditCard(String number) {
        int sum = 0;
        boolean doubleDigit = false;

        for (int i = number.length() - 1; i >= 0; i--) { //Mod-10 check, loops in reverse order and moving toward the first digit
            int digit = Character.getNumericValue(number.charAt(i)); //retrueves the character at the current i of the number string
            if (doubleDigit) {
                digit *= 2; //if true, digit is multiplied by 2
                if (digit > 9) digit -= 9; //if resulting value >9, 9 is subtracted from it
            }
            sum += digit; //suming the digits 
            doubleDigit = !doubleDigit;
        }

        return sum % 10 == 0; //determine if the number is valid
    }
    
}

