package com.company;

import java.util.Scanner;

public class Exercise5 {
    public Exercise5(){
        System.out.println("Exercise6");
        int x, s=0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 4-digit Number: ");
        x = scanner.nextInt();
        while(x!=0){
            s += x%10;
            x = x/10;
        }
        System.out.println("S="+s);
    }
}
