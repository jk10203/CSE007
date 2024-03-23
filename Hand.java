/* Joy Kim
November 18, 2022
CSE007 Fall 2022: HW 7
JDK 11 */
/* This program includes the Hand class which deals with everything hand related to the game 
 * black jack. It creates a hand array, the printed array, adding card to the hand array, and 
 * getting the value of the current hand (which is what winning or losing blackjack is based on)
*/
public class Hand {
    private Card[] hand;
    private int nextCard;
    
    public Hand(int size){
        nextCard = 0; //have to initialize in constructor
        hand = new Card[size];
    }
    //accepts cards from deck
    //d.dealCard - get a card that you add to hand ACTUAL CARD BEING RETURNED
    public void display(){
        for(int i=0; i< nextCard; i++){
            System.out.print(hand[i].getRankName() + hand[i].getSuitName() + " ");
        }
    }
        //one for loop

    public void addCard(Card card1){
        hand[nextCard++] = card1;
    //card as input / just handling cards as theyre being dealt
    }
    public int getValue(){
        int cardValue = 0;
        int totalValue = 0;
        for (int i = 0; i<nextCard; i++){
            switch(hand[i].getRank()){ //just checking value of Rank for switch
                case 0:
                    cardValue = 1;
                    totalValue += cardValue;
                    break;
                case 1:
                    cardValue = 2;
                    totalValue += cardValue;
                    break;
                case 2:
                    cardValue = 3;
                    totalValue += cardValue;
                    break;
                case 3:
                    cardValue = 4;
                    totalValue += cardValue;
                    break;
                case 4:
                    cardValue = 5;
                    totalValue += cardValue;  
                    break;
                case 5:
                    cardValue = 6;
                    totalValue += cardValue;
                    break;
                case 6:
                    cardValue = 7;
                    totalValue += cardValue;
                    break;
                case 7:
                    cardValue = 8;
                    totalValue += cardValue;
                    break;
                case 8:
                    cardValue = 9;
                    totalValue += cardValue;
                    break;
                case 9:
                    cardValue = 10;
                    totalValue += cardValue;
                    break;
                case 10:
                    cardValue = 10;
                    totalValue += cardValue;
                    break;
                case 11:
                    cardValue = 10;
                    totalValue += cardValue;
                    break;
                case 12:
                    cardValue = 10;
                    totalValue += cardValue;
                    break;
            }
        }
        return totalValue;
    }
}


    

