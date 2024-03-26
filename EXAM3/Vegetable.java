public class Vegetable extends Food {
    private String color;
    private static int numVeg = 0;

    public Vegetable (String color){
        super(null, 0.00); //because there is no NOARG constructor
        this.color = color;
    }
    public Vegetable(String name, double price, String color){
        super(name, price);
        this.color = color;
        
    }
    public int getVeg(){
        return numVeg;
    }

    @Override
    public String getType(){
        return "VEGETABLE";
    }
    @Override
    public String toString(){
        return super.toString() + "; TYPE: " + getType() + "; COLOR: " + color + "; PRICE: " + getPrice();
    }

    
}
