package com.company;

import java.util.Scanner;

public class Exercise2 {
    public Exercise2(){
        int num1, num2;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number 1:");
        num1 = scanner.nextInt();
        System.out.print("Number 2:");
        num2 = scanner.nextInt();
        System.out.println(num1+"%"+num2+"="+num1%num2);
        System.out.println(num2+"%"+num1+"="+num2%num1);
    }
}
