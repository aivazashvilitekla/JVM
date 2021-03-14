package constuctors;

public class Exercise6 {
    private float x, y;
    public Exercise6(){}
    public Exercise6(float x){
        this.x = x;
    }
    public Exercise6(float x, float y){
        this.x = x;
        this.y = y;
    }
    public float lcm()
    {
        return Math.abs(x * y) / m1();
    }
    //gcd
    public float m1()
    {
        if (x == 0)
            return y;

        return y%x;
    }
}
