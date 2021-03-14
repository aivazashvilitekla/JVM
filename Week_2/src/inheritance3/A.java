package inheritance3;

import java.util.Random;
import java.util.Scanner;

public class A {
    protected int x, y;
    public void setXY(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("X->");
        x = scanner.nextInt();
        System.out.print("Y->");
        y = scanner.nextInt();
    }
    public void setXYRandom(){
        Random rand = new Random();
        x = rand.nextInt(78 - 12) + 12;
        y = rand.nextInt(78 - 12) + 12;
    }
    public void printY(){
        System.out.println("Y="+y);
    }
}
