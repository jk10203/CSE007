/* Joy Kim
December 9, 2022
CSE007 Fall 2022: Final
JDK 11 */
/*This program is intended to use the Movie parent class in order to modify the genre of Drama as the subclass. 
 */
public class Drama extends Movie{
private int numDrama = 0;

public Drama(){
    super(null,null,0); //setting to null for strings because it is a NO-arg constructor
    numDrama++;
}
public Drama(String title, String rating, double length){
    super(title,rating,length); //using super in order to format / use parameters
    numDrama++;
}
public double getNumDrama(){
    return numDrama; //getter for numDrama
}

@Override
public String getType(){
    return "Drama"; //changing type to Drama (genre)
}
}
