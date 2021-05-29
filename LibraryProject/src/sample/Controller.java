package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Book;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller {
    public static int id;
    public static String editable;
    Connection con;
    String SQL;
    ResultSet rs;

    @FXML
    private TableView<?> table = new TableView<>();
    @FXML
    private void fillTable() {
        table.getColumns().clear();
        table.getItems().clear();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("არჩევა");
        alert.setHeaderText("გთხოვთ აირჩიეთ მონაცემი");
        alert.setContentText("");
        ButtonType buttonTypeOne = new ButtonType("წიგნები");
        ButtonType buttonTypeTwo = new ButtonType("ავტორები");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo,buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        con = sample.DBConnect.connect();
        if (result.get() == buttonTypeOne){
            SQL = "SELECT * from book";
            editable="book";
            try {
                rs = con.createStatement().executeQuery(SQL);
                ArrayList<Book> ar = new ArrayList<>();
                for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                    TableColumn col = new TableColumn<>();
                    col.setText(rs.getMetaData().getColumnName(i+1));
                    col.setCellValueFactory(new PropertyValueFactory<>(rs.getMetaData().getColumnName(i+1)));
                    table.getColumns().add(col);
                }
                while (rs.next()){
                    ar.add(new Book(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("authorID"),
                            rs.getString("description"),
                            rs.getString("pages")
                    ));
                }
                ObservableList rows = FXCollections.observableArrayList(ar);
                table.setItems(rows);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else if (result.get() == buttonTypeTwo) {
            editable="author";
            SQL = "SELECT * from author";
            try {
                rs = con.createStatement().executeQuery(SQL);
                ArrayList<Author> ar = new ArrayList<>();
                for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                    TableColumn col = new TableColumn<>();
                    col.setText(rs.getMetaData().getColumnName(i+1));
                    col.setCellValueFactory(new PropertyValueFactory<>(rs.getMetaData().getColumnName(i+1)));
                    table.getColumns().add(col);
                }
                while (rs.next()){
                    ar.add(new Author(
                            rs.getInt("id"),
                            rs.getString("firstname"),
                            rs.getDate("birthday")
                    ));
                }
                ObservableList rows = FXCollections.observableArrayList(ar);
                table.setItems(rows);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    @FXML
    private void addNew(){
        if(editable==null){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("არჩევა");
            alert.setHeaderText("გთხოვთ აირჩიეთ მონაცემი");
            alert.setContentText("");
            ButtonType buttonTypeOne = new ButtonType("წიგნები");
            ButtonType buttonTypeTwo = new ButtonType("ავტორები");
            ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo,buttonTypeCancel);

            Optional<ButtonType> result = alert.showAndWait();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("addBook.fxml"));
                if (result.get() == buttonTypeOne){
                    root = FXMLLoader.load(getClass().getResource("addBook.fxml"));
                }else if (result.get() == buttonTypeTwo){
                    root = FXMLLoader.load(getClass().getResource("addAuthor.fxml"));
                }

                Stage stage = new Stage();
                stage.setTitle("ფორმა");
                stage.setScene(new Scene(root));
                stage.show();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                Parent root = FXMLLoader.load(getClass().getResource("addBook.fxml"));

                if (editable.equals("book")){
                    root = FXMLLoader.load(getClass().getResource("addBook.fxml"));
                }else if (editable.equals("author")){
                    root = FXMLLoader.load(getClass().getResource("addAuthor.fxml"));
                }
                Stage stage = new Stage();
                stage.setTitle("ფორმა");
                stage.setScene(new Scene(root));
                stage.show();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
    @FXML
    private void edit(){
        if (editable.equals("book")){
            Book r = (Book) table.getItems().get(table.getSelectionModel().getSelectedIndex());
            id = r.id;
        }else if (editable.equals("author")){
            Author r = (Author) table.getItems().get(table.getSelectionModel().getSelectedIndex());
            id = r.id;
        }


        addNew();
    }
    @FXML
    private void delete(){
        if (editable.equals("book")){
            Book r = (Book) table.getItems().get(table.getSelectionModel().getSelectedIndex());
            id = r.id;
            SQL = "delete from book where id = ?";
        }else if (editable.equals("author")){
            Author r = (Author) table.getItems().get(table.getSelectionModel().getSelectedIndex());
            id = r.id;
            SQL = "delete from author where id = ?";
        }
        if(id>=1){

            try {
                PreparedStatement preparedStmt = con.prepareStatement(SQL);
                preparedStmt.setInt(1, id);
                preparedStmt.execute();
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setContentText("ჩანაწერი წარმატებით წაიშალა");
                a.setTitle("წარმატება");
                a.show();
            } catch (SQLException throwables) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("მოხდა შეცდომა");
                a.setTitle("შეცდომა");
                a.show();
                throwables.printStackTrace();

            }
        }
    }
}
