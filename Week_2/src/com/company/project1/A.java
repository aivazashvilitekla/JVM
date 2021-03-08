package com.company.project1;

import java.util.Scanner;

public class A {
    private int a, b;
    public void m1(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("a->");
        a = scanner.nextInt();
        System.out.print("b->");
        b = scanner.nextInt();
    }
    public void m2(){
        System.out.println("a+b="+(a+b));
    }
    public int m3(){
        return a*b;
    }
}
