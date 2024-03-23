/* Joy Kim
23 September, 2022
CSE007 Fall 2022: HW 3
JDK 11 */
/* This program is intended to receive a date as an input (in numbers) and give the day 
of the week that the date falls on. This is valid for the years 1700 to 2400. A combination
of loops, if statements, switches are used in order to fulfill this calender calculation
technique.*/
import java.util.Scanner;
public class WhatDay{
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int year = 0; //initializing
        int month = 0;
        int date = 0;
        int century = 0;
        int yearCode = 0;
        int monthCode = 0;
        int centuryCode = 0;
        int yearIsolate = 0; //just to help get the last two digits of the year
        int leapYearCode = 0;
        String dayOfWeek = "";
        int total = 0;
        
        System.out.println("Please enter the date as MM DD YYYY with only spaces in between.");
       
        month = input.nextInt(); //separating the input into their respective categories
        date = input.nextInt();
        year = input.nextInt();
        while (month > 12 || month < 1){ //checking input for month
            System.out.println("Please enter a valid number for the month.");
            month = input.nextInt();
        }
        while (date > 31 || date < 1){ //checking input for day
            System.out.println("Please enter a valid number for the date.");
            date = input.nextInt();
        }
        while (year < 1699 || year > 2400){ //checking input for year
            System.out.println("Please enter a valid number for the year.");
            year = input.nextInt();
        }

        //year code
        if (year > 1699 || year < 2400){
        yearIsolate = year % ((int)(year / 100) * 100);
        yearCode = (yearIsolate + (yearIsolate / 4)) % 7;
        }

        //month code
        if (month >=1 && month<=12){
            if (month == 1 || month == 10){
                monthCode = 0;
            } else if (month == 5){
                monthCode = 1;
            } else if (month == 8){
                monthCode = 2;
            } else if (month == 2 || month == 3 || month == 11){
                monthCode = 3;
            } else if (month == 6){
                monthCode = 4;
            } else if (month == 9 || month == 12){
                monthCode = 5;
            } else if (month == 4 || month == 7){
                monthCode = 6;
            }
        } 

        //century code
        if (year >= 1700 || year <= 2400){
            century = (int)(year / 100); //trying to get first two digits of the year as century
            switch (century){ //just to try switches
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
        }
        
        //LEAP YEAR FROG CODE
        if (month == 1 || month == 2){ //if jan or feb 
            if(year % 4 == 0){
                leapYearCode = 1; //subtract one from total
                if (year %100 ==0 && year%400 !=0){ 
                // if year is NOT divisible by 400 and IS divisble by 100 then NOT leap year
                leapYearCode = 0; //will not affect total
                }
            }
        }
        
        total = (yearCode + monthCode + centuryCode + date - leapYearCode) % 7;
        /*total has to be put at the end of the code and NOT the beginning because 
        we initialize all the values in the beginning in order for the integers to be 
        stored throughout the program*/

        switch (total){
            case 0:
                dayOfWeek = "Sunday";
                break;
            case 1:
                dayOfWeek = "Monday";
                break;
            case 2:
                dayOfWeek = "Tuesday";
                break;
            case 3:
                dayOfWeek = "Wednesday";
                break;
            case 4:
                dayOfWeek = "Thursday";
                break;
            case 5:
                dayOfWeek = "Friday";
                break;
            case 6:
                dayOfWeek = "Saturday";
                break;
        }

        System.out.println("This date falls on a " + dayOfWeek + "!"); //done!
    }
}