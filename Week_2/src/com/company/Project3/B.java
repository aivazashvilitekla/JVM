package com.company.Project3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class B {
    private int m[] = new int[12];
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
    public void m3(){
        for (int i = 0; i<m.length; i++){
            if (m[i]>7)
                System.out.println(m[i]+" - index of "+i);
        }
    }
    public int m4(){
        int min = m[0];
        int max = m[0];
        for (int i = 0; i<m.length; i++){
            if (m[i]>max)
                max = m[i];
            if (m[i]<min)
                min = m[i];
        }
//        System.out.println(Arrays.toString(m));
        return max-min;
    }
}
