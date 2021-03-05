package com.company;

import java.util.Scanner;

public class Exercise3 {
    public Exercise3(){
        System.out.println("ex 3");
        int x, y, z;
        Scanner scanner = new Scanner(System.in);
        System.out.print("x=");
        x = scanner.nextInt();
        System.out.print("y=");
        y = scanner.nextInt();
        System.out.print("z=");
        z = scanner.nextInt();
        System.out.println("X+Y+Z="+(x+y+z));
        System.out.println("X*Y*Z="+(x*y*z));
    }
}
