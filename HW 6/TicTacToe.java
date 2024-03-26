/* Joy Kim
October 30, 2022
CSE007 Fall 2022: HW 6
JDK 11 */
/* This program is intended to simulate a tic tac toe game by utilizing 2D arrays and methods in
 order to keep track of the user input. The game runs until player O or player X wins or if its a draw. 
 */
import java.util.Scanner;
public class TicTacToe{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char tttBoard[][] = new char[3][3]; //char to use ASCII numbers
        char copyBoard[][] = new char[3][3]; //copy of the board to keep track of each O and X
        char num = '1';
        int counter = 0; //to know if it is a draw or not
        boolean counter2 = false; //to use a draw as an else if statement to avoid printing both if 0 or X wins when coutner is 9
        
        copyBoard = tttBoard; //copying board
        copyBoard[0][0] ++; //copying an array into another array to use as reference
        
        //assigning the board with numbers
        for(int i = 0; i<tttBoard.length; i++){
            for (int j=0; j<3; j++){
                tttBoard[i][j] = num;
                num++; 
            }
        }
        //formatting the board
        for(int i = 0; i<tttBoard.length; i++){
            System.out.println("");
            for (int j=0; j<3; j++){
                System.out.print(tttBoard[i][j] + " ");
            }
        }
        /* to check if the arrary is copied
        for(int i = 0; i<tttBoard.length; i++){
            System.out.println("");
            for (int j=0; j<3; j++){
                System.out.print(copyBoard[i][j] + " ");
            }
        }*/

        //implement counter to keep track of if O or X
        boolean whoWinsBro = true; //controlling the loop for the game 

