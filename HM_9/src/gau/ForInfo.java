package gau;

import java.io.FileWriter;
import java.io.IOException;

public class ForInfo {
    public ForInfo(){
        try {
            FileWriter fileWriter = new FileWriter("info.txt");
            fileWriter.write("----\nhelp - getting help");
            fileWriter.write("\n----\ndate - getting date");
            fileWriter.write("\n----\nname - getting name");
            fileWriter.write("\n----\nerror - getting error");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
