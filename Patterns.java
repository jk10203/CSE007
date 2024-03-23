/* Joy Kim
29 September, 2022
CSE007 Fall 2022: Lab 5
JDK 11 */
/* This program is intended to give the user an option to give a word as an input and make it into
4 different types of patterns A,B,C, or D. This program intends to explore how to use loops to make
different patterns that may involve reversing the word or starting at different margins (left or right).  */

import java.util.Scanner;
public class Patterns{
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        //height = length (something.length)   
        // read in strings separated by white space(next - read until whitespace)--> next twice two read values

        //loop stops when user types in 
        //how to know when boolean?
        boolean loopContinue = true; 

        do{
        //everything we create is in this loop
        System.out.println("Enter a Pattern followed by a word: ");
        char pattern = input.next().charAt(0); //how to read in character from scanner (NO NEXTCHAR)
        //assume they type 2 strings and no spaces in between
        String word = input.next();

        switch(pattern){
            //pattern that is actually displayed
            case 'A':
                //pattern a
                //outer loop controlling rows
                for (int i = 0; i < word.length(); i++){
                    for(int j = 0; j<=i; j++){ //of just < never going to print T in first row
                        System.out.print(word.charAt(word.length() - 1 - j) + " "); //-j gets closer to front of the string
                    }
                    System.out.println();
                }
                break;
            case 'B':
                //pattern b
                for (int i = 0; i < word.length(); i++){ //when i is zero print out EVERYTHING
                    for (int j = 0; j < word.length()-i; j++){ //number of letters decrease as row number increases
                    System.out.print(word.charAt(j) + " ");
                    }
                    System.out.println();
                }

                break;
            case 'C':
                //pattern c
                for (int i = 0; i<word.length(); i++){ //reverse word with letter equal to amount of rows
                    //for loop to print spaces
                    for (int space = word.length() - 1; space >= i; space --){ //when i is 1 space is 2 before it
                        System.out.print("  "); //TWO SPACES
                    }
                    //for loop to print letters (do letters first THEN add loop for spaces)
                    for(int j = i; j>=0; j--){
                        System.out.print(word.charAt(j) + " ");
                    }
                    System.out.println();
                }
                break;
            case 'D':
                //pattern d
                for (int i = 0; i < word.length(); i++){  //reverse starting from the left margin
                    for(int j = word.length() - 1 - i; j >= 0; j--){ //row number inverse to amount of letters in row
                        System.out.print(word.charAt(j)+ " "); 
                    }
                    System.out.println();
                }
                break;
            case 'X':
                //EXITTING THE PROGRAM
                loopContinue = false;
                System.out.println("Goodbye");
                break;
            default:
                System.out.println("Not a valid pattern.");
        
        }

        } while (loopContinue);

    }
}