package Concurrency;

import java.util.ArrayList;

public class A extends Thread {

    private String name;
    private ArrayList<Integer> arrayList;

    public A(String name, ArrayList<Integer> arrayList) {
        this.name = name;
        this.arrayList = arrayList;
    }

    @Override
    public void run() {
        System.out.println("I am running in A with the name of " + name);
        System.out.println("The size of the arrayList is: " + arrayList.size());
    }
}
