/* Joy Kim
December 9, 2022
CSE007 Fall 2022: Final
JDK 11 */
/*This program is intended to use the Movie parent class in order to manipulate and reorganize the data using methods
 * that involve sorting, searching, adding, and displaying the movie arrays.
 */
public class WatchList {
    private Movie[] myList;
    private int countMovies = 0;
    
    public WatchList(int size){
        myList = new Movie [size]; //modifying size
    }
    public void addMovie(Movie m){
        if (m instanceof Movie){ //if m is of the movie class
            for(int i = 0; i<myList.length; i++){ //trying to see the first spot list is empty, it will add the movie
                if (myList[i] == null){  //if the spot is empty, then it will be null
                    myList[i] = m;
                    countMovies++; //incrementing the addition of the movie
                    break;
                }
            }
        }
    }
    public void searchMovie(String title, String type){
        int counter = 0;
        for(int i =0; i< myList.length;i ++){
            if (myList[i].getTitle().equals(title)){  //using .equals to check if the title in the array equals title entered by user
                if (myList[i].getType().equals(type)){
                    System.out.println("Movie was found! ");
                    System.out.println(myList[i]+ " ");
                    counter++; //utilizing counter in order to check if the movie was found
                }
            } 
        }   
        if (counter == 0){ //if counter ends up zero it means that it never passed the above if statements meaning
            //it was not found
            System.out.println("Movie was NOT found! Sorry:(");
        }  
    }
    public void viewByType(String type){
         //FOR FINDING ACCOUNTS GIVEN USER INPUT
         int counter = 0;
         double lengthCounter = 0;
         for (int i =0; i<myList.length; i++){
            if (myList[i] == null){
                break;
            }
            if (type.equals(myList[i].getType())){// dont put class MOvie for getType because it is a specific variable and it is public (not static?)
                 if (counter == 0){ //so it only prints out headers if accounts ARE found
                     System.out.println("The movies for " + type + " are: ");
                 }
                 System.out.println(myList[i] + " ");
                 lengthCounter += myList[i].getLength();
                 counter++;
            } else {     
            }
         }
         if (counter == 0){
         System.out.println("No such movies were found");
         }
         System.out.println(" ");
         System.out.print("Total Runtime: ");
         System.out.println(String.format("%.2f", lengthCounter) + "min");//formatting to 2 decimal places
         System.out.println(" ");
         System.out.print("Average Runtime: ");
         System.out.println(String.format("%.2f", (lengthCounter / counter)) + "min"); //formatting to 2 decimal places
         System.out.println(" ");

    }
    public void sortWatchList(){
        //sorts in ascending order based on title
        int lengthArrayNN = 0;
        for(int i =0; i<myList.length; i++){ //to make sure that the count is only counting for movies in array (NOT NULL stuff)
            if (myList[i] ==null){
                break; //break if null
            }
            lengthArrayNN++;
        }
        
        Movie[] tempA = new Movie[lengthArrayNN]; //making a new array in order to hold movie values
        for (int i=1; i<lengthArrayNN; i++) {
            //Insert element i in the sorted sub-list
            int counterRepeats = 0;
            tempA[i] = myList[i];
            int j = i;
            while (tempA[i].getTitle().charAt(counterRepeats)==(myList[j - 1].getTitle().charAt(counterRepeats))){
                counterRepeats++; //for the initial list element (if they have equal letters at char zero)
            }
            while (j>0 && tempA[i].getTitle().charAt(counterRepeats)<(myList[j - 1].getTitle().charAt(counterRepeats))){ //if current value is less than the previous value then it switches
                //the charAt number differs based on whether they have the same first letter
                 // Shift element (j-1) into element (j) --> resulting in the lower number goin before the higher number
                 myList[j] = myList[j - 1];
                 j--; //incrementing j here so it changes; i is incremented through the for loop
                 if (j>0 && tempA[i].getTitle().charAt(0)!=(myList[j - 1].getTitle().charAt(0))){ //if the first letter is not equal, the initial while loop will compare charAt 0
                    counterRepeats = 0; 
                 }
                 if (j>0 && tempA[i].getTitle().charAt(0)==(myList[j - 1].getTitle().charAt(0))){ //if the first letter are equal, a while loop will determine in which letter they differ
                    //this will be used for the initial while loop so that when it compares, it compares the different number
                    counterRepeats = 0;
                    while (tempA[i].getTitle().charAt(counterRepeats)==(myList[j - 1].getTitle().charAt(counterRepeats))){
                        counterRepeats++;
                    }
                 }
            }
            // Insert currentVal at position j
            myList[j] = tempA[i]; //inserts the "higher" number of the two after the "lesser" number
         }
    }

    public String toString(){
        double lengthCounter = 0;
        countMovies = 0;
        String returnValue = "";
        for (int i =0; i<myList.length;i++){
            if (myList[i] == null){ //if the array element is empty then break!
                break;
            }
            System.out.println(myList[i] + " ");
            lengthCounter +=myList[i].getLength(); //incrementing in this loop in order to get total runtime
            countMovies++; //in order to get how many movies
        }
        System.out.print("Total Runtime: ");
        System.out.println(String.format("%.2f", lengthCounter) + "min"); //formatting 2 decimal places
        System.out.println(" ");
        System.out.print("Average Runtime: ");
        System.out.println(String.format("%.2f", (lengthCounter / countMovies)) + "min"); //formatting 2 decimal places
        System.out.println(" ");

        return returnValue; //just put this as it prints within this method
    } 
    /*[COMPREHENSION 4]: Include a block comment explaining what dynamic binding is and when it is used. Additionally, 
    use this information to explain the output or error that would result from the following snippet of code:  
    Movie m = new Comedy ("Superbad”, “R”, 98.32); 
    m.laugh();
    Dynamic binding relates to overriding methods like overriding the toString and the equals methods from the object class.
    The compiler does NOT decide the method for these anymore as it is overriden to be decided by the programmer
    of what it will perform/do. JVM decides which instance method to invoke at runtime (the declared or actual). It is also important 
    to note that in overriding, both the parents and children have the same method. So when this snippet of code is performed, the program will 
    not be able to print out HAHAHA because it does not defined in the Movie class. Because m is declared as Movie there will be a compiler
    error. At compile time, we need the method laugh in Movie
    */
    
}
