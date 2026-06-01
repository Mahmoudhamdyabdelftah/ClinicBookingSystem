package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClinicServer {
    public static void main(String[] args) {
        int port = 5000;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("السيرفر شغال وبيستقبل مرضى على بورت " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("عميل جديد اتصل!");

                ClientHandler handler = new ClientHandler(clientSocket);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}