package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Calculator");
//        primaryStage.setScene(new Scene(root));
//        primaryStage.show();

        primaryStage.setTitle("Calculator");
        primaryStage.setOnCloseRequest(x -> {
            Platform.exit();
        });
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
//        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("sample.fxml"))));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
