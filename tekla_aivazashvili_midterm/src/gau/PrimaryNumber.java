package gau;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class PrimaryNumber {
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setNumber(){
        Random random = new Random();
        number = random.nextInt(200-100)+100;
        writeToFile();
    }
    public void writeToFile(){
        try {
            FileWriter fileWriter = new FileWriter("number1.txt", true);
            fileWriter.write(number+" ");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
