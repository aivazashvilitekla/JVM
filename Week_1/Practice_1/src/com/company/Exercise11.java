package com.company;

import java.util.Arrays;
import java.util.Random;

public class Exercise11 {
    public Exercise11(){
        double m[] = new double[8];
        Random rand = new Random();
        for(int i=0; i<8; i++){
            m[i] = Math.round(rand.nextDouble()*10000)/100D;
        }
        System.out.println(Arrays.toString(m));
    }
}
