public class Student119 {
    private String name; // default null
    private int age; // default 0
    private boolean isCSMajor; // default false
    private char pronoun; // ('t' for they, 'h' for he/him/his, 's' for she/her(s), and 'o' for other)
    private String classLevel;
    private static int totalEnrollment = 0; // # student objects
    private static int totalCSEnrollment = 0;
    //variables not visible outside of class

    /* Precondition: None; 
     * Postcondition: After this constructor executes, a Student object will 
     * be created in memory (the heap) and total enrollment will increase */
    //data fields are private, methods public, and getter/setter(?) have to be there
    public Student119() {
        classLevel = "First Year";
        totalEnrollment++;
    }

    public Student119(String name, int age) {
        this.name = name;
        this.age = age;
        classLevel = "First Year";
        totalEnrollment++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getIsCSMajor() {
        return isCSMajor;
    }

    public char getPronoun() {
        return pronoun;
    }

    public static int getTotalEnrollment() {
        return totalEnrollment;
    }

    public static int getTotalCSEnrollment() {
        return totalCSEnrollment;
    }

    public void declareMajor(String major) {
        if (major.equals("CS")) {
            isCSMajor = true;
            totalCSEnrollment++;
        }
    }

    public void changePronoun(char pronoun) {
        if (pronoun == 't' || pronoun == 'h' || pronoun == 's' || pronoun == 'o') {
            this.pronoun = pronoun;
        } else {
            System.out.println("Invalid pronoun code");
        }
    }

    public void print() {
        System.out.println("Name: \tAge: \tClassLevel:");
        System.out.println(name + " \t " + age + " \t " + classLevel);
    }

}