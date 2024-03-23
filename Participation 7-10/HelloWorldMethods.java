/* Joy Kim
October 17, 2022
CSE007 Fall 2022: Participation 9
JDK 11 

This program is intended to print out Hello, World/Universe/Earth by using a switch statement
inside a method and relying on user input to decide which result is outputted.
*/

import java.util.Scanner;
public class HelloWorldMethods {
    public static int helloWorld(int helloObject){
        switch (helloObject){
            case 1:
                System.out.print("Hello, World");
                break;
            case 2:
                System.out.print("Hello, Universe");
                break;
            case 3:
                System.out.print("Hello, Earth");
                break;
        }
        return (helloObject);
    }
    public static void main (String [] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter an integer between 1-3: ");
        int num = input.nextInt();
        System.out.println(" (" + helloWorld(num) + ")");
    }
}
