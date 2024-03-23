/* Joy Kim
3 September, 2022
CSE007 Fall 2022: Participation
JDK 11 
*/

// This program is intended to imitate a real-life ATM with some added/new features not regularly present
//This includes seeing the balance, withdrawing cash, and depositing cash or check.

import java.util.Scanner;

public class ATMVars{
    public static void main(String[]args){
        
        Scanner input = new Scanner(System.in); 
        System.out.println("Hello!");
        System.out.println("Please enter your initials to get started.");
        System.out.println("Please make sure to put a space in between initials with no periods :)");
        System.out.println(" ");
        System.out.print("Enter Initials: "); 
        char nameFirstInit = input.next().charAt(0); //utilizing char in order to get first name initial
        char nameLastInit = input.next().charAt(0); //utilizing char in order to get last name initial
    
        System.out.println("Welcome to the Bank of America ATM System");
        System.out.println("Main menu: ");
        System.out.println("1 - View my balance");
        System.out.println("2 - Withdraw Cash");
        System.out.println("3 - Deposit funds");
        System.out.println("4 - Exit");
        System.out.println("Account Owner: " + nameFirstInit + "." + nameLastInit + ".");
       
        double balance = 420.25; //Shows the total balance of the account
        int menuPressNum; // trying to write code that will show different results if 1,2,3,4 is pressed
        while (true){
            if (input.hasNextInt()){
                menuPressNum = input.nextInt();
                if (menuPressNum <= 4 && menuPressNum >= 1){
                    break;
                }
            }else{
                input.next();
            }
            System.out.println("Invalid Input. Please enter a valid input between 1 and 4.");
        }
                if (menuPressNum == 1){
                    System.out.print("Account Balance: $" + balance);
                }
                if (menuPressNum == 2){
                    System.out.print("Enter the amount you want to withdraw: ");
                    int numWithdrwl = input.nextInt(); //amount you want to withdraw
                    boolean isOverMaxWithdrwl; //establishing a limit to withdrawal (maximum) using a boolean
                    boolean isUnderMinWithdrwl; //establishing a limit to withdrawal (minimum) using a boolean
                    isOverMaxWithdrwl = ((0.8 * balance) < (double) numWithdrwl); // maximum: has to be less than 80% of balance
                    isUnderMinWithdrwl = ((0.01 * balance) > (double) numWithdrwl); // minimum: has to be more than 1% of balance
                        if (isOverMaxWithdrwl || isUnderMinWithdrwl){ // if over maximum or under minimum value
                            System.out.println("Unable to withdraw $" + numWithdrwl);
                            System.out.println("Either maximum withdrawal exceeded or minimum withdrawal was not met.");
                        }
                        if (!isOverMaxWithdrwl && !isUnderMinWithdrwl){
                                balance = balance - numWithdrwl;
                                System.out.println("You want to withdraw: $" + numWithdrwl);
                                System.out.println("Your new balance is: $" + balance);
                                
                                System.out.println("Would you like to receive half of your withdrawal in pennies?"); //trying to incorporate arithmetic expressions
                                String penniesYesNo; //in order to get an input of whether someone wants half their withdrawal in pennies
                                penniesYesNo = input.next();
                                
                                if (penniesYesNo.equals("yes")){
                                    final int withdrwlPennies = (100 * numWithdrwl) / 2; //the amount of pennies from half your withdrawal
                                    System.out.println("Your withdrawal in pennies: " + withdrwlPennies + " pennies dispensing.");
                                    System.out.println("Thank you, and come again.");
                                }
                                if (penniesYesNo.equals("no")){
                                    System.out.println("Please obtain the cash dispensed below.");
                                    System.out.println("Thank you, and come again.");
                                }
                        }
                }
                if (menuPressNum == 3){
                    System.out.println("Would you like to deposit check or cash?");
                    String depositMethod = input.next(); //trying to read user input of check or cash

                    if (depositMethod.equals("check")){ //if input is check then...
                        System.out.println("Please insert check now.");
                        System.out.println("Thank you, and come again.");
                    }
                    if (depositMethod.equals("cash")){ //if input is cash then...
                        System.out.println("Please insert cash now.");
                        System.out.println("Thank you, and come again.");
                    }
                } 
                if (menuPressNum == 4){
                    System.out.println("Exiting...");
                }
    }
}
