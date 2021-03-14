package constuctors;

public class Exercise4 {
    private int x, y;
    public Exercise4(){
        System.out.println("Hello my class");
    }
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int m1(){
        int res = 0;
        if (x>0)
            res = 4*x-y;
        else
            res = 2*x+y;
        return res;
    }
    public int m2(){
        int res = 0;
        if (x>0)
            res = 4*x+y;
        else
            res = 2*x-y;
        return res;
    }

}
