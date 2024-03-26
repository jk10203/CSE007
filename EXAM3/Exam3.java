import java.util.Scanner;
public class Exam3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String stringCheese = "";
        String ran2 = "";

        for(int i =0; i<5;i++){
            char ran = (char)((Math.random() *26)+65);
            stringCheese = ran + "" + ran2;
            ran2 += "" + ran;
            
        }
        System.out.print(stringCheese);
        Movie[] list = new Movie[1];
        System.out.println(list[0] + " ");

        Movie m = new Comedy ("Superbad", "R", 98.32); 
        m.laugh();
    }




}
