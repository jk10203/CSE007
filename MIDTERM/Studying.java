import java.util.Scanner;
public class Studying{
    public static void main(String[]args){
        Scanner input = new Scanner (System.in);
        /* list of things to work on 
        1) loops in loops
        2) do while, for , while loop
        3)charAt. stuff
        4) just go over the input validation stuff
        

        // ( 1 ) try to print 5 astericks 5 rows 5 columns
        //this prints 1 * according to the rows entered by user
        System.out.println("Enter a positive integer: ");
        int rows = input.nextInt();
        for(int counter = 1; counter <= rows; counter ++){
            System.out.println("*");
        }
        /*
        System.out.println("Enter another positive integer: ");
        //i want to print if 6 is rows than 6 astericks than next is 5 astericks.etc
        int counter = input.nextInt();
        for (int row = counter; row>0; row--){
            for (int length = row; length>0; length--){
                System.out.print("*");
            }
            System.out.println();
        }
        
        System.out.println("Enter ANOTHER positive integer: ");
        int counter = input.nextInt();
        for(rows = 1; rows <= counter; rows++){ // HOW MANY times below is printing for each row
            for (int length = 1; length <= rows; length++){ //WHAT is printing for each row
                System.out.print("*");
            }
            System.out.println();//controls next row
        }
        
         for(int row = 5; row > 0; row--){
            for(int col = row; col > 0; col--){
                System.out.print("*");
            }
            System.out.println(); *
        
        } */
        /* // DOOOOOO LOOOOP
        int count = 0;
        int sum = 0;
        boolean flag = true;
        do{
            do{
                System.out.println("Enter an integer");
                boolean correct = input.hasNextInt();
                if(correct){
                    int val = input.nextInt();
                    sum += val;
                    ++count;
                    flag = false;
                } else{
                    System.out.println(" invalid input");
                    String junk = input.next();
                }
            }while(flag);
        } while (count<5); */
        //trying to create a sum program
        /*


        //while LOOOOOOPPP
        int count = 0;
        int sum = 0;
        
        while(count<5){
            boolean flag = true;
            while(flag){
                System.out.println("Enter an integer: ");
                boolean correct = input.hasNextInt();
                if (correct){
                    int i = input.nextInt();
                    sum += i;
                    flag = false;
                } else {
                    System.out.println("invalid input");
                    String junk = input.next();
                }
                count++;
            }
        }
        System.out.println(sum);
            */
        
        // for LOOOOOPP
        int val=0;
        int i = 0;
        int sum = 0;

        for(int count = 0; count<5; count++){// going to run 5 times
            System.out.println("Enter an integer: ");
            boolean value= input.hasNextInt();
            if (value){
                i = input.nextInt();
                sum+=i;
                value = false;
            } else {
                System.out.println("invalid input. Try again.");
                String junk = input.next();
                value = true;
            }
        } System.out.println(sum);
            
        
    }
}