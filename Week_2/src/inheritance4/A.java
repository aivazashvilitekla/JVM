package inheritance4;

import java.util.Random;
import java.util.Scanner;

public class A {
    protected double x, y;
    public void setXY(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("X->");
        x = scanner.nextInt();
        System.out.print("Y->");
        y = scanner.nextInt();
    }
    public void setXYRandom(){
        Random rand = new Random();
        x = rand.nextInt(12);
        y = rand.nextInt(12);
    }
    public void printF(){
        System.out.println((y-3*x)/3);
    }
}
