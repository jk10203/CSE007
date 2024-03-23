/* Joy Kim
November 18, 2022
CSE007 Fall 2022: HW 7
JDK 11 */
/* This program is intended to simulate a one-person game of blackjack that utilizes 3 classes and a main method
 * that actually tests/runs the game. It includes loops to control the game repetition and a method for input
 * validation. The player is able to win the game only if their cards add up to 21, and hits automatically if the value
 * of the cards are less than 16.
*/
import java.util.Scanner;
public class Blackjack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //create an instance of deck(52)
        //dont put new carD
        /*Deck [] d = new Deck[52];
        Hand [] hand1 = new Hand [10];*/ 
        //Card c = d.dealCard();

        Deck deck1 = new Deck(); //making instance of deck
        boolean keepPlay = true; //controlling game loop
        int counter = 1; //just to implement game #

        //printing shuffle/unshuffle
        System.out.println("Game #" + counter + ": ");
        System.out.println("Unshuffled deck of cards: ");
        deck1.printDeck(); //calling method from class DECK based on our new instance of deck (deck1)
        System.out.println("Shuffled deck of cards: ");
        deck1.shuffle();
        deck1.printDeck();
    
        while (keepPlay /*&& deck1.cardsLeft()!=1 && deck1.cardsLeft()>1*/){
            boolean hittingboo = true; //in order to break out of automatic hitting
            Hand hand1 = new Hand(10); //serves to clear the hand each new game
            hand1.addCard(deck1.dealCard());
            hand1.addCard(deck1.dealCard());
            System.out.println("Current hand: "); 
            hand1.display();

            System.out.println(" ");
            System.out.println("Current value: " + hand1.getValue());
            //method(hand1.getValue);
            while (hand1.getValue() < 16 && hittingboo){ // value has to be less than 16 for automatic hitting to occur
                if (hand1.getValue() >=16 && hand1.getValue() <=20){
                    hittingboo = false;
                } else {
                    hand1.addCard(deck1.dealCard()); //adds card to hand when it deals card from DECK 
                    System.out.println("Hitting...");
                    System.out.println("Current hand: ");  
                    hand1.display();
                    System.out.println(" ");
                    System.out.println("Current value: " + hand1.getValue());
                    if (hand1.getValue()<21){
                        if(deck1.cardsLeft() <= 1){ //if deck has zero cards and is not above or equal to 21, the program will end
                            System.out.println("Ran out of Cards! Exitting...");
                            keepPlay = false;
                            hittingboo = false; //so it doesn't repeat inner while loop
                        }
                    }
                }
            }
            boolean stayHit = true; //to control stat/hit loop
            if (hand1.getValue() >= 16 && hand1.getValue() <=20){
                while (stayHit){ //if value is between 16 or 20 it enters this loop
                    System.out.println("Would you like to hit or stay? (1-HIT, 2-STAY) ");
                    int value1 = getChoice(input);//input validating
                    if (value1 == 1){
                        hand1.addCard(deck1.dealCard());
                        System.out.println("Current hand: "); 
                        hand1.display();
                        System.out.println(" ");
                        System.out.println("Current value: " + hand1.getValue());
                        if (hand1.getValue() > 21){ //loses if bigger than 21
                            System.out.println("Loser! BUST!");
                            counter++;
                            stayHit = false;
                        } else if (hand1.getValue() == 21){ //wins if equal to 21
                            System.out.println("Winner!");
                            counter++;
                            stayHit = false;
                        } else if (hand1.getValue() < 21){ //repeats if less than 21
                            if (deck1.cardsLeft() <= 1){ //if the total value of 3 cards is less than 21 the game ends bc no cards
                                System.out.println("Ran out of Cards! Exitting...");
                                keepPlay = false; 
                                stayHit = false; //so it breaks out of loop
                            }
                            stayHit = true;
                        }
                    } else if (value1 == 2){ //if you decide to stay, automatic loss
                        System.out.println("Loser! Could've hit :(");
                        counter++;
                        stayHit = false;
                    }
                }
            } else if (hand1.getValue() > 21){ //accounts for losing from automatic hits (going from less than 15 to over 21)
                System.out.println("Loser! BUST!");
                counter++;
            } else if(hand1.getValue() == 21){//accounts for winning from automatic hits (going from less than 15 to 21)
                System.out.println("Winner!");
                counter++; //if whack then this is the problem
            }
            //System.out.println("cardsLeft # is @ "+ deck1.cardsLeft()); //checking value of cardsLeft

            if(deck1.cardsLeft() <= 3){ //2 because 1 = 0 cards, 2 = 1 card (can't start new game)
                System.out.println("Ran out of Cards! Exitting...");
                keepPlay = false;
            } else if (deck1.cardsLeft()>3){ //if deck has atleast 3 cards (2 cards max is 20 so must be 3 cards max)
                System.out.println("Would you like to play again? (1-Yes, 2-No) ");
                int value2 = getChoice(input);
                if (value2 == 1){
                    System.out.println("\nGame #" + counter + ": " );
                    keepPlay = true;
                }
                if (value2 == 2){
                    System.out.println("Exitting...");
                    keepPlay = false; //breaks out of loop
                }
            } 
        }
    }
    public static int getChoice(Scanner sc){ //method to input validate :D
        int num = 0;
        boolean loopControl = true;
        do{
            if (sc.hasNextInt()){
                num = sc.nextInt();
                if (num == 1){
                    loopControl = false; 
                } else if (num == 2){
                    loopControl = false;
                } else { //if not the right int
                    System.out.println("Please enter a valid integer. ");
                    sc.nextLine();
                }
            } else { //if not an int
                System.out.println("Please enter a valid integer. ");
                sc.nextLine();
            }

        } while (loopControl);

        return num; //returns number so if statements can be made for 1 or 2
    }
}

