/* Joy Kim
November 30, 2022
CSE007 Fall 2022: Lab 12
JDK 11 */
/* This program is intended to be the test class that utilizes multiple other classes in order to create
a banking system that is able to keep track of the account's type, number, owner, balance, and interest if 
it is a savings accounts. It utilizes methods in order to add to the banking system's features (displaying accounts,
finding accounts, sorting accounts, and exitting).
*/

import java.util.Scanner;

public class TestAccounts {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BankAccount [] accounts = new BankAccount[10];
        //BankAccount - blueprint to create objects
        //things left to do:
        //do we do anything for interest accumulated
 
        //creating new (objects?) in BankAccount class
        // object = new " "
        accounts[0] = new CheckingAccount("William Burst", 10000);
        accounts[1] = new SavingsAccount("Laura Stevens", 25000, 9.25);
        accounts[2] = new CheckingAccount("Nathan Steward", 24900);
        accounts[3] =  new SavingsAccount("Isabel Truman", 89250, 10.5);
        accounts[4] =  new SavingsAccount("Andrew Sullivan", 12734, 12.1);
        accounts[5] =  new CheckingAccount("George Duck", 29990);
        accounts[6] =  new SavingsAccount("Emma Stevens", 31250, 8.89);
       
        int operations = 0;//just to count how many operations are being performed each time the program runs
        boolean loopies = true;

        while (loopies){ //loop for program to run
            System.out.println("Select an operation: ");
            System.out.println("1: display accounts");
            System.out.println("2: find accounts");
            System.out.println("3: sort accounts by owner name");
            System.out.println("4: exit");

            if (input.hasNextInt()){ //input validation
                int choice = input.nextInt();
                if (choice == 1){
                    printAccounts(accounts);
                    operations++; //just counting operations
                }
                else if (choice == 2){
                    System.out.println("Please enter an amount: ");
                    double amountHow = inputVal(input);;
                    findAccounts(accounts, amountHow);
                    operations++;//just counting operations
                    System.out.println(" ");
                }
                else if (choice == 3){
                    sortAccounts(accounts);
                    operations++;//just counting operations
                    System.out.println(" ");
                }
                else if (choice == 4){
                    System.out.println("Exitting...");
                    loopies = false; //exits out of the program loop
                } else { //if any other number other than 1-4
                    System.out.println("Please enter a valid operation: ");
                }
            } else { //if input does NOT HAVE NEXT INT
                System.out.println("Please enter a valid operation: ");
                input.nextLine();
            }
        } 
    }

    //every method for test class is static
    public static void printAccounts(BankAccount[] list){ 
        System.out.println(String.format("%-10s\t%-10s\t%-30s\t%-10s\t%-10s","Type", "Number", "Owner", "Balance", "Interest"));
        for(int i =0; i<7; i++){ // have to set restriction to 7 and NOT length bc length is 10, and we only have 7 elements
            System.out.println(list[i] + " ");
        }

        System.out.println("There are " + BankAccount.getNumAccounts() + " BankAccounts, " + CheckingAccount.getNumChecking()+ " CheckingAccounts, and " + SavingsAccount.getSavings() + " SavingsAccounts.");
        System.out.println(" "); //in order to access public getter from BankAccount class, have to specify the class then state method within that class for static
    }
    public static void findAccounts(BankAccount[] list, double amount){   //WHY INT???
        //FOR FINDING ACCOUNTS GIVEN USER INPUT
        int counter = 0;
        for (int i =0; i<7; i++){
            if (list[i].getBalance() <= amount){// dont put class BankAccount for getBalance because it is a specific variable and it is public (not static?)
                if (counter == 0){ //so it only prints out headers if accounts ARE found
                    System.out.println(String.format("%-10s\t%-10s\t%-30s\t%-10s\t%-10s","Type", "Number", "Owner", "Balance", "Interest"));
                }
                System.out.println(list[i] + " ");
                counter++;
            } else {     
            }
        }
        if (counter == 0){
        System.out.println("No such accounts were found");
        }
    }
    public static void sortAccounts(BankAccount[] list){
        int length = 7;
        int arrayInt[] = new int[length]; //new array filled with numbers that will then be sorted 

        //getting an int from a string
        for (int i =0; i< length; i++){
            int c = list[i].getOwner().charAt(0); //utilizing char in order to convert string to int
            arrayInt[i] = c; 
        }

        insertionSort(arrayInt); //sorting the numbers array

        //just to see what it would print out after it was sorted --> successfully sorted the numbers from lowest to highest
        /*for (int i = 0; i< length; i++){
            System.out.println(arrayInt[i]);
        }*/

        System.out.println(String.format("%-10s\t%-10s\t%-30s\t%-10s\t%-10s","Type", "Number", "Owner", "Balance", "Interest"));
        //big gap is on owner = formatting-wise
        for (int i =0; i< length; i++){
            for (int j = 0; j<length; j++){
                if (arrayInt[i] == list[j].getOwner().charAt(0)){ //matching up the sorted arrayInt to the original String array bankaccount
                    System.out.println(list[j] + " ");
                    break; //once it matches it breaks out of the inner loop and moves on to the next number in the number array
                }//important to note that this NOT permanently edit the BankAccount [] list***
            }
           
        }
    }
    public static void insertionSort(int[] list) {
        for (int i=1; i<list.length; i++) {
            //Insert element i in the sorted sub-list
            int currentVal = list[i];
            int j = i;
            while (j>0 && currentVal<(list[j - 1])){ //if current value is less than the previous value then it switches
                 // Shift element (j-1) into element (j) --> resulting in the lower number goin before the higher number
                 list[j] = list[j - 1];
                 j--;
            }
            // Insert currentVal at position j
            list[j] = currentVal; //inserts the "higher" number of the two after the "lesser" number
         }
       }
       
    public static double inputVal(Scanner sc){ //input validation for a double in order to get the correct input for finding accounts
        double num = 0;
        boolean loopControl = true;
        do{
            if (sc.hasNextDouble()){ //checks to make sure it is a double
                num = sc.nextDouble();
                loopControl = false;//if it is a double, then it breaks out of loop and returns the double 
            } else {
                System.out.println("Please enter a valid amount. ");
                sc.nextLine();//clears line
            }

        } while (loopControl);

        return num;
    }
}
