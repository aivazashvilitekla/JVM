package gau;

import java.io.FileWriter;
import java.io.*;
import java.util.Scanner;
import java.util.Random;
public class Task2 {
    public int n, num;
    public Task2(){
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        System.out.print("n->");
        n = scanner.nextInt();
        try {
            FileWriter fileWriter = new FileWriter("numbers.txt");
            for(int i=0; i<n; i++){
                num = rand.nextInt(23-(-12))+(-12);
                fileWriter.write(Integer.toString(num)+"\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Read File
        try {
            int sum = 0;
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader("numbers.txt"));
            String s;
            while ((s=bufferedReader.readLine())!=null){
                sum+=Integer.parseInt(s);
            }
            bufferedReader.close();
            System.out.println("Sum is " +sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
