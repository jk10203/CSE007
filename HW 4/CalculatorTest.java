/* Joy Kim
November 17, 2022
CSE007 Fall 2022 Lab 11
JDK 11 */
/* This program is intended to utilize the calculator class in order to calculate the value of a certain
equation that is listed on the assignment pdf. It simulates a typical calculator that will give you the value
of an expression given that you input certain values for x,y,z.
*/
import java.util.Scanner;
public class CalculatorTest {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        Calculator calc = new Calculator(); //invoking calculator class
        int x;
        double y;
        double z;
        double valueHold; //holding value
        
        //must validate input (used a method)

        System.out.println("Please enter the value for x: ");
        x = getVValue(input);
    
        System.out.println("Please enter the value for y: ");
        y = getVValue(input);

        System.out.println("Please enter the value for z: ");
        z = getVValue(input);


        //System.out.println("\nx: " + x + ";y: " + y + ";z: " + z); //checking if input works

        //testing
        /*calc.add(7.0);
        System.out.println("Value: " + calc.getValue());
        calc.multiply(x);
        System.out.println("Value: " + calc.getValue());
        calc.add(y);
        System.out.println("Value: " + calc.getValue());
        calc.subtract(13.0);
        System.out.println("Value: " + calc.getValue());
        calc.divide(4.0);
        System.out.println("Results: " + calc.getValue());
        System.out.println("# of operations: " + Calculator.getOperations());
        calc.clear();*/
 
        //first part numerator
        calc.add(4.0);
        calc.multiply(x);
        System.out.println("Value: " + calc.getValue());
        calc.multiply(y);
        System.out.println("Value: " + calc.getValue());
        calc.multiply(y);
        System.out.println("Value: " + calc.getValue());
        calc.multiply(y);
        System.out.println("Value: " + calc.getValue());
        calc.multiply(z);
        System.out.println("Value: " + calc.getValue());
        valueHold = calc.getValue();
        calc.clear();

        //to create a new calculator instead of using temp values to hold values 
        /*Calculator calc2 = newCalculator;
        calc2.add(2);
        System.out.println("Value: " + calc2.getValue());
        calc2.add(y);
        System.out.println("Value: " + calc2.getValue());
        double temp = calc2.getValue();
        for(int i =0; i<x; i++){
            calc.multiply(temp);
            System.out.println("Value: " + calc2.getValue());
        }
        */
        //second part numerator
        calc.add(2.0);
        System.out.println("Value: " + calc.getValue());
        calc.add(y);
        double valueHold2 = calc.getValue(); //another value holder
        System.out.println("Value: " + calc.getValue());
        //calc.multiply();//valueHold2 = calc.getValue() );
        for (int i = 0; i<x; i++){
            valueHold2 *= valueHold2;
        }
        System.out.println("Value: " + calc.getValue());
        valueHold2 = calc.getValue();
        calc.clear();

        //third part numerator
        calc.add(7.0);
        System.out.println("Value: " + calc.getValue());
        calc.multiply(z);
        System.out.println("Value: " + calc.getValue());
       
        double valueHold3 = calc.getValue();
        calc.clear();

        //numerator total
        calc.add(valueHold);
        System.out.println("Value: " + calc.getValue());
        calc.add(valueHold2);
        System.out.println("Value: " + calc.getValue());
        calc.subtract(valueHold3);

        valueHold = calc.getValue();
        calc.clear();

        //first part denominator 
        calc.add(5.0);
        System.out.println("Value: " + calc.getValue());
        calc.multiply(x);
        System.out.println("Value: " + calc.getValue());
        calc.multiply(y);
        System.out.println("Value: " + calc.getValue());
        valueHold2 = calc.getValue();
        calc.clear();

        //second part denominator
        calc.add(4.0);
        System.out.println("Value: " + calc.getValue());
        calc.multiply(z);
        System.out.println("Value: " + calc.getValue());
        valueHold3 = calc.getValue();
        calc.clear();

        //altogether denominator
        calc.add(valueHold2);
        System.out.println("Value: " + calc.getValue());
        calc.add(valueHold3);
        System.out.println("Value: " + calc.getValue());
        calc.subtract(x);
        System.out.println("Value: " + calc.getValue());

        valueHold2 = calc.getValue();
        calc.clear();

        //dividing num by denominator
        calc.add(valueHold);
        System.out.println("Value: " + calc.getValue());
        calc.divide(valueHold2);
        System.out.println("Value: " + calc.getValue());
        valueHold = calc.getValue();

        System.out.println("Results: " + calc.getValue());
        System.out.println("# of operations: " + Calculator.getOperations());
        calc.clear();
    }

    public static int getVValue(Scanner sc){ //method to input validate :D
        int num = 0;
        boolean loopControl = true;
        do{
            if (sc.hasNextInt()){
                num = sc.nextInt();
                loopControl = false;
            } else {
                System.out.println("Please enter a valid integer. ");
                sc.nextLine();
            }

        } while (loopControl);

        return num;
    }
    public static double getDValue(Scanner sc){ //method to input validate :D
        double num = 0.0;
        boolean loopControl = true;
        do{
            if (sc.hasNextDouble()){ //need to be different for doubles
                num = sc.nextDouble();
                loopControl = false; //breaks loop
            } else {
                System.out.println("Please enter a valid integer. ");
                sc.nextLine();
            }

        } while (loopControl);

        return num; //returns decision
    }
}
