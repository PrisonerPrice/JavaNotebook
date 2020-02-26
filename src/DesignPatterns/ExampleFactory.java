package DesignPatterns;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ExampleFactory {

    private ExampleFactory() {}

    public static List<Integer> getList(int typeCode) {
        if (typeCode == 0) {
            return null;
        }
        if (typeCode == 1) {
            return new ArrayList<>();
        }
        if (typeCode == 2) {
            return new LinkedList<>();
        }
        return null;
    }

}
