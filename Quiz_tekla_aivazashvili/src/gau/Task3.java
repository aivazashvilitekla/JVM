package gau;

import java.util.Random;
import java.util.Scanner;

public class Task3 {
    int a, b;
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    public Task3(){
        System.out.print("A->");
        a = scanner.nextInt();
        System.out.print("B->");
        b = scanner.nextInt();
        if(a>b){
            a = a+b;
            b = a-b;
            a = a-b;
        }
        int countEven = 0, countOdd=0, num;
        for (int i=0; i<40; i++){
            num = random.nextInt(b - a) + a;
            if(num%2==0)
                countEven++;
            else countOdd++;
            System.out.println(num);
        }
        System.out.println("ლუწი - "+countEven);
        System.out.println("კენტი - "+countOdd);

    }
}
