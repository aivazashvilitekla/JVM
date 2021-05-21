package gau;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread{
    Socket socket;
    ObjectOutputStream objectOutputStream;
    String message, message1;
    ObjectInputStream objectInputStream;
    Scanner scanner;
    static String IP;
    public void run(){
        try {
            scanner = new Scanner(System.in);
            System.out.println("ip:");
            IP = scanner.next();
            while(true){
                socket = new Socket(InetAddress.getByName(IP), 8080);
                scanner = new Scanner(System.in);
                System.out.print("Enter Client: ");
                message1 = scanner.nextLine();
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(message1);
                objectInputStream = new ObjectInputStream(socket.getInputStream());
                message = (String) objectInputStream.readObject();
                System.out.println("===Client===");
                System.out.println("Server:"+message);
                System.out.println(message1);
                if(message1.equals("bye")){
                    System.out.println(message1);
                    System.exit(0);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
