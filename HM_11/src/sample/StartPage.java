package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StartPage {
    public static int id;
    Connection con;
    String SQL;
    ResultSet rs;
    //constructor
    public StartPage(){
        con = DBConnect.connect();
        SQL = "SELECT * from info";
        try {
            rs = con.createStatement().executeQuery(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    private TableView<RealEstate> table = new TableView<>();
    @FXML
    public void getInfo(){
        ArrayList<RealEstate> ar = new ArrayList<>();
        try {
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                TableColumn col = new TableColumn<>();
                col.setText(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new PropertyValueFactory<>(rs.getMetaData().getColumnName(i+1)));
                table.getColumns().add(col);
            }
            while (rs.next()){
                ar.add(new RealEstate(
                        rs.getInt("id"),
                        rs.getString("dealType"),
                        rs.getString("location"),
                        rs.getString("district"),
                        rs.getString("propertyType"),
                        rs.getFloat("numberOfRooms"),
                        rs.getString("price"),
                        rs.getString("email"),
                        rs.getString("mobile"),
                        rs.getString("text")
                ));
            }
            ObservableList rows = FXCollections.observableArrayList(ar);
            table.setItems(rows);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @FXML
    public void addNew(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Stage stage = new Stage();
            stage.setTitle("ფორმა");
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void edit(){
        RealEstate r = table.getItems().get(table.getSelectionModel().getSelectedIndex());
        id = r.id;

        addNew();
    }
    @FXML
    public void delete(){

        id = table.getSelectionModel().getSelectedIndex()+1;
        if(id>=1){
            SQL = "delete from info where id = ?";
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
