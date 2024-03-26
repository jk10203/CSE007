/* Joy Kim
November 30, 2022
CSE007 Fall 2022: Lab 12
JDK 11 */
/* This class serves to be an extension of the BankAccount class. It includes many functions like 
calculating the monthly interest, yearly interest, and the amount of interest earned if the user
wants to implement it in the test class and utilize it. This classes' override also includes yearly 
interest as well.
*/
public class  SavingsAccount extends BankAccount{
    private double yearlyInt;
    private static int numSavings = 0;
    //private gives us control over how user sets it
    //cant be updated from outside of class

    public SavingsAccount(String owner, double balance, double yir){
        super(owner, balance);//constructor chaining
        yearlyInt = yir;
        numSavings++;
    }
    public double getinterest(){
        return yearlyInt;
    }
    public double getMonthlyInt(){ //decor
        return balance*(yearlyInt / 12) / 100;
    }
    public void setYearlyIntR(double yir){
        yearlyInt = yir;
    }
    public static int getSavings(){ //some more decor
        return numSavings;
    }
    public double applyInterest(){//more decor
        double interestEarned;
        interestEarned = ((yearlyInt / 12) / 100) * balance;
        balance += interestEarned;

        return interestEarned;
    }  
    
    @Override  //for each class
    public String toString(){
        //String out = super.toString();
        return String.format("%-10s\t%s\t%-10.2f", "Savings", super.toString(), yearlyInt);
        //return String.format("%10-s\t%-30s\t%-10.2f", "Savings", super.toString()); //fix
    }

}
