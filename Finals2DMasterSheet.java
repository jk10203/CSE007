
import java.util.Scanner;
public class Finals2DMasterSheet {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //
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
}
