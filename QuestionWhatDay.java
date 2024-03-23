
import java.util.Scanner;
public class QuestionWhatDay{
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int month = 0;
        int monthCode = 0;
        //year code
        System.out.println("Please enter the year: ");
        int year = input.nextInt();
        int yearIsolate = year % ((int)(year / 100) * 100);
        // System.out.println( yearIsolate );
        int yearCode = (yearIsolate + (yearIsolate / 4)) % 7;
        System.out.println(yearCode);

        //month code
        boolean monthLoop = true;

        while (monthLoop){

            System.out.println(" Please enter the month as an integer: ");
            month = input.nextInt();
            if (month >=1 && month<=12){
                switch (month){
                    case 1:
                        monthCode = 0;
                        monthLoop = false;
                    case 2:
                        monthCode = 3;
                        monthLoop = false;
                    case 3:
                        monthCode = 3;
                        monthLoop = false;
                    case 4:
                        monthCode = 6;
                        monthLoop = false;
                    case 5:
                        monthCode = 1;
                        monthLoop = false;
                    case 6:
                        monthCode = 4;
                        monthLoop = false;
                    case 7:
                        monthCode = 6;
                        monthLoop = false;
                    case 8:
                        monthCode = 2;
                        monthLoop = false;
                    case 9:
                        monthCode = 5;
                        monthLoop = false;
                    case 10:
                        monthCode = 0;
                        monthLoop = false;
                    case 11:
                        monthCode = 3;
                        monthLoop = false;
                    case 12:
                        monthCode = 5;
                        monthLoop = false;
                }
            } else {
                System.out.println("Please enter a valid integer for the month.");
                monthLoop = true;
            } 
            System.out.println(monthCode);
        }
        
            
            

            /* if (month == 1 || month == 10){
                monthCode = 0;
                monthLoop = false;
            }
            if (month == 5){
                monthCode = 1;
                monthLoop = false;
            }
            if (month == 1 || month == 10){
                monthCode = 0;
                monthLoop = false;
            } */
            
        
       
        
        /* 1)  Year code:
        	(YY + (YY / 4)) % 7
        	YY is the last two digits of the year.
            Hint: You are asking the user to input a year in the format YYYY, but you require the last two digits.  How can you use the modulus operator to determine this number?
            2)  Month code:
            January = 0
            February = 3
            March = 3
            April = 6
            May = 1
            June = 4
            July = 6
            August = 2
            September = 5
            October = 0
            November = 3
            December = 5
            3)  Century code:
            1700s = 4
            1800s = 2
            1900s = 0
            2000s = 6
            2100s = 4
            2200s = 2
            2300s = 0
            4)  Date number:
            This is simply the date dd that the user inputs.
            5) Leap year code: If the date is in January or February of a leap year, you must then subtract 1 from your total before taking the modulus in the final formula.
            Rules to determine a leap year:”
            If the year is divisible by 4, it is a leap year.  
            However, if it is also divisible by 100, it is not a leap year.  
            BUT, if it is divisible by 400, it is a leap year. 
            6)  Finally, when you apply each of these codes, and use them in the formula above, you should get a number between 0 and 6 representing a day of the week:
                        0 = Sunday
                        1 = Monday
                        2 = Tuesday     
                        3 = Wednesday
                        4 = Thursday
                        5 = Friday
                        6 = Saturday
                        
                        System.out.println("Please enter the date in \" month dd, yyyy \" format: ")
       
       
       //year code
       do{
        System.out.println("Please enter the year: ");
        int year = input.nextInt();
        int yearIsolate = year % ((int)(year / 100) * 100);
        // System.out.println( yearIsolate );
        int yearCode = (yearIsolate + (yearIsolate / 4)) % 7;
        System.out.println(yearCode);
       
        //month code
       
        
            
            

            
            
        

     boolean monthLoop = true;

        if (monthLoop){
            int month;
            int monthCode;
            System.out.println("Please enter the month as an integer: ");
            month = input.nextInt();
            if (month >=1 && month<=12){
                if (month == 1 || month == 10){
                    monthCode = 0;
                    System.out.println("The month code is " + monthCode);
                    monthLoop = false;
                } else if (month == 5){
                    monthCode = 1;
                    System.out.println("The month code is " + monthCode);
                    monthLoop = false;
                } else if (month == 8){
                    monthCode = 2;
                    System.out.println("The month code is " + monthCode);
                    monthLoop = false;
                } else if (month == 2 || month == 3 || month == 11){
                    monthCode = 3;
                    System.out.println("The month code is " + monthCode);
                    monthLoop = false;
                } else if (month == 6){
                    monthCode = 4;
                    System.out.println("The month code is " + monthCode);
                    monthLoop = false;
                } else if (month == 9 || month == 12){
                    monthCode = 5;
                    System.out.println("The month code is " + monthCode);
                    monthLoop = false;
                } else if (month == 4 || month == 7){
                    monthCode = 6;
                    System.out.println("The month code is " + monthCode);
                    monthLoop = false;
                } 
            } else {
                do{
                    System.out.println("Please enter a valid integer for the month.");
                    System.out.println("Please enter the month as an integer: ");
                    month = input.nextInt();
                } while (monthLoop);
            }
            
        }

*/
    }
}