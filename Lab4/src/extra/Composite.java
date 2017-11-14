import java.util.ArrayList;


public class Composite extends Component {
    String name="";
    double weight;
    private ArrayList<Component> stuff;



    public Composite(String name, double weight) {
        this.name = name;
        this.weight = weight;
        stuff = new ArrayList<>();
    }

    @Override
    double getWeight() {

        double w = weight;
        for(Component c: stuff){
            w += c.getWeight();
        } return w;
    }

    @Override
    public String toString() {
       String n = name;
       for(Component c: stuff){
           n += " " + c.toString();
       } return n;
    }

    public void add(Component f){
        stuff.add(f);
    }
    public void remove(Component f){
        stuff.remove(f);
    }





}
