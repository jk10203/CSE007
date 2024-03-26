
import java.util.Scanner;
public class arraysPractice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter number of rows: ");
        int row = getChoice(input);
        System.out.println("Please enter the number of columns: ");
        int column = getChoice(input);

        String minMax;
        
        String arrayS[][] = {{"Bob", "George", "Monkey", "Doggy"},
                            {"Fly", "Flower", "Fun", "Fae"},
                            {"Water", "Earth", "Fire", "Dingus"}};
        int arraySA[][] = new int[3][4]; //--> randomly generated without repeats
       
        //alphabetizing 2D strings
        /* .compareTo() returns negative number if first variable is before (in value) than the 2nd
         * returns positive if first variable is more than (in value) than the 2nd
         * returns 0 if the same word
          */

        int indexString[] = {-1,-1};
        for(int k = 0; k<arrayS.length; k++){
            for(int i = 0; i<arrayS[k].length - 1; i++){
                indexString[0] = k;
                indexString[1] = i;
                minMax = arrayS[k][i];
                for(int j = i+1; j<arrayS[k].length; j++){
                    if (arrayS[indexString[0]][indexString[1]].compareTo(arrayS[k][j])>0){
                        indexString[1] = j;
                        minMax = arrayS[k][j];                    
                    }
                }
                if(indexString[1] != i){
                    arrayS[indexString[0]][indexString[1]] = arrayS[k][i];
                    arrayS[k][i] = minMax;
                }
            }
        }

        for (int i = 0; i< arrayS.length; i++){//row
            System.out.println(" "); //so each row is separated
            for (int j = 0; j< arrayS[i].length; j++){
                System.out.print(arrayS[i][j] + " ");
            }
        }

        System.out.println("\nWould you like to reverse the string array or shuffle? (R-1, S-2)");
        int choice2 = getChoice(input); //did not validate if 1 or 2 will exit if other
        switch(choice2){
            case 1:
                reverseArray(arrayS);
                for (int i = 0; i< arrayS.length; i++){//row
                    System.out.println(" "); //so each row is separated
                    for (int j = 0; j< arrayS[i].length; j++){
                        System.out.print(arrayS[i][j] + " ");
                    }
                }
                break;
            case 2:
                shuffleArray(arrayS);
                for (int i = 0; i< arrayS.length; i++){//row
                    System.out.println(" "); //so each row is separated
                    for (int j = 0; j< arrayS[i].length; j++){
                        System.out.print(arrayS[i][j] + " ");
                    }
                }
                break;
        }

        assignNum(arraySA);
        System.out.println("\n ");
        System.out.println("Randomly generated numbers with no repeats: ");
        for (int i = 0; i< arraySA.length; i++){//row
            System.out.println(" "); //so each row is separated
            for (int j = 0; j< arraySA[i].length; j++){
                System.out.print(arraySA[i][j] + " ");
            }
        }

        char arrayc[][] = new char[row][column];
        fillArray(arrayc);
        //descending see 2Dmastersheet
        System.out.println("\n ");
        System.out.println("Just a filled array of chars starting at 'a': ");
        for (int i = 0; i< arrayc.length; i++){//row
            System.out.println(" "); //so each row is separated
            for (int j = 0; j< arrayc[i].length; j++){
                System.out.print(arrayc[i][j] + " ");
            }
        }


    }
    public static void assignNum(int list[][]){ //assigning random variables without repeats
        for(int k=0; k<list.length; k++){ //controlling rows
            for(int i = 0; i < list[k].length; i++){
                boolean loopControl = true;
                int rand = (int)((Math.random()) *5 + 1);
                do{ //repeat if in the same row there is the same number
                    loopControl = true;
                        for(int j = 0; j<=i; j++){//checks every variable preceding the one we are working with
                            if (list[k][j] == rand){
                                loopControl = false; //if false it repeats, otherwise it runs
                                rand = (int)(Math.random()*5 + 1);
                                break;
                            }
                        }
                    }while(!loopControl);
                    list[k][i] = rand;
                }
            }
        }
    
            
    public static void shuffleArray(String shuffle[][]){ //change array type
        for(int k = 0; k<shuffle.length; k++){
            for(int i =0; i<1000;i++){
                int rand1 = (int)(Math.random() * (shuffle[k].length) - 1);
                int rand2 = (int)(Math.random()* (shuffle[k].length) - 1);

                String temp = shuffle[k][rand1]; //change variable type
                shuffle[k][rand1] = shuffle[k][rand2];
                shuffle[k][rand2] = temp;
            }
        }
    }
    public static void reverseArray(String list[][]){ //change array type
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
    public static void fillArray(char list[][]){
        char letter = 'a';
        for (int i = 0; i< list.length; i++){//row
            for (int j = 0; j< list[i].length; j++){
                list[i][j] = letter;
                letter++;
            }
        }
    }
     public static int getChoice(Scanner s){
        int num = 0;
        boolean loopControl = true;
        do{
            if (s.hasNextInt()){
                num = s.nextInt();
                loopControl = false;   
            } else {
                System.out.println("Please enter a valid choice. ");
                s.nextLine();
            }
        } while (loopControl);
        return num;
    }
}
