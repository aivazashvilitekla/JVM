package com.company;

import java.util.Arrays;

public class Exercise9 {
    public Exercise9(){
        double m[] = {1.3, 0.4, 8, 0, -8.7, 2, 14.5, 7};
        for(int i=0; i<m.length; i++){
            System.out.println((i+1)+" - "+m[i]);
        }
//        for (double item : m) {
//            System.out.println(item);
//        }
//        System.out.println(Arrays.toString(m));
        double min = m[0];
        double max = m[0];
        for(int i=0; i<m.length; i++){
            if(min>m[i]){
                min = m[i];
            }
            if(max<m[i]){
                max = m[i];
            }
        }
        System.out.println(min);
        System.out.println(max);
    }
}
