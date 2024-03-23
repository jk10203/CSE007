/* Joy Kim
7 September, 2022
CSE007 Fall 2022: Participation 3
JDK 11 */
/* This program is an extension from the ATMVars program in which it serves to add more features
to the ATM system by utilizing new methods like Character.isDigit, etc*/
import java.util.Scanner;
public class AtmAPI{
    public static void main(String[]args){
        Scanner in = new Scanner (System.in);
        final String pin = "1234"; //if you use string instead of integer you can check is number or letter
        double balance = 123456.54;
        final double EPSILON = 1E-14;

        System.out.println("Enter your pin");
        String pinAttempt = in.next();
        // isDigit(char ch) determines if the specified characer is a digit
        //make sure that every character in the pinAttempt is a digit
        if(pinAttempt.length() == 4){
            if(Character.isDigit(pinAttempt.charAt(0))&& Character.isDigit(pinAttempt.charAt(1)) && Character.isDigit(pinAttempt.charAt(2))
            && Character.isDigit(pinAttempt.charAt(3))){ //checks first character in index zero in pinAttempt
                System.out.println("PIN is valid 4 digit sequence");
            }
        }
        if(pin.equals(pinAttempt)){
            System.out.println("Pin Verified!");
            System.out.println("How much do you want to withdraw?");
            double withdraw = in.nextDouble();

            //see if you are trying to withdraw your total balance
            if(Math.abs(withdraw - balance)< EPSILON){
                System.out.println("You wil have no money after this transaction.");
            } else if (withdraw > balance){
                System.out.println("You do not have enough money in your account.");
            } else {
                System.out.println("Withdrawal successful.");
                balance -= withdraw;
                System.out.println("Your new balance is: $" + balance);
            }
        } else {
            System.out.println("Doesn't match, try again");
        }

    }
}