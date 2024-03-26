/* Joy Kim
November 28, 2022
CSE007 Fall 2022: Participation 15
JDK 11 */
/* This program is intended to utilize the abstract class shape and sets the area, perimeter, radius which is all 
specific to this class/shape of a circle.
*/
public class Circle extends Shape{
   
    private double radius;
    private static int numCircles=0; //to hold the number of circle objects created

    public Circle(){
        super("yellow", "circle"); //constructor chaining
        //set fields of super class (shape class has color and name - field)
        radius = 0;
        numCircles++;
    }
    public Circle(double radius) {
        super("yellow", "circle"); //yellow is default and for this class, the default is circle
        this.radius = radius;
        numCircles++;
    }
    public Circle(double radius, String color, String name){
        super(color, "circle");
        this.radius = radius;
        numCircles++;
    }
    
    //getter setter for radius values
    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public int getNumCircles(){
        return numCircles;
    }
    
    //overriding / redefining values
    @Override
    public double computeArea(){
        double area = (Math.PI * radius * radius);
        return area;
    }
    @Override
    public double computePerimeter(){
        return 2 * Math.PI * radius;
    }
   
    @Override
    public String toString(){
        return super.toString() + "\t radius: " + radius + "; Area: " + computeArea();
    }
}
