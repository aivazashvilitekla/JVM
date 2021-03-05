package com.company;

import java.util.Scanner;

public class Exercise6 {
    public Exercise6(){
        System.out.println("Exercise6");
        int x, s=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("X=");
        x = scanner.nextInt();
        while(x!=0){
            s += x%10;
            x = x/10;
        }
        System.out.println("S="+s);
    }
}
