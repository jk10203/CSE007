public class StudentTest2{
    public static void main(String[] args) {
        //had to change student to student119 to differentiate between the 2 student java files
    System.out.println("Before creating any students:");
    System.out.println("Current Enrollment: " + Student119.getTotalEnrollment());
    Student119[] roster = new Student119[3];
    System.out.println("Current Enrollment: " + Student119.getTotalEnrollment());
    roster[0] = new Student119("Hector", 20);
    roster[1] = new Student119("Aparna", 18);
    roster[2] = new Student119();
    System.out.println("Current Enrollment: " + Student119.getTotalEnrollment());
    System.out.println("Current CSEnrollment: " + Student119.getTotalCSEnrollment());
    roster[2].setName("Chelsea");
    roster[2].setAge(18);
    roster[1].changePronoun('t');
    for(int i =0; i<roster.length; i++){
    roster[i].declareMajor("CS");
    }
    System.out.println("Current CSEnrollment: " + Student119.getTotalCSEnrollment());
    System.out.println(roster[0]); //memory @abc
    System.out.println(roster[0].getName());
    roster[0].print();
    System.out.println(roster[1]);//memory @def
    roster[1].print();
    roster[0] = roster[1]; //roster[0] points to def (holds SAME reference) / refers to same instance of class
    System.out.println(roster[0]);
    roster[0].print();
    System.out.println(roster[1]);
    roster[1].print();
   
    }
   }