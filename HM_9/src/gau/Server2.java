package gau;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 extends Thread{
    Socket socket;
    ObjectInputStream objectInputStream;
    String message;
    ObjectOutputStream objectOutputStream;
    public void run(){
        try {
            ServerSocket serverSocket = new ServerSocket(8081);
            while (true) {
                socket = serverSocket.accept();
                objectInputStream = new ObjectInputStream(socket.getInputStream());
                message = (String) objectInputStream.readObject();
//                System.out.println("msg - " + message);
//                Scanner scanner = new Scanner(System.in);
//                System.out.print("Server enter:");
//                message = scanner.nextLine();
                message = getText(message);
//                System.out.println("mmmm:"+message);

//                switch (message){
//                    case "hi":
//                        message = "HI";
//                    case "help":
//                    case "date":
//                    case "name":
//                    case "error":
//                        message = getText(message);
//                    case "bye":
//                        System.out.println("Bye");
//                        System.exit(0);
//                    default:
//                        System.out.println("Waiting for your command...");
//                }
//                if(message.equals("help")){
//
//                }else if(message.equals("date")){
//
//                }else if(message.equals("name")){
//
//                }else if(message.equals("error")){
//
//                }else{
//
//                }
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(message);
                System.out.println(message);
                if(message.equals("bye")){
                    System.out.println("Bye");
                    System.exit(0);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public String getText(String command){
        String line2 = "";
        try {
            File file = new File("info.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
//            StringBuffer sb = new StringBuffer();

            String line ;
            while((line=br.readLine())!=null)
            {

                if(line.substring(0,message.length()).equals(command)){
//                    line2 = line.substring(message.length()+3);
                }
            }

            fr.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return line2;
    }
}
