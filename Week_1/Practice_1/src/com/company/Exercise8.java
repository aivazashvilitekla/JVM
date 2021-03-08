package com.company;

import java.util.Scanner;

public class Exercise8 {
    public Exercise8(){
        int m, n;
        System.out.println("შემოიტანეთ M და N:");
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        while (m>n){
            System.out.println("N მეტი უნდა იყოს M-ზე, სცადეთ თავიდან.");
            m = scanner.nextInt();
            n = scanner.nextInt();
        }
        for (int i = m; i<n; i++){
            System.out.println(i);
        }

    }
}
