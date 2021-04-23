package gau;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task1 implements Task1Interface{
    int a, b, m[] = new int[12];
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    @Override
    public void setAB() {
        System.out.print("A->");
        a = scanner.nextInt();
        System.out.print("B->");
        b = scanner.nextInt();
    }

    @Override
    public void setMArray() {
        for (int i=0; i<m.length; i++){
            m[i] = random.nextInt(a-b)+b;
        }
        System.out.println(Arrays.toString(m));
    }
    public int returnMinFromPositiveNumbers(){
        int min = m[0];
        for (int i=0; i<m.length; i++){
            if (m[i]>0)
                if (min>m[i])
                    min=m[i];
        }
        return min;
    }
    public void printArrayMembers(){
        for (int i=0; i<m.length; i++){
            System.out.println("Index - "+i+"; Member - "+m[i]);
        }
    }
    public void printMembersDivBy3(){
        for (int i=0; i<m.length; i++){
            if(m[i]%3==0)
                System.out.println(m[i]);
        }
    }
}
