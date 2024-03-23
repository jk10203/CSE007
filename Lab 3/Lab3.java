/* Joy Kim
9 September, 2022
CSE007 Fall 2022: Lab 3
JDK 11 */
/* This program is intended to test switch statements in which if a character is assigned to c then
it goes through multiple cases until it finds a match and ends with a final output showing what c's new
value is */

public class Lab3{
    public static void main(String[]args){
        int num = 10; // this number might change depending on which case it falls in
        char c = 'A'; //the case depends on what is in between these apostrophes
        /* a) */
        switch(c){ // basically means if c.equals("some value") then ...
            case 'A': 
                num -= c; //if the char c = 'A' then num = num - c where c = 65 (A in ascII is 65)
                System.out.println("caseA " + num); //output
                break; //if case 'A' is true, then the program can stop here
            case 'D': System.out.println("caseD " + '0' + num); break;//during output, 0 is added in front of the num (not math addition)
            case 'B': System.out.println("caseB " + ++num); break; //num's value changes before the output so the output for num is (1 + num)
            case 'C' : System.out.println("caseC " + num+2); // you add 2 after the value of num (NOT math addition)
                c-=2; //if the char c = 'C', then c = c-2 where c = 67. So, c is now equal to 65
                break; // if case 'C' is true, then program stops here
            case 'E': System.out.println("case2 " + num++); //num's value after the output is shown is (1+num)
            case 'F': System.out.println("case3" + num--); //num's value after the output is shown is (1-num)
            default: System.out.println("default " + --num);//num's value changes before the output so the output for num is (num-1)
        }    //default also means that if char c is equal to any other value/number/letter/character, this default case will run
        System.out.println("end " + c); //this statement will print at the end of any case/default with the new value of c

    }
}