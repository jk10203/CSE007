/* Joy Kim
Decemer 8, 2022
CSE007 Fall 2022: Practice Exam
JDK 11 */
import java.util.Scanner;
public class TestFood{
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        Food[] groceryCart = new Food[50];
        groceryCart[0] = new Vegetable("Romaine", 1.09, "Green");
        groceryCart[1] = new Fruits("Mango", 3.79, true);
        groceryCart[2] = new Vegetable ("Brussel Sprouts", 4.56, "Green");
        groceryCart[3] = new Fruits("Blueberry", 0.89, false);
        groceryCart[4] = new Vegetable("Purple Carrots", 1.56, "Purple");
        groceryCart[5] = new Vegetable("Spinach", 2.32, "Green");
        groceryCart[6] = new Vegetable("Carrots", 1.45, "Orange");
        groceryCart[7] = new Vegetable("Potatoes", 3.99, "Red");
        groceryCart[8] = new Vegetable("Broccoli", 5.21, "Green");
        groceryCart[9] = new Vegetable("Turnip", .99, "White");
        groceryCart[10] = new Vegetable("Onions", 1.99, "Yellow");
        groceryCart[11] = new Fruits("Apples", 5.79, true);
        groceryCart[12] = new Fruits("Banana", .78, false);
        groceryCart[13] = new Fruits("Kiwi", 2.65, true);
        groceryCart[14] = new Fruits("Strawberry", 4.79, true);
        groceryCart[15] = new Fruits("Watermelon", 6.32, false);

        System.out.println("Items in your cart");
        display(groceryCart);

        sortByPrice(groceryCart); //problem

        /*System.out.println("Cart sorted by price");
        display(groceryCart);*/

        int search = getInt(scan);
        scan.nextLine(); //clearing the scanner of a new line character

        for(int i =0; i<search; i++){
            System.out.println("What item would you like to search for? ");
            String searchName = scan.nextLine();
            searchByName(groceryCart, searchName);
        }
        System.out.println("");
        System.out.println("CHECKING OUT... ");
        checkOut(groceryCart);
    }
    public static int getInt(Scanner s){
        boolean loopNeeded = true;
        int num = 0;
        do{
            System.out.println("How many items would you like to search for? ");
            if(s.hasNextInt()){
                num = s.nextInt();
                if(num > 0 ){
                    loopNeeded= false;
                } else {
                    System.out.println("Enter a num greater than 0");
                }
            } else {
                System.out.println("not a number");
                s.nextLine();
            }
        }while(loopNeeded);
        return num;
    }
    public static void checkOut(Food[]cart){
        /*This method should accept an array of Food and calculate/display the total cost for everything in the cart as well as the average price per item.
        Be sure to display both values to 2 decimal places. 
        */
        double pricesTot = 0;
        for (int i =0; i<16; i++){
            pricesTot+=cart[i].getPrice();
        }
        System.out.print("Total Cost: $");
        System.out.println(String.format("%-10.2f", pricesTot));

        System.out.print("Price per item: $");
        System.out.println(String.format("%-10.2f", pricesTot/cart.length));
    }
    public static void display(Food[]list){
    /*This method should accept an array of Food as input and display the filled contents of the cart. */
        for (int i=0; i<16; i++){
            System.out.println(list[i]);
        }
    }
    public static void sortByPrice(Food[]list){
        //accept an array of Food and sort by price per item in descending order using the sorting algorithm of your choice.
        int length = 16;
        double arrayInt[] = new double[length]; //new array filled with numbers that will then be sorted 

        //getting a double from double food
        for (int i =0; i< length; i++){
            double c = list[i].getPrice(); 
            arrayInt[i] = c; 
        }
        insertionSort(arrayInt); //sorting the numbers array

        System.out.println("");
        
        System.out.println("Cart sorted by price: ");
        for (int i =0; i< length; i++){
            for (int j = 0; j<length; j++){
                if (arrayInt[i] == (list[j].getPrice())){ //matching up the sorted arrayInt to the original String array bankaccount
                    System.out.println(list[j] + " ");
                }//important to note that this NOT permanently edit the Food [] list***
            }
        }

        /*for (int i = 0; i< length; i++){
            System.out.println(arrayInt[i]);
        }*/
    }
    public static void searchByName(Food[]list, String name){
        //This method should accept an array of Food as input as well as the name of a Food object to search for within the Cart. 
//For full credit, this method must invoke the equals(Object o) method that you defined in Food.
        int counter = 0;
        for(int i =0; i< 16;i ++){
            if (list[i].getName().equals(name)){ 
                System.out.println("Item found in your cart: ");
                System.out.println(String.format("%-10s", list[i]));
                counter++;
            } 
        }   
        if (counter ==0){
            System.out.println("Item was not found in your cart!");
        }  
    }

    public static void insertionSort(double[]list){
        for (int i=1; i<list.length; i++) {
            //Insert element i in the sorted sub-list
            double currentVal = list[i];
            int j = i;
            while (j>0 && currentVal>(list[j - 1])){ //if current value is less than the previous value then it switches
                 // Shift element (j-1) into element (j) --> resulting in the lower number goin before the higher number
                 list[j] = list[j - 1];
                 j--;
            }
            // Insert currentVal at position j
            list[j] = currentVal; //inserts the "higher" number of the two after the "lesser" number
         }
    
    }
   /*
    Comprehension 1:
     * Food is declared as abstract because it defines the common behavior for related subclasses Vegetable and Fruit 
     * Food only has meaning when its child classes or types are referred to
     * getType() is an abstract method so that child class can have this functionality and actually implement it 
     * abstract methods are meant to be overridden and with the two types of food
     * an abstract class cannot be instantiated 
     * 
     * you cannot make a food variable 
     * never make an instance of an abstract class 
     * 
     */

   /* Comprehension 2
     * Constructor chaining is the connection of the same constructor between a parent class and child class 
     * By calling "extends" in the class declaration of a child class, any constructor called with the same parameters
     * as listed in the parent class and the command "super()" is called, this automatically retrieves the action of the constructor seen in the parent class
     * which can then be implemented by the child class as well due to inheritance 
     * --> everything that comes after "extends" is from the super class 
     * 
     * This is used in my program when the last overloaded constructor of Vegetable includes parameters from the super class "String name, double price"
    Then the super command is called to use the specific constructor in the parent class to use and set5 those parameters 
     * This is what would happen if this overloaded Vegetable constructor were to be invoked 
     

     Comprehension 3:
     * Overriding methods is to directly change the function of the overridden method by returning something different
     * Overloading methods is the act of creating methods with the same signature, but with different parameter types
     * Overriding methods is seen directly above when the command @Override is written before the method that will be overridden
     * This will return the name of this specific class "Fruit" if the getType() method were invoked using the Fruit class
     * This will be invoked when an object of the Fruit class is made and the getType() or toString() methods will return what is
     * specifically changed as the return statement in the Fruit class instead of what's in the parent class Food
     * Whereas overloading methods can be seen by the overloaded constructors for Fruit
     * Both constructor names are Fruit, but the number and type of parameters are different as the second Fruit constructor
     * includes the additional parameter "boolean seeds" contrary to the first constructor also named "Fruit" but including only two
     * parameters String name, double price
     */

    /* Comprehension 4
     * JVM knows which one to invoke
     * At runtime, the actual type being invoked such as Vegetable or Fruit matches the actual type of the object
     * Dynamic binding = JVM decides which instance method to invoke at runtime
     */ 
}