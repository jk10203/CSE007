public class PersonInheritance {
    public static void main(String[]args){
        //create, person, lehighperson, student
        Person p = new Person("Doug", "123 Main St", "April 4, 2021"); 
        LehighPerson lp = new LehighPerson("813104117", "dak123@lehigh.edu");
        Student s = new Student("111111111", "123dak@lehigh.edu");
        
        s.setName("Amelia"); //SHOWS inheritance
        p.saySomething();
        lp.saySomething();

        System.out.println(p);
        System.out.println(lp);
        System.out.println(s);

        //practice calling, testing

    }
}
