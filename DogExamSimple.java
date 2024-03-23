import java.util.Scanner;
public class DogExamSimple {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        Animal[][]list = new Animal[3][15];
    //Sugg: Use the row to keep track of the type of animal,
    // such that all elements in list[0] are Animals, list[1] is Dogs and list[2] is RescueDogs
        
        for (int i = 0; i<4; i++){
            for (int j = 0; j< 15; j++){
                //trying to limit double to 2 decimals
                String breedD = "";
                double breedRan = (int)(Math.random()*100); //range is 0-99?
                double ranx = (int)(Math.random()*10000)+1;
                double rany = (int)(Math.random()*10000)+1;
                double ran1 = ranx / 100;
                double ran2 = rany / 100;
                int dayGotcha = 0;

                int monthGotcha = (int)(Math.random()*12) + 1; //range from 1-12?
                switch (monthGotcha){
                    case 1:
                    dayGotcha = (int)(Math.random()*31) + 1;
                    case 2:
                    dayGotcha = (int)(Math.random()*28) + 1;
                    case 3:
                    dayGotcha = (int)(Math.random()*31) + 1;
                    case 4:
                    dayGotcha = (int)(Math.random()*30) + 1;
                    case 5:
                    dayGotcha = (int)(Math.random()*31) + 1;
                    case 6:
                    dayGotcha = (int)(Math.random()*30) + 1;
                    case 7:
                    dayGotcha = (int)(Math.random()*31) + 1;
                    case 8:
                    dayGotcha = (int)(Math.random()*31) + 1;
                    case 9:
                    dayGotcha = (int)(Math.random()*30) + 1;
                    case 10:
                    dayGotcha = (int)(Math.random()*31) + 1;
                    case 11:
                    dayGotcha = (int)(Math.random()*30) + 1;
                    case 12:
                    dayGotcha = (int)(Math.random()*31) + 1;
                }
                int yearGotcha = (int)(Math.random()*100) + 1923; //range from 1922 to 2022

                if(breedRan>=0&& breedRan<33){
                    breedD = "German Shepherd";
                } else if(breedRan>=33&& breedRan<66){
                    breedD = "Golden Retriever";
                } else if(breedRan>=66&& breedRan<99){
                    breedD = "Shiba Inu";
                }
                
                String dateGotcha = monthGotcha + "/" + dayGotcha + "/" + yearGotcha ;

                if (i ==0){
                    list[i][j] = new Animal(ran1, ran2); 
                } else if (i ==1){
                    list[i][j] = new Dog(ran1, ran2, breedD);
                } else if (i==2){
                    list[i][j] = new RescueDog(ran1, ran2 , dateGotcha, breedD);
                }
            }
        }
        display(list);
        double totalHeightAnimal = 0;
        double totalHeightDog = 0;
        double totalHeightRDog = 0;
        double totalWeightAnimal = 0;
        double totalWeightDog = 0;
        double totalWeightRDog = 0;

        for (int i = 0; i<4;i++){
            for (int j = 0; j< 15; j++){
                if (i == 0){
                    totalHeightAnimal+= list[i][j].getHeight();
                    totalWeightAnimal+= list[i][j].getWeight();
                }
                if(i == 1){
                    totalHeightDog+= list[i][j].getHeight();
                    totalWeightDog+= list[i][j].getWeight();
                }
                if(i == 2){
                    totalHeightRDog+= list[i][j].getHeight();
                    totalWeightRDog+= list[i][j].getWeight();
                }
            }
        }
        //make sure to use .equals if you want to use user input as string
        System.out.println("Would you like to sort the heights? (ascend or descend) ");
        String choice = inputValString(input);
        String choice2 = choice.toUpperCase();
        if(choice2.equals("ASCEND")){
            sortHeightA(list);
            display(list);
        } else if (choice2.equals("DESCEND")){
            sortHeightD(list);
            display(list);
        }

