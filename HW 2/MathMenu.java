/* Joy Kim
14 September, 2022
CSE007 Fall 2022: HW 2
JDK 11 */
/* This math program is intended to help the user practice simple mathematics that only involves adding, 
subtracting, multiplying, or dividing single digit numbers. */

import java.util.Scanner;
import java.util.Random;
public class MathMenu{
    public static void main(String[]args){
        Scanner input = new Scanner (System.in);
        Random rand = new Random();
       
        System.out.println("Welcome to the Math Program");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Enter your choice: ");
       
       //in order to loop the program if an incorrect answer is inputted
        boolean mathLoop = true; 

        switch (input.nextInt()) { 
            //Addition
            case 1: 
                int num = rand.nextInt(9);
                int num2 = rand.nextInt(9);
                int sumTotal = num + num2;
                do{ //a loop in order to repeat the question until the answer is correct
                    System.out.println("Enter what x equals.");
                    System.out.println(num + " + " + num2 + " = x");
                    System.out.print("x = ");
                    int sumAnswer = input.nextInt();

                    if (sumAnswer == sumTotal){
                        System.out.println("Correct! Nice Job!");
                        mathLoop = false; //breaks loop
                    } else {
                        System.out.println("Incorrect. Try again.");
                    }
                } while (mathLoop);
                break;

            //subtraction
            case 2: 
                num = rand.nextInt(9);
                num2 = rand.nextInt(9);
                int subTotal = num - num2;
                
                do{ //a loop in order to repeat the question until the answer is correct
                    System.out.println("Enter what x equals.");
                    System.out.println(num + " - " + num2 + " = x");
                    System.out.print("x = ");
                    int subAnswer = input.nextInt();

                    if (subAnswer == subTotal){
                        System.out.println("Correct! Nice Job!");
                        mathLoop = false; //breaks loop
                        break;
                    } else {
                        System.out.println("Incorrect. Try again.");
                    }
                } while (mathLoop);
                break;
            
            //multiplication
            case 3: 
                num = rand.nextInt(9);
                num2 = rand.nextInt(9);
                int multTotal = num * num2;

                do{ //a loop in order to repeat the question until the answer is correct
                    System.out.println("Enter what x equals.");
                    System.out.println(num + " * " + num2 + " = x");
                    System.out.print("x = ");
                    int multAnswer = input.nextInt();

                    if (multAnswer == multTotal){
                        System.out.println("Correct! Nice Job!");
                     
                        mathLoop = false; //breaks loop
                    } else {
                        System.out.println("Incorrect. Try again.");
                    }
                } while (mathLoop);
                break;
            
            //division
            case 4: 
                num = rand.nextInt(9);
                num2 = rand.nextInt(8) + 1 ; //gets rid of #/0 output
                double divTotal = (((double) num) / ((double)num2)) * 100.0;
                double divRoundT = (Math.floor(divTotal)) / 100; //in order to get a number with 2 decimal places
                //math.floor rounds an integer down which truncates its value

                do{ //a loop in order to repeat the question until the answer is correct
                    System.out.println("Enter what x equals. Make sure to include 2 decimal places, but DO NOT ROUND!");
                    System.out.println(num + " / " + num2 + " = x");
                    System.out.print("x = ");
                    double divAnswer = input.nextDouble();

                    if (Math.abs(divRoundT-divAnswer) <= 0.0001){ //because you cannot compare equality with doubles
                        System.out.println("Correct! Nice Job!");
                        
                        mathLoop = false; //breaks loop
                        break;
                    } else {
                        System.out.println("Incorrect. Try again.");
                    }
                } while (mathLoop);
                break;

            //if any number other than 1-4 is entered, program stops
            default: System.out.println("Please enter a valid choice."); 
        }
    
    //closing scanner
    input.close(); 
    
    }
}