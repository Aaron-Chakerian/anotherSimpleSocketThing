/* Created by Aaron Chakerian
 * A simple client class that will be used to send/receive messages to server
 * 
 */

import java.net.Socket;

public class Client {
    InputOutputSocket client;
        public static void main(String[] args) throws Exception{
            Client c = new Client("localhost", 50000);
            System.out.println(c.client.receive());
            c.getInputOutputSocket().send("G'day");
            System.out.println("Client received: " + c.getInputOutputSocket().receive());
    }

    public Client(String address, int port) throws Exception{
        client = new InputOutputSocket(new Socket(address, port));
        System.out.println("Server Started");

    }

    public InputOutputSocket getInputOutputSocket(){
        return client;
    }

    public void close() throws Exception{
        this.client.close();
    }
}
