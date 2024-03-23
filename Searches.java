/* Joy Kim
October 12, 2022
CSE007 Fall 2022: Lab 7
JDK 11 */
/* This program is intended to illustrate how linear and binary searches work by
implementing a system that utilizes both systems (which includes input validating)
and see how many comparisons each make in order to find the desired key value inputted 
by the user within a randomly assigned array with the length given by the user.
Thus, we are able to compare and contrast the two systems effectively.*/

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Searches{ 
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in); 
        Random rand = new Random();
        int length = 0;
        char key = 0;
        String keyInput; //placeholder in order to get value for key

        System.out.println("Please enter the length of the array: ");
        boolean inputVLength = true; //setting up input validation
        length = input.nextInt();

        //input validating length first
        if (length < 10){ //length must be greater than 10
             while (inputVLength){
                System.out.println("Invalid input. Please enter a length greater than 10: ");
                length = input.nextInt();
                if (length > 10){
                    inputVLength = false;
                }
             }
        }
        
        System.out.println("Please enter the key value (A-Z) to search for: ");
        keyInput = input.next();
        key =  keyInput.charAt(0);

        //input validating the user input for the letter (key)
        while (key<65 || key>90){ //input validating to make sure an uppercase letter is entered
            System.out.println("Please enter a valid uppercase letter: ");
            keyInput = input.next();
            key =  keyInput.charAt(0);
        }

        //assigning random letters to the array depending on user input for length
        char[] random = new char[length];
        for(int i = 0; i< random.length; i++){
            random[i] = (char)(rand.nextInt(26) + 65); //gives random letter A-Z
        }

        int linearIndex = -1;//will return a value of 0 is key not found
        int comparisons = 0; 
        //linear search
        for(int index = 0; index< random.length; index++){ //compares one by one the individual values
            comparisons++;//keeping track of how many comparisons
            if(random[index] == key){
                linearIndex = index;
                break;
            }
        }

       // WHY arrays must be sorted in order to use binary search
       /* arrays have to be sorted because in binary search arrays are not compared to each other's
       individual values, but their relative position/value to one another. When finding the mid value, 
       the array must be sorted in order to accurately determine whether the left of the array is less than
       and the right of the array is greater than. */

        //sorting arrays for binary search
        Arrays.sort(random);

        System.out.print("Sorted array: ");
        for(char c: random){
            System.out.print(c + " ");
        }
        System.out.println();

        //binary search
        int binaryIndex = -1; //returns -1 if value not found
        int binComparisons = 0;

        int high, low, mid;
        low = 0;
        high = random.length - 1;
        while (high >= low){ 
            mid = (high + low) / 2;
            binComparisons++; //keeping count of the comparisons
            if (random[mid] < key){ //determining where to split
                low = mid + 1;
            } else if (random [mid] > key){
                high = mid - 1;
            } else {
                binaryIndex = mid; //if letter is found right at middle, loop ends
                break;
            }
        }
        //determining whether key value was found or not
        if (binaryIndex == -1 || linearIndex == -1){
            System.out.println("Key was not found in array.");
        }
        if (binaryIndex!=-1 && linearIndex != -1){
            System.out.println("Key was found!");
            System.out.println("For linear search, the key was found at index #" + linearIndex);
            System.out.println("For binary search, the key was found at index #" + binaryIndex);
        }

        //comparing comparisons for linear and binary search 
        System.out.println("For linear search, " + comparisons + " comparison(s) were made.");
        System.out.println("For binary search, " + binComparisons + " comparison(s) were made.");
    }
}