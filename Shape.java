/* Joy Kim
November 28, 2022
CSE007 Fall 2022: Participation 15
JDK 11 */
/* This program is intended to create the abstract class shape which will define the characteristics
of a shape that its subclasses will look for / and set. It will define the properties of color and name.
*/
public abstract class Shape {
    private String color;
    private String name;
    private static int numShapes = 0;
    
    //overload constructor - make same method twice with diff parameters

    protected Shape(){ //to read object
        name = "shape";
        color = "yellow";
        numShapes++;
    }
    protected Shape(String color, String name){
        this.name = name;
        this.color = color;
        numShapes++;
    }

    //getter setter fields - public

    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name= name;
    }
    public static int getNumShapes(){
        return numShapes;
    }

    //abstract = no default implementation - no way for me to implement this, BUT the 
    //child classes will implement this and have this commonality
    public abstract double computeArea();  //changes to computeArea / computePerieter
    public abstract double computePerimeter();

    @Override
    public String toString(){ //will always look like this
        return "name: " + name + "; color: " + color;
    }
}
