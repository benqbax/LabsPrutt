import java.util.ArrayList;
public class lab0 {
    public static void main(String[] args) {

        //Del 2:
        Person britt = new Person("Britt", 27);
        System.out.println("Britts ålder är: " + britt.getAge());
        System.out.println(britt);
        //2.3 man behöver inte anropa toString för det är en inbyggd funktion som vi overridar. Den kallas vid Sysprint.

        //Del 3:
        ArrayList<Person> personArray = new ArrayList<Person>();

        for(int j=0; j<16; j++){
            personArray.add(new Person());
        }
        //printa
        for(Person p:personArray){
            System.out.println(p);
        }

        //Del 4:
        ArrayList<Person> pandstudArray = new ArrayList<Person>();

      for(int i = 0; i<5; i++){
            pandstudArray.add(new Student());
            pandstudArray.add(new Person());
        }
        for(Person p:pandstudArray){
            System.out.println(p);
        }

    }
}
