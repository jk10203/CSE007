/* Joy Kim
November 1, 2022
CSE007 Fall 2022: Exam 2
JDK 11 */
import java.util.Scanner;
public class Exam2{
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the dimension of a 1D array");
        int length = getInt(s);
        System.out.println("Enter two dimensions -- row and col for the 2D array");
        int row = getInt(s);
        int col = getInt(s);
        String[] words = new String[length];
        String[][] moreWords = new String[row][col];

        fillArray(words);
        fillArray(moreWords);

        System.out.println("Words: "); 
        printArray(words);
        System.out.println("Lots of Words: "); 
        printArray(moreWords);

        sortArray(words);
        System.out.println("Sorted Words: "); 
        printArray(words);

        searchArray(words, "EXAM2!");
        searchArray(words, words[0]);

        System.out.println("Lots of Words (Again): "); 
        printArray(moreWords);

        sortArray(moreWords[0]);
        System.out.println("Lots of Words, Sorted first row: ");
        printArray(moreWords);

        reverseArrays(moreWords);
        System.out.println("Lots of Words Reversed: ");
        printArray(moreWords);

        searchArray(moreWords, "TESTINGSEARCH");
        searchArray(moreWords, moreWords[row-1][col-1]);  
        //i edited the index print statement so that the columns and rows do not start at zero
        
        s.close();
    }
    public static int getInt(Scanner keys){
        int num = 0;
        boolean loopControl = true;
        do{
            if(keys.hasNextInt()){
                num = keys.nextInt();
                if(num >=5 && num <=95){
                    loopControl = false;
                } else {
                    System.out.println("Out of range -- 5:95");
                }
            } else {
                System.out.println("not an int");
                keys.nextLine();
            }
        } while (loopControl);
        return num;
    }
    public static char generateChar(){
        //return a random character that is in one of these ranges: 0-9, A-Z or a-z
        int randChoice = (int)(Math.random()*62);
        //0-9 48-57
        //total is 62
        //A-Z 65-90
        //a-z  97-122
        char arrayRan[] = new char[62]; //to generate random
        char num = '0';
        char capA = 'A';
        char lowerA = 'a';
        char charRESULTS;

        for(int i = 0; i<10; i++){ //using the loop bounds in order to get a random value
            arrayRan[i] = num;
            num++;
        }
        for(int i = 10; i < 36; i++){
            arrayRan[i] = capA;
            capA++;
        }
        for (int i = 36; i< 62; i++){
            arrayRan[i] = lowerA;
            lowerA++;
        }

        charRESULTS = arrayRan[randChoice];
        return charRESULTS;

    }
    public static void fillArray(String[] list){
        //Overload the printArray() method to accept either a one- or two-dimensional array 
        //of Strings. Iterate through the appropriate array and display each String element on 
        //the same line. Be sure to print new lines between each row of the two-dimensional array. 
        //These methods must be void.
        for(int i = 0; i<list.length; i++){
            list[i] = String.valueOf(generateChar()); //a command in the string class to change the variable
        }
    }

    public static void fillArray(String[][]list){
        for (int k = 0; k<list.length; k++){
            for(int i = 0; i<list[k].length; i++){
                list[k][i] = String.valueOf(generateChar());
                
            }
        }
    }
    public static void printArray(String[] list){
        for (int i =0; i< list.length; i++){ //one row so one for loop
            System.out.print(list[i] + " ");
        }
    }
    public static void printArray(String[][]list){
        for (int i = 0; i< list.length; i++){//row
            System.out.println(" "); //so each row is separated
            for (int j = 0; j< list[i].length; j++){
                System.out.print(list[i][j] + " ");
            }
        }
    }
    public static void sortArray(String[]list){
        //I chose to use selection sort where the sorting algorithm
        /*is able to treat the input as two parts which is the sorted and the unsorted parts. 
         * it then is able to repeatedly select the next value that is desired (bigger if descending and smaller is ascending)
         * and move it from the unsorted to the sorted part of the array. It compares each element to one another 
         * in order to make sure that the element that is being moved is indeed the biggest (for descending). it checks every
         * element.
         */
        //For the one-dimensional array, you must sort the elements 
        //in descending order using the sorting algorithm of your choice (insertion or selection).
        int indexSmallest;
        String holder = "change";
        for (int i = 0; i < list.length - 1; ++i) {
   // Find index of smallest remaining element
            indexSmallest = i;
            for (int j = i + 1; j <list.length; ++j) {
                if (list[j].compareTo(list[indexSmallest]) > 0) {
                    indexSmallest = j;
                    holder = list[j];
                    
                }   
   // Swap numbers[i] and numbers[indexSmallest]
            }      
            if(indexSmallest != i){
                list[indexSmallest] = list[i];
                list[i] = holder;
            }   

        }
        printArray(list);
    }
    public static void reverseArrays(String[][]list){
        int i = 0;
        String tempValue; //change to array type
        for (int k = 0; k< list.length; k++){
            for (i = 0; i < ((list[k].length)/2); i++){
                tempValue = list[k][i];
                list[k][i] = list[k][(list[k].length) - 1 - i];
                list[k][(list[k].length) - 1 - i] = tempValue;
            }
        }
    }
    public static void searchArray(String[]list, String key){
        sortArray(list);
        /*The array first has to be sorted because the sorting relies on the relative positioning of
         * other string/char values in the array in order to find the middle value see if the word you are looking
         * for is less than/ equal to /greater than to see if it should split it and look for the next middle element 
         * to the right or to the left (greater or less than).
        */
        int searchBIndex = -1;
        int mid = -1;
        int low = 0;
        int high = list.length - 1;
        while (high >= low){
            mid = (high + low) / 2;
            if (list[mid].compareTo(key)<0){ //if list [k][mid] is less than the input/char neg
                low = mid + 1;
            } else if (list[mid].compareTo(key)>0){ //if list [k][mid] is more than input/char pos
                high = mid - 1;
            } else { //returns zero is same word
                searchBIndex = mid;
                System.out.println("The string was found!");
                System.out.println("The index is located at row #" + (searchBIndex+1) + ", column #" + (searchBIndex+1)); //edited index so it doesn't start at zero  
                break;
            }
            //counter for comparisons HERE for comparisons for whole array (each array)
        }
        
        if (searchBIndex == -1){
            System.out.println("Word was not found.");
        }
    }
    public static void searchArray(String[][]list, String key){
        int searchLIndex[] = {-1, -1}; //to do index for 2D, make a 1D array to hold values
        for (int i=0; i<list.length; i++){
            for (int j = 0; j< list[i].length; j++){
               //comparisons
                if (list[i][j] == key){
                   searchLIndex[0] = i;
                   searchLIndex[1] = j;
                   break; 
                }
            }
        }
        if (searchLIndex[0] > -1 && searchLIndex[1]>-1){
        System.out.println("Word/char was found at row #" +(searchLIndex[0]+1) + ", column #" + (searchLIndex[1]+1));
        } else {
        System.out.println("Word/char not found :(");
        }
    }

}