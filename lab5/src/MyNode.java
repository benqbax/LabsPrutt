import javax.swing.tree.DefaultMutableTreeNode;

public class MyNode extends DefaultMutableTreeNode {
    private final String level;
    private final String text;

    public MyNode(String level, String text) {
        super(level);
        this.level = level;
        this.text = text;
    }

    public String getLeveln() {
        return level;
    }

    public String getText() {
        return text;
    }
}
