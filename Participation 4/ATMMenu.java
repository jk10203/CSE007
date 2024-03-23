/* Joy Kim
17 September, 2022
CSE007 Fall 2022: Participation 4
JDK 11 */
/* This program is intended to simulate an ATM machine by offering a variety of choices related to the functions
of an ATM. Some features include entering your pin, depositing check or cash, withdrawing money, checking
current balance, and changing PIN*/
import java.util.Scanner;
public class ATMMenu{
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        String PIN = "1234";
        double balance = 8008132;

        int attempt = 1;
        boolean verified = false; //in order to know whether pin was verified after 3 tries
        while (attempt < 4){
            System.out.println("Enter your pin");
            String pinAttempt = input.next();
            if (pinAttempt.equals(PIN)){
                System.out.println("Pin Verified");
                verified = true;
                break; 
            } else {
                System.out.println("Incorrect attempt, try again");
                attempt++;
            }
        }
        if (verified){
            boolean loop = true; //loop that goes back to menu after each option until Q is pressed
            do{ //menu options displayed
                System.out.println("ATM Main Menu");
                System.out.println("D: Deposit");
                System.out.println("W: Withdraw Cash");
                System.out.println("B: Display Current Balance");
                System.out.println("P: Change PIN");
                System.out.println("Q: Program ends.");

                System.out.println("Enter menu choice");
                char choice = input.next().charAt(0); //reads input character

                switch (choice){
                    case'D': //deposit
                        System.out.println("Would you like to deposit check or cash?");
                        String methodDep = input.next(); //to check if deposit is check or cash
                        if (methodDep.equals("check")){
                            System.out.println("Please insert check now.");
                            System.out.println("How much would you like to deposit?");
                            double deposit = input.nextDouble();
                            balance += deposit;
                            System.out.println("Your new balance is $" + balance);
                        } else if (methodDep.equals("cash")){
                            System.out.println("How much would you like to deposit?");
                            double deposit = input.nextDouble();
                            balance += deposit;
                            System.out.println("Your new balance is $" + balance);
                        } else {
                            System.out.println("Invalid option.");
                        }
                        break;
                    case 'W': //withdraw
                        System.out.println("Enter the amount you want to withdraw (multiple of 20)");
                        int with = input.nextInt();
                        if(with < balance && with % 20 == 0){
                            System.out.println("Withdraw successful");
                            balance -= with;
                            System.out.println("Your new balance is $" + balance);
                        } else {
                            System.out.println("Either invalid amount or insufficient funds");
                        }
                        break;
                    case 'B': //current balance
                        System.out.printf("Current balance is $%.2f", balance);
                        break;
                    case 'P': //change PIN
                        System.out.println("Please verfiy your PIN again to continue.");
                        String verifyPIN = input.next();
                        if (verifyPIN.equals(PIN)){
                            System.out.println("PIN verified. Please enter your new PIN");
                            String newPIN = input.next();
                            int countPIN = newPIN.length();
                            if (newPIN.equals(PIN)){ //cannot equal old pin
                                System.out.println("Invalid. New PIN cannot be the same as the old PIN.");
                            } else if (countPIN != 4){ //new pin has to be 4 digits long
                                System.out.println("Invalid. New PIN must be 4 digits long.");
                            } else {
                                PIN = newPIN;
                                System.out.println("New PIN has been saved.");
                            }
                        }
                        break;
                    case 'Q': //quit
                        System.out.println("Goodbye");
                        loop = false; //breaks loop
                        break;
                    default: 
                        System.out.println("Invalid option.");
                        loop = false; //breaks loop
                }
            } while (loop); //while loop is true, keep looping
        } else {
            System.out.println("Goodbye.");
        }
    }
}