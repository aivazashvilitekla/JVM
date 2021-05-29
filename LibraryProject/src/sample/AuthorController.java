package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class AuthorController extends Controller implements Initializable {
    Connection con;
    String SQL;
    ResultSet rs;
    @FXML
    private TextField txtField_firstname;
    @FXML
    private DatePicker dtPicker;
    Timestamp timestamp;
    @FXML
    private Button btn_saveAuthor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        con = sample.DBConnect.connect();
        if(id>=1){
            fillFields();
        }
    }

    private void fillFields() {

        SQL = "SELECT * from author where author.id=" + id;
        try {
            rs = con.createStatement().executeQuery(SQL);

            while (rs.next()) {
                txtField_firstname.setText(rs.getString("firstname"));
                timestamp = rs.getTimestamp("birthday");
                dtPicker.setValue(timestamp.toLocalDateTime().toLocalDate());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @FXML
    private void save() {
        try {
            Statement st = con.createStatement();
            String preInsert;
            if(id>=1){
                preInsert = "UPDATE author SET firstname=?,birthday=? where id="+id;
            }else {
                preInsert="INSERT INTO author (firstname, birthday) VALUES(?, ?)";
            }
            PreparedStatement statement = con.prepareStatement(preInsert);
            statement.setString(1, txtField_firstname.getText());
            statement.setString(2, dtPicker.getValue().toString());
            statement.executeUpdate();
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setContentText("ჩანაწერი წარმატებით შეინახა");
            a.setTitle("წარმატება");
            a.show();
            Stage stage = (Stage) btn_saveAuthor.getScene().getWindow();
            stage.close();
        }catch (SQLException throwables) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("მოხდა შეცდომა");
            a.show();
            throwables.printStackTrace();
        }
    }
}
