package sample;

import java.awt.*;
import java.math.BigDecimal;
import java.math.MathContext;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public final class Controller extends Application{
    private BigDecimal left;
    private String selectedOperator;
    private boolean numberInputting;

    @FXML
    private TextField display;

    public Controller() {
        this.left = BigDecimal.ZERO;
        this.selectedOperator = "";
        this.numberInputting = false;
    }

    @Override
    public void start(Stage stage) throws Exception {
//        stage.setTitle("Calculator");
//        stage.setOnCloseRequest(x -> {
//            Platform.exit();
//        });
//        stage.setResizable(false);
//        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("sample.fxml"))));
//        stage.show();
    }

    @FXML
    protected void handleOnAnyButtonClicked(ActionEvent evt) {
        Button button = (Button)evt.getSource();
        final String buttonText = button.getText();
        if ( buttonText.equals("AC")) {
            left = BigDecimal.ZERO;
            selectedOperator = "";
            numberInputting = false;
            display.setText("0");;
            return;
        }
        if (buttonText.matches("[0-9\\.]")) {
            if (!numberInputting) {
                numberInputting = true;
                display.clear();
            }
            display.appendText(buttonText);
            return;
        }
        if (buttonText.matches("[＋－×÷%√^!]")) {
            if (buttonText.matches("[!]")){
                display.appendText("!");
            }
            left = new BigDecimal(display.getText().substring(0, display.getText().length()-1));
            selectedOperator = buttonText;
            numberInputting = false;
            return;
        }
        if (buttonText.matches("[log][ln]")) {
            left = new BigDecimal(display.getText());
            selectedOperator = buttonText;
            numberInputting = false;
            return;
        }
        if (buttonText.equals("=")) {
            final BigDecimal right = numberInputting ? new BigDecimal(display.getText()) : left;
            if(right!=left){
                left = calculate(selectedOperator, left, right);
            }else {
                left = calculate(selectedOperator, left);
            }


            display.setText(left.toString());
            numberInputting = false;
            return;
        }

    }
     static BigDecimal calculate(String operator, BigDecimal left) {
        switch (operator) {
            case "log":

                return new BigDecimal(10, MathContext.DECIMAL64);
            case "ln":
                return new BigDecimal(Math.log(left.doubleValue()), MathContext.DECIMAL64);
            case "!":
                double factorial =1;
//                BigDecimal factorial = new BigDecimal(1, MathContext.DECIMAL64);
                for (int i = 1; i <= left.intValue(); i++) {
                    factorial = factorial*i;
                }
                return new BigDecimal(factorial, MathContext.DECIMAL64);
            default:
        }
        return left;
    }
    static BigDecimal calculate(String operator, BigDecimal left, BigDecimal right) {
        switch (operator) {
            case "＋":
                return left.add(right);
            case "－":
                return left.subtract(right);
            case "×":
                return left.multiply(right);
            case "÷":
                return left.divide(right);
            case "%":
                return left.remainder(right);
            case "√":
                return left.sqrt(new MathContext(2));
            case "^":
                return left.pow(right.intValue());
            default:
        }
        return right;
    }

//    public static void main(String[] args) {
//        launch(args);
//    }
}
