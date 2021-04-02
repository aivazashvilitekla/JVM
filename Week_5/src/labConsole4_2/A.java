package labConsole4_2;

import java.util.Arrays;
import java.util.Random;

public class A {
    private int a, b;
    private int m[] = new int[12];
    Random rand = new Random();
    public void setABRandomly(){
        a = rand.nextInt(25-10)+10;
        b = rand.nextInt(25-10)+10;
        System.out.println(a);
        System.out.println(b);
    }
    public String returnAB(){
        return "a=" + a+", " + "b=" + b;
    }
    public String returnABChar(){
        return "a="+(char)a + "b="+ (char)b;
    }
    public void fillTheArray(){
        for (int i = 0; i<m.length; i++){
            m[i] = -10+ rand.nextInt(60);
        }
        System.out.println(Arrays.toString(m));
    }
    public void printEvenNumbers(){
        for (int i = 0; i<m.length; i++){
            if (m[i]%2==0) System.out.println(m[i]);
        }
    }
    public void sumOfEvens(){
        int s = 0;
        for (int i = 0; i<m.length; i++)
            if (m[i]%2==0) s+=m[i];
        System.out.println("sum="+s);
    }
    public void min(){
        int min = m[0];
        for (int i = 0; i<m.length; i++)
            if (m[i]>0 & m[i]<min) min = m[i];
        System.out.println("min="+min);
    }

}
