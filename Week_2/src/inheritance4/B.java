package inheritance4;

import java.util.Random;
import java.util.Scanner;

public class B extends A{
    private double a, b;
    public void setAB(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("A->");
        a = scanner.nextInt();
        System.out.print("B->");
        b = scanner.nextInt();
    }
    public void swap(){
        if (a>b){
            a = a+b;
            b = a-b;
            a = a-b;
        }
    }
    public void ran(){
        Random rand = new Random();
        x = rand.nextInt((int) (b-a))+a;
    }
}
