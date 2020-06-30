package lambda;

import com.sun.tools.internal.xjc.model.CElement;

import javax.xml.bind.Element;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JointMembership {

    public static void main(String[] args) {
        List<Integer> listA = new ArrayList<>();
        for (int i = 1; i <= 10; i++)
            listA.add(i);
        listA.add(10);
        List<Integer> listB = new ArrayList<>();
        for (int i = 2; i <= 12; i += 2)
            listB.add(i);

        // listA: 1,2,3,4,5,6,7,8,9,10,10
        // listB: 2,4,6,8,10,12

        Set<Integer> setA = new HashSet<>();
        for (int number : listA) setA.add(number);
        Set<Integer> setB = new HashSet<>();
        for (int number : listB) setB.add(number);

        // 1, find all elements present in both lists
        Set<Integer> res1 = listA.stream().filter(setB::contains).collect(Collectors.toSet());
        System.out.println(res1);

        // 2, find all elements in exactly one list only
        Set<Integer> res2 = new HashSet<>();
        setA.stream().filter(number -> !setB.contains(number)).forEach(res2::add);
        setB.stream().filter(number -> !setA.contains(number)).forEach(res2::add);
        System.out.println(res2);

        // 3, all elements present in either list, but discarding duplicates
        Set<Integer> res3 = new HashSet<>(setA);
        setB.forEach(element -> res3.add(element));
        System.out.println(res3);

    }
}
