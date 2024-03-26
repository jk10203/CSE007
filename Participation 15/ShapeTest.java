/* Joy Kim
November 28, 2022
CSE007 Fall 2022: Participation 15
JDK 11 */
/* This program is intended to test the classes that area made from the abstract class shape and its sub classes.
It will first randomly generate a shape given a user input to the array size, and calculate the perimeter, area,
average area, average perimeter, total area, and total perimeter.
*/
import java.util.Scanner;
public class ShapeTest {
    //abstract  - no objects from abstract class --> use other classes to define characteristics from abstract
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
       
        System.out.println("Please enter an integer for the shape array size: ");
        int choiceS = input.nextInt();
        //validate
        Shape[] lotsShape = new Shape[choiceS];

        //randomly generated shapes based on input from user on array size
        for (int i = 0; i< choiceS; i++){
            int rand = (int) (Math.random() * 99);
            double rand1 = (Math.random() * 20); //limited to 20 because I don't want the areas to get too big
            double rand2 = (Math.random() * 20);
            int rand3 = (int) (Math.random() * 99); //randomly generated colors
            String color = "";
            
            //randomly generated colors
            if (rand3 >= 0 && rand3<=33){
               color = "green";
            } else if (rand3 >= 34 && rand3 <= 66){
                color = "purple";
            } else if (rand3 >= 67 && rand3 <= 99){
                color = "brown";
            }  
            //randomly generating shapes
            if (rand >= 0 && rand<=33){
                lotsShape[i] = new Circle(rand1, color, "Circle");
            } else if (rand >= 34 && rand <= 66){
                lotsShape[i] = new Rectangle(rand1, rand2, color);
            } else if (rand >= 67 && rand <= 99){
                lotsShape[i] = new Triangle(rand1, rand2, color);
            }      
        }

        double perimeter = 0; //initializing so I can keep track
        double area = 0;
        for (int i = 0; i< choiceS; i++){ 
            System.out.println(lotsShape[i]); //utilizing to.String without calling it
            System.out.println("Area: " + lotsShape[i].computeArea()); //printing area
            System.out.println("Perimeter: " + lotsShape[i].computePerimeter()); //printing perimeter
            System.out.println("");

            double perimeter1 = lotsShape[i].computePerimeter();
            perimeter += perimeter1; //keeping track of the perimeter
            double area1 = lotsShape[i].computeArea();
            area += area1; //keeping track of the area
        }

        System.out.println("Total Area = " + area);
        System.out.println("Total Perimeter = " + perimeter);
        System.out.println("");
        System.out.println("Average Area = " + (area / choiceS));
        System.out.println("Average Perimeter = " + (perimeter / choiceS));
        
        //testing three overloading for CIRCLE
       /* Circle circle1 = new Circle(5.3, "green", "circle");
        System.out.println(circle1); //compared to printing out circle1.toString()

        Circle circle2 = new Circle(1.11);
        System.out.println(circle2.toString());

        Circle circle3 = new Circle();
        System.out.println(circle3);*/  

    }
}
