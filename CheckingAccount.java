/* Joy Kim
November 30, 2022
CSE007 Fall 2022: Lab 12
JDK 11 */
/* This class utilizes inheritance to be an extension of BankAccount. It overrides the toString to
print out the corresponding accounts type (checking)
*/
public class CheckingAccount extends BankAccount{
    private static int numChecking = 0;
    
    public CheckingAccount(String owner, double balance){
        super(owner, balance); //constructor chaining
        numChecking++;
    }

    public String toString(){
        return String.format("%-10s\t%s", "Checking", super.toString()); //just adds checking classification
    }
    public static int getNumChecking(){
        return numChecking;
    }
}
