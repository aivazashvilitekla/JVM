package com.company;

import java.util.Arrays;

public class Exercise10 {
    public Exercise10(){
        boolean sorted = false;
        double m[] = {1.3, 0.4, 8, 0, -8.7, 2, 14.5, 7};
        double temp;
        while(!sorted){
            sorted = true;
            for (int i=0; i<m.length-1; i++){
                if(m[i]>m[i+1]){
                    temp = m[i];
                    m[i] = m[i+1];
                    m[i+1] = temp;
                    sorted = false;
                }
            }
        }
        System.out.println(Arrays.toString(m));
    }
}
