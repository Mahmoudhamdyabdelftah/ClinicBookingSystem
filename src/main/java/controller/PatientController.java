package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Patient;
import network.NetworkClient;

public class PatientController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField phoneField;

    @FXML
    public void addPatient() {
        // 1. التحقق من المدخلات (Edge cases)[span_1](start_span)[span_1](end_span)
        if (nameField.getText().isEmpty() || phoneField.getText().isEmpty()) {
            showAlert("خطأ", "الرجاء إدخال اسم المريض ورقم التليفون.");
            return;
        }

        Patient newPatient = new Patient(1, nameField.getText(), phoneField.getText(), "No history");

        // 2. إرسال البيانات في Thread منفصل عشان الـ GUI ميفصلش[span_2](start_span)[span_2](end_span)
        new Thread(() -> {
            try {
                NetworkClient client = new NetworkClient();
                client.sendPatientToServer(newPatient);

                // تحديث الـ GUI لازم يتم من خلال Platform.runLater[span_3](start_span)[span_3](end_span)
                javafx.application.Platform.runLater(() ->
                        showAlert("نجاح", "تم حفظ المريض وإرساله للسيرفر بنجاح!"));
            } catch (Exception e) {
                javafx.application.Platform.runLater(() ->
                        showAlert("خطأ", "فشل الاتصال بالسيرفر: " + e.getMessage()));
            }
        }).start();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

