package inheritance3;

public class C extends B{
    double z, r;

    public void setZR(double z, double r) {
        this.z = z;
        this.r = r;
    }

    public double f3() {
        return (Math.pow(x,2)+2*y)/z-r;
    }
    public double f4() {
        return (y-x)/3+r/(z+4);
    }
}
