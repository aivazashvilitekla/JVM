package gau;

import java.util.Scanner;

public class A {
    protected int x;
    Scanner scanner = new Scanner(System.in);
    public A(){
        System.out.println("Hello A");
    }

    public void setX() {
        System.out.print("X->");
        x = scanner.nextInt();
    }
    public void m2(){
        System.out.println(x+12);
    }
    public void m3(){
        if(x%2==0) System.out.println("ლუწი");
        else System.out.println("კენტი");
    }
}
