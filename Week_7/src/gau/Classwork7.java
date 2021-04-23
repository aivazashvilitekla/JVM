package gau;

import java.util.*;

public class Classwork7 {
    Random random = new Random();
    List<Integer> list=new ArrayList<Integer>();
    public void addToList(int n){
        for (int i=0; i<n; i++)
            list.add(random.nextInt(100));
        System.out.println(list);
    }
    public void printList(){
        addToList(5);
        Collections.reverse(list);
        System.out.println(list);
    }
    public void listASC(){
        addToList(5);
        Collections.sort(list);
        System.out.println("Ascending" + list);
    }
    public void listDESC(){
        addToList(5);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Descending" + list);
    }
    public void addAnother3(){
        addToList(5);
        addToList(3);
    }
    public void m6(){
        addToList(5);
        for (int i=1; i<=list.size(); i+=2)
            list.add(i, random.nextInt(100));
        System.out.println(list);
    }
    public void m7(int n){
        addToList(5);
        list.add(n+1, random.nextInt(100));
        System.out.println(list);
    }
    public void m8(){
        addToList(5);
        for (int i=0; i<3; i++)
            list.remove(0);
        System.out.println(list);
    }
    public void m9(int n){
        addToList(5);
        list.remove(n);
        System.out.println(list);
    }
    public void m10(){
        addToList(5);
        for (int i=0; i<list.size(); i+=2)
            if(i%2==0)
                list.remove(i);
        System.out.println(list);
    }
    public void m11(){
        addToList(5);
        for (int i=0; i<list.size(); i++)
            if(list.get(i)==30)
                list.remove(i);
        System.out.println(list);
    }
    public void m12(){
        addToList(20);
        List<Integer> newList =new ArrayList<Integer>();
        for (int i=7; i<15; i++)
            newList.add(list.get(i));
        System.out.println(newList);
    }
    public void m13(){
        List<String> newList =new ArrayList<String>();
        String s="";
        for (int i=0; i<20; i++) {
            for (int j = 0; j < 10; j++)
                s = s + (char) (random.nextInt(123 - 65) + 65);
            newList.add(s);
            s="";
        }
        System.out.println(newList);
    }
    public void m14(int n){
        StringBuilder input1 = new StringBuilder(n+"");
//        input1.append(n+"");
        input1.reverse();
        if(Integer.parseInt(input1.toString())==n)
            System.out.println("palindrome");
        else System.out.println("not palindrome");
    }
    public void m15(int a, int b){
        int row = 6, column = 5;
        int[][] first = new int[row][column];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                first[r][c] = random.nextInt(a-b)+b;
            }
        }
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                System.out.print(first[r][c] + " ");
            }
            System.out.println();
        }

    }
}
