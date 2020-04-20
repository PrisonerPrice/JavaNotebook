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
        thread.start();      // Not thread safe, sometimes print size 5, sometimes 6

        ArrayList<Integer> syncArrayList = new ArrayList<>();
        for(int i = 0; i < 5; i++) syncArrayList.add(i);

        A aa = new A("a-alpha", syncArrayList);
        B bb = new B("b-beta", syncArrayList);
        Thread thread2 = new Thread(bb);

        synchronized (syncArrayList) {
            aa.start();
            thread2.start();    // Thread safe, always print size 5, not size 6
        }
    }

}
