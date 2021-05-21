package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    public Label label1;
    @FXML
    public TextField input;

    public void method(){
        System.out.println("java fx");
        String t = input.getText();
        label1.setText(t);

    }

}
