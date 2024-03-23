/* Joy Kim
14 September, 2022
CSE007 Fall 2022: HW 2
JDK 11 */
/* This program is intended to simulate the game of Craps by giving the user two 
ways to play the game. One way involves randomly casting dice and receiving the 
ouput of the terminology of the two dice that were thrown. The second involves 
getting input from the user for the two dice values and outputting the terminology 
of the roll*/

import java.util.Scanner;
import java.util.Random;
public class Craps{
    public static void main(String[]args){
        Scanner input = new Scanner (System.in);
        Random rand = new Random();

        System.out.println("Welcome to the game of Craps.");
        System.out.println("What would you like to do?");
        System.out.println("1. Randomly cast dice");
        System.out.println("2. State two dice you want to evaluate");
        
        int choice = input.nextInt();
        
        switch(choice){
            //two die values are chosen at random
            case 1:
                int num = rand.nextInt(5) + 1; // in order to get a value between 1 - 6
                int num2 = rand.nextInt(5) + 1;
                if (num == 1 && num2 == 1){
                    System.out.println("You rolled 1 and 1, the slang terminology is Snake Eyes.");
                }
                else if (num == 6 && num2 == 6){
                    System.out.print("You rolled 6 and 6, the slang terminology is Boxcards");
                }
                else if (num == num2){
                    System.out.print("You rolled " + num + " and " + num2 + ", the slang terminology is ");
                    System.out.print("Hard ");
                    if (num == 2){
                        System.out.print("Four");
                    }
                    else if(num == 3){
                        System.out.print("Six");
                    }
                    else if (num == 4){
                        System.out.print("Eight");
                    }
                    else if (num == 5){
                        System.out.print("Ten");
                    }
                }
                else if (Math.abs(num - num2) == 2){
                    System.out.print("You rolled " + num + " and " + num2 + ", the slang terminology is ");
                    if((num == 1 && num2 == 3)||(num == 3 && num2 == 1)){
                    System.out.println("Easy Four");
                    }
                    else if ((num == 4 & num2 == 2)||(num == 2 && num2 == 4)){
                    System.out.println("Easy Six"); 
                    }
                    else if ((num == 5 & num2 == 3)||(num == 3 && num2 == 5)){
                    System.out.println("Easy Eight"); 
                    }
                    else if ((num == 6 & num2 == 4)||(num == 4 && num2 == 6)){
                    System.out.println("Easy Ten"); 
                    }
                }
                else if (Math.abs(num - num2) == 1){
                    System.out.print("You rolled " + num + " and " + num2 + ", the slang terminology is ");
                    if ((num == 2 & num2 == 1)||(num == 1 && num2 == 2)){
                    System.out.println("Ace Deuce"); 
                    }
                    else if ((num == 3 & num2 == 2)||(num == 2 && num2 == 3)){
                    System.out.println("Fever Five"); 
                    }
                    else if ((num == 4 & num2 == 3)||(num == 3 && num2 == 4)){
                    System.out.println("Seven Out"); 
                    }
                    else if ((num == 5 & num2 == 4)||(num == 4 && num2 == 5)){
                    System.out.println("Nine"); 
                    }
                    else if ((num == 6 & num2 == 5)||(num == 5 && num2 == 6)){
                    System.out.println("Yo-leven"); 
                    }
                }
                else if ((num == 4 & num2 == 1)||(num == 1 && num2 == 4)){
                    System.out.print("You rolled " + num + " and " + num2 + ", the slang terminology is ");
                    System.out.println("Fever Five");
                }
                else if ((num == 5 & num2 == 1)||(num == 1 && num2 == 5)){
                    System.out.print("You rolled " + num + " and " + num2 + ", the slang terminology is ");
                    System.out.println("Easy Six");
                }
                else if ((num == 5 & num2 == 2)||(num == 2 && num2 == 5)){
                    System.out.print("You rolled " + num + " and " + num2 + ", the slang terminology is ");
                    System.out.println("Seven Out");
                }
                else if ((num == 4 & num2 == 1)||(num == 1 && num2 == 4)){
                    System.out.print("You rolled " + num + " and " + num2 + ", the slang terminology is ");
                    System.out.println("Fever Five");
                }
                else if ((num == 6 & num2 == 1)||(num == 1 && num2 == 6)){
                    System.out.print("You rolled " + num + " and " + num2 + ", the slang terminology is ");
                    System.out.println("Seven Out");
                }
                else if ((num == 6 & num2 == 2)||(num == 2 && num2 == 6)){
                    System.out.print("You rolled " + num + " and " + num2 + ", the slang terminology is ");
                    System.out.println("Easy Eight");
                }
                else if ((num == 6 & num2 == 3)||(num == 3 && num2 == 6)){
                    System.out.print("You rolled " + num + " and " + num2 + ", the slang terminology is ");
                    System.out.println("Fever Five");
                }
        
            //user chooses 2 die values
            case 2:
                System.out.print("Enter the first die value (1-6): ");
                num = input.nextInt();
                System.out.print("Enter the second die value (1-6): ");
                num2 = input.nextInt();
                
                if (num == 1 && num2 == 1){ //basically same code as the first part
                    System.out.println("You rolled 1 and 1, the slang terminology is Snake Eyes.");
                }
                else if (num == 6 && num2 == 6){
                    System.out.print("You rolled 6 and 6, the slang terminology is Boxcards");
                }
                else if (num == num2){
                    System.out.print("You rolled " + num + " and " + num2 + ", the slang terminology is ");
                    System.out.print("Hard ");
                    if (num == 2){
                        System.out.print("Four");
                    }
                    else if(num == 3){
                        System.out.print("Six");
                    }
                    else if (num == 4){
                        System.out.print("Eight");
                    }
                    else if (num == 5){
                        System.out.print("Ten");
                    }
                }
                else if (Math.abs(num - num2) == 2){
                    System.out.print("You rolled " + num + " and " + num2 + ", the slang terminology is ");
                    if((num == 1 && num2 == 3)||(num == 3 && num2 == 1)){
                    System.out.println("Easy Four");
                    }
                    else if ((num == 4 & num2 == 2)||(num == 2 && num2 == 4)){
                    System.out.println("Easy Six"); 
                    }
                    else if ((num == 5 & num2 == 3)||(num == 3 && num2 == 5)){
                    System.out.println("Easy Eight"); 
                    }
                    else if ((num == 6 & num2 == 4)||(num == 4 && num2 == 6)){
                    System.out.println("Easy Ten"); 
                    }
                }
                else if (Math.abs(num - num2) == 1){
                    System.out.print("You rolled " + num + " and " + num2 + ", the slang terminology is ");
                    if ((num == 2 & num2 == 1)||(num == 1 && num2 == 2)){
                    System.out.println("Ace Deuce"); 
                    }
                    else if ((num == 3 & num2 == 2)||(num == 2 && num2 == 3)){
                    System.out.println("Fever Five"); 
                    }
                    else if ((num == 4 & num2 == 3)||(num == 3 && num2 == 4)){
                    System.out.println("Seven Out"); 
                    }
                    else if ((num == 5 & num2 == 4)||(num == 4 && num2 == 5)){
                    System.out.println("Nine"); 
                    }
                    else if ((num == 6 & num2 == 5)||(num == 5 && num2 == 6)){
                    System.out.println("Yo-leven"); 
                    }
                }
                else if ((num == 4 & num2 == 1)||(num == 1 && num2 == 4)){
                    System.out.print("You rolled " + num + " and " + num2 + ", the slang terminology is ");
                    System.out.println("Fever Five");
                }
                else if ((num == 5 & num2 == 1)||(num == 1 && num2 == 5)){
                    System.out.print("You rolled " + num + " and " + num2 + ", the slang terminology is ");
                    System.out.println("Easy Six");
                }
                else if ((num == 5 & num2 == 2)||(num == 2 && num2 == 5)){
                    System.out.print("You rolled " + num + " and " + num2 + ", the slang terminology is ");
                    System.out.println("Seven Out");
                }
                else if ((num == 4 & num2 == 1)||(num == 1 && num2 == 4)){
                    System.out.print("You rolled " + num + " and " + num2 + ", the slang terminology is ");
                    System.out.println("Fever Five");
                }
                else if ((num == 6 & num2 == 1)||(num == 1 && num2 == 6)){
                    System.out.print("You rolled " + num + " and " + num2 + ", the slang terminology is ");
                    System.out.println("Seven Out");
                }
                else if ((num == 6 & num2 == 2)||(num == 2 && num2 == 6)){
                    System.out.print("You rolled " + num + " and " + num2 + ", the slang terminology is ");
                    System.out.println("Easy Eight");
                }
                else if ((num == 6 & num2 == 3)||(num == 3 && num2 == 6)){
                    System.out.print("You rolled " + num + " and " + num2 + ", the slang terminology is ");
                    System.out.println("Fever Five");
                }
        }
    //closing scanner
    input.close();

    }
}

