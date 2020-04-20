package Concurrency;

import java.util.ArrayList;

public class RaceCondition {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < 5; i++) arrayList.add(i);

        A a = new A("alpha", arrayList);       // extends Thread
        B b = new B("beta", arrayList);        // implements Runnable

        Thread thread = new Thread(b);
        a.start();
        thread.start();      // Not thread safe, sometimes print size 5, sometimes 6
    }

    public static class A extends Thread {

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

    public static class B implements Runnable {

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
}
