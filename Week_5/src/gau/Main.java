package gau;

import labConsole4_3.A;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        A a = new A();
//        a.setABRandomly();
//        System.out.println(a.returnABChar());
//        a.fillTheArray();
//        a.printEvenNumbers();
//        a.sumOfEvens();
//        a.min();
        A a = new A(6, 15);
//        a.printFromAToB(5, 10);
//        a.divisorsOfA();
//        a.primeDivisorsOfB();
        System.out.println(a.mostFrequentDigit());
    }
}
