package inheritance;

public class B extends A{
    public B(int _x, int _y){
        x = _x;
        y = _y;
    }

    public int m1(){
        return y-x;
    }

    public int m2(){
        return x+2*y;
    }
}
