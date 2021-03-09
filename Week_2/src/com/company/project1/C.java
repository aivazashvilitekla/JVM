package com.company.project1;

import java.util.Scanner;

public class C {
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
    public int m2(){
        return a%10;
    }
    public int m3(){
        int firstN = b;
        while(firstN > 9){
            firstN = (firstN - (firstN%10))/10;
        }
        return firstN;
    }
    public int m4(){
        int s=0;
        while(c !=0){
            s += c%10;
            c /= 10;
        }
        return s;
    }
    public int m5(){
        return m3()*m2();
    }
    public void m6(){
        System.out.println(m3()+m5());
    }
}
