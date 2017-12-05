import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.html.*;
import javax.swing.text.*;


public class Prototype extends JFrame {

    private JTable table;
    private JScrollPane links;
    private JEditorPane webPane;
    private JTextField urlfield;

    public Prototype() {
        Container c = getContentPane();

        initGUI();
        c.add(links, BorderLayout.EAST);
        c.add(urlfield, BorderLayout.PAGE_START);
        c.add(webPane, BorderLayout.CENTER);
        c.setSize(1500,500);
        setVisible(true);

    }

    void initGUI(){
        table = new JTable(50,2);
        links = new JScrollPane(table);
        webPane = new JEditorPane();
        urlfield = new JTextField();

    }

    public static void main(String[] a){
        new Prototype();
    }
}
