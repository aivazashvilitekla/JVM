package gau;

import java.util.Scanner;

public class B {
    private int a = 33;
    private float b = 9.7f;
    private char s = '#';
    Scanner scanner = new Scanner(System.in);
    public void m1(){
        System.out.println("S="+s);
    }
    public void m2(){
        System.out.println("A="+a);
    }
    public void m3(){
        System.out.println("B="+b);
    }
    public void m4(){
        System.out.println("A-B="+(a-b));
    }
    public double m5(){
        return a*1.0/b;
    }
    public void m6(){
        a = 45;
        b = 3.47f;
        s = 's';
    }
    public void m7(){
        System.out.println("A->");
        a = scanner.nextInt();
    }
    public void m8(){
        System.out.println(b+10);
    }
}
