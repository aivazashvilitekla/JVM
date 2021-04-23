package gau;

import java.util.Random;

public class SubtractNumber  implements Runnable{
    int primaryNumber, num;
    public SubtractNumber(int number){
        primaryNumber = number;
    }
    public void subtractNum(){
        Random random = new Random();
        PrimaryNumber obj1 = new PrimaryNumber();
        num = obj1.getNumber();
        if(num>=60){
            num-=random.nextInt(60-50)+50;
            obj1.setNumber(num);
        }
    }

    @Override
    public void run() {
       for (int i=0; i<5; i++){
           subtractNum();
       }
    }
}
