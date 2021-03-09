package com.company.Project3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class A {
    private int m[] = new int[10];
    public void m1(){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i<m.length; i++){
            System.out.print((i+1)+":");
            m[i] = scanner.nextInt();
        }
    }
    public void m2(){
        Random rand = new Random();
        for (int i = 0; i<m.length; i++){
            m[i] = rand.nextInt(15);
        }
//        System.out.print(Arrays.toString(m));
    }
    public int m3(){
        int s=0;
        for (int i = 0; i<m.length; i++){
            if (m[i]<i)
                s+=m[i];
        }
        return s;
    }
    public int m4(){
        int s=1;
        for (int i = 0; i<m.length; i++){
            if (m[i]>i)
                s*=m[i];
        }
        return s;
    }
}
