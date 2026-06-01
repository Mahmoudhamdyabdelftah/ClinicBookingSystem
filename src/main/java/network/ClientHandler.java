
package network;

import model.Patient;
import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream())) {

            Patient patient = (Patient) in.readObject();
            System.out.println("تم استقبال المريض: " + patient.getName());


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}