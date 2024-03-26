/* Joy Kim
October 21, 2022
CSE007 Fall 2022: Lab 9
JDK 11 */
/* This program is intended to calculate your taxes based on your wage, taxable interest, 
unemployment compensation, withheld taxes, and your status. The taxes that are calculated include
AGI, deduction taxable income, and finally the overall taxes that must be paid. We are able to 
create this program by utilizing a combination of methods and input validation.*/

import java.util.Scanner;
import java.util.Random;

public class CalculateTaxes{ 
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in); 

        //add print statements to specify input
        System.out.println("Please enter your wage: ");
        double wages = getDouble(input); //input validating for later

        System.out.println("Please enter the taxable interest: ");
        double interest = getDouble(input);//input validating for later

        System.out.println("Please enter your unemployment compensation: ");
        double unemployComp = getDouble(input);//input validating for later

        System.out.println("Please enter amount of taxes withheld: ");
        double withheld = getDouble(input);//input validating for later

        System.out.println("Please enter your status ((0) dependent, (1) single, or (2) married): ");
        int status= getInt(input);

        //output
        int agi = computeAGI(wages,unemployComp,interest); //utilizing inputs to calculate
        System.out.printf("AGI: $%,d\n", agi); //add comma if over thousand

        int deduction  = getDeduction(status);
        System.out.printf("Dedication: $%,d\n", deduction);

        int taxableInc = getTaxable(agi,deduction);
        System.out.printf("Taxable Income: $%,d\n", taxableInc);

        int taxes = calcTax(status, taxableInc);
        System.out.printf("Federal Tax: $%,d\n",taxes);

        int taxBill = calcTaxDue(taxes, withheld);
        System.out.printf("Taxes owed: $%,d\n", taxBill);
        

    }
    //order of methods don't matter

    public static double getDouble(Scanner s){
        double num = 0;
        do{
            System.out.println("(enter a positive double)"); //fix formatting
            if(s.hasNextDouble()){
                num = s.nextDouble();
                if (num > 0){
                    break;
                } else {
                    System.out.println("Double not valid");
                }
            } else {
                String junk = s.nextLine(); //clearing junk that is not a number
                System.out.println("NOT A DOUBLE");
            }
        } while (true);
        return num;//returns positive double value
    }

    public static int getInt(Scanner sc){
        int num = 0;
        do{
            System.out.println("Enter a positive integer");
            if(sc.hasNextInt()){
                num = sc.nextInt();
                if (num >= 0){
                    break;
                } else {
                    System.out.println("Integer not valid (must be 0,1,2)");
                }
            } else {
                String junk = sc.nextLine(); //clearing junk that is not a number
                System.out.println("NOT AN INTEGER");
            }
        } while (true);        
        return num;//positive integer value (0,1,2)
    }
    //trying to get adjusted gross income
    public static int computeAGI(double wages, double unemployment, double interest){ 
        int agi = (int) (wages + unemployment + interest); //cutting off decimals 
        return agi;
    }
    //deduction is based on status
    public static int getDeduction(int status){
        int deduction;
        if(status == 0){ //dependent
            deduction = 6000;
        } else if (status ==1){//single
            deduction = 12000;
        } else if (status == 2){//married
            deduction = 24000;
        } else {
            deduction = 6000;
        }
        return deduction;
    }

    public static int getTaxable(int agi, int deduction){ //taxable income
        int taxable = agi - deduction;
        if (taxable < 0){
            taxable = 0;
        }
        return taxable;
    }

    public static int calcTax(int status, int taxable){
        double tax;
        if (status == 0 || status == 1){ //not letting me enter 0
            if (taxable <=10000){
                tax = 0.1 * taxable;
            } else if (taxable > 10000 && taxable <= 40000) {
                tax = 1000 + (.12 * (taxable - 10000)); //(taxable - 10000) amount you earned over 10,000
            } else if (taxable > 40000 && taxable <= 85000){
                tax = 4600 + (.22 * (taxable - 40000));
            } else { // greater than 85,000
                tax = 14500 + (.24 * (taxable - 85000));
            }
        } else {
            if (taxable >= 0 && taxable <= 20000){
                tax = 0.10 * taxable;
            } else if (taxable > 20000 && taxable <= 80000){
                tax = 2000 + (.12 * (taxable - 20000));
            } else { //over 80,000
                tax = 9200 + (.22 * (taxable - 80000));
            }
        }
        tax = Math.round(tax);
        return (int) tax;
    }
    
    public static int calcTaxDue(int taxesOwed, double taxesPaid){
        double due1; //amount of taxes you have to pay
        due1 = taxesOwed - taxesPaid;
        int due2 = (int) due1;
        return due2;
    }
}