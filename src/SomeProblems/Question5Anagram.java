package SomeProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question5Anagram {

    public static void main(String[] args) {
        List<String[]> testCases = new ArrayList<>();
        testCases.add(new String[]{"", "", "true"});
        testCases.add(new String[]{"a", "", "false"});
        testCases.add(new String[]{"a", "A", "true"});
        testCases.add(new String[]{"acb", "bca", "true"});
        testCases.add(new String[]{"a, c.b!", " b,!c.a#", "true"});
        testCases.add(new String[]{"aaaaab", "aaaab", "false"});

        for (int i = 0; i < testCases.size(); i++) {
            String [] data = testCases.get(i);
            test(i, data[0], data[1], Boolean.valueOf(data[2]));
        }
    }

    public static void test(int i, String str1, String str2, boolean assertResult) {
        if (isAnagram(str1, str2) == assertResult)
            System.out.println("Test " + i + " successful!");
        else
            System.out.println("Test " + i + " failed!");
    }

    public static boolean isAnagram(String str1, String str2) {
        int[] dict = new int[26];
        for (char c : str1.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                dict[c - 'a']++;
            }
        }
        for (char c : str2.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                dict[c - 'a']--;
                if (dict[c - 'a'] < 0)
                    return false;
            }
        }
        for (int num : dict) {
            if (num != 0)
                return false;
        }
        return true;
    }
}
