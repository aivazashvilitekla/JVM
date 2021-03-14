package com.company;

import constuctors.Exercise2;
import constuctors.Exercise5;
import inheritance.A;
import inheritance.B;

public class Main {

    public static void main(String[] args) {
//        Exercise2 exercise2 = new Exercise2();
//        Exercise2 exercise21 = new Exercise2(34);
//        exercise21.m1();
//        Exercise5 exercise5 = new Exercise5(4);
//        exercise5.setY(3);
//        System.out.println(exercise5.m1());
        A obj1 = new A();
//        obj1.setXY();
//        obj1.printX();
//        obj1.printY();
        B b = new B();
        b.setXY();
        b.printX();
    }
}
