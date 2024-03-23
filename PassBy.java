/* Joy Kim
October 26, 2022
CSE007 Fall 2022: Participation 10
JDK 11 */

public class PassBy{
    public static void main(String[]args){
        int[] numbers = {100, 200, 300, 400};
        printArray(numbers);
        int[] newNumbers = copyArray(numbers);
        doubleArrayContent(numbers);
        printArray(numbers);
        //int[] newNumbers = copyArray(numbers);
        printArray(newNumbers);

        int[] list = {1, 2, 3, 4, 5};
        methodX(list);
        printArray(list);
    }
    public static void methodX(int[] list){
        int[] newList = new int[list.length];
        for(int i=0; i<list.length; i++)
            newList[i] = list[list.length - 1 - i];
        printArray(newList);
        printArray(list);
        list = newList;
        printArray(list);
       }
    public static void printArray(int[] list){
        for(int i=0; i < list.length; i++){
            System.out.print(list[i]+ " ");
            System.out.println();
        }
       }
       public static void printArray(double[] list){
        for(int i=0; i < list.length; i++){
            System.out.print(list[i]+ " ");
                 System.out.println();
        }
      }
      
    public static void doubleArrayContent(int[] list){
        for (int i=0; i<list.length; i++)
        list[i] = list[i] * 2;
    }
    public static int[] copyArray(int[] list){
        int[] newList = new int[list.length];
        for(int i=0; i<list.length; i++){
        newList[i] = list[i];
        }
        return newList;
       }
}