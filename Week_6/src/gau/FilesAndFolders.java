package gau;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FilesAndFolders {
    public void createFileAndFolder(){
//        File f = new File("File.txt");
        File f = new File("JavaFolder");
        f.mkdir();
//        try {
//            f.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    public void writeIntoFiles(){
        try {
            FileWriter fileWriter = new FileWriter("JavaFolder/text1.txt");
            fileWriter.write("hbhubfhubfur");
            fileWriter.close();
        }catch (IOException e) {
            e.printStackTrace();
        }


    }
}
