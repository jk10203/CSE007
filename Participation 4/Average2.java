/* Joy Kim
14 September, 2022
CSE007 Fall 2022: Participation 4
JDK 11 */
/* This program is intended to calculate the average by getting the input from the user
involving how many integers will be used to calucate the average, and what values these
integers have. This program uses while and do-while loops to achieve this. */

import java.util.Scanner;
public class Average2{
    public static void main(String[]args){
        Scanner keys = new Scanner (System.in);

        double sum = 0; //running total
        System.out.println("Please enter the amount of integers you want to take the average of: ");
        int countNums = keys.nextInt();

        int counter = 1; //controls the loop

        while(counter <= countNums){
            System.out.println("Enter integer #" + counter + ": "); 
            int temp = 0;
            
            boolean loopNeed = true; // in order to continue loop until it is false
            do{ //will run forever until a valid integer
                if(keys.hasNextInt()){ //if user types integer, i want to read it in and add to total
                    temp = keys.nextInt();
                    loopNeed = false; //loop ends
                } else { //clearing the scanner
                    String junk = keys.nextLine(); 
                    System.out.println("Please enter a valid integer");
                }

            }while (loopNeed);
            sum += temp; //gets the sum from each loop run through
            counter++; //adds 1 to counter to keep track of how many integers
        }
        System.out.printf("The average is: %.3f\n", (sum / countNums));
        //user enters loops amount for average2
    }
}