package SomeProblems;

import java.math.BigInteger;

public class Question4 {

    public static void main(String[] args) {

    }

    class Calculator {
        long size;
        int mean;

        public Calculator() {
            size = 0L;
            mean = 0;
        }

        public void add(int number) {
            BigInteger oldSize = new BigInteger(String.valueOf(size));
            BigInteger oldMean = new BigInteger(String.valueOf(mean));
            BigInteger addNumber = new BigInteger(String.valueOf(number));
            BigInteger sum = oldSize.multiply(oldMean).add(addNumber);
            size++;
            BigInteger newSize = new BigInteger(String.valueOf(size));
            BigInteger newMean = sum.divide(newSize);
            mean = newMean.intValue();
        }

        public int getMean() {
            return mean;
        }
    }
}


