public class Person {  //superclass
        
    private String name; 
    private String address;
    private String birthdate; //in the form: YYYYMMDD

    public Person(String name, String address, String birthdate) {
        this.name = name;
        this.address = address;
        this.birthdate = birthdate;
    }
    
    public Person() {
        this(null, null, null); //don't need to
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    @Override  //for each class
    public String toString(){
        String out = "Name: " + name + "; Address: " + address + "; Birthdate: " + birthdate;
        return out;
    }

    public void saySomething(){
        System.out.println("Hello, Person!");
    }
}
