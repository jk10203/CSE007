import java.util.Scanner;
import java.util.Random;
public class STUDY{
    public static void main(String[]args){
        Scanner input = new Scanner (System.in);
        Random rand = new Random(); 
       
        //8)
        // int k= input.nextInt(); // do not rewrite
        /* for(int i=1; i < k; i++){
            System.out.println("i :"+i);
        } 
        
        int i = 1;
        while(i<k){
            System.out.println("i: " +i);
            i++;
        } 

        int i = 1;
        do{
            System.out.println("i: " +i);
            i++;
        } while (i<k);
        */

        //9)
        //for loop - height is random
        System.out.print("Enter a character: ");
        String chara = input.next();
        int triHeight = rand.nextInt(9)+ 1; //get a value between 1-10
        int rows = 1;
        int length;
        for (rows = 1; rows <= triHeight; rows++){
            for (length = 1; length <= rows; length++){
                System.out.print(chara);
            }
            System.out.println();
        } 
        
        //while loop - character and height is entered by user
        String character;
        int triHeight;
        int rows = 1;

        System.out.println("Enter a character: ");
        character = input.next(); 
        System.out.println("Enter the height of the triangle: ");
        triHeight = input.nextInt();
        
        while (triHeight<=0){
            System.out.println("Not a valid input for triangle height.");
            System.out.println("Please enter the height again: ");
            triHeight = input.nextInt();
        }
        

        while (rows <= triHeight){
            int length = 1; //I HAVE TO PUT THE INNER LOOP DECLARED VARIABLE IN THE OUTER LOOOOOOP
            while(length <= rows){
                System.out.print(character);
                length++;
            }
            rows++;
            System.out.println();
        } 
        /*
        int i;
        String str;
        str = input.nextLine();
        for (i = str.length() - 1; i >= 0; --i) { //str.length()-1 because length starts at 1 but the char starts at 0
        // conditional is i>=0 because char is 0 1 2 3 etc 
        System.out.print(str.charAt(i));
        } */
       
    }
}