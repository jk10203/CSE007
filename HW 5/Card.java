/* Joy Kim
November 18, 2022
CSE007 Fall 2022: HW 7
JDK 11 */
/* This program intends to create the class Card which is the basis for how the deck is created and thus
 * the hand as well. It establishes the fact that there will be 52 spaces in the deck array and creates
 * the ranks and suits which is the basis for a card game.
 */
public class Card {

    private int rank; //representing the rank of a card (face value A-K, integer values 0-12)
    private int suit; //representing the suit of a card (Clubs (0), hearts (1), spades (2), diamonds (3))
    private String[] rankName = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q","K"}; //an array holding the face value of cards in order from lowest to highest (“A” for Ace to “K” for King)
    private String[] suitName = {"C","H","S","D"}; 
    
    String[] deck = new String[52];

    public int getRank(){
        return rank; //getter method for rank
    }
    public int getSuit(){
        return suit; //getter method for suit
    }
    public String getRankName(){
        return rankName[rank]; //returns the actual letters/num
    }
    public String getSuitName(){
        return suitName[suit];//returns the actual letters
    }
    public Card (int rank, int suit){ //constructor
        this.rank = rank;
        this.suit = suit;
    }
    
}
