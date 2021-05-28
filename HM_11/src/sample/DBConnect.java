package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static Connection con;
    private static String url = "jdbc:mysql://localhost:3306/realestate";
    private static String user = "root";
    private static String pass = "";

    public static Connection connect() {
        try {
            con = DriverManager.getConnection(url,user,pass);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return con;
    }
}
