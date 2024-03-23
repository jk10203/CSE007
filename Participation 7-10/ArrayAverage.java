/* Joy Kim
October 8, 2022
CSE007 Fall 2022: Participation 7
JDK 11 */
/* This program is intended to generate 10 random numbers and classify whether it is the minimum or
maximum value in the array (which has 10 variables). Then, the average is taken of the 10 randomly
generated numbers. We are able to utilize arrays and the notion of randomly generated numbers in order
to create this program.*/

import java.util.Scanner;

public class ArrayAverage{ 
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in); 

        int[] array = new int [10];
        
        int max = 0;
        int min = 20;
        double sum = 0;
        double average;
        int maxIndex = 0;
        int minIndex = 0;

        for(int i = 0; i<array.length; i++){
            array[i] = (int)(Math.random() * 20 + 1);
            System.out.println(array[i]);
            sum += array[i];

            if(array[i] > max){
                max = array[i];
                maxIndex = i;
                System.out.print("Maximum value now: " + array[i]);
                System.out.println("");
            }
            if(array[i] < min){
                min = array[i];
                minIndex = i;
                System.out.print("Minimum value now: " + array[i]);
                System.out.println("");
            }
        }
        average = sum / 10.0;
        for(int temp: array){
            System.out.print(temp+ " ");
        }
        System.out.println("\nMax Element: " + max + " @ index #" + maxIndex + "; Min Element: " + min + " @ index #" + minIndex);
        System.out.println("Average of all elements in array: " + average);
    }
}