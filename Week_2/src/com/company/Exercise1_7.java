package com.company;

import java.util.Scanner;

public class Exercise1_7 {
    public Exercise1_7(){
        int x, y;
        Scanner scanner = new Scanner(System.in);
        System.out.print("X->");
        x = scanner.nextInt();
        System.out.print("Y->");
        y = scanner.nextInt();
        int n = x*y;
        while(x!=y){
            if(x>y) x -=y;
            else y -=x;
        }
        System.out.println("უსგ="+x);
        System.out.println("უსჯ="+n/x);
    }
}
