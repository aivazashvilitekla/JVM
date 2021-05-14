package gau;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FamilyBudget {
    private int money;
    public String financialStatus;
    public void moneyChange(){
        try {
            FileWriter fw = new FileWriter("budget.txt", true);
            fw.write("update : money=" +money + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
        moneyChange();
    }
    public void changeMoney(int money) {
        this.money = money;
        moneyChange();
    }
    public void income(){
        financialStatus = money>40000? "Rich" : money>1000 && money<40000? "Middle":"Poor";
        System.out.println(financialStatus);
    }
}
