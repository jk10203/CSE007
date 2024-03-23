/* Joy Kim
14 September, 2022
CSE007 Fall 2022: Lab 3
JDK 11 */
/* This program is intended to pick a random card from a deck of playing cards and give its suit name,
card identity, and its number */

public class Cards{
    public static void main(String[]args){
        int cardNumber = (int) (Math.random() * 52); //math.random returns a double value between 0 and 1
        // you multiply it by 51 to change the range from 0 to 52 (if you dont multiply by number it will return 0)
        
        // declaring variables to use later
        String suitName = "";
        String cardIdentity = "";
        int suit, card;

        //dividing a card by 13-25 gives 1, 25-38 gives 2, etc
        suit = cardNumber / 13; //gives one of four cards

        if (suit == 0){
            suitName = "diamonds";
        } else if (suit ==1){
            suitName = "clubs";
        } else if (suit ==2){
            suitName = "hearts";
        } else {
            suitName = "spades";
        }
        //calculate suite number
        //1-13 --> comes from the +1 --> number matches up with identity
        card = (cardNumber + 1) % 13; // lets us know what card we have
        
        //assigning the suitNumber
        switch(card){
            case 1: cardIdentity = "A"; break;
            case 2: //2-10 has card + "";
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: cardIdentity = card + ""; break;
            case 11: cardIdentity = "Jack"; break;
            case 12: cardIdentity = "Queen"; break;
            case 0: cardIdentity = "King"; break;
        }
            System.out.println("Card number " + cardNumber + " is the " + cardIdentity + " of " + suitName);

        

    }
}