public class StudentTest {
    public static void main(String[] args) {
        System.out.println("Before creating any students:");
        System.out.println("Current Enrollment: " + Student.totalEnrollment);
        Student student0 = new Student();
        System.out.println("Current Enrollment: " + Student.totalEnrollment);
        Student student1 = new Student("Amelia", 18); //the 2 argument version being invoked
        System.out.println("Current Enrollment: " + Student.totalEnrollment);
        Student student2 = new Student("Amanda", 22);
        System.out.println("Current Enrollment: " + Student.totalEnrollment);
        
        student0.name="Anshika"; 
        student0.age = 20;
        student1.changePronoun('t');
        student2.declareMajor("CS");

        System.out.println(student0); //just like printing an array var reference (prints memory location)
        student0.print(); //prints out Name: Age: ClassLevel: etc
        System.out.println(student1);
        student1.print();
        System.out.println(student2);
        student2.print();

        student1 = student2; // think arrays; student1 instance becomes garbage, 
                            //student1 variable now points to student2 object
        System.out.println("After student1=student2");
        System.out.println(student0);
        student0.print();
        System.out.println(student1);
        student1.print();
        System.out.println(student2);
        student2.print();
    }
}

