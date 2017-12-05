import javax.swing.*;
import javax.swing.text.ChangedCharSetException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Webreader extends JEditorPane {

    public Webreader() {
        this.setEditable(false);
    }

    void showPage(String webaddr) {
        try {
            this.setPage(webaddr);
        } catch (MalformedURLException e1) {
            this.setText("404 not found");

            JOptionPane.showMessageDialog(this, "Url is not ok");
        } catch(ChangedCharSetException c){
            c.printStackTrace();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Url is not ok");
        }
    }

}
