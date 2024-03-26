public class LehighPerson extends Person { //subclass
    private String lin;
    private String email;

    public LehighPerson(String lin, String email, String name, String address, String birthdate) {
        super(name, address, birthdate);
        this.lin = lin;
        this.email = email;
        
    }
    public LehighPerson(String lin, String email){
        super(null,null,null); // not necessary
        this.lin=lin;
        this.email=email;
    }

    public LehighPerson() {
        super();
        //default call to super()
    }

    public String getLin() {
        return lin;
    }

    public void setLin(String lin) {
        this.lin = lin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override  //for each class
    public String toString(){
        String out = super.toString() + "\n\tLIN: " + lin + "; Email: " + email; //super.toString refers to person
        return out;
    }

    @Override
    public void saySomething(){ //redefining from person.java
        System.out.println("Beat Lafayette!");
    }
}
