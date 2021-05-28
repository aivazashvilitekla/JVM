package gau;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String url = "jdbc:mysql://localhost:3306/java2021";
        try {
            Connection con = DriverManager.getConnection(url, "root", "");
//            Statement st = con.createStatement();
//            String insert = "INSERT INTO users(name, lastname,age) " +
//                    "VALUES('tekla', 'aaa', 20)";
//            st.executeUpdate(insert);
//            String preInsert = "INSERT INTO users(name, lastname,age) " +
//                    "VALUES(?, ?, ?)";
//            PreparedStatement statement = con.prepareStatement(preInsert);
//            statement.setString(1, "Nat");
//            statement.setString(2, "Bat");
//            statement.setInt(3, 16);
//            statement.executeUpdate();
            String query = "select * from users";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                int age = rs.getInt("age");
                System.out.println(id+" "+name + " " + lastname + " " + age);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
