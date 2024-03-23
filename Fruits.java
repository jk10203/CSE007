public class Fruits extends Food {
    private boolean seeds;
    private static int numMeat = 0;
    private String seedOrNot;

    public Fruits (boolean seeds){
        super (null, 0.00);
        this.seeds = seeds;
        if (seeds = true){
            seedOrNot = "(SEEDED)";
        } else {
            seedOrNot = "(SEEDLESS)";
        }
        numMeat++;
    }
    public Fruits (String name, double price, boolean seeds){
        super(name, price);
        this.seeds = seeds;
        if (seeds = true){
            seedOrNot = "(SEEDED)";
        } else {
            seedOrNot = "(SEEDLESS)";
        }
        numMeat++;
    }
    public int getNumMeat(){
        return numMeat;
    }

    @Override
    public String getType(){
        return "FRUIT";
    }
    @Override
        public String toString(){
        return super.toString() + "; TYPE: " + getType()+ seedOrNot +  "; PRICE: " +  getPrice(); 
    }
}
