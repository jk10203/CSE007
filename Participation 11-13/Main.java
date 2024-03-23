
/* Joy Kim
November 4, 2022
CSE007 Fall 2022 Participation 11
JDK 11 */
/*This program is intended to utilize objects/methods created from another java file to establish and organize
TVShow name, network, and length. We have created a new class from another file which allows us
to use it as a class (like string or scan) to call it like a method
*/
import java.util.Scanner;
public class Main {
    public static void main(String[]args){
        //creating 6th TVSHOW from user input
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a TVShow name: ");
        String nameInput = input.nextLine();
        System.out.println("Please enter a network: ");
        String networkInput = input.nextLine();
        System.out.println("Please enter the length: ");
        int lengthInput = input.nextInt();
        TVShow tvShow6 = new TVShow(nameInput, networkInput, lengthInput); //establishing the 6th TVShow

        TVShow tvShow1 = new TVShow("Westworld","HBO",60);
        TVShow tvShow3 = new TVShow("Grey's Anatomy", "ABC", 60);
        TVShow tvShow4 = new TVShow ("The White Lotus", "HBO", 10);
        TVShow tvShow5 = new TVShow ("Over the Garden Wall", "Cartoon Network" , 15);
        TVShow tvShow2 = new TVShow(); //has name, network of n/a and length of zero
        tvShow2.name="Spongebob Squarepants";
        tvShow2.network="Nickelodeon";
        //tv.name will change the value
        //tvShow2.length=22;
        //tvshow.length = 22

        System.out.println("tvShow1: " + tvShow1); //tvShow1 is reference variable, what will print out? memory location
        System.out.println("tvShow4: Name = " + tvShow4.name + "; Network = " + tvShow4.network);

        tvShow5.printShow();
        tvShow2.printShow();
        tvShow3.printShow();
        tvShow1.printShow();
        }
   }
