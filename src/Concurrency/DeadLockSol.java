package Concurrency;

public class DeadLockSol {

    private static String resourceA = "Resource A";
    private static String resourceB = "Resource B";

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println(resourceA + " acquired by ThreadOne");
                try{
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            synchronized (resourceB) {
                System.out.println(resourceB + " acquired by ThreadOne");
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (resourceB) {
                System.out.println(resourceB + " acquired by ThreadTwo");
                try{
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            synchronized (resourceA) {
                System.out.println(resourceA + " acquired by ThreadTwo");
            }
        });
        t1.start();
        t2.start();

        // Solution:
        // 1) Avoid Nested Locks (Here, we use this)
        // 2) Avoid Unnecessary Locks
        // 3) Using Thread Join
    }
}
