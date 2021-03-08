package com.company;

import java.util.Scanner;

public class Exercise7 {
    public Exercise7(){

        int a, b, g;
        Scanner scanner = new Scanner(System.in);
        System.out.print("a=");
        a = scanner.nextInt();
        System.out.print("b=");
        b = scanner.nextInt();
        g = gcd(a, b);
        System.out.println("GCD(" + a +  " , " + b+ ") = " + g);


        int lcm = lcm(a, b, g);
        System.out.println("LCM(" + a +  " , " + b+ ") = " + lcm);

    }
    public static int lcm(int a, int b, int gcdValue)
    {
        return Math.abs(a * b) / gcdValue;
    }
    public static int gcd(int a, int b)
    {
        if (a == 0)
            return b;

        return gcd(b%a, a);
    }
}
