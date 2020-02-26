package Concurrency;

import java.util.ArrayList;

public class B implements Runnable {

    private String name;
    private ArrayList<Integer> arrayList;

    public B(String name, ArrayList<Integer> arrayList) {
        this.name = name;
        this.arrayList = arrayList;
    }

    @Override
    public void run() {
        System.out.println("I am running in B with the name of " + name);
        arrayList.add(5);
    }
}
