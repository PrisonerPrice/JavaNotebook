package SomeProblems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Question1 {

    public static void main(String[] args) {
        solution.print(13231);
    }
}

class solution {

    public static void print(int n) {
        Deque<LinkedList<Integer>> stack = new LinkedList<>();
        int digit = 6;
        int remainder = n;
        for(int minus = 1000000; minus > 0; minus /= 10) {
            LinkedList<Integer> curr = new LinkedList<>();
            while (remainder - minus >= 0) {
                curr.add(minus);
                remainder -= minus;
            }
            digit--;
            stack.push(curr);
        }
        while(!stack.isEmpty()) {
            LinkedList<Integer> minus = stack.pop();
            if (!stack.isEmpty()) {
                LinkedList<Integer> added = stack.pop();
                int lenM = minus.size();
                int lenA = added.size();
                for(int i = 0; i < lenA && i < lenM; i++) {
                    added.set(i, added.get(i) + minus.get(i));
                }
                if(lenM > lenA) {
                    for(int i = 0; i < lenM - lenA; i++) {
                        added.add(minus.get(lenA + i));
                    }
                }
                stack.push(added);
            } else {
                stack.push(minus);
                break;
            }
        }
        String result = "";
        int count = 0;
        while(!stack.isEmpty()) {
            LinkedList<Integer> curr = stack.pop();
            count += curr.size();
            for(int i = curr.size() - 1; i >= 0; i--) {
                result += curr.get(i) + " ";
            }
        }
        System.out.println(count);
        System.out.println(result.trim());

        /*
        for(int i = 0; i < 7; i++) {
            String log = 1 + "";
            for(int j = 0; j < i; j++) {
                log += "0";
            }
            System.out.println(log + ": " + stack.pop().size());
        }

         */
    }
}
