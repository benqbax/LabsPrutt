
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.*;
import javax.swing.text.*;

public class lab6 extends JFrame{
    private JTable table;
    private JScrollPane links;
    private JScrollPane webScroll;
    private Webreader webPane;
    private JTextField urlfield;
    private String url="";

    public lab6() {
        Container c = getContentPane();

        initGUI();
        c.add(links, BorderLayout.EAST);
        c.add(urlfield, BorderLayout.PAGE_START);
        c.add(webScroll, BorderLayout.CENTER);
        this.setSize(1000,500);
        this.setVisible(true);


    }

    void initGUI(){
        table = new JTable(50,2);
        links = new JScrollPane(table);
        webPane = new Webreader();
        urlfield = new JTextField();
        urlfield.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                url = e.getActionCommand();
                setUrlPage(url);
                setLinkTable(url);
            }
        });

        webScroll = new JScrollPane(webPane);


    }

    void setLinkTable(String url){
        Urlfinder links = new Urlfinder(url);
        String[][] matrix;
        matrix = links.getUrlMatrix();
        String[] header= {"WEBADRESS", "BENÄMNING"};
        if(matrix!=null){
            table.setModel(new DefaultTableModel(matrix, header));
        }
        else{
            table.setModel(new DefaultTableModel(new String[50][2], header));
        }

    }

    void setUrlPage(String url){
            webPane.showPage(url);
    }

    public static void main(String[] a){
        new lab6();
    }
}
