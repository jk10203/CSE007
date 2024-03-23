/* Joy Kim
October 11, 2022
CSE007 Fall 2022: HW 5
JDK 11 */
/* This program is intended to take an uppercased word or phrase and count how many
unique letters and how many times these unique letters repeat. We are able to do this by
using selection sorting and arrays. */

import java.util.Scanner;

public class CharCount{ 
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in); 
        String userInput;
        char[] message;
        char[] alphabet = new char[26];
        int[] counts = new int[26];
        int j = 0;
        //char c; //A in ascii --> 65

        System.out.println("Please enter a word or phrase: ");
        userInput = input.nextLine();
        message = new char[userInput.length()]; //initializing the array message by setting a value

        for(int i = 0; i < userInput.length() ; i++){
            message[i] = userInput.charAt(i); //assigning array message to user input
        }
        //System.out.print(message[3]); //testing
        
        //assigning alphabet to array
        for(char i = 65; i<=90; i++){
            alphabet[j] = i;//[0] corresponds to A , etc...
            j++;
        }
        // System.out.println(alphabet[4]); //testing

        int k = 0;
        //counts holds number of times each letter occurs
        for(int i = 0; i < userInput.length(); i++){ //for each letter in message
            for (k = 0; k<26; k++){ //comparing 26 times
                char letter = alphabet[k];
                if (message[i] == letter){ //if the message letter = an alphabet, increment count
                    counts[k]++; //how many repeats for a letter
                    break;
                }
            }
        }
        //System.out.println(counts[3]); //testing

        //sorting in descending order for both the alphabet and the # of repeats
        int count2 = 0;
        for(int i=0; i < alphabet.length; i++){
            j = i;
            while(j>0 && counts[j]>counts[j-1]){
                int temp = counts[j]; //doing both simultaneously
                char temp2 = alphabet[j];
                counts[j] = counts[j-1];
                alphabet[j] = alphabet[j-1];
                counts[j-1] = temp;
                alphabet[j-1] = temp2;
                --j;
            }
        }
        for(int i=0; i< counts.length - 1; i++){
            for (k = i + 1; k<counts.length; k++){
                if (counts[i]<counts[k]){
                    int holder = counts[i];
                    counts[i] = counts[k];
                    counts[k] = holder;

                    char alphaHolder = alphabet[i];
                    alphabet[i] = alphabet[k];
                    alphabet[k] = alphaHolder;
                }
            }
        }        //counting how many unique letters
        for(int i = 0; i < 26 ; i++){
            if (counts[i]>0){
                count2++;
            }
        } 

        //printing out output/results
        System.out.println("There are " + count2 + " unique letters in this phrase.");
        for (int i = 0; i< 26; i++){ //only print out if the letter occurs atleast once
            if(counts[i]>0){
            System.out.println("The letter " + alphabet[i] + " occurs " + counts[i] + " times.");
            }
        }


        

    }
}