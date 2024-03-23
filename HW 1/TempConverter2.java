/* Joy Kim
8 September, 2022
CSE007 Fall 2022: HW 1
JDK 11 
*/
/* This program is intended to convert degrees Fahrenheit to degrees Celsius */
import java.util.Scanner;
public class TempConverter2{
    public static void main(String[]args){
        Scanner scnr = new Scanner(System.in);
        System.out.print("Please enter the temp in degrees FAHRENHEIT: ");
        double fahrenheit = scnr.nextDouble();
        final double x = 5;
        final double y = 9;
        final double convertConstant2 = (x / y); // (5 / 9) part of the formula

        //TO DO: convert the celsius input value to fahrenheit
        double celsius =  (convertConstant2 * (fahrenheit - 32));
        System.out.println("The temperature in degrees CELSIUS is " + celsius);
    }
}