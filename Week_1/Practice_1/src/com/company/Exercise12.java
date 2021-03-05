package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Exercise12 {
    public Exercise12(){
        int m[] = new int[8];
        Random rand = new Random();
        for(int i=0; i<8; i++){
            m[i] = rand.nextInt(100);
        }
        Arrays.sort(m);
        System.out.println(Arrays.toString(m));
        for(int i=0; i< m.length/2; i++){
            int temp = m[i];
            m[i] = m[m.length-1-i];
            m[m.length-1-i] = temp;
        }
        System.out.println(Arrays.toString(m));
    }
}
