package inheritance3;

public class B extends A{
    public float f1(){
        return (y-x)/3;
    }
    public float f2(){
        return (((float) Math.pow(x,2))+2*y)/5;
    }
    public void printX(){
        System.out.println("X="+x);
    }
}
