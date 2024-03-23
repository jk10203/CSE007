/* Joy Kim
October 26, 2022
CSE007 Fall 2022: Participation 10
JDK 11 */

import java.util.Scanner;
import java.util.Arrays;
public class MultiAverage{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter");
    }
    
    public static int getInt(Scanner s){
        int num = 0;
        boolean loopControl = true;
        do{
            if(s.hasNextInt()){
                num = s.nextInt();
                loopControl = false;
            } else {
                System.out.println("not an int");
                s.nextLine();
            }
        } while (loopControl);
        return num;
    }
}