
/* Joy Kim
October 26, 2022
CSE007 Fall 2022: Participation 10
JDK 11 */
//This program is intended to find the average of arrays
import java.util.Scanner;
import java.util.Arrays;
public class OverloadMultiAvg{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int dimension = getDimension(s); //method input validation for number of dimensions
        int length = getLength(s); //method input validation for length of array

        switch(dimension){
            case 1: 
                int[]arrI = new int[length]; 
                fillArray(arrI); //arrI in main method is list[] in method parameter
                System.out.println(Arrays.toString(arrI));
                System.out.println("The average of the above numbers is: "+ findAverage(arrI));
                break;
            case 2: 
                
                System.out.println("Enter a second dimension");
                int elLength = getLength(s);
                //create a 2d array called arr2D that is length x elLength
                int[][] arr2D = new int[length][elLength]; //
                
                fillArray(arr2D);           
                System.out.println(Arrays.toString(arr2D)); //prints out the memory location of the arrays
                System.out.println(Arrays.deepToString(arr2D)); //prints out the arrays themselves
                System.out.println("The average of the above numbers is: "+ findAverage(arr2D));    
                break;
        }
        s.close();
    }
    public static int getInt(Scanner keys){
        int num = 0;
        boolean loopControl = true;
        do{
            if(keys.hasNextInt()){
                num = keys.nextInt();
                loopControl = false;
            } else {
                System.out.println("not an int");
                keys.nextLine();
            }
        } while (loopControl);
        return num;
    }
    public static int getLength(Scanner scan){
        //complete this method to use getInt
        int length;
        do{
            System.out.println("Please enter the length of the array: ");
            length = getInt(scan);
            if(length>=2 && length<=25){
                break;
            } else {
                System.out.println("out of range (2-25)");            }
        } while (true);
        return length;
    }

    public static int getDimension(Scanner scan){
        //complete this method to return only a valid int (1 or 2) -- you should call getInt
       int dim;
       boolean tf = true;
        do{
            System.out.println("Please enter a dimension (1 or 2): ");
            dim = getInt(scan);
            if(dim == 1 || dim == 2){
                tf = false;
            } else {
                System.out.println("out of range (1 or 2)");            }
        } while (tf);
        return dim;
    }
    
    public static void fillArray(int[]list){
        for(int i = 0; i<list.length; i++){
            int ran = (int)(Math.random()*100)+1;
            list[i] = ran;
        }
    }
    public static void fillArray(int[][]list){
        ///complete this method
        for(int i = 0; i<list.length; i++){  //doing row first
            for(int j =0; j<list[i].length; j++){ //going through each element in row
                int ran = (int)(Math.random()*100) +1; //get number from 1 - 100
                list[i][j] = ran; //as a result - 2D array is filled with random numbers
            }
        }
    }

    public static double findAverage(int[]list){
        double avg, sum=0;
        for(int i = 0; i<list.length; i++){
            sum += list[i];
        }
        avg = sum / list.length;
        return avg;
    }
    public static double findAverage(int[][]list){
        //complete this method
        double sum = 0, average;
        int numInts = 0;
        for(int i = 0; i<list.length; i++){
            //sum = 0 so it resets for each row if trying to get average of each row
            numInts += list[i].length; //what if array doesn't have same length
            for(int j = 0; j < list[i].length; j++){
                sum += list[i][j];
            }
        }
        average = sum / numInts;
        return average;
    }


}