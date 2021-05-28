package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller extends StartPage implements Initializable {

    ObservableList dealTypes = FXCollections.observableArrayList();
    ObservableList locations = FXCollections.observableArrayList();
    ObservableList districts = FXCollections.observableArrayList();
    ObservableList propertyTypes = FXCollections.observableArrayList();
    @FXML
    private TextField txtField_price;
    @FXML
    private TextField textField_email;
    @FXML
    private TextField textField_mobile;
    @FXML
    private TextArea txtArea_anText;
    @FXML
    private ChoiceBox<String> choiceBox_dealType;
    @FXML
    private ChoiceBox<String> choiceBox_location;
    @FXML
    private ChoiceBox<String> choiceBox_district;
    @FXML
    private ChoiceBox<String> choiceBox_propertyType;
    @FXML
    private ToggleGroup rbRooms;
    @FXML
    private RadioButton rb1, rb2, rb3, rb4, rb5, rb6, rb7;
    @FXML
    private Button btn_send;
    Connection con;
    String SQL;
    ResultSet rs;

    public void saveInfo(){
        String dealType = choiceBox_dealType.getValue();
        String location = choiceBox_location.getValue();
        String district = choiceBox_district.getValue();
        String propertyType = choiceBox_propertyType.getValue();
        float rooms = Float.parseFloat(((RadioButton)rbRooms.getSelectedToggle()).getText());
        String price = txtField_price.getText();
        String email = textField_email.getText();
        String mobile = textField_mobile.getText();
        String text = txtArea_anText.getText();
        try {
            Statement st = con.createStatement();
            String preInsert;
            if(id>=1){
                preInsert = "UPDATE info SET dealType=?, location=?,district=?, propertyType=?, numberOfRooms=?, price=?, email=?, mobile=?, text=? " +
                        "where id="+id;
            }else {
                preInsert = "INSERT INTO info(dealType, location,district, propertyType, numberOfRooms, price, email, mobile, text) " +
                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            }

            PreparedStatement statement = con.prepareStatement(preInsert);
            statement.setString(1, dealType);
            statement.setString(2, location);
            statement.setString(3, district);
            statement.setString(4, propertyType);
            statement.setFloat(5, rooms);
            statement.setString(6, price);
            statement.setString(7, email);
            statement.setString(8, mobile);
            statement.setString(9, text);
            statement.executeUpdate();
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setContentText("ჩანაწერი წარმატებით შეინახა");
            a.setTitle("წარმატება");
            a.show();
            if(id>=1){
                Stage stage = (Stage) btn_send.getScene().getWindow();
                stage.close();
            }
        } catch (SQLException throwables) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("მოხდა შეცდომა");
            a.show();
            throwables.printStackTrace();
        }


    }

    private void clearFields() {
        choiceBox_dealType.getSelectionModel().clearSelection();
        choiceBox_location.getSelectionModel().clearSelection();
        choiceBox_district.getSelectionModel().clearSelection();
        choiceBox_propertyType.getSelectionModel().clearSelection();
        rbRooms.getSelectedToggle().setSelected(false);
        txtField_price.setText("");
        textField_email.setText("");
        textField_mobile.setText("");
        txtArea_anText.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();
    }
    public void loadData(){
        con = DBConnect.connect();
        if(id>=1){
            fillChoiceBoxes();
            SQL = "SELECT * from info where id="+id;
            try {
                rs = con.createStatement().executeQuery(SQL);

                while (rs.next()){
                    choiceBox_dealType.setValue(rs.getString("dealType"));
                    choiceBox_location.setValue(rs.getString("location"));
                    choiceBox_district.setValue(rs.getString("district"));
                    choiceBox_propertyType.setValue(rs.getString("propertyType"));
                    float rooms = rs.getFloat("numberOfRooms");
                    switch (rooms+""){
                        case "1.0":
                            rb1.setSelected(true);
                        case "1.5":
                            rb2.setSelected(true);
                        case "2.0":
                            rb3.setSelected(true);
                        case "2.5":
                            rb4.setSelected(true);
                        case "3":
                            rb5.setSelected(true);
                        case "4":
                            rb6.setSelected(true);
                        case "5":
                            rb7.setSelected(true);
                        default:
                    }
                    txtField_price.setText(rs.getString("price"));
                    textField_email.setText(rs.getString("email"));
                    textField_mobile.setText(rs.getString("mobile"));
                    txtArea_anText.setText(rs.getString("text"));

                }
                fillChoiceBoxes();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else {
            fillChoiceBoxes();
        }

    }

    private void fillChoiceBoxes() {
        SQL = "SELECT DISTINCT dealType, location, district, propertyType from info";
        try {
            rs = con.createStatement().executeQuery(SQL);
            while (rs.next()){
                dealTypes.add(rs.getString("dealType"));
                locations.add(rs.getString("location"));
                districts.add(rs.getString("district"));
                propertyTypes.add(rs.getString("propertyType"));
            }
            choiceBox_dealType.getItems().addAll(dealTypes);
            choiceBox_location.getItems().addAll(locations);
            choiceBox_district.getItems().addAll(districts);
            choiceBox_propertyType.getItems().addAll(propertyTypes);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
