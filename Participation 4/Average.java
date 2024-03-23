/* Joy Kim
14 September, 2022
CSE007 Fall 2022: Participation 4
JDK 11 */
/* This program is intended to get the input from the user for the values of 5 integers
that will be used to calculate the average. This program uses while and do-while loops to
achieve this*/

import java.util.Scanner;
public class Average{
    public static void main(String[]args){
        Scanner keys = new Scanner (System.in);

        double sum = 0; //running total
        int counter = 1; //controls the loop 

        System.out.println("The average of 5 integers will be calculated.");

        while(counter < 6){
            System.out.print("Please enter integer #" + counter + ": "); 
            int temp = 0;
           
            boolean loopNeed = true; // in order to continue loop until it is false
            do{ //will run forever until a valid integer
                if(keys.hasNextInt()){ //if user types integer, read it in and add to total
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
        System.out.println("The average is: " + (sum / 5.0));
        //user enters loops amount for average2
        
        keys.close(); //closes scanner
    }
}