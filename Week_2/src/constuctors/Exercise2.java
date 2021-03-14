package constuctors;

public class Exercise2 {
    private int x;
    public Exercise2(){
        System.out.println("Hello");
    }
    public Exercise2(int _x){
        x = _x;
    }
    public void m1(){
        if(x>=5 && x<=24)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
