/* Joy Kim
5 September, 2022
CSE007 Fall 2022: Participation 3
JDK 11 */
/*The purpose of this program is to identify
whether the integer entered by the user is odd or not. 
Created w/ VSCode
*/

import java.util.Scanner;

public class OddCheck {
   public static void main(String[] args) {
      Scanner myScanner = new Scanner(System.in);
      System.out.println("Enter a number");
      int inputNum = myScanner.nextInt();
   
      if (inputNum % 2 != 0) { //fill in the conditional expression within the parens to check if inputNum is odd (using only java operator(s))
        System.out.println(inputNum+ " is an odd number."); //if the expression evaluates as true, display this message
      }
      else { //if the inputNum isn't odd, then it must be even
        System.out.println(inputNum+ " is an even number.");
      } 
   }
}