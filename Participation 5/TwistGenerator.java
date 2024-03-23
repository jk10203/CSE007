/* Joy Kim
23 September, 2022
CSE007 Fall 2022: Participation 5
JDK 11 
*/
/* This program is intended to utilize loops within loops to generate a pattern
according to the length input given by the user. Because this pattern that we try to recreate
repeats itself, loops prove to be the perfect way to achieve the purpose of this program. */
import java.util.Scanner;
public class TwistGenerator{
    public static void main(String[]args){
        Scanner input = new Scanner (System.in);

        int length = 0;
        boolean loop = true;

        do {
            System.out.println("Enter a positive integer: ");
            if (input.hasNextInt()){
                //read integer and check range
                length = input.nextInt();
                if (length > 0){
                    loop = false; //or break;
                } else {
                    System.out.println("Not a positive Integer.");
                }
            } else {
                //use didn't type an int - clear scanner
                String junk = input.nextLine();
                System.out.println("Invalid input. NOT an integer.");
            }
        } while (loop);

        int count = 0;
        while(count < length){
            //printing the first row
            //\ / comparing count to amount of characters you put in that line
            // every time loop happens, one character prints
            if (count % 3 == 0){
                System.out.print("\\");
            } else if (count % 3 == 1){
                System.out.print(" ");
            } else {
                System.out.print ("/");
            }
            count++;
        }
        System.out.println();

        //loop to print the second row follows
        for(count = 0; count <length; count++){
            //space - x - space
            if (count % 3 == 1){
                System.out.print("X");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();

        count = 0;
        while(count < length){
            //printing the first row
            //\ /
            if (count % 3 == 0){
                System.out.print("/");
            } else if (count % 3 == 1){
                System.out.print(" ");
            } else {
                System.out.print ("\\");
            }
            count++;
        }
        System.out.println();
    }
}
