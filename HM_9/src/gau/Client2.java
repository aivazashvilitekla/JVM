package gau;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client2 extends Thread{
    Socket socket;
    ObjectOutputStream objectOutputStream;
    String message, message1;
    ObjectInputStream objectInputStream;
    Scanner scanner;
    public void run(){
        try {
            while(true){
                socket = new Socket(InetAddress.getByName("localhost"), 8081);
                scanner = new Scanner(System.in);
                System.out.print("Client: ");
                message1 = scanner.nextLine();
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(message1);
                objectInputStream = new ObjectInputStream(socket.getInputStream());
                message = (String) objectInputStream.readObject();
//                System.out.println("Server:"+message);
//                System.out.println(message1);
//                if(message1.equals("bye")){
//                    System.out.println(message1);
//                    System.exit(0);
//                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
