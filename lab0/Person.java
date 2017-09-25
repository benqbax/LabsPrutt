
public class Person {

    private String nameIn;
    private int ageIn;

    //detta fält ska vara static för att det är inget vi ska ändra på, det ska bara finnas ett nameArray för alla Persons.
    private static String[] nameArray = {"Peter",
                                    "Nils",
                                    "Ben",
                                    "Oscar",
                                    "Emil",
                                    "Micke",
                                    "Kalle", "Diba", "Veronica","Kasper", "Olivia", "Jason", "Gabriella"};

    public Person(String nameIn, int ageIn) {
        this.nameIn = nameIn;
        this.ageIn = ageIn;
    }

    /** 3.1 constructor for a randomized name*/
    public Person(){
        this.ageIn = (int) (Math.random() * (100-15)) + 15;
        int index = (int) (Math.random() * this.nameArray.length);
        this.nameIn = nameArray[index];
    }

    public String getName() {
        return nameIn;
    }

    public void setName(String nameIn) {
        this.nameIn = nameIn;
    }

    public int getAge() {
        return ageIn;
    }

    public void setAge(int ageIn) {
        this.ageIn = ageIn;
    }

    @Override
    public String toString() {
        return
                "Namn: " + this.nameIn + ", ålder=" + this.ageIn;
    }

    public static String[] getNameArray() {
        return nameArray;
    }

}