        System.out.println("Would you like to sort the weights? (ascend or descend)");
        String choicea = inputValString(input);
        String choiceb = choicea.toUpperCase();
        if(choiceb.equals("ASCEND")){
            sortWeightA(list);
            display(list);
        } else if (choiceb.equals("DESCEND")){
            sortWeightD(list);
            display(list);

        System.out.println("");
        System.out.print("Total height (Animal): ");
        System.out.println(String.format("%.2f", totalHeightAnimal) + "cm");
        System.out.print("Total height (Dog): ");
        System.out.println(String.format("%.2f", totalHeightDog)+ "cm");
        System.out.print("Total height (RescueDog): ");
        System.out.println(String.format("%.2f", totalHeightRDog)+ "cm");
        System.out.print("Total weight (Animal): ");
        System.out.println(String.format("%.2f", totalWeightAnimal)+ " pounds");
        System.out.print("Total weight (Dog): ");
        System.out.println(String.format("%.2f", totalWeightDog)+ " pounds");
        System.out.print("Total weight (RescueDog): ");
        System.out.println(String.format("%.2f", totalWeightRDog)+ " pounds");
        
        System.out.print("Average height (Animal): ");
        System.out.println(String.format("%.2f", (totalHeightAnimal / 15)) + "cm");
        System.out.print("Average height (Dog): ");
        System.out.println(String.format("%.2f", (totalHeightDog / 15))+ "cm");
        System.out.print("Average height (RescueDog): ");
        System.out.println(String.format("%.2f", (totalHeightRDog / 15))+ "cm");
        System.out.print("Average weight (Animal): ");
        System.out.println(String.format("%.2f", (totalWeightAnimal / 15))+ " pounds");
        System.out.print("Average weight (Dog): ");
        System.out.println(String.format("%.2f", (totalWeightDog / 15))+ " pounds");
        System.out.print("Average weight (RescueDog): ");
        System.out.println(String.format("%.2f", (totalWeightRDog / 15))+ " pounds");

    }
}
    public static void display(Animal[][]list){
        /*This method should accept an array as input and display the filled contents of the 2D array animal. */
            for (int i=0; i<3; i++){
                for (int j = 0; j< 15; j++){
                    System.out.println(list[i][j] + "");
                }
            }
        }
    
    public static void sortHeightA(Animal[][]array1){
        Animal arrayT[][] = new Animal[3][15];
        for (int k = 0; k<array1.length; k++){ 
            //keeps the rows constant so that it will be organized according to row 
            for (int i = 1; i<array1[k].length; i++){ //starts at the 1st index (2nd element) because bc [j-1] will cover the 0th index
                int j = i;
                while (j > 0 && (array1[k][j].getHeight() <  /*(>) for descending*/ array1[k][j-1].getHeight())){ //if the variable ahead of the one being compared is LESS then
                    arrayT[k][j] = array1[k][j]; //this is the one that is out of order (lesser one in front)
                    array1[k][j] = array1[k][j-1]; //make the index of the lesser value NOW equal to the array value that is GREATER than it (was out of order before)
                    array1[k][j-1] = arrayT[k][j];// now the one whose location is before is set to the lesser value
                    --j; //to check down the array to see if the lesser value is placed correctly
                }
            }
        }
        
    }
    public static void sortHeightD(Animal[][]array1){
        Animal arrayA[][] = new Animal[3][15];
        for (int k = 0; k<array1.length; k++){ 
            //keeps the rows constant so that it will be organized according to row 
            for (int i = 1; i<array1[k].length; i++){ //starts at the 1st index (2nd element) because bc [j-1] will cover the 0th index
                int j = i;
                while (j > 0 && (array1[k][j].getHeight() > /*(>) for descending*/ array1[k][j-1].getHeight())){ //if the variable ahead of the one being compared is LESS then
                    arrayA[k][j] = array1[k][j]; //this is the one that is out of order (lesser one in front)
                    array1[k][j] = array1[k][j-1]; //make the index of the lesser value NOW equal to the array value that is GREATER than it (was out of order before)
                    array1[k][j-1] = arrayA[k][j];// now the one whose location is before is set to the lesser value
                    --j; //to check down the array to see if the lesser value is placed correctly
                }
            }
        }
    }
    public static void sortWeightA(Animal[][]array1){
        Animal arrayA[][] = new Animal[3][15];
        for (int k = 0; k<array1.length; k++){ 
            //keeps the rows constant so that it will be organized according to row 
            for (int i = 1; i<array1[k].length; i++){ //starts at the 1st index (2nd element) because bc [j-1] will cover the 0th index
                int j = i;
                while (j > 0 && (array1[k][j].getWeight() <  /*(>) for descending*/ array1[k][j-1].getWeight())){ //if the variable ahead of the one being compared is LESS then
                    arrayA[k][j] = array1[k][j]; //this is the one that is out of order (lesser one in front)
                    array1[k][j] = array1[k][j-1]; //make the index of the lesser value NOW equal to the array value that is GREATER than it (was out of order before)
                    array1[k][j-1] = arrayA[k][j];// now the one whose location is before is set to the lesser value
                    --j; //to check down the array to see if the lesser value is placed correctly
                }
            }
        }
    }
    public static void sortWeightD(Animal[][]array1){
        Animal arrayA[][] = new Animal[3][15];
        for (int k = 0; k<array1.length; k++){ 
            //keeps the rows constant so that it will be organized according to row 
            for (int i = 1; i<array1[k].length; i++){ //starts at the 1st index (2nd element) because bc [j-1] will cover the 0th index
                int j = i;
                while (j > 0 && (array1[k][j].getWeight() > /*(>) for descending*/ array1[k][j-1].getWeight())){ //if the variable ahead of the one being compared is LESS then
                    arrayA[k][j] = array1[k][j]; //this is the one that is out of order (lesser one in front)
                    array1[k][j] = array1[k][j-1]; //make the index of the lesser value NOW equal to the array value that is GREATER than it (was out of order before)
                    array1[k][j-1] = arrayA[k][j];// now the one whose location is before is set to the lesser value
                    --j; //to check down the array to see if the lesser value is placed correctly
                }
            }
        }
    }
    public static String inputValString(Scanner sc){ //input validation for a double in order to get the correct input for finding accounts
        boolean loopControl = true;
        String var = "";
        String var2 = "";
        do{
            var = sc.next();
            var2 = var.toUpperCase();
            if (var2.equals("ASCEND")|| var2.equals("DESCEND")){ //checks to make sure it is a double
                loopControl = false;//if it is a double, then it breaks out of loop and returns the double 
            } else {
                System.out.println("Please enter a valid choice. ");
                sc.nextLine();//clears line
            }
            

        } while (loopControl);

        return var2;
    }
    

    public static int inputVal(Scanner sc){ //input validation for a double in order to get the correct input for finding accounts
        int num = 0;
        boolean loopControl = true;
        do{
            if (sc.hasNextInt()){ //checks to make sure it is a double
                num = sc.nextInt();
                if (num==1||num==2){
                    loopControl = false;//if it is a double, then it breaks out of loop and returns the double 
                } else {
                    System.out.println("Please enter a valid choice. ");
                    sc.nextLine();//clears line
                }
            } else {
                System.out.println("Please enter a valid choice. ");
                sc.nextLine();//clears line
            }

        } while (loopControl);

        return num;
    }
}


/*Creates a multidimensional array of animals: 
Animal[][]list = new Animal[3][15];
Sugg: Use the row to keep track of the type of animal, such that all elements in list[0] are Animals, list[1] is Dogs and list[2] is RescueDogs
Randomly create animals to fill the array
Sort each row by either animal height or weight
Display the array in an easy to read manner 
Sugg: Override toString in all object classes

Calculate the total height and weight:
For all Animals
For all Dogs
For all RescueDogs

Calculate the average height and weight for each of the following (separately):
For all Animals
For all Dogs
For all RescueDogs

Hints/Notes:
You can create additional methods in the object classes to complete any part of the above requirements.
Sugg: create a print method or override toString in each class
You can use instanceof within an if/else statement to determine the actual type of a reference. Example:
 */

