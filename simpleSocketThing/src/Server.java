/* Created by Aaron Chakerian
 * A simple client class that will be used to send/receive messages to client
 * in addition to the Client class it also runs the ServerSocket
 * 
 */
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    private ServerSocket ss;
    InputOutputSocket server;

    public static void main(String[] args) throws Exception{
        Server c = new Server("localhost", 50000);
        c.getInputOutputSocket().send("Hello");
        System.out.println(c.getInputOutputSocket().receive());

        c.close();
    }
    public Server(String address, int port) throws Exception{
        ss = new ServerSocket(port);
        Socket s = ss.accept();
        server = new InputOutputSocket(s);
        System.out.println();
    }

    public InputOutputSocket getInputOutputSocket(){
        return server;
    }

    public void close() throws Exception{
        this.server.close();
    }
}