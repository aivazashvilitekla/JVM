package gau;

public class Main {

    public static void main(String[] args) {

        C c = new C();
        c.setAB();
        System.out.println(c.lastOfA());
        System.out.println(c.firstOfB());
        c.average();

        //--------------------
        System.out.println("----------");
        A a = new A();
        a.setX();
        a.m3();
        //--------------------
        System.out.println("----------");
        B b = new B(4, 6);
        b.setY();
        //--------------------
        System.out.println("----------");
        Task3  task3 = new Task3();
    }
}
