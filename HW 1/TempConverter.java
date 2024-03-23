/* Joy Kim
8 September, 2022
CSE007 Fall 2022: HW 1
JDK 11 
*/
/* This program is intended to convert degrees Celsius into degrees Fahrenheit */
import java.util.Scanner;
public class TempConverter{
    public static void main(String[]args){
        Scanner scnr = new Scanner(System.in);
        System.out.print("Please enter the temp in degrees CELSIUS: ");
        double celsius = scnr.nextDouble();
        final double x = 5;
        final double y = 9;
        final double convertConstant = (y / x); // (9/5) part of the formula

        //TO DO: convert the celsius input value to fahrenheit
        double fahrenheit =  convertConstant * celsius + 32;
        System.out.println("The temperature in degrees FAHRENHEIT is " + fahrenheit);
    }
}