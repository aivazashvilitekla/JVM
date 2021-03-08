package com.company.project1;

import java.util.Scanner;

public class B {
    private int a, b, c;
    public void m1(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("a->");
        a = scanner.nextInt();
        System.out.print("b->");
        b = scanner.nextInt();
        System.out.print("c->");
        c = scanner.nextInt();
    }
    public void m2(){
        if(a>b && a>c) System.out.println(a);
        else if (b>a && b>c) System.out.println(b);
        else System.out.println(c);
    }
    public int m3(){
        if(a<b && a<c) return a;
        else if (b<c) return b;
        else return c;
    }
}
