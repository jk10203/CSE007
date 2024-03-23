
import java.util.Scanner;

public class TESTTEST{
    public static void main(String[]args){
        Scanner input = new Scanner (System.in);

        int rows = input.nextInt();
        int num = 1;
        //outer loop
        for(int i = 1; i <= rows; ++i){
            //inner loop
            for(int j = 1; j <=i; ++j){
                System.out.print(num+" ");
                num *=2;
            }
            System.out.println();
        }

        }
    }
    
