/* Joy Kim
October 6, 2022
CSE007 Fall 2022: Lab 6
JDK 11 */
/* This program is intended to use arrays in order to simulate a roster
that contains 8 names and 8 ratings. The user is able to organize them in order to find
a player with a rating that is above a specific rating and can update te roster by changing
a player's rating. The jersey numbers of all of the players are also randomized and assigned.*/

import java.util.Scanner;
import java.util.Random; 
public class Roster{
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        Random rand = new Random(); 
        String[] names = new String[8];
        int [] ratings = new int[8];
        int [] jerseys = new int[8];

        System.out.println("Please enter 8 names and their rating:");
        
        for(int i = 0; i<names.length; i++){
            System.out.print("Player " + (i+1) + ": "); //trying to get input for player name
            names[i] = input.nextLine();
            do{
                System.out.print("Rating: "); //
                int x;
                if(input.hasNextInt()){
                    //i know i can read it in without error --> input validating
                    x = input.nextInt();
                    input.nextLine();
                    if(x>0 && x<10){
                        ratings[i] = x;
                        break;
                    } else {
                        System.out.println("Rating out of range.");
                    }
                } else {
                    input.nextLine();
                    System.out.println("Invalid input, not an integer.");
                }
            }while(true); //for loops for input validating
        }
        // System.out.println(names[5]); //to test  
    
        // System.out.println(ratings[5]); //checking

        for (int k = 0; k<jerseys.length; k++){ 
            int jersey = (int) (Math.random()*100);
            boolean isUnique = true;
            do{
                isUnique = true;
                for(int j = 0; j<=k; j++){ //check everything in front of current index
                //generate 8 unique numbers for jerseys (checks 8 times)
                    if (jerseys[j] == jersey){
                        isUnique = false;
                        jersey = (int)(Math.random()*100);
                        break;
                    }
                }
            }while(!isUnique);
            //make sure jersey is unique
            jerseys[k] = jersey;
        }
        //Collections.shuffle(jerseys, rand); //how to make sure random number doesn't repeat
        boolean loop = true;
        do{
            System.out.println("o - Output roster");
            System.out.println("a - Output players above a rating");
            System.out.println("u - Update player rating");
            System.out.println("q - Quit (ends the program)");

            System.out.print("Choice: ");
            char choice = input.next().charAt(0); //using char fo menu input
                
                switch (choice){
                    case 'o': //outputting roster
                        for (int numO = 0; numO<8; ++numO){
                            System.out.println("Player " + (numO+1) + ": " + names[numO] + "; Jersey " + jerseys[numO]  + "; Rating: " + ratings[numO] );
                        } 
                        System.out.println(" ");
                        break; 

                    case 'a': //outputting players above a certainr ating
                        System.out.print("Please enter an integer rating: ");
                        int aboveR = input.nextInt();
                        while (aboveR<0 || aboveR>9){
                            System.out.println("Please enter a valid integer rating.");
                            aboveR = input.nextInt(); //input validating not working - exits after a valid integer is entered but worked after adding break?
                            } 
                        if (aboveR>=0 && aboveR<=9){ //change the jersey numbers after fixing jersey part
                            System.out.println("Players with ratings >= " + aboveR);
                            for (int g = 0; g<8; g++){
                                if (ratings[g]>= aboveR){
                                System.out.println("Player " + (g+1) + ": " + names[g] + "; Jersey " + jerseys[g]  + "; Rating: " + ratings[g]);
                                }
                            }
                        }
                        break;

                    case 'u':   //updating player rating
                        System.out.print("Enter a name: ");
                        String name = input.next();
                        System.out.print("Enter a new rating: ");
                        int newRating = 0;
                        do{ //input validating player rating
                            if(input.hasNextInt()){
                                newRating = input.nextInt();
                                input.nextLine();
                                if(newRating > 0 && newRating<10){
                                    break; //then input validating confirmed then breaks loop
                                } else {
                                    System.out.println("Rating out of range");
                                }
                            } else {
                                input.nextLine();
                                System.out.println("Invalid input, not an integer");
                            }
                        } while (true);

                        boolean nameFound = false; //can you switch and use true instead
                        for(int i = 0; i<names.length; i++){
                            if(names[i].equals(name)){
                                ratings[i] = newRating;
                                nameFound = true;
                                break;
                            }
                        }
                        if (nameFound){
                            System.out.println(name + "'s rating successfully updated."); //updates name is name is found
                            break;
                        } else {
                            System.out.println("Invalid name, could not update rating."); //if name is not found then don't do anything
                            break;
                        }

                    case 'q': //to exit the program
                        System.out.println("Exiting...");
                        loop = false;
                        break;
                    
                    default: //can i input validate with this?
                        System.out.println("Please enter a valid menu option.");
                        break;         
            }

        } while (loop); //can we use a boolean and just add q as a menu option? i think?
    }
}