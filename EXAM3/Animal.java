public class Animal{
    double height;
    double weight;
    public Animal(){
        this(0,0);
        //System.out.println("In Animal -- No Arg Constructor");
    }
    public Animal (double height, double weight){
        this.height = height;
        this.weight = weight;
        //System.out.println("In Animal -- 2-Arg Constructor");
    }
    public double getHeight(){
        return height;
    }
    public double getWeight(){
        return weight;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }
    public void eat(){
        System.out.println("Nom Nom Nom");}
    
    public String getType(){
        return "Animal";
    }
    public String toString(){
        return "Type: " + getType() + "; height: " + getHeight() + "; weight: " + getWeight();
    }
    //@Override
    
 }
 
 class Dog extends Animal{
    String breed;
    public Dog(){
        breed = "";
        //System.out.println("In Dog -- No Arg Constructor");
    }
    public Dog(double height, double weight, String breed){
        super(height, weight);
        this.breed = breed;
       // System.out.println("In Dog -- 3-Arg Constructor");
    }
    public void bark(){
        System.out.println("Woof!");
    }
    public void bark(int n){
        for(int i=0; i<n; i++){
            this.bark();}
    }
    public String getBreed(){
        return breed;
    }
    public void setBreed(String breed){
        this.breed= breed;
    }
    @Override
    public void eat(){
        System.out.println("Who wants a treat?!");}
  
    public void play(){
        System.out.println("Let's play fetch!");}
    public String getType(){
        return "Dog";
    }
    public String toString(){
        return super.toString() + "; breed: " + getBreed();
    }
 }

 class RescueDog extends Dog{
    String gotchaDate;
    public RescueDog(){
        super();
        gotchaDate = "N/A";
        //System.out.println("In RescueDog -- No Arg Constructor");
    }
    public RescueDog(String gotchaDate, String breed){
        super.breed=breed;
        this.gotchaDate = gotchaDate;
    }
    public RescueDog(double height, double weight ,String gotchaDate, String breed){
        super(height, weight, breed);
        this.gotchaDate=gotchaDate;
        //System.out.println("In RescueDog -- 2-Arg Constructor");
    }
    public String getGotchaDate(){
        return gotchaDate;
    }
    public void setGotchaDate(String gotchaDate){
        this.gotchaDate= gotchaDate;
    }
    @Override
    public void eat(){
        super.eat();
        System.out.println("Give me a bone!"); }
    public String getType(){
        return "Rescue Dog";
    }
    public String toString(){
        return super.toString()+ "; gotacha date: " + getGotchaDate();
    }
    
 }
class PracticeComp{
    public static void main(String[]args){
        Dog lady = new Dog();
        RescueDog amelia = new RescueDog("03202020","mutt");
        Animal doug = new Dog(32.3, 75, "Labrador");
 
    }
 }
 
