/* Joy Kim
November 30, 2022
CSE007 Fall 2022: Lab 12
JDK 11 */
public abstract class Food {
    //italicized is abstract
    //make sure to make private for 
    private String name;
    private double price;
    private static int numFoods = 0;

    protected Food(String name, double price){ //when protected??
        this.name = name;
        this.price = price;
        numFoods++;
    }
    //public getters and setters
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getNumFood(){
        return numFoods;
    }
    public abstract String getType();

    @Override
    public String toString(){
        return String.format("%-10s", "NAME: " + name); 
    }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Food){  //if obj found, cast as Food
            Food f = (Food) obj;
            return f.getName().equals(name);
        }
        return false;
    }

}
