
import java.util.Scanner;

public class One{
    public static void main(String[]args){
        Scanner input = new Scanner (System.in);
int count = 0;
int rows = 1;
char letter = 'A';

System.out.println("Enter a positive integer: ");
count = input.nextInt();

while (rows <= count){
    int length = 1; 
while(length <= rows){
    letter +=length;
    System.out.print(letter);
        length++;
}
}
rows++;
System.out.println();

    }
}
