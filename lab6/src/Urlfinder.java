import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.ChangedCharSetException;
import javax.swing.text.Element;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class Urlfinder {
    InputStream in;
    InputStreamReader reader;
    HTMLEditorKit editorKit;
    HTMLDocument doc;

    public Urlfinder(String url){
        String webpage=url;
        in= null;
        try {

            in = new URL(webpage).openConnection().getInputStream();
            reader= new InputStreamReader(in, "ISO-8859-1");
            doc = new HTMLDocument();
            editorKit = new HTMLEditorKit();
            doc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
            editorKit.read(reader,doc,0);

        } catch (ChangedCharSetException h){
            h.printStackTrace();
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BadLocationException e) {
            e.printStackTrace();
        }


    }

    public String[][] getUrlMatrix(){
        String[][] matrix = new String[50][2];
        String value = "";
        int count=0;
        if(doc==null){
            return null;
        }

        for (HTMLDocument.Iterator iter = doc.getIterator(HTML.Tag.A); iter.isValid(); iter.next()) {
            if(count>49){ return matrix; }
            AttributeSet attributes = iter.getAttributes();
            String link = (String) attributes.getAttribute(HTML.Attribute.HREF);
            int start = iter.getStartOffset();
            int end = iter.getEndOffset();
            int length = end - start;

            try {
                value = doc.getText(start, length);
                matrix[count][0]=link;
                matrix[count][1]=value;
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
            count++;
        }
        return matrix;


    }

}
