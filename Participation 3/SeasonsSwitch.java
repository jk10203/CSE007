/* Joy Kim
7 September, 2022
CSE007 Fall 2022: Participation 3
JDK 11 */
/* This program utilizes switches in order to classify specific dates of the year into their
respective seasons */
import java.util.Scanner;

public class SeasonsSwitch {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);

        switch (month){
            case "January":
            case "February": season = "winter"; break;
            case "March":
                if (day<20){
                    season = "winter";
                } else {
                    season = "spring";}
                break;
            case "April";
            case "May": season = "spring"; break;
            case "June":
                if (day<21){
                    season = "spring";
                } else {
                    season = summer;}
                break;
            case "July" //switch is checking for quality
            case "August": season = "summer"; break;
            case "September":
                if (day<20){
                    season = "winter";
                } else {
                    season = "spring";} //break is for switch?
                break;
            case "October":
            case "November": season = "autumn"; break;
            case "December":
                if (day<21){
                    season = "autumn";
                } else {
                    season = "winter";}
                break;
        }
    }
}