package Concurrency;

import java.util.ArrayList;

public class MultiThreading {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < 5; i++) arrayList.add(i);

        A a = new A("alpha", arrayList);       // extends Thread
        B b = new B("beta", arrayList);        // implements Runnable

        Thread thread = new Thread(b);
        a.start();
        thread.start();      // Not thread safe, sometimes return size 5, sometimes 6

    }



}
