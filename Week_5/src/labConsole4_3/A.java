package labConsole4_3;
import java.util.Hashtable;
public class A implements InterfaceForAclass {
    private int a, b;
    public A(int a, int b){
        this.a = a;
        this.b = b;
    }
    @Override
    public void printFromAToB() {
        for (int i = a+1; i<b; i++){
            System.out.println(i);
        }
    }

    @Override
    public void divisorsOfA() {
        for (int i = 1; i<=a; i++){
            if (a%i==0)
                System.out.println(i);
        }
    }

    @Override
    public void primeDivisorsOfB() {
        while (b%2==0){
            System.out.println(2);
            b/=2;
        }
        for (int i = 3; i <= Math.sqrt(b); i+= 2)
            while (b%i == 0)
            {
                System.out.println(i);
                b /= i;
            }
        if (b > 2)
            System.out.print(b);
    }

    @Override
    public int mostFrequentDigit() {

        return 0;
    }
}
