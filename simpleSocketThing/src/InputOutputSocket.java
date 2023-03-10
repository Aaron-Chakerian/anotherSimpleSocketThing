import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/* Created by Aaron Chakerian
 * A simple socket class that takes care of the send/receive logic for servers and clients
 * 
 */

public class InputOutputSocket {
    private Socket s;
    private DataInputStream din;
    private DataOutputStream dout;
    private BufferedReader br;

    public InputOutputSocket(Socket s) throws Exception{
        this.s = s;
        din = new DataInputStream(s.getInputStream());
        dout = new DataOutputStream(s.getOutputStream());
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void send(String str) throws Exception{
        dout.writeUTF(str);
        dout.flush();
    }

    public String receive() throws Exception{
        return din.readUTF();
    }

    public void close() throws Exception{
        din.close();
        dout.close();
    }
}
