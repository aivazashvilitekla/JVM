package gau;

import java.util.Random;

public class B extends A{
    private int y;
    Random rand = new Random();
    public B(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void setY(){
        y = rand.nextInt();
//        System.out.println("y="+y);
    }
    public int sumOfXY(){
        return x+y;
    }
}
