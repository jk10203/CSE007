import java.util.Scanner;
//2d array
public class TWODMASTERSHEET {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            
            System.out.println("Please enter number of rows");
            //should usually declare a variable in the main method to set equal to method returns
            int rowLength = getRow(input);
            System.out.println("Please enter the column length (number of elements)");
            int colLength = getCol(input); //can +1 or +2 to edit the legnth
            int[][] array1 = new int[rowLength][colLength];
            
            //using the method where using empty declared array in main and 
            //filling it in a method and returning that filled array
            randFill2DArray(array1); 

            for (int i = 0; i< array1.length; i++){//row
                System.out.println(" "); //so each row is separated
                for (int j = 0; j< array1[i].length; j++){
                    System.out.print(array1[i][j] + " ");
                }
            }

            System.out.println(" ");
            System.out.println("Please enter 1 for linear search or 2 for  binary search: ");
            int searchChoice = getChoice(input);
            switch (searchChoice){
                //basically for searches, you are trying to check to see if the number is there so the 
                //return values are either the index  # where the number ur looking for is at
                //or -1 meaning it was not found
                case 1: //linear
                    System.out.println("Please enter a number to search for: ");
                    int[] linearSearch = checkLinearly(array1, input);

                    if (linearSearch[0] > -1 && linearSearch[1]>-1){
                        System.out.println("Number was found at row #" +linearSearch[0] + ", column #" + linearSearch[1]);
                    } else {
                        System.out.println("Number not found :(");
                    }
                    break;

                case 2: //binary 2 DIMENSIONALLLLLL
                //NEEDS TO BE SORTED
                System.out.println("First, please enter a sorting method (1 for selection, 2 for insertion)");
                int sortingChoice = getChoice(input);
                int indexSmallest[] = {-1,-1};
                int temp = 0;
                switch (sortingChoice){
                    case 1: //selection
                        //you make the first FOR loop the smallestindex then the second FOR loop as a comparison to compare
                        for (int k = 0; k<array1.length; k++){ //array1.length = # of rows
                            for (int i = 0; i<array1[k].length - 1; i++){
                                indexSmallest[0] = k; //set another variable or 1D array into k and i as the "smallest"
                                indexSmallest[1] = i;
                                for(int j = i + 1; j<array1[k].length; j++){ //you have to make j 1 more than i so it has two different vals to compare
                                    
                                    if (array1[k][j]</*> for descending*/array1[indexSmallest[0]][indexSmallest[1]]){ //make the innermost for loop variable < the smallest index
                                        indexSmallest[0] = k;
                                        indexSmallest[1] = j;
                                    }
                                }
                                temp = array1[k][i]; //holds temp value for the smallest
                                array1[k][i] = array1[indexSmallest[0]][indexSmallest[1]];
                                array1[indexSmallest[0]][indexSmallest[1]] = temp;
                            }
                        }
                        for (int i = 0; i< array1.length; i++){//row
                            System.out.println(" "); //so each row is separated
                            for (int j = 0; j< array1[i].length; j++){
                                System.out.print(array1[i][j] + " ");
                            }
                        }
                        break;
                        
                    case 2://insertion
                        for (int k = 0; k<array1.length; k++){ 
                            //keeps the rows constant so that it will be organized according to row 
                            for (int i = 1; i<array1[k].length; i++){ //starts at the 1st index (2nd element) because bc [j-1] will cover the 0th index
                                int j = i;
                                while (j > 0 && (array1[k][j]< /* > for descending*/ array1[k][j-1])){ //if the variable ahead of the one being compared is LESS then
                                    int temp2 = array1[k][j]; //this is the one that is out of order (lesser one in front)
                                    array1[k][j] = array1[k][j-1]; //make the index of the lesser value NOW equal to the array value that is GREATER than it (was out of order before)
                                    array1[k][j-1] = temp2;// now the one whose location is before is set to the lesser value
                                    --j; //to check down the array to see if the lesser value is placed correctly
                                }
                            }
                        }
                        for (int i = 0; i< array1.length; i++){//row
                            System.out.println(" "); //so each row is separated
                            for (int j = 0; j< array1[i].length; j++){
                                System.out.print(array1[i][j] + " ");
                            } 
                        }
                        break;
                }
                //binary search
                System.out.println("\nPlease enter a number to search for (binary): ");
                int binarySResult = checkBinarly(array1, input);

                if (binarySResult ==-1){
                    System.out.println("The number was not found in the 2D array.");
                } else if (binarySResult >-1){
                    System.out.println("The number was found!");
                }
            }

    }
    public static int checkBinarly(int list[][], Scanner scar){
        int choice = getRow(scar);
        int searchBIndex[] = {-1,-1};
        for (int k = 0; k<list.length; k++){
            int mid = -1;
            int low = 0;
            int high = list.length - 1;
            while (high >= low){
                mid = (high + low) / 2;
                if (list[k][mid]<choice){
                    low = mid + 1;
                } else if (list[k][mid]>choice){
                    high = mid - 1;
                } else {
                    searchBIndex[0] = k;
                    searchBIndex[1] = mid;
                    System.out.println("The index is located at row #" + searchBIndex[0] + ", column #" + searchBIndex[1]);
                    return mid; 
                }
                //counter for comparisons HERE for comparisons for whole array (each array)
            }
        }
        return -1;
    }
    public static int [] checkLinearly (int list[][], Scanner sca){ //put comparisons as parameters and initialize if you want to use in main method
        int choice = getRow(sca); //input validate first
        int searchLIndex[] = {-1, -1}; //to do index for 2D, make a 1D array to hold values
        for (int i=0; i<list.length; i++){
            for (int j = 0; j< list[i].length; j++){
                //comparisons
                if (list[i][j] == choice){
                    searchLIndex[0] = i;
                    searchLIndex[1] = j;
                    break; 
                }
            }
        }
        return searchLIndex;
    }
    public static int getChoice(Scanner s){
        int num = 0;
        boolean loopControl = true;
        do{
            if (s.hasNextInt()){
                num = s.nextInt();
                if (num ==1 || num ==2){
                    loopControl = false;
                } else{
                    System.out.println("Please enter a valid choice (1 or 2). ");
                    s.nextLine();
                }            
            } else {
                System.out.println("Please enter a valid choice (1 or 2). ");
                s.nextLine();
            }
        } while (loopControl);
        return num;
    }

    public static void randFill2DArray(int list[][]){
       // int [][] list2 = new int [list.length][list.length];
        for (int i = 0; i< list.length; i++){//row
            for (int j = 0; j< list[i].length; j++){//elements
                int ran = (int)(Math.random()*100)+1; //+1 makes the random number between 1-100 instead of 0-99;
                list[i][j] = ran;
            }
        }
    }
    public static int getRow(Scanner sc){
        int num = 0;
        boolean loopControl = true;
        do{
            if (sc.hasNextInt()){
                num = sc.nextInt();
                loopControl = false;
            } else {
                System.out.println("Please enter a valid integer. ");
                sc.nextLine();
            }

        } while (loopControl);

        return num;
    }
    public static int getCol(Scanner scan){
        int num = 0;
        boolean loopControl = true;
        do{
            if (scan.hasNextInt()){
                num = scan.nextInt();
                loopControl = false;
            } else {
                System.out.println("Please enter a valid integer for column length. ");
                scan.nextLine();
            }
        } while (loopControl);
        return num;
    }
    }
