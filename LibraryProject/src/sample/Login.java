package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

public class Login extends Controller {
    byte[] hash;
    Connection con;
    ResultSet rs;

    @FXML
    private TextField txtField_email;
    @FXML
    private TextField txtField_password;
    @FXML
    private Button btn_login;
    @FXML
    private void login(){
        String email = txtField_email.getText();
//        String pass = passHash(txtField_password.getText());
        String pass = txtField_password.getText();

        String encryptedString = encrypt(pass, "ragaca") ;
        try {
            con = sample.DBConnect.connect();
            Statement stmt = con.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("SELECT users.firstname FROM users WHERE users.email='"+email+"' AND users.password='"+encryptedString+"'");
            while (rs.next()){
                user = rs.getString("firstname");
            }
            if(user!=null){

                access="yes";

                Stage stage = (Stage) btn_login.getScene().getWindow();
                stage.close();
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setContentText("ოპერაცია წარმატებულია");
                a.show();
            }
            else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("მომხმარებელი ვერ მოიძებნა");
                a.show();
            }




        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    private static SecretKeySpec secretKey;
    private static byte[] key;

    public static void setKey(String myKey)
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    public static String encrypt(String strToEncrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

//    private String passHash(String pass) {


//        try {
//            SecureRandom random = new SecureRandom();
//            byte[] salt = new byte[16];
//            random.nextBytes(salt);
//            KeySpec spec = new PBEKeySpec(pass.toCharArray(), salt, 65536, 128);
//            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
//            hash = factory.generateSecret(spec).getEncoded();
//
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (InvalidKeySpecException e) {
//            e.printStackTrace();
//        }
//        return hash.toString();
    }
//}
