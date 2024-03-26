/* Joy Kim
December 9, 2022
CSE007 Fall 2022: Final
JDK 11 */
/*This program is intended to use the abstract class Movie in order to run operations on 
lists of movies
 */
import java.util.Scanner;
public class Test{
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);
        WatchList movies = new WatchList(100);
        fillMovies(movies);
        System.out.println(movies);
        int choice;
        do{
            printMenu();
            System.out.println("Enter a choice (1-5)");
            choice = getChoice(s);
            switch(choice){
                case 1:
                    System.out.println(movies);
                    break;
                case 2:
                    System.out.println("Enter the movie title");
                    String title = s.nextLine();
                    System.out.println("Enter the rating");
                    String rating = s.nextLine();
                    System.out.println("Enter the length of the movie (in minutes)");
                    double length = s.nextDouble();
                    s.nextLine();
                    System.out.println("Enter type");
                    String type = s.nextLine();
                    switch(type){
                        case "Action": movies.addMovie(new Action (title, rating, length)); break;
                        case "Drama": movies.addMovie(new Drama (title, rating, length)); break;
                        case "Comedy": movies.addMovie(new Comedy (title, rating, length)); break;
                        default: System.out.println("Invalid type");
                    }
                    break;
                case 3: 
                    System.out.println("Enter a movie type");
                    String t = s.nextLine();
                    switch(t){
                        case "Action":
                        case "Drama": 
                        case "Comedy":
                            movies.viewByType(t);
                            break;
                        default: System.out.println("Invalid type");
                    }
                    break;
                case 4: 
                    movies.sortWatchList();
                    System.out.println(movies);
                    break;
                case 5: System.out.println("Goodbye"); System.exit(0);
            }
        } while (choice != 5);
    }

    public static int getChoice(Scanner scan){
        int x = -1; 
        boolean flag = true;

        do{
            if(scan.hasNextInt()){
                x = scan.nextInt();
                scan.nextLine();
                if(x >= 1 && x <=5){
                    flag = false;
                } else {
                    System.out.println("Invalid option (1-5)");
                }
            } else {
                scan.nextLine();
                System.out.println("Not an integer (1-5)");
            }
        }while(flag);
        return x;
    }
    public static void fillMovies(WatchList list){
        addComedies(list);
        addDramas(list);
        addAction(list);
    }
    public static void addComedies(WatchList list){
        list.addMovie(new Comedy("Life is Beautiful", "PG-13", 125.3));
        list.addMovie(new Comedy("City Lights", "G", 96.3));
        list.addMovie(new Comedy ("The Intouchables", "R", 67.8));
    }
    
    public static void addDramas(WatchList list){
       list.addMovie(new Drama("Casablanca", "PG", 100.2));
       list.addMovie(new Drama("The Departed", "R", 130.2));
       list.addMovie(new Drama("Alien", "R", 76.2));
       list.addMovie(new Drama("Goodfellas", "R", 141.2));
       list.addMovie(new Drama("Apocalypse Now", "R", 86.72));
       list.addMovie(new Drama("City of God", "R", 95.4));
       list.addMovie(new Drama("The Silence of the Lambs", "R", 98.2));
       list.addMovie(new Drama("Interstellar", "PG-13", 96.3));
       list.addMovie(new Drama("The Lion King", "G", 75.4));
       list.addMovie(new Drama("The Pianist", "R", 87.12));
       list.addMovie(new Drama("Pulp Fiction", "R", 111.3));
       list.addMovie(new Drama("Angry Men", "R", 98.54));
       list.addMovie(new Drama("Schindler's List", "R", 132.5));
       list.addMovie(new Drama("The Shawshank Redemption", "R", 149.4));
       list.addMovie(new Drama("The Godfather", "R", 121.5));
    }
    public static void addAction(WatchList list){
        list.addMovie(new Action("Avengers", "PG-13", 129.5));
        list.addMovie(new Action("The Good, The Bad and The Ugly", "R", 98.32));
        list.addMovie(new Action("Inception", "PG-13", 126.32));
        list.addMovie(new Action("Star Wars: The Empire Strikes Back", "PG", 154));
        list.addMovie(new Action("The Matrix", "R", 101.5));
        list.addMovie(new Action("Gladiator", "R", 129.5));
        list.addMovie(new Action("Harry Potter & The Chamber of Secrets", "G", 119.5));
        list.addMovie(new Action("The Dark Knight", "PG-13", 109.45));
        list.addMovie(new Action("The Lord of the Rings", "PG-13", 141.6));
    }

    public static void printMenu() {
        System.out.println("Select an operation:");
        System.out.println("1: View Movies");
        System.out.println("2: Add Movie");
        System.out.println("3: View by Type (Action, Comedy or Drama)");
        System.out.println("4: Sort Movies by Title");
        System.out.println("5: Exit");
        }
}