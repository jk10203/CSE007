public class Student extends LehighPerson{
    
    private String major;
    private String anticipatedGradDate;
    private static int totalCSEnrollment=0; //bc static, getter method has to be static
    
    public Student(){
        super();
    }
    public Student(String lin, String email){
        //super(null, null, null);
        super(lin,email);
        //super.setLin(lin);
        //super.setEmail(email);
        
    }
    public Student(String name, String address, String birthdate, String lin, String email){
        super(lin,email,name,address, birthdate);
    }
    public String getMajor(){
        return major;
    }
    public String getAnticipatedGradDate(){
        return anticipatedGradDate;
    }
    public void setMajor(String major){
        this.major = major;
    }
    public void setAnticipatedGradDate(String anticipatedGradDate){
        this.anticipatedGradDate = anticipatedGradDate; //don't have to do this. (never do this. for static)
    }
    public static int getTotalCSEnrollment(){
        return totalCSEnrollment;
    }
    @Override  //for each class
    public String toString(){
        String out = super.toString() + "\n\tMajor: " + major + "; Grad Date: " + anticipatedGradDate; //name,address,birthdate, then major, grad
        return out;
    }

    @Override
    public void saySomething(){ //redefining from person.java
        System.out.println("Class registration is the worst");
    }
}

