/* Joy Kim
November 9, 2022
CSE007 Fall 2022 Participation 12
JDK 11 */
/*This program is intended to utilize the objects created from an established class
TV SHOW that utilizes private modifiers. It fills arrays with TV show specifics and 
gives it a random airtime. This program then displays it.
*/
public class TVTest2 {
    public static void main(String[]args){
        TVShow[]list = new TVShow[3];
        fillArray(list);
        airTime(list);
        displayLineup(list);

    }
    public static void fillArray(TVShow[]array){
        array[0] = new TVShow("Black Mirror", "Netflix", "Drama", 45.6);
        array[1] = new TVShow("New Girl","Netflix","RomCom", 22.5);
        array[2] = new TVShow("The House of Dragons", "HBO", "Drama", 56.7);
    }
    public static void airTime(TVShow[] arr){
        for(int i = 0; i<arr.length; i++){//iterating through array and air a random number of episodes
            int random = (int)(Math.random()*100);
            airTime(arr[i], random); 
        }
    }
    public static void airTime(TVShow tv, int epi){
        tv.airEpisodes(epi); 
    }
    public static void displayLineup(TVShow[]arr){
        System.out.println("Number of shows: " + TVShow.getShows()); //static for getShows
        for(int i = 0; i< arr.length; i++){
            //use arr[i] tp access name, epsiodes, and total airtime
            System.out.print("Name: " + arr[i].getName() + "; ");
            System.out.print("\tNumber of Episodes: " + arr[i].getEpisodes() + "; ");
            System.out.print("\tTotal Airtime (in mins): " + arr[i].getTotalAirtime() + "; ");
            System.out.println(" ");

        }

    }
}
