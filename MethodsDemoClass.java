import java.util.Scanner;

public class MethodsDemoClass{
	public static void main(String[] args){
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Please enter 2 ints:");
		int x = myScanner.nextInt();
		int y = myScanner.nextInt();
		printEvenInRange(x,y);
		System.out.println("Done!");
	} // End of Main Method
	
	// Scan through all numbers in the range indicated by 
	// the user
	public static void printEvenInRange(int a, int b){
		if(a==b || a>b){
			System.out.println("Not a valid range");
			return;
		}
		else{
				//i=1; i<=11; i++
			for(int i=a;i<=b;i++){
				// If any numbers are even, print them
				if(findEven(i)) {
					System.out.print(i+"\t");
				}
			}		
		}
	}

	// Determine whether a number is even
	public static boolean findEven(int num){
		return(num % 2 == 0);
		// for odd: num % 2 == 1
	} 
}//close class Demo
