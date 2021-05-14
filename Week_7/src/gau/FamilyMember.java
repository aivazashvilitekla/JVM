package gau;

import java.io.FileWriter;
import java.io.IOException;

public class FamilyMember {
    private int age;
    private String name, lastName, status;

    public FamilyMember(int age, String name, String lastName, String status) {
        this.age = age;
        this.name = name;
        this.lastName = lastName;
        this.status = status;
    }
    public void addToFile(){
        try {
            FileWriter fw = new FileWriter("budget.txt", true);
            fw.write("age="+age+ "\n"+"name="+name+ "\n"+"lastname="+lastName+ "\n"+"status="+status + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getMoney(int m){
//        int money = fb.getMoney()>=m ? fb.getMoney() : 0;
//        String st = money>0? "თანხა მიღებულია" : "თანხის მიღება ვერ მოხდა";
//        System.out.println(st);
    }
}
