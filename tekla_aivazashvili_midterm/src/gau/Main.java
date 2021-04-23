package gau;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        Task1 task1 = new Task1();
//        task1.setAB();
//        task1.setMArray();
//        System.out.println(task1.returnMinFromPositiveNumbers());
//        task1.printArrayMembers();
//        task1.printMembersDivBy3();
//        Task2 task2 = new Task2();
//        PrimaryNumber primaryNumber = new PrimaryNumber();
//        primaryNumber.setNumber();
        SubtractNumber ob1 = new SubtractNumber(50);
        SubtractNumber ob2 = new SubtractNumber(40);
        Thread t1 = new Thread(ob1);
        Thread t2 = new Thread(ob2);
        t1.start();
        t2.start();
//        ob1.subtractNum();
//        System.out.println(primaryNumber.getNumber());

    }
}
