/* Joy Kim
5 September, 2022
CSE007 Fall 2022: Lab 2
JDK 11 */
/* This program intends to utilize input from the user about a pizza party on
friday and saturday in order to figure out if he/she can afford a pizza party given a budget
given the circumstances of the party itself (number of people attending, amount of pizza,
price of pizza, delivery price, tax, and average amount of slice per person) */
import java.util.Scanner;

public class PizzaParty {
    public static void main(String[]args){
        double budget; //this holds the total amount you have to spend on the weekend (we will compare this to the weekendTotal)
        int numFriends; //this holds the number of people that will join you for pizza each night
        double avgSlicePerson; //this holds the number of slices that the avg person eats and will be used to calculate the total number of slices (pies) needed
        double costPerPizza; //this holds the cost for a single pizza (whole pie; slices not available separately)
        int wholePizzas; //will hold the number of whole pizzas required based on the slices that are estimated
        double totalPizzaCost; //subtotal of cost of pizzas
        double totalTaxOwed; //uses rate below to calculate the tax owed on the total
        double total; //will hold the total owed each night including pizza, tax and delivery
        final int slicePerPizza = 8; //this is the number of slices cut from each pizza
        final double salesTax = .06; //this holds the salesTax rate used for the order (6%)
        final double deliveryFee = 4.99; //this holds the flat delivery fee applied to each order
        double totalWeekend;//cost for entire weekend
        int totalPizzasWeekend;//total pizzas for the weekend

        Scanner scan = new Scanner(System.in);

        //getting input for friday night
        System.out.println("Enter your budget for the weekend: ");
        budget = scan.nextDouble();
        System.out.println("Enter the number of friends you are feeding on Friday: ");
        numFriends = scan.nextInt();
        System.out.println("Enter the avg number of slices for each person on Friday: ");
        avgSlicePerson = scan.nextDouble();
        System.out.println("Enter the cost per pizza on Friday: ");
        costPerPizza = scan.nextDouble();

        //getting input for saturday night
        System.out.println("Enter the number of friends you are feeding on Saturday: ");
        int numFriendsSat = scan.nextInt();
        System.out.println("Enter the avg number of slices for each person on Saturday: ");
        double avgSlicePersonSat = scan.nextDouble();
        System.out.println("Enter the cost per pizza on Saturday: ");
        double costPerPizzaSat = scan.nextDouble();

        //calculating friday night costs
        double numSlices = (numFriends + 1) * avgSlicePerson;
        double pizzas = numSlices / slicePerPizza;
        wholePizzas = (int)(Math.ceil(pizzas));//the ceiling of 3.5 is 4 and the floor is 3
        totalPizzasWeekend = wholePizzas;
        // System.out.println("Whole pizzas: " + wholePizzas); // not part of submission but part of testing process

        totalPizzaCost = wholePizzas * costPerPizza;
        totalTaxOwed = totalPizzaCost * salesTax;
        total = totalPizzaCost + totalTaxOwed + deliveryFee;

        //displaying friday night costs
        System.out.println(" ");
        System.out.println("Friday Night Pizza Party");
        double roundedNum = ((int)(totalPizzaCost * 100)) / 100.0;//move decimal place then truncate decimals we don't want then add decimals back in to make sure we have 2 decimal places
        if (wholePizzas == 1){
            System.out.println(wholePizzas + " Pizza: $" + (roundedNum));
        }
        else{
        System.out.println(wholePizzas + " Pizzas: $" + (roundedNum));
        }
        System.out.printf("Tax: $%.2f\n",totalTaxOwed); // printing to 2 decimal places
        System.out.printf("Delivery fee: $%.2f\n",deliveryFee);
        System.out.printf("Friday night total: $%.2f\n",total);

        //calculating saturday night costs
        numSlices = (numFriendsSat + 1) * avgSlicePersonSat;
        pizzas = numSlices / slicePerPizza;
        wholePizzas = (int)(Math.ceil(pizzas));
        totalPizzasWeekend += wholePizzas;

        totalPizzaCost = wholePizzas * costPerPizzaSat;
        totalTaxOwed = totalPizzaCost * salesTax;
        double totalSat = totalPizzaCost + totalTaxOwed + deliveryFee;

        //display Saturday night costs
        System.out.println(" ");
        System.out.println("Saturday Night Pizza Party");
        roundedNum = ((int)(totalPizzaCost * 100)) / 100.0;//move decimal place then truncate decimals we don't want then add decimals back in to make sure we have 2 decimal places
        if (wholePizzas == 1){
            System.out.println(wholePizzas + " Pizza: $" + (roundedNum));
        }
        else{
        System.out.println(wholePizzas + " Pizzas: $" + (roundedNum));
        }
        System.out.printf("Tax: $%.2f\n",totalTaxOwed); // printing to 2 decimal places
        System.out.printf("Delivery fee: $%.2f\n",deliveryFee);
        System.out.printf("Saturday Night Total: $%.2f\n",totalSat);

        //TOTAL Weekend OVERVIEW
        System.out.println(" ");
        totalWeekend = total + totalSat; 
        totalWeekend = ((int)(totalWeekend * 100)) / 100.0;
        System.out.println(totalPizzasWeekend + " Total Pizzas for Friday and Saturday: $" + totalWeekend);

        System.out.println("Can you afford? " + (budget >= totalWeekend));
    }
}