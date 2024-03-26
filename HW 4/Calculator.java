/* Joy Kim
November 17, 2022
CSE007 Fall 2022 Lab 11
JDK 11 */
/* This program is intended to create the Calculator class in order to make math operations simpler
and reusable for other math intended programs. It includes functions like addition, subtraction, division, 
multiplication, and number of operations performed.
*/
public class Calculator {
    private double value;
    private static int operations;
    
    public Calculator(){
        //Constructor method to set the member field to 0.0
        value = 0.0;
    }

    public void add(double val){
        //Add the parameter to the member field
        this.value += val; //doesn't need this. (not required)
        operations++; //keeps track of number of operations
    } 
    
    public void subtract(double val){
        //Subtract the parameter from the member field
        this.value -= val;
        operations++; //keeps track of number of operations
    }
   
    public void multiply(double val){
        //Multiply the member field by the parameter
        this.value *= val;
        operations++; //keeps track of number of operations
    }
    public void divide(double val){
        //Divide the member field by the parameter
        this.value /= val;
        operations++; //keeps track of number of operations
    }
   
    public void clear( ){
        //Set the member field to 0.0
        value = 0.0;
    }
    
    public double getValue( ){
        //Return the member field
        return value; //GETs value
    }

    public static int getOperations(){
        return operations; //GETs number of operations
    }

    

    
}
