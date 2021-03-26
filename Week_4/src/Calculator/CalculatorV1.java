package Calculator;


import java.util.Scanner;

public class CalculatorV1 {
    int number1;
    int number2;
    char o;
    int r = 0;
    public void m1(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number 1:");
        number1 = scanner.nextInt();
        System.out.println("Enter operator(*, +, /, -):");
        o = scanner.next().charAt(0);
        System.out.println("Enter number 2:");
        number2 = scanner.nextInt();
        switch (o){
            case '/':
                r = number1/number2;
                break;
            case '+':
                r = number1+number2;
                break;
            case '-':
                r = number1-number2;
                break;
            case '*':
                r = number1*number2;
                break;

        }
        System.out.println(r);
    }

}
