package gau;

import java.util.Scanner;

public class C {
    private int a, b;
    Scanner scanner = new Scanner(System.in);
    public void setAB() {
        System.out.print("A->");
        a = scanner.nextInt();
        System.out.print("B->");
        b = scanner.nextInt();
    }
    public int lastOfA(){
        return Math.abs(a) % 10;
    }
    public int firstOfB(){
        return Integer.parseInt(Integer.toString(b).substring(0, 1));
    }
    public void average(){
        System.out.println((lastOfA()+firstOfB())*1.0/2);
    }
}
