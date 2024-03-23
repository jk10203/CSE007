/* Joy Kim
22 September, 2022
CSE007 Fall 2022: Lab 4
JDK 11 */
/* This program is intended to test a word or number as a palindrome. If it is not a palindrome, it will
tell you that it is not a palindrome and vice versa. THis program also utilizes loops in order to make sure
the input is valid. */
import java.util.Scanner;
public class CheckPalindrome{
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int numPal = 0;
        String strPal = "";
        boolean isNum = false; // keeps track of when user types in number
        boolean isPal = true;

        System.out.println("Enter an int or string to check");

        if(input.hasNextInt()){
            isNum = true;
            numPal = input.nextInt();
            if (numPal <= 11 || numPal >= 100000){
                System.out.println("Invalid entry. Must be in the range of 11-100,000");
                isNum = false;
            }
        } else if (input.hasNextLine()) {
            strPal = input.nextLine();
            }

        if (isNum){
            //check int palindrome ny reversing the number and comparing to the original
            int reverse = 0;
            int temp = numPal; //take digits from temp and add them in reverse order to reverse
            //1234321
            while(temp != 0){
                int digit = temp % 10; // returns 1 (isolates last digit)
                reverse = reverse * 10 + digit;
                temp /= 10;
            }
            if (reverse != numPal){
                isPal = false;
            }
            
        } else if (isPal) {// for loop to go through every single character
            String temp = ""; //make sure there is no space in between the quotes
            for(int i = 0; i < strPal.length(); i++){
                if(!Character.isWhitespace(strPal.charAt(i))){
                temp += strPal.charAt(i);
                }
            }// temp = strPal without spaces
            for (int i = 0; i < temp.length(); i++){
                //assume true until exception
                if(temp.charAt(i) != temp.charAt(temp.length()-1-i)){
                    //temp.charAt(i) = character zero, temp.length()-1-i --> last character?
                    isPal = false;
                    break;
                }
            }
            //handle string by looping through and comparing characters
        }
        if (isPal && isNum){
            System.out.println("Result: int " + numPal + " is a palindrome.");
        } else if (isPal && !isNum){
            System.out.println("Result: String " + strPal + " is a palindrome.");
        } else if (!isPal && !isNum){
            System.out.println("Result: String "  + strPal + " is NOT a palindrome.");
        } else {
            System.out.println("Result: int "  + numPal + " is NOT a palindrome.");
        }
    
    }
}
