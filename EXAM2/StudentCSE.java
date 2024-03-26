/* Joy Kim
November 7, 2022
CSE007 Fall 2022 Participation 12
JDK 11 */
/* This program is intended to 
*/

public class StudentCSE { //student is the object we are creating
    //visible to entire program
    //typically has public or private modifiers - if you don't put it affects scope
    //your data fields in another class can be objects(?)
    //something that is not defined as static is instance - an instance is something that relates to a specific instance of that class
    
    //GLOBAL VARIABLES FOLLOW
    String name; // default null
    int age; // default 0
    boolean isCSMajor; // default false
    char pronoun; // ('t' for they, 'h' for he/him/his, 's' for she/her(s), and 'o' for other)
    String classLevel;
    static int totalEnrollment = 0; // # student objects you create
    static int totalCSEnrollment = 0; //only increase if someone declares major as cs
    //static members always invoked with class name - dont use instance of student class

    //in memory only one copy of each variable
    //something that is static - Math.random() - class name to invoke method

    /* Precondition: None; 
     * Postcondition: After this constructor executes, a Student object will 
     * be created in memory (the heap) and total enrollment will increase */
    public StudentCSE() {
        //any method called student in this class is a constructor
        classLevel = "First Year";
        totalEnrollment++;
    }

    public StudentCSE(String name, int age) {
        //overload constructor - create another for another variable of arguments
        //this(); --> have to use it bc the parameter has same identifier as variable (one is global)
        this.name = name; //local identifier name, global is this.name
        //dont need if variables don't have same name
        this.age = age;
        //only see it in method that is not static and refers to specfiic instance of class
        System.out.println(this.name);
        this.classLevel = "First Year";
        totalEnrollment++; //counter - increment in constructor
    }

    public void declareMajor(String major) {
        if (major.equals("CS")) {
            isCSMajor = true;
            //if they have same name or same identifier - use this.
            totalCSEnrollment++;//is static and related to class NOT instance of class (not specific student)
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
