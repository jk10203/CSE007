/* Joy Kim
October 11, 2022
CSE007 Fall 2022: Lab 8
JDK 11 */
/* This program is intended to */

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class InputVJunk{ 
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in);
        Random rand = new Random(); 
        //descending - nested for loop for descending sorting
        //binary search - while then if statements
        //grade distribution (percentage to letter) - switches?
        //input validation - if input.hasNextchar ish vibe then loopie
    
        //include why you chose which algorithm

        int numStudents = 0;
        boolean vInt = true;

        System.out.println("Please enter an integer between 5-150: ");
        if(input.hasNextInt()){
            numStudents = input.nextInt();
            if(numStudents<5||numStudents>150){
                do{
                    System.out.println("Please enter a valid integer between 5-150: ");
                    if(input.hasNextInt()){
                        if(numStudents>=5||numStudents<=150){ //fix
                            numStudents = input.nextInt();
                            vInt = false;
                        } else {
                            vInt = true;
                        }
                    } 
                } while(vInt = true);
            }
        }
        /* get an integer from user, and validate
        be sure to valuidate that it is an integer before reading it in
        validate the range
        keep prompting (looping) until the user enters a valid number*/

        //int len = 150; //this is the value you'll use for input from user for now
        int[] grades = new int[numStudents];

        for(int i =0; i < grades.length; i++){
            grades[i] = (int)(Math.random()*101);
            //System.out.println(grades[i]);
        }
        System.out.println("Unsorted grades for course: ");
        System.out.println(Arrays.toString(grades));

        //comment about why you chose selection sort
        
        for(int i = 0; i< grades.length-1; i++){
            int maxIndex = i;
            int max = grades[i];
            for(int j = i+1; j< grades.length; j++){
                if(max < grades[j]){
                    max = grades[j];
                    maxIndex = j; //no swapping until inner loop?
                }
            }
            if (maxIndex != i){
                grades[maxIndex] = grades[i];
                grades[i] = max;
            }
        }
        System.out.println("Sorted grades for course: ");
        System.out.println(Arrays.toString(grades));

        double sum = 0;
        double average = 0;
        for(int i =0; i<grades.length; i++){
            sum += grades[i];
        }

        average = sum / grades.length;

        System.out.printf("\n Average course grade: %.3f", average);
        System.out.println(" ");

        //binary search time
        int[] letterGrades = new int[numStudents];
        int gradeKey = 0;
        
        System.out.println("Please enter a grade to search for (0-100) or a Letter Grade: ");
        if(input.hasNextInt()){
            gradeKey = input.nextInt();
            //validate gradeKey between 0-100
            if(gradeKey<0||gradeKey>100){
                boolean invalidG = true;
                while (invalidG){
                    System.out.println("Please enter a valid grade between 0-100: ");
                    gradeKey = input.nextInt();
                    if (gradeKey<0||gradeKey>100){
                        invalidG = true;
                    } else {
                        invalidG = false;
                    }
                }
            }
            int low = 0, high = grades.length - 1;
            int mid;
            int iterations = 0;
            int binaryIndex = -1;

            while(low <= high){
                mid = (low + high) / 2;
                iterations++;
                if (grades[mid] < gradeKey){ 
                    high = mid - 1;
                } else if (grades[mid] > gradeKey){
                    low = mid+1;
                } else {
                    binaryIndex = mid;
                    break;
                }
            }
            // tell the user the results of the binary search
            if(binaryIndex == -1){
            System.out.println("Grade of " + gradeKey + " was not found!");
            System.out.println("Number of iterations: " + iterations);
            } else if (binaryIndex>0);{ //what happens if binaryIndex = 0?
            System.out.println("Grade of " + gradeKey + " was found!");
            System.out.println("Number of iterations: " + iterations);
            }

        } else {
            boolean letterGradeV;
            //the user didn't type an integer
            while (true){
               char choice = Character.toUpperCase(input.next().charAt(0));
                  if(choice>=65&& choice<=70&& choice!=69){
                     false;
                     switch(choice){
                           case 'A':
                              System.out.println(" A");
                              break;
                           case 'B':
                              System.out.println(" B");
                              break;
                           case 'C':
                              System.out.println(" C");

                              break;
                           case 'D':
                              System.out.println(" D");

                              break;
                           case 'F':
                              System.out.println(" F");

                              break;
                           /*default: //use this to handle invalid input -- keep prompting if you get here
                              System.out.println("Please enter a valid letter grade (A,B,C,D,F): "); //not returning to input option FIX FIX FIX
                              break;*/
                     }
                  } else {
                     System.out.println("Please enter a valid letter grade (A,B,C,D,F): ");
                  }
            }
         }
                    
                
            
        

        System.out.println("xx");



    }
}