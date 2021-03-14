package constuctors;

public class Exercise3 {
    private int a, b, x;
    public Exercise3(){}
    public Exercise3(int _a, int _b){
        a = _a;
        b = _b;
    }
    public void m1(){
        if(a<b)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    public void setX(int x) {
        this.x = x;
    }

    public void m2(){
        if(x>a && x<b)
            System.out.printf("X in[%o;%o]", a, b);
        else
            System.out.printf("X not in[%o;%o]", a, b);
    }
}
