package DesignPatterns;

public class SingletonExample {

    private static SingletonExample obj;

    private SingletonExample(){}

    public static SingletonExample getInstance() {
        if (obj == null) obj = new SingletonExample();
        return obj;
    }
}
