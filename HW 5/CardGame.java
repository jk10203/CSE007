/* Joy Kim
October 6, 2022
CSE007 Fall 2022: HW 4
JDK 11 */
/* This program is intended to simulate a card game by shuffling an unshuffled deck of cards and distributing 5 cards per
hand (total of 2 hands). There will be a certain value associated with the cards which is how we determine who wins
each round. The game can only be played a maximum of 5 times because there are only 52 cards in a deck. We utilize arrays
in order to accomplish the goals of this program. */

import java.util.Scanner;
import java.util.Random;

public class CardGame{ 
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in); 
        Random rand = new Random(); 

        //suits club, heart, spade or diamond 
        String[] suitNames={"C","H","S","D"};    
        String[] rankNames={"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q","K","A"}; 
        String[] deck = new String[52]; 
        String[] deckShuffled = new String[52];
        String[] hand1 = new String[5]; 
        String[] hand2 = new String[5];
        int repeat = 0;
        int counter = 1;

        /*Create a deck of cards
        Shuffle a deck of cards 
        Create a hand from a deck of cards 
        */

        //creating a deck of cards
        System.out.println("Unshuffled deck of cards: ");
        
            int k = 0; //assigning suit and rank to deck
            for (int i=0; i<4; i++){
                for(int j=0; j<13; j++){
                    System.out.print(suitNames[i]);
                    System.out.print(rankNames[j] + " ");
                    deck[k] = suitNames[i] + rankNames[j];
                    k += 1;
                    
                }
            }
            // System.out.println("CHECKING: " + deck[4]);

        //shuffled deck of cards
        for(int i=0; i<52; i++){ //copying the deck to the deck to be shuffled 
            deckShuffled[i] = deck[i];
            }
        

        int randomNum=0;
        for(int i = 0; i<52; i++){
            while(true){
                    randomNum = rand.nextInt(52);
                    deck[i] = deckShuffled[randomNum]; //assigning shuffled values to deck
                    if(randomNum!=0){ 
                        break;
                    }
                }
        }

        //shuffled deck
        System.out.println(" ");
        System.out.println("Shuffled deck of cards: ");
        for (int i =0; i<52; i++){
            System.out.print(deck[i] + " "); //deck is now shuffled
        }

        //giving out cards
        System.out.println(" "); // in order to make the output easier to read
        System.out.println(" "); //adding new blank line
        
        boolean playAgainY = true; //in order to repeat a max of 5 times
        do{
            System.out.println("Hand 1: "); //hand 1 output
            for (int i = 0 ; i<5; i++){
                hand1[i] = deck[i + repeat]; //repeat is an integer that will change in increments of 10 in order to generate a new hand
                System.out.print(hand1[i] + " "); 
            }

            System.out.println(" ");
            System.out.println("Hand 2: "); //hand 2 output
            for(int i = 0; i<5; i++){
                hand2[i] = deck[i + 5 + repeat]; //hand2 also changes in increments of 10, but has 5 added to it so it doesn't generate same hand as hand1
                System.out.print(hand2[i] + " ");
            }
            System.out.println("");
        
            //assigning value to hands
            char cardValue;
            int cardTotal = 0;
            int cardNum;
            for (int i = 0; i< 5; i++){
                cardValue = hand1[i].charAt(1);
                //for (int k=0; k<5; k++){
                // cardNum = cardValue.charAt(k);
                    switch(cardValue){
                        case '1':
                            cardNum = 10;
                            cardTotal += cardNum;
                            break;
                        case '2':
                            cardNum = 2;
                            cardTotal += cardNum;
                            break;
                        case '3':
                            cardNum = 3;
                            cardTotal += cardNum;
                            break;
                        case '4':
                            cardNum = 4;
                            cardTotal += cardNum;
                            break;
                        case '5':
                            cardNum = 5;
                            cardTotal += cardNum;
                            break;
                        case '6':
                            cardNum = 6;
                            cardTotal += cardNum;
                            break;
                        case '7':
                            cardNum = 7;
                            cardTotal += cardNum;
                            break;
                        case '8':
                            cardNum = 8;
                            cardTotal += cardNum;
                            break;
                        case '9':
                            cardNum = 9;
                            cardTotal += cardNum;
                            break;
                        case 'A':
                            cardNum = 11;
                            cardTotal += cardNum;
                            break;
                        case 'J':
                            cardNum = 10;
                            cardTotal += cardNum;
                            break;
                        case 'K':
                            cardNum = 10;
                            cardTotal += cardNum;
                            break;
                        case 'Q':
                            cardNum = 10;
                            cardTotal += cardNum;
                            break;

                    }
            }    
            System.out.println("");
            System.out.println("Hand1 value is " + cardTotal);

            //same thing for hand2
            char cardValue2; 
            int cardTotal2 = 0;
            for (int i = 0; i< 5; i++){
                cardValue2 = hand2[i].charAt(1);
                //for (int k=0; k<5; k++){
                // cardNum = cardValue.charAt(k);
                    switch(cardValue2){
                        case '1':
                            cardNum = 10;
                            cardTotal2 += cardNum;
                            break;
                        case '2':
                            cardNum = 2;
                            cardTotal2 += cardNum;
                            break;
                        case '3':
                            cardNum = 3;
                            cardTotal2 += cardNum;
                            break;
                        case '4':
                            cardNum = 4;
                            cardTotal2 += cardNum;
                            break;
                        case '5':
                            cardNum = 5;
                            cardTotal2 += cardNum;
                            break;
                        case '6':
                            cardNum = 6;
                            cardTotal2 += cardNum;
                            break;
                        case '7':
                            cardNum = 7;
                            cardTotal2 += cardNum;
                            break;
                        case '8':
                            cardNum = 8;
                            cardTotal2 += cardNum;
                            break;
                        case '9':
                            cardNum = 9;
                            cardTotal2 += cardNum;
                            break;
                        case 'A':
                            cardNum = 11;
                            cardTotal2 += cardNum;
                            break;
                        case 'J':
                            cardNum = 10;
                            cardTotal2 += cardNum;
                            break;
                        case 'K':
                            cardNum = 10;
                            cardTotal2 += cardNum;
                            break;
                        case 'Q':
                            cardNum = 10;
                            cardTotal2 += cardNum;
                            break;

                    }
            } 
            System.out.println("Hand2 value is " + cardTotal2);
            System.out.println("");

            //checking to see who wins
            if (cardTotal > cardTotal2){
                System.out.println("Hand1 is the winner!");
            } else if (cardTotal2 > cardTotal){
                System.out.println("Hand2 is the winner!");
            } else if (cardTotal == (cardTotal2)){
                System.out.println("It's a draw!");
            }

            System.out.println("Would you like to play again? Y/N "); //prompt user input
            char playAgain = input.next().charAt(0);
            
            switch(playAgain){
                case 'Y':
                    playAgainY = true;
                    for(int x = counter; x == counter; x++){
                        repeat = 10*x; //repeat changes in increments of 10 everytime the counter increases
                    }
                    counter++; //counter increases if user inputs Y (prompts repeat to change values)
                    if (counter>=6){
                        System.out.println("Ran out of cards! Thanks for playing!");
                        System.out.println("Exiting..."); //when we run out of cards (max playing of 5 times)
                    }
                    break;
                    
                case 'N':
                    System.out.println("Goodbye!");
                    playAgainY = false; //if you don't want to play loop breaks and program ends
                    break;
            }
        } while (playAgainY && counter<=5);  //in order to ensure loop runs a max amount of 5 times and unless playAgainY is true 
    }
}