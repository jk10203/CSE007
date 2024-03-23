/* Joy Kim
November 30, 2022
CSE007 Fall 2022: Lab 12
JDK 11 */
/* This class is the parent class for checking and savings and serves to set the formulas / characteristics
of a bankaccount (the number, owner, balance) so we can establish objects from this class and utilize it in the
test program.
*/
public class BankAccount {
    //bankaccount is the object?
    private static String bankAccNum;
    private String number;
    private String owner;
    protected double balance;
    //visible within same package (between public and private)
    private static int numAccounts = 0;
    //WHEN field of method refers to preperty of class itself rather than objects --> counts

    public BankAccount(String owner, double balance){
        number = "";
        for (int i =0; i<10; i++){ //initializing the account numbers with 10 random numbers each time
            number+= (int)(Math.random() * 10) + "";
        }
        this.owner = owner;
        this.balance = balance;
        numAccounts++;
        
    }
    public String getNumber(){ //getter for number
        return number;
    }
    public String getOwner(){
        return owner;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){ //depositing feature that adds balance to amount
        balance += amount;
    }
    public boolean withdraw(double amount){ 
        if(amount<balance){//if the amount you want to withdraw is less than the amount, it comes back true
            balance -=amount;
            return true;
        } else {
            return false; //if the amount you want to withdraw is more than the amount, it comes back false (not possible)
        }
    }
    public static int getNumAccounts(){
        return numAccounts;
    }

    @Override  //for each class
    public String toString(){
        // Return the Account number,  Owner and Balance
        return String.format("%-10s\t%-30s\t%-10.2f", number, owner, balance); //the default formula for BankAccount                                
    }

}
