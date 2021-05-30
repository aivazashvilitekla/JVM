package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookController extends Controller implements Initializable {
    Connection con;
    String SQL;
    ResultSet rs;
    ObservableList authors = FXCollections.observableArrayList();
    @FXML
    private TextField txtField_name;
    @FXML
    private TextArea txtArea_desc;
    @FXML
    private TextField txtField_pages;
    @FXML
    private ComboBox<String> comboBox_author;
    @FXML
    private Button btn_saveBook;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillFields();
    }

    private void fillFields() {
        con = sample.DBConnect.connect();
        if(id>=1) {
            fillComboBox();
            SQL = "SELECT book.id, book.name, book.description,book.pages, author.firstname FROM book INNER JOIN author ON book.authorID = author.id where book.id=" + id;
            try {
                rs = con.createStatement().executeQuery(SQL);

                while (rs.next()) {
                    txtField_name.setText(rs.getString("name"));
                    txtArea_desc.setText(rs.getString("description"));
                    txtField_pages.setText(rs.getString("pages"));
                    comboBox_author.setValue(rs.getString("firstname"));


                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else {
            fillComboBox();
        }

    }

    private void fillComboBox() {
//        SQL = "SELECT DISTINCT author.firstname FROM book INNER JOIN author ON book.authorID = author.id";
        SQL = "SELECT DISTINCT author.firstname FROM author ";
        try {
            rs = con.createStatement().executeQuery(SQL);
            while (rs.next()){
                authors.add(rs.getString("firstname"));
            }
            comboBox_author.getItems().addAll(authors);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    private void save(){

        String name = txtField_name.getText();
        String author = comboBox_author.getValue();
        String desc = txtArea_desc.getText();
        String pages = txtField_pages.getText();
        if(name!="" & author!="" & pages!="" & desc!=""){
            try {
                Statement st = con.createStatement();
                String preInsert;
                if(id>=1){
                    preInsert = "UPDATE book SET name=?,authorID=(SELECT author.id FROM author WHERE author.firstname = '"+author+"') ,description=?, pages=? where id="+id;
                }else {
                    preInsert="INSERT INTO book (name, authorID,description, pages) SELECT  ?,author.id, ?, ?" +
                            "FROM    author WHERE author.firstname='"+author+"'";
                }
                PreparedStatement statement = con.prepareStatement(preInsert);
                statement.setString(1, name);
                statement.setString(2, desc);
                statement.setString(3, pages);
                statement.executeUpdate();
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setContentText("ჩანაწერი წარმატებით შეინახა");
                a.setTitle("წარმატება");
                a.show();
                Stage stage = (Stage) btn_saveBook.getScene().getWindow();
                stage.close();
            }catch (SQLException throwables) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("მოხდა შეცდომა");
                a.show();
                throwables.printStackTrace();
            }
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("გთხოვთ შეავსეთ ყველა ველი");
            a.show();
        }

    }

}
