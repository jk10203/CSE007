/* Joy Kim
December 9, 2022
CSE007 Fall 2022: Final
JDK 11 */
/*This program is intended to use the Movie parent class in order to modify the subclass of Comedy to make the genre
more specific. 
 */
public class Comedy extends Movie{
    private static int numComedy = 0;
    
    public Comedy(){
        super(null,null,0.0); //because there is no no-arg constructor in movie
        numComedy++;
    }
    public Comedy(String title, String rating, double length){
        super(title,rating,length);
        numComedy++; //incrementing to keep track
    }
    public double getNumComedy(){ //getter for numComedy
        return numComedy;
    }

    public String laugh(){
        return "HAHAHA";
    }

    @Override
    public String getType(){
        return "Comedy"; //modifying so type changes
    }

    /*[COMPREHENSION 3]: Include a block comment explaining the difference between 
    instance and static class members, how they are used within the classes above, 
    and how they are stored in memory. 
    The difference between instance and static class members is that static deals with
    variables that are only allocated in the memory once when the program runs. This means
    that the static variables are located in the static memory region of the program and has a global 
    scope as a result. They are a part of the class rather than an instance. This means that these static 
    variables can be accessed anywhere in the program. HOwever, on the other hand, instance class members 
    relate directly to the instance of a class. You can access static members from instance methods 
    (but NOT vice versa - cannot access instance members from static methods) A static methods relates to class but not to 
    all instances of class, but instance methods can relate to static members because all of class.They are limited to the objects themselves which are 
    instances of the class. In this program, instance is used when we refer to “this.” in our constructors. 
    It is the specific instance or variable that relates to current instance of class which then relates it to the variable in the 
    parameter. Also an example could be our objects which are istances of the class. The objects in this program
    can be the getter setters and the public string laugh();.
*/
}
