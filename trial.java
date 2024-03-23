
   /* Joy Kim
November 1, 2022
CSE007 Fall 2022: Exam 2
JDK 11 */
import java.util.Scanner;
public class trial{
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the dimension of a 1D array");
        int length = getInt(s);
        System.out.println("Enter two dimensions -- row and col for the 2D array");
        int row = getInt(s);
        int col = getInt(s);
        String[] words = new String[length];
        String[][] moreWords = new String[row][col];
        sortArray(words);
        System.out.println("Sorted Words: "); 
        printArray(words);

        //fillArray(words);
        //fillArray(moreWords);

        /*System.out.println("Words: "); 
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
        printArray(moreWords);*/

        reverseArrays(moreWords);
        System.out.println("Lots of Words Reversed: ");
        printArray(moreWords);

        searchArray(moreWords, "TESTINGSEARCH");
        searchArray(moreWords, moreWords[row-1][col-1]); 
        
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

        for(int i = 0; i<10; i++){
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
        //For the one-dimensional array, you must sort the elements 
        //in descending order using the sorting algorithm of your choice (insertion or selection).
        int indexSmallest;
        String temp;
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

    }
    public static void searchArray(String[][]list, String key){

    }
}
    

