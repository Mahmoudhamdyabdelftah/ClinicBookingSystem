
package network;

import model.Patient;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class NetworkClient {
    public void sendPatientToServer(Patient patient) {

        try (Socket socket = new Socket("localhost", 5000);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {


            out.writeObject(patient);
            out.flush();
            System.out.println("تم إرسال بيانات المريض للسيرفر بنجاح!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}