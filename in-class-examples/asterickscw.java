public class asterickscw{
    public static void main(String[]args){

       /* String i = "*";
        int count = 1
        do {
            System.out.println(i + i + i + i + i)
        } while (count < 6) 

        for (int row = 1; row<6; row++){ //runs five times for every row
            for (int col = 1; col < 6; col++){
                System.out.print( "*");
            }
            System.out.println();
        }*/
        /*for (int rows = 1; rows < 6; rows++){ 
            for (int cols = 1; cols <= rows; cols++){
                System.out.print("*");
            }
            System.out.println();
        } */
        //opposite way
        for (int rows = 1; rows < 6; rows++){ 
            for (int cols = 5; cols >= rows; cols--){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int row = 5; row > 0; row--){
            for(int col = row; col > 0; col--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
