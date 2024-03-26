/* Joy Kim
November 28, 2022
CSE007 Fall 2022: Participation 15
JDK 11 */
/* This program is intended to utilize the abstract class shape and sets the area, perimeter, height, and width 
which is all specific to this class/shape of a rectangle.
*/
public class Rectangle extends Shape {
    private double height;
    private double width;
    private static int numRects=0;
    
    public Rectangle(){
        numRects++;
    }
    public Rectangle(double height, double width){
        this.height = height;
        this.width = width;
        numRects++; 
    }
    public Rectangle(double height, double width, String color){
        super(color,"Rectangle");
        this.height = height;
        this.width = width;
        numRects++; 
    }
    public static int getNumRects(){
        return numRects; 
    }
    
    //getters and setters
    public double getHeight(){
        return height; 
    }
    public void setHeight(double height){
        this.height=height; }
        public double getWidth(){
        return width; 
    }
    public void setWidth(double width){
        this.width = width; 
    }
    
    @Override
        public double computeArea(){
        return width*height;
    }
    
    @Override
        public double computePerimeter(){
        return 2*(width+height);
    }
    
    @Override
        public String toString(){
        return super.toString()+"; height is "+height + " and width is "+width;
    }
   }
