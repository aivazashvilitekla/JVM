package gau;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server extends Thread{
    Socket socket;
    ObjectInputStream objectInputStream;
    String message;
    ObjectOutputStream objectOutputStream;
    public void run(){
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            while (true) {
                socket = serverSocket.accept();
                objectInputStream = new ObjectInputStream(socket.getInputStream());
                message = (String) objectInputStream.readObject();
                Scanner scanner = new Scanner(System.in);
                System.out.print("Server enter:");
                message = scanner.nextLine();
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(message);
                if(message.equals("bye")){
                    System.out.println("Bye");
                    System.exit(0);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
