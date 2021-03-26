package gau;

import java.util.Scanner;

public class Cclass implements InterfaceForCclass {
    private int a=10, b=9;
    private char s = '#', h = '@';
    Scanner scanner;
    public void printAB(){
        System.out.println(a + ", " +b);
    }
    public void printSH(){
        System.out.println(s + ", " +h);
    }

    @Override
    public void manipulationsAB() {
        System.out.println((a+b)+"\n"+(a*b)+"\n"+(a/b)+"\n"+(a%b));
    }

    @Override
    public void setA() {
        scanner = new Scanner(System.in);
        a = scanner.nextInt();
    }

    @Override
    public void setB() {
        scanner = new Scanner(System.in);
        b = scanner.nextInt();
    }

    @Override
    public void setSH() {
        scanner = new Scanner(System.in);
        h = scanner.next().charAt(0);
        s = scanner.next().charAt(0);
    }
}
