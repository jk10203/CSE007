/* Joy Kim
November 28, 2022
CSE007 Fall 2022: Participation 15
JDK 11 */
/* This program is intended to utilize the abstract class shape and sets the area, perimeter, base, and height
which is all specific to this class/shape of a triangle. It is important to note that the sides of the triangle assumes
the height is measured in the middle of the base.
*/
import java.util.Scanner;
public class Triangle extends Shape {
    Scanner scan = new Scanner(System.in);

    private double base;
    private double height;
    private static int numTris=0;

    public Triangle(){
        numTris++; 
    }
        
    public Triangle(double base, double height){
        this.base = base;
        this.height = height;
        numTris++; 
    }
    
    public Triangle(double base, double height, String color){
        super(color,"Triangle");
        this.base = base;
        this.height = height;
        numTris++; 
    }
    //getters and setters
    public static int getNumTris(){
        return numTris; 
    }
    public double getBase(){
        return base; 
    }
    public void setBase(double base){
        this.base=base; 
    }
    public double getHeight(){
        return height; 
    }
    public void setHeight(double height){
        this.height = height; 
    }
    
    @Override
        public double computeArea(){
        return 0.5 * height * base; //formula for a triangle
    }
    
    @Override
    public double computePerimeter(){
    
    //user input for sides version
    /*System.out.println("Enter the length of side 1");
    double side1 = scan.nextDouble();
    System.out.println("Enter the length of side 2");
    double side2 = scan.nextDouble();*/
    
    //because not all side lengths of the triangle can equal a specific set height and base, I decided
    //to make it more correctish by just setting the side to be equal to the pythagorean thm results
        double side1 = Math.sqrt(height*height) + ((base/2)*(base/2));
        return base + side1 + side1; 
    }
    
    @Override
        public String toString(){
        return super.toString()+"; base is "+ base + " and height is "+ height; 
    }
}
