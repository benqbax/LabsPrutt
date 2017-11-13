import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsBoard extends JFrame implements ActionListener{
    @Override
    public String getName() {
        return name;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    private String name, host, port;
    private JLabel nameLabel, hostLabel, portLabel, connectionMessage;
    private JTextField nameTextField, hostTextField, portTextField;
    private JButton connect;

    SettingsBoard(){
        setUpBoard();
        name = "Test";
        host="localhost";
        port = "4713";
    }

    void setUpBoard(){
        setLayout(new GridLayout(4,1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nameLabel = new JLabel("Name");
        nameTextField = new JTextField(20);

        hostLabel = new JLabel("Host");
        hostTextField = new JTextField(20);

        portLabel = new JLabel("Port");
        portTextField = new JTextField(20);


        JPanel namePanel = new JPanel();
        namePanel.add(nameLabel);
        namePanel.add(nameTextField);


        JPanel hostPanel = new JPanel();
        hostPanel.add(hostLabel);
        hostPanel.add(hostTextField);

        JPanel portPanel = new JPanel();
        portPanel.add(portLabel);
        portPanel.add(portTextField);


        add(namePanel);
        add(hostPanel);
        add(portPanel);


        connectionMessage = new JLabel("");

        connect = new JButton("Connect");
        connect.addActionListener(this);
        add(connect);
        add(connectionMessage);
        setVisible(true);
        pack();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        name = nameTextField.getText();
        host = hostTextField.getText();
        port= portTextField.getText();

        System.out.println(name);
    }
}
