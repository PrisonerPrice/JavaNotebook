package ComparatorVsComparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CVC {

    static class People implements Comparable<People> {

        private String name;
        private int id;

        public People(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(People p) {
            return this.id - p.id;
        }

        @Override
        public String toString() {
            return "People{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }
    }

    static class PeopleComparator implements Comparator<People> {

        @Override
        public int compare(People p1, People p2) {
            return p1.getName().compareTo(p2.getName());
        }
    }

    public static void main(String[] args) {
        List<People> list = new ArrayList<>();
        list.add(new People("Alex", 2));
        list.add(new People("Max", 3));
        list.add(new People("Jackson", 1));
        list.add(new People("Ryo", 4));

        // order by adding order
        for(People p : list) {
            System.out.println(p);
        }

        // order by id
        Collections.sort(list);
        for(People p : list) {
            System.out.println(p);
        }

        // order by name
        Collections.sort(list, new PeopleComparator());
        for(People p : list) {
            System.out.println(p);
        }
    }
}
