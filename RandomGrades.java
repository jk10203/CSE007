/* Joy Kim
October 11, 2022
CSE007 Fall 2022: Lab 8
JDK 11 */
/* This program is intended to utilize arrays/algorithms in order to generate a number of grades for a course depending
on the user input for the number of grades generated. These randomly generated grades are then sorted using 
selection sort then the user is then prompted to either enter a letter or number grade in order to search the array
for that specific range/value. The output for a number value is whether that specific value was found or not and the iterations
whereas the letter grade gives how many grades fall in that category. */

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class RandomGrades{ 
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in);
        Random rand = new Random(); 
        //descending - nested for loop for descending sorting
        //binary search - while then if statements
        //grade distribution (percentage to letter) - switches?
        //input validation - if input.hasNextchar ish vibe then loopie
    
        //include why you chose which algorithm

        int numStudents = 0;
        String junk;
        boolean vInt = true;

        System.out.println("Please enter a class size between 5-150: ");
        if(input.hasNextInt()){
            numStudents = input.nextInt();
            while(numStudents < 5 || numStudents >150){ //input validating that range is correct
                System.out.println("Please enter a valid class size integer between 5-150: ");
                numStudents = input.nextInt();
            }
        }

        //declaring array depending on user input
        int[] grades = new int[numStudents];

        //getting the unsorted course grades
        for(int i =0; i < grades.length; i++){
            grades[i] = (int)(Math.random()*101);
            //System.out.println(grades[i]);
        }
        System.out.println("Unsorted grades for course: ");
        System.out.println(Arrays.toString(grades));

        //comment about why you chose selection sort
        /* I chose to do selection sort because it contains less swapping than insertion sort. 
        Since selection sort involves comparing each element to look for the next biggest variable, 
        and then swaps when the biggest variable is found (for this program since it is descending)
        I chose to do selection sort since it seemed better for number organized in a reverse fashion.
        Also, insertion sort is most likely better when the array is already somewhat sorted, which in 
        this case, it is not, so selection sort would be better regardless.*/
        for(int i = 0; i< grades.length-1; i++){//outer loop - looking for smallest value by moving forward
            int maxIndex = i;
            int max = grades[i];
            for(int j = i+1; j< grades.length; j++){ //inner loop //processes smaller value
                if(max < grades[j]){
                    max = grades[j];
                    maxIndex = j; //no swapping until inner loop
                }
            }
            if (maxIndex != i){ //resetting from when maxIndex = j
                grades[maxIndex] = grades[i];
                grades[i] = max;
            }
        }
        //printing out sorted grades
        System.out.println("Sorted grades for course: ");
        System.out.println(Arrays.toString(grades));

        //calculating average
        double sum = 0;
        double average = 0;
        for(int i =0; i<grades.length; i++){
            sum += grades[i];
        }
        average = sum / grades.length;

        //average course grade
        System.out.printf("\nAverage course grade: %.3f", average);
        System.out.println(" ");

        //user input for grade search
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
            //binary search time
            /* I chose to do binary search because of the amount of grades that are possible to be entered (up to 150)
            since it is so many, if linear search was done, there would be a lot more iterations/comparisons that is 
            technically less efficient. Binary search is technically more efficient which is why I chose binary search!*/
            int low = 0, high = grades.length - 1;
            int mid;
            int iterations = 0;
            int binaryIndex = -1;

            while(low <= high){
                mid = (low + high) / 2;
                iterations++; //counting iterations
                if (grades[mid] < gradeKey){ 
                    high = mid - 1;
                } else if (grades[mid] > gradeKey){
                    low = mid+1;
                } else {
                    binaryIndex = mid;
                    break; //if found, break
                }
            }
            //System.out.println(binaryIndex); //testing

            // tell the user the results of the binary search
            if(binaryIndex == -1){ //if grade does not exist
                System.out.println("Grade of " + gradeKey + " was not found!");
                System.out.println("Number of iterations: " + iterations);
            } 
            if (binaryIndex>0){ //if grade exists
                System.out.println("Grade of " + gradeKey + " was found!");
                System.out.println("Number of iterations: " + iterations);
            } 
            if (binaryIndex == 0){ //halloween surprise
                System.out.println("boo");
            }

        } else {
            //the user didn't type an integer
            //while (letterGradeV = true){
                int[] gradeA = new int[numStudents]; // in order to hold the separate grades
                int[] gradeB = new int[numStudents];
                int[] gradeC = new int[numStudents];
                int[] gradeD = new int[numStudents];
                int[] gradeF = new int[numStudents];
                int j = 0;
                int counter = 0; //counting how many

                char choice = Character.toUpperCase(input.next().charAt(0)); //user input is uppercased just in case
                    switch(choice){ //depending on user input
                        case 'A':
                            for (int i = 0; i<grades.length; i++){ //separating grades above 90 from the rest
                                if (grades[i] >= 90){
                                    gradeA[j] = grades[i];
                                    j++;
                                }
                            }
                            for(j=0; j<gradeA.length; j++){ //counting how many grades in that range
                                if(gradeA[j] !=0 ){
                                    counter++;
                                }
                            }
                            if (counter == 1){ //separate statements for grammar
                            System.out.println("There is " + counter + " grade in the A range.");
                            }
                            if (counter != 1){
                            System.out.println("There are " + counter + " grades in the A range.");
                            }

                            break;
                        case 'B':
                            for (int i = 0; i<grades.length; i++){ //separating grades above 90 from the rest
                                if (grades[i] >= 80 && grades[i] < 90){
                                    gradeB[j] = grades[i];
                                    j++;
                                }
                            }
                            for(j=0; j<gradeB.length; j++){ //counting how many grades in that range
                                if(gradeB[j] !=0 ){
                                    counter++;
                                }
                            }
                            if (counter == 1){ //separate statements for grammar
                            System.out.println("There is " + counter + " grade in the B range.");
                            }
                            if (counter != 1){
                            System.out.println("There are " + counter + " grades in the B range.");
                            }

                            break;
                        case 'C':
                            for (int i = 0; i<grades.length; i++){ //separating grades above 90 from the rest
                                if (grades[i] >= 70 && grades[i] < 80){
                                    gradeC[j] = grades[i];
                                    j++;
                                }
                            }
                            for(j=0; j<gradeC.length; j++){ //counting how many grades in that range
                                if(gradeC[j] !=0 ){
                                    counter++;
                                }
                            }
                            if (counter == 1){ //separate statements for grammar
                            System.out.println("There is " + counter + " grade in the C range.");
                            }
                            if (counter != 1){
                            System.out.println("There are " + counter + " grades in the C range.");
                            }
                            break;
                        case 'D':
                            for (int i = 0; i<grades.length; i++){ //separating grades above 90 from the rest
                                if (grades[i] >= 60 && grades[i] < 70){
                                    gradeD[j] = grades[i];
                                    j++;
                                }
                            }
                            for(j=0; j<gradeD.length; j++){ //counting how many grades in that range
                                if(gradeD[j] !=0 ){
                                    counter++;
                                }
                            }
                            if (counter == 1){ //separate statements for grammar
                            System.out.println("There is " + counter + " grade in the D range.");
                            }
                            if (counter != 1){
                            System.out.println("There are " + counter + " grades in the D range.");
                            }
                            
                            break;
                        case 'F':
                            for (int i = 0; i<grades.length; i++){ //separating grades above 90 from the rest
                                if (grades[i] >= 0 && grades[i] < 60){
                                    gradeF[j] = grades[i];
                                    j++;
                                }
                            }
                            for(j=0; j<gradeF.length; j++){ //counting how many grades in that range
                                if(gradeF[j] !=0 ){
                                    counter++;
                                }
                            }
                            if (counter == 1){ //separate statements for grammar
                            System.out.println("There is " + counter + " grade in the F range.");
                            }
                            if (counter != 1){
                            System.out.println("There are " + counter + " grades in the F range.");
                            }
                            
                            break;
                        
                        default: //use this to handle invalid input -- keep prompting if you get here
                            boolean letterVal = true;
                            while(letterVal){
                            System.out.println("Please enter a valid letter grade (A,B,C,D,F): ");
                            choice = Character.toUpperCase(input.next().charAt(0));

                            if(choice>=65&& choice<=70&& choice!=69){ //if the input is A,B,C,D,F then fulfill switch
                                 switch(choice){
                                    case 'A':
                                        for (int i = 0; i<grades.length; i++){ //separating grades above 90 from the rest
                                            if (grades[i] >= 90){
                                                gradeA[j] = grades[i];
                                                j++;
                                            }
                                        }
                                        for(j=0; j<gradeA.length; j++){ //counting how many grades in that range
                                            if(gradeA[j] !=0 ){
                                                counter++;
                                            }
                                        }
                                        if (counter == 1){ //separate statements for grammar
                                        System.out.println("There is " + counter + " grade in the A range.");
                                        }
                                        if (counter != 1){
                                        System.out.println("There are " + counter + " grades in the A range.");
                                        }

                                        break;
                                    case 'B':
                                        for (int i = 0; i<grades.length; i++){ //separating grades above 90 from the rest
                                            if (grades[i] >= 80 && grades[i] < 90){
                                                gradeB[j] = grades[i];
                                                j++;
                                            }
                                        }
                                        for(j=0; j<gradeB.length; j++){ //counting how many grades in that range
                                            if(gradeB[j] !=0 ){
                                                counter++;
                                            }
                                        }
                                        if (counter == 1){ //separate statements for grammar
                                        System.out.println("There is " + counter + " grade in the B range.");
                                        }
                                        if (counter != 1){
                                        System.out.println("There are " + counter + " grades in the B range.");
                                        }

                                        break;
                                    case 'C':
                                        for (int i = 0; i<grades.length; i++){ //separating grades above 90 from the rest
                                            if (grades[i] >= 70 && grades[i] < 80){
                                                gradeC[j] = grades[i];
                                                j++;
                                            }
                                        }
                                        for(j=0; j<gradeC.length; j++){ //counting how many grades in that range
                                            if(gradeC[j] !=0 ){
                                                counter++;
                                            }
                                        }
                                        if (counter == 1){ //separate statements for grammar
                                        System.out.println("There is " + counter + " grade in the C range.");
                                        }
                                        if (counter != 1){
                                        System.out.println("There are " + counter + " grades in the C range.");
                                        }
                                        break;
                                    case 'D':
                                        for (int i = 0; i<grades.length; i++){ //separating grades above 90 from the rest
                                            if (grades[i] >= 60 && grades[i] < 70){
                                                gradeD[j] = grades[i];
                                                j++;
                                            }
                                        }
                                        for(j=0; j<gradeD.length; j++){ //counting how many grades in that range
                                            if(gradeD[j] !=0 ){
                                                counter++;
                                            }
                                        }
                                        if (counter == 1){ //separate statements for grammar
                                        System.out.println("There is " + counter + " grade in the D range.");
                                        }
                                        if (counter != 1){
                                        System.out.println("There are " + counter + " grades in the D range.");
                                        }
                            
                                        break;
                                    case 'F':
                                        for (int i = 0; i<grades.length; i++){ //separating grades above 90 from the rest
                                            if (grades[i] >= 0 && grades[i] < 60){
                                                gradeF[j] = grades[i];
                                                j++;
                                            }
                                        }
                                        for(j=0; j<gradeF.length; j++){ //counting how many grades in that range
                                            if(gradeF[j] !=0 ){
                                                counter++;
                                            }
                                        }
                                        if (counter == 1){ //separate statements for grammar
                                        System.out.println("There is " + counter + " grade in the F range.");
                                        }
                                        if (counter != 1){
                                        System.out.println("There are " + counter + " grades in the F range.");
                                        }
                            
                                        break;
                                }
                                letterVal = false; //breaks loop
                            } else {
                                letterVal = true; //if it is not in range A,B,C,D,F --> loop continues
                            }
                            }
                    }    
        }
    }
}