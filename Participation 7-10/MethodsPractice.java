/* Joy Kim
October 22, 2022
CSE007 Fall 2022: Participation 9
JDK 11 */
/* This program is intended to use methods in order to generate a 
random character between A-Z and return the largest character between x and y.
The method will thus generator 2 random characters and ask the user
which is bigger to which the program will indicate whether that is correct or not.*/

import java.util.Scanner;
import java.util.Random;

public class MethodsPractice{ 
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in); 
        do{
            char letter1 = generateChar();
            System.out.println("Letter 1: " + letter1);
            char letter2 = generateChar();
            System.out.println("Letter 2: " + letter2);
            System.out.println("Which letter is bigger?");
            char ans = input.next().charAt(0);
            char max = compareChars(letter1, letter2);
            if(ans == max){
                System.out.println("Correct");
            } else {
                System.out.println("Incorrect");
            }
            System.out.println("Play again? Y/N");
            char choice = input.next().charAt(0);
            if (choice == 'N'){
                break;
            }
        } while (true);
    }

    public static char generateChar(){
        Random ran = new Random();
        return (char)(ran.nextInt(26) + 65);
    }

    public static char compareChars(char char1, char char2){
        char max;
        if(char1>char2){
            System.out.println(char1+ " is bigger than " + char2);
            max = char1;
        } else if (char1 < char2){
            System.out.println(char2 + " is bigger than" + char1);
            max = char2;
        } else {
            System.out.println("Generated two of the same letter");
            max = char1;
            //doesn't matter which you choose ... this is an edge case
        }
        return max;
    }
}
