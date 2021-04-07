package gau.classwork6;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Work6 {
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();
    public Work6(){
        File f = new File("myFiles");
        f.mkdir();
    }
    public void m1(){
        try {
            FileWriter fileWriter = new FileWriter("myFiles/data.txt");
            fileWriter.write("24, 39, -90");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void m2(){
        try {
            FileWriter fileWriter = new FileWriter("myFiles/data1.txt");
            for (Integer i=0; i<=100; i++)
                if (i==100)
                    fileWriter.write(Integer.toString(i)+".");
                else fileWriter.write(Integer.toString(i)+",");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void m3(){
        File f = new File("myFiles1");
        f.mkdir();
        try {
            for (Integer i=1; i<=30; i++){
                FileWriter fileWriter = new FileWriter("myFiles1/data"+i+".txt");
                fileWriter.write("Programmer");
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void m4(){
        File f = new File("myFiles2");
        f.mkdir();
        try {
            for (Integer i=1; i<=30; i++){
                FileWriter fileWriter = new FileWriter("myFiles2/data"+i+".txt");
                fileWriter.write("Programmer"+i);
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void m5(int a, int b){
        Random rand  = new Random();
        try {
            FileWriter fileWriter = new FileWriter("myFiles/data2.txt");
            for (int i = 0; i<100; i++){
                fileWriter.write(Integer.toString(rand.nextInt(b-a)+a)+",");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void m6(float a, float b){
        Random rand  = new Random();
        try {
            FileWriter fileWriter = new FileWriter("myFiles/data3.txt");
            for (int i = 0; i<50; i++){
                fileWriter.write((Math.round((rand.nextFloat()*(50-10)+10)*100.0)/1000.0)+",");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void m10(int a){
        System.out.println(Integer.toBinaryString(a));
    }
    public void m11(String binary){
        System.out.println(Integer.parseInt(binary, 2));
    }
    public void m12(){
        double p, q, k;
        int n;
        System.out.print("საწყისი თანხა:");
        p = scanner.nextDouble();
        System.out.print("პროცენტის რაოდენობა:");
        k = scanner.nextDouble();
        System.out.print("წლების რაოდენობა:");
        n = scanner.nextInt();
        q = p*n*(k/100);
        System.out.println(n+" წლისთვის - "+q+"₾");
    }
    public void m13(){
        double p, q, k, i;
        int n;
        System.out.print("საწყისი თანხა:");
        p = scanner.nextDouble();
        System.out.print("პროცენტის რაოდენობა:");
        k = scanner.nextDouble();
        System.out.print("წლების რაოდენობა:");
        n = scanner.nextInt();
        i = p*Math.pow((1+k/100), n);
        q = i-p;
//        System.out.println(i);
        System.out.println(n+" წლისთვის - "+Math.round(q * 100.0) / 100.0+"₾");
    }
    public void m14(int a, int b){
        int r, countEven = 0, countOdd = 0, sumEven = 0, sumOdd = 0;
        try {
            FileWriter fileWriter = new FileWriter("myFiles/numbers.txt");
            for (int i = 0; i<40; i++){
                r = rand.nextInt(b-a)+a;
                if(r%2==0){
                    countEven++;
                    sumEven+=r;
                }
                else {
                    countOdd++;
                    sumOdd+=r;
                }
                fileWriter.write(r+",");
            }

            System.out.println("ლუწები:"+countEven);
            System.out.println("კენტები:"+countOdd);
            System.out.println("ლუწების ჯამი:"+sumEven);
            System.out.println("კენტების ჯამი:"+sumOdd);
            fileWriter.close();
            //------
            FileWriter fileWriter2 = new FileWriter("myFiles/numbers2.txt");
            for (int i = 0; i<5; i++) {
                if(sumEven>sumOdd)
                    r = rand.nextInt(sumEven - sumOdd) + sumOdd;
                else r = rand.nextInt(sumOdd - sumEven) + sumEven;
                fileWriter2.write(r + ",");

            }
            fileWriter2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void m15(){
        int m, n, r, countZeros = 0, countOnes = 0;
        System.out.print("შეიყვანეთ m, სადაც m<=50:");
        m = scanner.nextInt();
        System.out.print("შეიყვანეთ n, სადაც n<=50:");
        n = scanner.nextInt();

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("myFiles/info.txt"));

            int[][] matrix = new int[m][n];;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    r = (int)Math.round(Math.random());
                    bw.write(r + " ");
                }
                bw.newLine();
            }
            bw.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileReader fileReader = new FileReader("myFiles/info.txt");
            int symbol;
            while ((symbol = fileReader.read())!=-1){
                if ((char)symbol=='0')
                    countZeros++;
                else if ((char)symbol=='1')
                    countOnes++;
            }
            fileReader.close();
            System.out.println("zeros - "+countZeros);
            System.out.println("ones - "+countOnes);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
