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
        for(int j=0; j<14; j++){
            personArray.add(new Person());
        }
        //printa
        for(Person p:personArray){
            System.out.println(p);
        }

        //Del 4:
     /*   for(int i = 0; i<5; i++){
            System.out.println(new Student());
            System.out.println(new Person());
        }
*/

    }
}
