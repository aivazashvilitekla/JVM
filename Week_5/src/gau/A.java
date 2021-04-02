package gau;

public class A {
    protected  int a =10, b=29;
    public void m1(){
        System.out.println("Hello OPP");
    }
    public void m2(){
        System.out.println("A="+a);
    }
    public void m3(){
        System.out.println("B="+b);
    }
    public void m4(){
        System.out.println("A+B="+(a+b));
    }
    public int m5(){
        return a+b;
    }
    public int m6(){
        return a*b;
    }
    public void m7(){
        a=5;
        b=6;
    }
}
