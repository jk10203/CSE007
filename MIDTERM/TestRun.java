
import java.util.Scanner;
public class TestRun{
    public static void main(String[]args){
        Scanner input = new Scanner (System.in);

        System.out.println("Just enter like the year bro");
        int year = input.nextInt();
        int centuryCode = 0;
        int century = 0;
        if (year >= 1700 || year <= 2400){
            century = (int)(year / 100); //trying to get first two digits of the year as century
            switch (century){
                case 17:
                    centuryCode = 4;
                    break;
                case 18:
                    centuryCode = 2;
                    break;
                case 19:
                    centuryCode = 0;
                    break;
                case 20:
                    centuryCode = 6;
                    break;
                case 21:
                    centuryCode = 4;
                    break;
                case 22:
                    centuryCode = 2;
                    break;
                case 23:
                    centuryCode = 0;
                    break;
            }
            System.out.println(centuryCode);
        }
    }
}