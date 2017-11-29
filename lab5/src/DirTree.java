import jdk.nashorn.internal.scripts.JO;
import org.jdom2.input.SAXBuilder;
import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.io.File;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;






public class DirTree extends TreeFrame {
    static Document document;

    // Overrides method in TreeFrame
    void initTree() {

        //creates a new root element for sax document
        Element rootElement = document.getRootElement();

        //variables for root text and level
        String rootText = rootElement.getText();
        String rootLevel = rootElement.getAttributeValue("namn");


        //creating the root node
        MyNode root = new MyNode(rootLevel, rootText);


        treeModel = new DefaultTreeModel( root );
        tree = new JTree( treeModel );

        //build the tree from the element and root
        buildTree(rootElement, root);
    }

    // New method
    private void buildTree(Element root, MyNode parent) {

        List<Element> children = root.getChildren();

        for(Element e: children){
            String text = e.getText();
            String level = e.getAttributeValue("namn");

            MyNode child = new MyNode(level, text);

            parent.add(child);
           if(e.getChildren()!=null){
               buildTree(e, child);
          }
        }

    }


    // Overrides method in TreeFrame
    void showDetails(TreePath p){
        if ( p == null ) return;

        MyNode node = (MyNode) p.getLastPathComponent();
        String test = node.getLeveln() + node.getText();

        if (p.getParentPath() != null) {

            test += "\nMen allt som";

            String parentPath = p.getParentPath().toString();
            String[] ar = parentPath.split(",");
            for(int i=ar.length; i>0; i--){
                MyNode n = (MyNode) p.getPathComponent(i);
                test += " är "+ n.getLeveln();
            }

            test += " är Liv";

        }

        JOptionPane.showMessageDialog(this, test);



    }

    // New method
    private String getAttributes( File f ) {
        return "";
    }

    public static void main(String[] args) {



        try {
            File inputFile = new File("src/Liv.xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            document = saxBuilder.build(inputFile);
        }  catch (Exception e) {
            e.printStackTrace();
        }

        new DirTree();
    }

}
