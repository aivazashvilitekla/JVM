package inheritance;

public class C extends B{
    private double z=8;

    public C(int _x, int _y) {
        super(_x, _y);
    }

    public double m3(){
        return (x+y+z)/3;
    }
}
