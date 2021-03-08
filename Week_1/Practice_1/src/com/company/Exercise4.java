package com.company;

import java.util.Scanner;

public class Exercise4 {
    public Exercise4(){
        int num;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 3-digit Number: ");
        num = scanner.nextInt();
        String l = Integer.toString(num);
        for (int i=0; i<l.length(); i++){
            System.out.println(l.charAt(i));
        }
    }
}
