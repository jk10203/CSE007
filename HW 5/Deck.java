/* Joy Kim
November 18, 2022
CSE007 Fall 2022: HW 7
JDK 11 */
/* This program is intended to create the Deck class which creates the card deck and includes the ability
 * to shuffle the deck. It also can print the deck, deal a card from the deck so it can go into the hand,
 * and calculates the amount of cards left.
*/
public class Deck {
    
         //an array of Card objects called deck -- what is the expected length of a deck of cards?
     //a counter to keep track of cards as they are dealt
    private Card[] deck;
    private int nextCard;
    
     //assigning suit and rank to deck

     //where do we initialize the suit and rank #/letters 
    public Deck(){ //no arg constructor
        deck = new Card[52];
        nextCard = -1;
        for(int j=0; j<52; j++){
            deck[j]= new Card((j%13), (j/13));
        
            //deck[i]= new Card((i%13), (i/13));
            /*deck[i] = new Card();
            System.out.print(deck[i].getSuit());
            System.out.print(deck[j].getRank() + " ");
            deck[k]= (deck[i].getSuit() + deck[j].getRank()); //??
            k += 1;*/
        }
        
    }

    public void shuffle(){
        for(int k = 0; k<deck.length; k++){
            for(int i =0; i<1000;i++){ //switching 1000 times
                int rand1 = (int)(Math.random() * (deck.length) - 1);
                int rand2 = (int)(Math.random() * (deck.length) - 1);

                Card temp = deck[rand1]; //change variable type
                deck[rand1] = deck[rand2];
                deck[rand2] = temp;
            }
        }
    }
//A no-argument constructor that initializes the cards array (where each element represents a separate Card object).
//A method shuffle() that will randomly shuffle the cards in the deck.
//Shuffle the cards by randomly choosing an index number (that is not zero) and swap the element at that index with the current element (starting at index 0). Swap however many times you like, but you should choose a minimum of 52 swaps to ensure a high probability that your deck is well-shuffled.
//A method dealCard() that will return the next card in the deck (i.e. the next card element from the cards array (either shuffled or not))
    public void printDeck(){
        for(int i=0; i< deck.length; i++){
            System.out.print(deck[i].getRankName() + deck[i].getSuitName() + " ");
            }
            System.out.println(" ");
        }
    
    public Card dealCard(){
        nextCard++; //return card from array of cards / deck (in order from shuffled)
        return deck[nextCard];
    }
    public int cardsLeft(){
        return (deck.length-nextCard); //how many cards are left (helps with ending the game if runs out card)
    }
}


