package SomeProblems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Question2 {

    static List<User> users = new ArrayList<User>(500);

    public static void main(String[] args) {

        for (int i = 0; i < 500; i++) {
            users.add(new User(UUID.randomUUID().toString() + i, "Ryo" + " No. " + i));
        }

        List<String> userIds = users.stream().map(user -> user.id).collect(Collectors.toList());
        int frequency = 100;
        AtomicInteger count = new AtomicInteger();
        userIds.stream().forEach(uId -> {
            if (count.get() == 0) {
                System.out.println("[" + uId + ",");
                count.getAndIncrement();
            } else if (count.get() < frequency - 1) {
                System.out.println(uId + ",");
                count.getAndIncrement();
            } else {
                System.out.println(uId + "]");
                count.set(0);
            }
        });

        count.set(0);
        // GroupingBy way:
        Collection<List<String>> idGroups = users.stream().map(user -> user.id).collect(Collectors.groupingBy(it -> count.getAndIncrement() / frequency)).values();
        idGroups.stream().map(I -> I.stream().collect(Collectors.joining(","))).forEach(s -> System.out.println(s));
    }

    public static class User {
        private String id;
        private String name;

        public User(String id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
