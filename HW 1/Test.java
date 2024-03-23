/* Joy Kim
8 September, 2022
CSE007 Fall 2022: HW 1
JDK 11 
*/
/*This program is intended to breakdown an amount of money into its smaller components
such as dollars, quarters, dimes, nickels, and pennies*/

public class Test{
    public static void main(String[]args){
        //Variables and constants
        final int Dollar = 100; //only uppercased the first letter for convenience
        final int Quarter = 25; //separated the initialization of Dollar and Quarter
        double money = 23.68; /*got rid of the number infront of money and combined with the
        last statement in the variables and constants category*/
        int dollars;
        int quarters; //separated the initialization of dollars and quarters
        
        //added coding to fill in gaps since 23.68 != 23.50 as produced by this program
        final int Dime = 10;//actual numerical value of a dime
        final int Nickel = 5; //actual numerical value of a nickel
        final int Penny = 1; //actual numerical value of a penny
        int dimes; //actual number of dimes not the value itself
        int nickels; //actual number of nickels not the value itself
        int pennies; // actual number of pennies not the value itself
        
        //Processing
        int amount = (int) (money * 100); //amount is 2368
        dollars = amount / Dollar; //separated the two statements and added a semicolon
        amount = amount % Dollar; //amount is 68 remainder
        quarters = amount / Quarter; //result is 2 quarters
        
        //additional coding (part of processing)
        dimes = (amount % Quarter) / Dime; //calculating amount of dimes 
        nickels = ((amount % Quarter)% Dime) / Nickel; //calculating amount of nickels
        pennies = (((amount % Quarter)% Dime) % Nickel) / Penny; //calculating the amount of pennies

        //Output
        System.out.println("For $" + money + ", the components are: "); //added introduction to print statements
        System.out.println("Dollars = " + dollars + ", Quarters = " + quarters + ", Dimes = " + dimes); //fixed syntax errors in the print statement
        System.out.println("Nickels = " + nickels + ", Pennies = " + pennies); // added additional statements on a second line
    }
}