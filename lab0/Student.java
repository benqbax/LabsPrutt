
public class Student extends Person {
    private int year;

    public Student(String nameIn, int ageIn, int year) {
        super(nameIn, ageIn);
        this.year = year;
    }
    //* ger slumpmässig data till student */
    public Student(){
        this.year = (int) (Math.random()* (2016-1934) + 1934);
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return super.toString() + ", började på CMETE " +  getYear();
    }
}
