/* Joy Kim
26 September, 2022
CSE007 Fall 2022: Midterm 1
JDK 11 */
/* This program is intended to simulate a rock, paper, scissors game where a random hand is
generated for each player based on how many rounds the user inputted. */

import java.util.Scanner;
import java.util.Random; 
public class Exam1{
    public static void main(String[]args){
        Scanner input = new Scanner (System.in);
        Random rand = new Random(); 
        
        System.out.println("Enter the two player names then number of rounds with only spaces in between: ");
        String player1 = input.next(); //initializing player names
        String player2 = input.next();
        int rounds = 0;
        boolean flag = true; // establishing loop variables
        while (flag){
            boolean value= input.hasNextInt();
            if (value){
                rounds = input.nextInt();
                value = false;
                flag = false;
            } else {
                System.out.println("invalid input. Enter number of rounds again.");
                String junk = input.next();
                value = true;
                }
        }
        String hand1 = "";
        String hand2 = "";
        int trials = 1;
        do{ //getting random generated moves
            int random1 = (int) (Math.random()*2);
            int random2 = (int) (Math.random()*2);
            switch (random1){
                case 0:
                    hand1 = "Rock";
                    break;
                case 1:
                    hand1 = "Paper";
                    break;
                case 2:
                    hand1 = "Scissors";
                    break;
            }
            switch (random2){
                case 0:
                    hand2 = "Rock";
                    break;
                case 1:
                    hand2 = "Paper";
                    break;
                case 2:
                    hand2 = "Scissors";
                    break;
            } 
        } while (hand1.equals(hand2));
        
        if (hand1.equals(hand2)){ //trying to make rounds not changed if a tie
            rounds -= 1;
        } 
        int player1W = 0; //counting how many wins
        int player2W = 0;
        for (trials = 1; trials<=rounds; trials++){ //trying to make multiple rounds of RPS for the rounds given by user
            if (hand1.equals("Rock")){ //each type of outcome using if/else statements
                if (hand2.equals("Scissors")){
                    System.out.println(player1 + " wins");
                    player1W++; //keeping track of how many times a player is winning
                }
                if (hand2.equals("Paper")){
                    System.out.println(player2 + " wins");
                    player2W++;
                }
            }
            if (hand1.equals("Paper")){
                if (hand2.equals("Scissors")){
                    System.out.println(player2 + " wins");
                    player2W++;
                    }
                if (hand2.equals("Rock")){
                    System.out.println(player1 + " wins");
                    player1W++;
                }
            }
            if (hand1.equals("Scissors")){
                if (hand2.equals("Paper")){
                    System.out.println(player1 + " wins");
                    player1W++;
                }
                if (hand2.equals("Rock")){
                    System.out.println(player2 + " wins");
                    player2W++;
                }
            }
        }
        System.out.println(player1 + " has won " + player1W + " times!"); //printing who won how many times
        System.out.println(player2 + " has won " + player2W + " times!");

        if (player1W>player2W){ //deciding who wins overall by who won more times
            System.out.println(player1 + " WINS OVERALL!");
        } else {
            System.out.println(player2 + " WINS OVERALL!");
        }
            
        


    }
}