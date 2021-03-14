package inheritance1;

import java.util.Scanner;

public class B extends A{
    protected int y;
    public void m1(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Y->");
        y = scanner.nextInt();
    }
    public int m4(){
        return x+y;
    }
}
