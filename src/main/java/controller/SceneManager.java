package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class SceneManager {
    public static void switchScene(String fxmlFile, Stage stage) throws Exception {

        Parent root = FXMLLoader.load(Objects.requireNonNull(SceneManager.class.getResource("/fxml/" + fxmlFile)));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
