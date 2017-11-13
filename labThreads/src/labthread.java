import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class labthread {
    public static void main(String[] v){
        try {
            Socket socket=new Socket("share-02.csc.kth.se",4713);
            BufferedReader in=new BufferedReader
                    (new InputStreamReader(socket.getInputStream()));
            PrintWriter ut=new PrintWriter(socket.getOutputStream());
            ut.println("Charlotta");
            ut.flush();
            System.out.println(in.readLine());

            ut.println("STEN");
            ut.flush();
            System.out.println(in.readLine());

            ut.println("SAX");
            ut.flush();
            System.out.println(in.readLine());

            ut.println("PASE");
            ut.flush();
            System.out.println(in.readLine());

            ut.println("");
            ut.flush();
            System.out.println(in.readLine());





        } catch (UnknownHostException e) {
            System.out.println("Ingen anslutning");
        } catch (IOException e) {
            System.out.println("Ingen anslutning");
        }
    }
}
