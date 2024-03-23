/* Joy Kim
November 3, 2022
CSE007 Fall 2022: Lab 10
JDK 11 */
/*This program is intended to utilize different ways of organizing arrays by either sorting them in 
 * descending and ascending order and searching for the number. It includes both 1D and 2D arrays which
 * are modifiable by user input. A majority of this program uses methods to achieve this.
*/

import java.util.Scanner;
import java.util.Arrays;
public class ArrayAlgos{
    public static void main(String[] args) {
       System.out.println("What size 1d array would you like?");
       Scanner scnr = new Scanner(System.in);
       int size = scnr.nextInt();
       int[] arrayToPlay = randomArray(size);
       System.out.println("Original Array: \n"+Arrays.toString(arrayToPlay));
       System.out.println("List in Ascending Order");
       ascendArray(arrayToPlay);
       System.out.println(Arrays.toString(arrayToPlay));
       
       System.out.println("What number would you like to search for?");
       int key = scnr.nextInt();
       int index = linearSearch(arrayToPlay, key);
       System.out.println("Performing linear search on your 1D array..."); //organizing when program is using linear or binary search
       if (index != -1) {
           System.out.println("Your key was found at index " + index);
       } else {
           System.out.println("Your key was not found"); 
        }

       System.out.println("List in Descending Order");
       descendArray(arrayToPlay);
       System.out.println(Arrays.toString(arrayToPlay));
       
       System.out.println("Performing a binary search on your sorted array.");
       index = binarySearch1d(arrayToPlay, key);
       if (index != -1) {
           System.out.println("Your key was found at index " + index);
       } else {
           System.out.println("Your key was not found (return value is " + index + ")."); 
           } //including index # for return to show that it is -1
        
       System.out.println("Enter the number of rows in your 2D array: ");
       int rows = scnr.nextInt();
       System.out.println("Enter the number of columns in your 2D array: ");
       int cols = scnr.nextInt();
       int[][] randomArray2dim = randomArray(rows, cols);
       System.out.println(Arrays.toString(randomArray2dim));
       System.out.println(Arrays.deepToString(randomArray2dim));
       for (int i = 0; i < rows; i++) {
           System.out.println(Arrays.toString(randomArray2dim[i])); }
       
           System.out.println("Enter a number to search for in your 2D array: ");
       key = scnr.nextInt();
       int[] indexArray = linearSearch2d(randomArray2dim, key);
       System.out.println("Performing linear search on the 2D array...");
       if (indexArray[0] != -1) {
    		System.out.println("Key found @ row " + indexArray[0] + ", col " + indexArray[1]);
       } else {
           System.out.println("Your key was not found (return value is " + indexArray[0] + ").");
           //including index # for return to show that it is -1
       }
    }
// Method Headers:
    //declare and create a random array with elements from 0 to length (number of ints)
    public static int[] randomArray(int arrayLength){
    //one loop per dimension
        int[] array = new int[arrayLength];
        for (int i = 0; i <array.length; i++){
            array[i] = (int)(Math.random() * array.length); //array length makes it so it depends on how many elements in the array
        }
        return array;
    }

    //declare and create a random 2d array with valyes from 0 to the total number of integer elements
    public static int[][] randomArray(int rows, int cols){
        int[][] array = new int[rows][cols];
        int numEl = rows * cols; //to figure out how many elements are in a 2D loop
        for (int r = 0; r <array.length; r++){
            for (int c = 0; c< array[r].length; c++){
                array[r][c] = (int)(Math.random() * numEl); //generating random number for each element
            }
        }
        return array;
        }
    
    public static void ascendArray(int[] list){
        for(int i = 0; i< list.length-1; i++){
            int min = list[i];
            int indexMin = i;
            for(int j = i+1; j<list.length; j++)
            if(min> list[j]){ //if min is more than then value that comes after it
                min = list[j];//min becomes the number that is less than itself
                indexMin = j;//records the index that carries the smaller number to j

            }
            if (indexMin != i){ //if the index that carries the smaller number does not correspond to i
                list[indexMin] = list[i]; //the minimum index carries the value of the value of i at that time
                list[i] = min;// list i now corresponds to the new minimum
            }
        }
    }
    public static void descendArray (int[] list){
     for(int i = 0; i< list.length-1; i++){
        int max = list[i];
        int indexMax = i;
            for(int j = i+1; j<list.length; j++)
            if(max < list[j]){ //same idea as above but now flipped so that if min is less than value that comes after it
                max = list[j];// min becomes the number that is bigger than itself
                indexMax = j; //keeps track of the index that carries the max index

            }
            if (indexMax != i){ //to modify the original array so that it is in descended order
                list[indexMax] = list[i];
                list[i] = max;
            }
        }
     }
    

    //search for key in list return index if found
    public static int linearSearch(int[] list, int key){
         int index = -1;
         int counterL = 0; //counter for comparisons
        for (int i = 0; i <list.length; i++){
            counterL++;
            if( list[i] == key){ //if the number is found than index keeps track of where it was found (i)
                index = i;
                break;
            }
        }
        System.out.println("Comparisons made: " +  counterL);
        return index;
    }

    //search for integer key in two dimensional array and return an array with indices
    public static int[] linearSearch2d(int[][] searchArray2d, int key){
        int [] index = {-1, -1}; //needs an array to keep track of row and column of where the number is found
        int counterL2 = 0;//counter for comparisons
        for(int r = 0; r<searchArray2d.length; r++){
            for(int c = 0; c< searchArray2d[r].length; c++){
                counterL2++;
                if(searchArray2d[r][c] == key ){ //if found, then 
                    index[0] = r;//.. index changes so that 0 corresponds to rows
                    index[1] = c;// 1 corresponds to column
                    break;
                }
            }
        }
        System.out.println("Comparisons made: " +  counterL2);
        return index;
    }

    public static int binarySearch1d(int[] list, int key){ //descending
        int high = 0;
        int low = high; 
        int index = -1;
        high = list.length - 1; 
        int counterB = 0;
        // 10 9 8 7 6 5 4 3 2 1
        while (high>=low){
            counterB++; //counter
            int mid = (high+low) / 2; //establishes middle value
            if(list[mid] > key){
                low = mid+1; //low changes if mid is bigger than the number that we are searching for
            } else if (list[mid]< key){
                high = mid - 1;//high changes if mid is smaller than the number that we are searching for
            } else {
                index = mid;  //if found than the index equals mid
                break;
            }
        }
        System.out.println("Comparisons made: " +  counterB);
        return index;
    }


}
