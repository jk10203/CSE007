/* Joy Kim
November 7, 2022
CSE007 Fall 2022 Participation 11
JDK 11 */
/*This program is intended to utilize the objects created from an established class
TV SHOW that utilizes private(now)/public(then) modifiers. It fills arrays with TV show specifics and 
gives it a random airtime. This program then displays it.
*/

import java.util.Arrays;
public class TVTest{
    public static void main(String[]args){
        TVShow[] lineup = new TVShow[4];
        System.out.println(Arrays.toString(lineup));
        lineup[0] = new TVShow("Great British Baking Championship", "Netflix", "Food/Reality", 55 );
        lineup[1] = new TVShow("Nailed it!", "Netflix", "Food/Reality", 22);
        lineup[2] = new TVShow("Brooklyn 99", "Hulu", "Comedy", 23.5);
        lineup[3] = new TVShow("Arrested Development", "Netflix", "Comedy", 22.7);
        System.out.println(Arrays.toString(lineup));
        
        for(int i = 0; i<lineup.length; i++){
            int random = (int)(Math.random() * 95);
            //each element reference to TV show
            lineup[i].airEpisodes(random); // air it x amount of times
        }
        
        print(lineup);

        
    }
    public static void print(TVShow[]arr){
        System.out.println(TVShow.getShows()); //bc we changed TO PRIVATE(11/9) had to change get(NAME)
        for(int i = 0; i< arr.length; i++){
            //use arr[i] tp access name, epsiodes, and total airtime
            System.out.print("Name: " + arr[i].getName() + "; ");
            System.out.print("Number of Episodes: " + arr[i].getEpisodes() + "; ");
            System.out.print("Airtime: " + arr[i].getTotalAirtime() + "; ");
            System.out.println(" ");

        }

        }



}