        while(whoWinsBro == true){
            System.out.println(" ");
            copyBoard = oKeepTrack(input); //O placement
            counter++; //incrementing for draws
            //printing out the results for the O placed
            for(int i = 0; i<tttBoard.length; i++){
                System.out.println(""); //separating rows
                for (int j=0; j<3; j++){
                    if(tttBoard[i][j]=='O' || tttBoard[i][j]=='X'){ //since in the method, the board only keeps
                        //track of one input at a time, it is only when it has a O or X that it adds to an exiting board
                        copyBoard[i][j] = tttBoard[i][j]; //utilizing two arrays back and forth
                    }
                    System.out.print(copyBoard[i][j] + " ");
                }
            }
            /*who wins possibilities
            0,0 0,1 0,2
            1,0 1,1 1,2
            2,0 2,1 2,2
            0,0 1,0 2,0 
            0,1 1,1 2,1
            0,2 1,2 2,2
            0,0 1,1 2,2 
            0,2 1,1 2,0
            */
            //all the possibilities if they win (couldn't find a pattern to use a loop on)
            if (copyBoard[0][0]== 'O' && copyBoard[0][1] =='O' && copyBoard[0][2] == 'O'){
                System.out.println("\nO player wins!");
                whoWinsBro = false;
                counter2 = true;
            }else if (copyBoard[0][0]== 'O' && copyBoard[0][1] =='O' && copyBoard[0][2] == 'O'){
                System.out.println("\nO player wins!");
                whoWinsBro = false;
                counter2 = true;
            }else if (copyBoard[1][0]== 'O' && copyBoard[1][1] =='O' && copyBoard[1][2] == 'O'){
                System.out.println("\nO player wins!");
                whoWinsBro = false;
                counter2 = true;
            }else if (copyBoard[2][0]== 'O' && copyBoard[2][1] =='O' && copyBoard[2][2] == 'O'){
                System.out.println("\nO player wins!");
                whoWinsBro = false;
                counter2 = true;
            }else if (copyBoard[0][0]== 'O' && copyBoard[1][0] =='O' && copyBoard[2][0] == 'O'){
                System.out.println("\nO player wins!");
                whoWinsBro = false;
                counter2 = true;
            }else if (copyBoard[0][1]== 'O' && copyBoard[1][1] =='O' && copyBoard[2][1] == 'O'){
                System.out.println("\nO player wins!");
                whoWinsBro = false;
                counter2 = true;
            }else if (copyBoard[0][2]== 'O' && copyBoard[1][2] =='O' && copyBoard[2][2] == 'O'){
                System.out.println("\nO player wins!");
                whoWinsBro = false;
                counter2 = true;
            }else if (copyBoard[0][0]== 'O' && copyBoard[1][1] =='O' && copyBoard[2][2] == 'O'){
                System.out.println("\nO player wins!");
                whoWinsBro = false;
                counter2 = true;
            }else if (copyBoard[0][2]== 'O' && copyBoard[1][1] =='O' && copyBoard[2][0] == 'O'){
                System.out.println("\nO player wins!");
                whoWinsBro = false;
                counter2 = true;
            }else if (counter==9 && counter2 == false){//for draws - utilizing counter
                System.out.println(""); //only on this one because always ends with this (counter will be 9 only at this part of the code not the next)
                System.out.println("It's a draw!");
                whoWinsBro = false;
            }

            tttBoard = copyBoard; //updating each array as new inputs change the array

            if (whoWinsBro){ //so it doesn't run if the conditions above are true
                System.out.println("");
                tttBoard = xKeepTrack(input); //getting X input and putting it into tttboard
                counter++;
                for(int i = 0; i<tttBoard.length; i++){
                    System.out.println("");
                    for (int j=0; j<3; j++){
                        if(copyBoard[i][j]=='O' || copyBoard[i][j]=='X'){
                            tttBoard[i][j] = copyBoard[i][j]; //copying one board into the other if it has an X or O to update
                            //since tttboard now only has ONE X (the current input of user) and copyboard is keeping track of the past inputs
                        }
                            System.out.print(tttBoard[i][j] + " "); //formatting
                    }
                }
            }
            if (tttBoard[0][0]== 'X' && tttBoard[0][1] =='X' && tttBoard[0][2] == 'X'){
                System.out.println("\nX player wins!");
                whoWinsBro = false;
                counter2 = true;
            }else if (tttBoard[0][0]== 'X' && tttBoard[0][1] =='X' && tttBoard[0][2] == 'X'){
                System.out.println("\nX player wins!");
                whoWinsBro = false;
                counter2 = true;
            }else if (tttBoard[1][0]== 'X' && tttBoard[1][1] =='X' && tttBoard[1][2] == 'X'){
                System.out.println("\nX player wins!");
                whoWinsBro = false;
                counter2 = true;
            }else if (tttBoard[2][0]== 'X' && tttBoard[2][1] =='X' && tttBoard[2][2] == 'X'){
                System.out.println("\nX player wins!");
                whoWinsBro = false;
                counter2 = true;
            }else if (tttBoard[0][0]== 'X' && tttBoard[1][0] =='X' && tttBoard[2][0] == 'X'){
                System.out.println("\nX player wins!");
                whoWinsBro = false;
                counter2 = true;
            }else if (tttBoard[0][1]== 'X' && tttBoard[1][1] =='X' && tttBoard[2][1] == 'X'){
                System.out.println("\nX player wins!");
                whoWinsBro = false;
                counter2 = true;
            }else if (tttBoard[0][2]== 'X' && tttBoard[1][2] =='X' && tttBoard[2][2] == 'X'){
                System.out.println("\nX player wins!");
                whoWinsBro = false;
                counter2 = true;
            }else if (tttBoard[0][0]== 'X' && tttBoard[1][1] =='X' && tttBoard[2][2] == 'X'){
                System.out.println("\nX player wins!");
                whoWinsBro = false;
                counter2 = true;
            }else if (tttBoard[0][2]== 'X' && tttBoard[1][1] =='X' && tttBoard[2][0] == 'X'){
                System.out.println("\nX player wins!");
                whoWinsBro = false;
                counter2 = true;
            }

            copyBoard = tttBoard; //copying board into the other
        } 

    }
    public static int inputVal(Scanner keys){ //input validating to make sure the input is between 1-9
        int num = 0;
        boolean loopControl = true;
        do{
            if(keys.hasNextInt()){
                num = keys.nextInt();
                if(num<=9 && num>=1){
                    loopControl = false;
                } else {
                    System.out.println("Please enter a valid integer from 1-9: ");
                    keys.nextLine();
                }
            } else { //if it doesn't have an int
                System.out.println("Please enter a valid integer from 1-9: ");
                keys.nextLine();
            }
        } while (loopControl);
        return num; //returning the input if it fulfills above condition
    }

    public static char[][] oKeepTrack(Scanner scan){
        char num = '1';
        char methodBoardO[][] = new char[3][3];
        //making a new board for JUST the one input from the user
        for(int i = 0; i<methodBoardO.length; i++){
            for (int j=0; j<3; j++){
                methodBoardO[i][j] = num;
                num++;
            }
        }
        System.out.println("Please enter the placement of the O token (1-9): "); //switches to relate number to column/row
        int oChoice = inputVal(scan);
        switch(oChoice){
            case 1:
                methodBoardO[0][0] = 'O';
                break;
            case 2:
                methodBoardO[0][1] = 'O';
                break;
            case 3:
                methodBoardO[0][2] = 'O';
                break;
            case 4:
                methodBoardO[1][0] = 'O';
                break;
            case 5:
                methodBoardO[1][1] = 'O';
                break;
            case 6:
                methodBoardO[1][2] = 'O';
                break;
            case 7:
                methodBoardO[2][0] = 'O';
                break;
            case 8:
                methodBoardO[2][1] = 'O';
                break;
            case 9:
                methodBoardO[2][2] = 'O';
                break;
        } 
        return methodBoardO;
    }
        public static char[][] xKeepTrack(Scanner s){
        char num = '1';
        char methodBoardX[][] = new char[3][3]; //making a whole new board that will carry ONE input from user each time
        for(int i = 0; i<methodBoardX.length; i++){
            for (int j=0; j<3; j++){
                methodBoardX[i][j] = num;
                num++;
            }
        }
        System.out.println("Please enter the placement of the X token (1-9): ");
        int xChoice = inputVal(s);
        switch(xChoice){ //switches to relate 1-9 to a row/column
            case 1:
                methodBoardX[0][0] = 'X';
                break;
            case 2:
                methodBoardX[0][1] = 'X';
                break;
            case 3:
                methodBoardX[0][2] = 'X';
                break;
            case 4:
                methodBoardX[1][0] = 'X';
                break;
            case 5:
                methodBoardX[1][1] = 'X';
                break;
            case 6:
                methodBoardX[1][2] = 'X';
                break;
            case 7:
                methodBoardX[2][0] = 'X';
                break;
            case 8:
                methodBoardX[2][1] = 'X';
                break;  
            case 9:
                methodBoardX[2][2] = 'X';
                break;
        }
        return methodBoardX; //returning a WHOLE array
    }
}