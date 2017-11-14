public class Leaf extends Component {
    String name;
    double weight;

    public Leaf(String name, double weight) {
        this.name = name;
        this.weight = weight;

    }

    @Override
    double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name;
    }
}
