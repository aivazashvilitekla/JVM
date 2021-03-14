package inheritance1;

import java.util.Scanner;

public class A {
    protected int x;
    public A(){
        System.out.println("hello my a class");
    }
    public void m1(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("X->");
        x = scanner.nextInt();
    }
    public void m2(){
        System.out.print("X->"+x);
    }
    public void m3(){
        if (x%2==0)
            System.out.print("luwi");
        else
            System.out.println("kenti");
    }
}
