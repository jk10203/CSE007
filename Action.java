/* Joy Kim
December 9, 2022
CSE007 Fall 2022: Final
JDK 11 */
/*This program is intended to use the Movie parent class in order to make a subclass of Action genre.
 */
public class Action extends Movie {
    private static int numAction = 0;
    public Action(){
        super(null,null,0); //setting to null for strings because it is a NO-arg constructor
        numAction++;
    }
    public Action(String title, String rating, double length){
        super(title,rating,length);
        numAction++;
    }
    public double getNumAction(){
        return numAction;
    }

    @Override
    public String getType(){
        return "Action";
    }
    /*[COMPREHENSION 2]: Include a block comment explaining what constructor chaining is, when it is 
    required/used, and how only defining one constructor (with three args) in the Movie class complicated 
    this for you. 
    Constructor chaining is when you use super() inside of a subclass constructor in order to relate / use
    the parent classes already established or outlined variables/data fields for the child/subclasses. So you are
    basically using the saem constructor between the parent and child class and constructor chaining is the
    connection that the two make. It is used when you want to use the sets of data field already outlined in the parent class
    in your child class andyou can call it by using super(whatever parameters needed). It is used when you are using the same parameters
    from the super class. Only defining one constructor in the movie class did complicate this for a bit only because there 
    is NO no-arg constructor in the parent class. This made it so that you have to add null for string parameters and 
    0 for double parameters if you want a no-arg constructor in the child class.*/

}
