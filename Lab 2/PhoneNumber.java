/* Joy Kim
5 September, 2022
CSE007 Fall 2022: Lab 2
JDK 11 
*/

/* This program classifies the first 3 digits, the middle 3 digits, 
and the last 4 digits of a 10-digit phone number by using the modulus operator
in order to reformat a phone number */

import java.util.Scanner;
public class PhoneNumber{
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
    
        long phoneNumber; //stores the 10-digit number
        double lineNumber; //represents the last four digits of the phone number 
        double prefix; //represents the middle three digits of the phone number
        double areaCode; //represents the first three digits of the phone number
        final long isolateLastFour = 10000; //just to simplify the coding I assigned the number to a variable
        final long isolateNextThree = 1000; //just to simplify the coding I assigned the number to a variable

        //getting phone number input from user
        System.out.print("Please enter a 10-digit phone number: ");
        phoneNumber = input.nextLong();

        //isolating last 4 numbers (line number)
        lineNumber = (phoneNumber % isolateLastFour); //cannot use int to declare lineNumber because phoneNumber is declared through long
        System.out.println("Line Number: " + (int) lineNumber);  //included a print statement for each component of the phone number just to make the process mroe visible

        //isolating middle 3 (prefix)
        phoneNumber /= isolateLastFour; //cannot use int to declare prefix because phoneNumber is declared through long
        prefix = (phoneNumber % isolateNextThree);
        System.out.println("Prefix: " +  (int) prefix);

        //isolating first 3 (area code)
        phoneNumber /= isolateNextThree;
        areaCode = (phoneNumber % isolateNextThree); //cannot use int to declare areaCode because phoneNumber is declared through long
        System.out.println("Area code: " + (int) areaCode);

        //combining to general formatted output
        System.out.print("Formatted phone number: ");
        System.out.println("(" + (int) areaCode + ")" + " " + (int) prefix + "-" + (int) lineNumber);
    }
}