/* Joy Kim
5 September, 2022
CSE007 Fall 2022: Participation 3
JDK 11 */
/* This program utilizes if/else statements in order to classify the seasons in a year from a user input
of a specific day of the year */

import java.util.Scanner;

public class SeasonsIf {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter a month (string) followed  by day (int)");
        String month = input.next();
        int day = input.nextInt();

        if (month.equalsIgnoreCase("January")){
            System.out.println(month + day + " falls during the Winter season");
        } else if (month.equalsIgnoreCase("February")){
            System.out.println(month + day + " falls during the Winter season");
        } else if (month.equalsIgnoreCase("March")){
            if (day<21){
                System.out.println(month + day + " falls during the Winter season");
            } else {
                System.out.println(month + day + " falls during the Spring season");
            }
        } else if (month.equalsIgnoreCase("April") || month.equalsIgnoreCase("May")){
            System.out.println(month + day + " falls during the Spring season");
        } else if (month.equalsIgnoreCase("June")){
            if (day<21){
                System.out.println(month + day + " falls during the Spring season");
            } else {
                System.out.println(month + day + " falls during the Summer season");
            }
        } else if (month.equalsIgnoreCase("July") || month.equalsIgnoreCase("August")){
            System.out.println(month + day + " falls during the Summer season");
        } else if (month.equalsIgnoreCase("September")){
            if (day < 22){
                System.out.println(month + day + " falls during the Summer season");
            } else {
                System.out.println(month + day + " falls during the Autumn season");
            }
        } else if(month.equalsIgnoreCase("October") || month.equalsIgnoreCase("November")){
            System.out.println(month + day + " falls during the Autumn season");
        } else if (month.equalsIgnoreCase("December")){
            if (day < 21){
                System.out.println(month + day + " falls during the Autumn season");
            } else {
                System.out.println(month + day + " falls during the Winter season");
            }

        }

        /* Spring: March 20 - June 20
        Summer: June 21 - September 21
        Autumn: September 22 - December 20
        Winter: December 21 - March 19*/

    }
}