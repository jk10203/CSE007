/* Joy Kim
26 September, 2022
CSE007 Fall 2022: Midterm 1
JDK 11 */
/* This program is intended to */

import java.util.Scanner;
import java.util.Random; //delete if don't need
public class CSEMidterm1{
    public static void main(String[]args){
        Scanner input = new Scanner (System.in);
        Random rand = new Random(); //delete if don't nee
        System.out.println("Please enter a positive integer: "); //65 to 90
        int row = input.nextInt();
        char letter = 'A';
        for (int count = 1; count <= row; count++){
            int length = 1;
            for(length = 1; length <= count; length++){
                System.out.println(letter + 1);
                letter++;
            }
        }
    }   
}
