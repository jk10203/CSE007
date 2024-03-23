/* Joy Kim
8 September, 2022
CSE007 Fall 2022: HW 1
JDK 11 
*/
/*This program calculates the change in quarters, dimes, and nickels you need if 
the item you are buying is less than or equal to a dollar, and no pennies are involved. */
import java.util.Scanner;
public class DispenseChange{
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);

        final int Quarter = 25;
        final int Dime = 10;
        final int Nickel = 5;
        int numQuarter; //actual number of quarters not the value itself
        int numDime; //actual number of dimes not the value itself
        int numNickel; //actual number of nickels not the value itself
        
        //getting input from user and setting up for future calculations
        System.out.println("Enter the price of the item you are buying in cents (in increments of 5).");
        int priceCoin = input.nextInt(); 
        System.out.println("You bought an item for " + priceCoin + " cents and gave me a dollar, so your change is");
        int change = 100 - priceCoin; //might have problem from int to doule
        
        //calculating how much of each coin is needed for the specific amount of change
        numQuarter = change / Quarter;
        numDime = (change % Quarter) / Dime;
        numNickel = ((change % Quarter)% Dime) / Nickel;
        //key is that (0 % a number) = 0 but something like (ex) 45 % 25 = 45
        
        //results output
        System.out.println(numQuarter + " quarter(s)");
        System.out.println(numDime + " dime(s)");
        System.out.println(numNickel + " nickel(s)");
        
        System.out.println("Making a total of " + change + " cents for your change.");
    }
}
        