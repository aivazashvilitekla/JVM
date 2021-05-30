package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.*;
import java.util.Arrays;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationController extends Controller {
    private static final String regex = "^(.+)@(.+)$";
    Connection con;
    String SQL;
    ResultSet rs;
    byte[] hash;
    @FXML
    private TextField txtField_firstname;
    @FXML
    private TextField txtField_lastname;
    @FXML
    private TextField txtField_email;
    @FXML
    private PasswordField txtField_password;
    @FXML
    private Button btn_signUp;
    @FXML
    private TextField txtField_nm;
    @FXML
    private void save(){
        String fName = txtField_firstname.getText();
        String lName = txtField_lastname.getText();
        String email = txtField_email.getText();
        String pass = txtField_password.getText();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(fName!="" & lName!="" & email!="" & pass!=""){
            if(pass.length()>=8 & matcher.matches()){
                try {
                    con = sample.DBConnect.connect();
                    Statement st = con.createStatement();
                    pass = encrypt(pass, "ragaca");
                    String preInsert;
                    preInsert = "INSERT INTO users(firstname, lastname, email, password) VALUES(?,?,?,?)";

                    PreparedStatement statement = con.prepareStatement(preInsert);
                    statement.setString(1, fName);
                    statement.setString(2, lName);
                    statement.setString(3, email);
                    statement.setString(4, pass);
                    statement.executeUpdate();
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                    a.setContentText("ჩანაწერი წარმატებით შეინახა");
                    a.setTitle("წარმატება");
                    a.show();
                    access="yes";
                    Stage stage = (Stage) btn_signUp.getScene().getWindow();
                    stage.close();
                }catch (SQLException throwables) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("მოხდა შეცდომა");
                    a.show();
                    throwables.printStackTrace();
                }
            }else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("გთხოვთ შეავსეთ ყველა ველი მოთხოვნების შესაბამისად");
                a.show();
            }
        }else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("გთხოვთ შეავსეთ ყველა ველი");
            a.show();
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
//
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
//    }
}
