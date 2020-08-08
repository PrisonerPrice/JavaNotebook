package LeetCodeProblems;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LC146 {

    // simple implementation
    // hashMap + linkedList
    class LRUCache1{
        private int capacity;
        private Map<Integer, Integer> map;
        private LinkedList<Integer> list;

        public LRUCache1(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            list = new LinkedList<>();
        }

        public int get(int key) {
            if (!map.containsKey(key))
                return -1;
            list.remove(key);
            list.add(0, key);
            return map.get(key);
        }

        public void put(int key, int value) {
            if (!map.containsKey(key)) {
                if (map.size() == capacity) {
                    map.remove(list.removeLast());
                }
            }
            list.add(0, key);
            map.put(key, value);
        }
    }

    // hashMap of nodes + doubleLinkedList
    class LRUCache2{
        private int capacity;
        private Map<Integer, Node> nodeMap; // <key, node<key, value>>
        private Node head;
        private Node tail;

        public LRUCache2(int capacity) {
            this.capacity = capacity;
            nodeMap = new HashMap<>();
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!nodeMap.containsKey(key)) {
                return -1;
            }
            Node curr = nodeMap.get(key);
            removeANode(curr);
            addToHead(curr);
            return curr.val;
        }

        public void put(int key, int value) {
            if (!nodeMap.containsKey(key)) {
                if (nodeMap.size() == capacity) {
                    nodeMap.remove(removeLast());
                }
                Node curr = new Node(key, value);
                nodeMap.put(key, curr);
                addToHead(curr);
            } else {
                Node curr = nodeMap.get(key);
                curr.val = value;
                removeANode(curr);
                addToHead(curr);
            }
        }

        private void removeANode(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        private void addToHead(Node node) {
            Node next = head.next;
            head.next = node;
            node.prev = head;
            node.next = next;
            next.prev = node;
        }

        private int removeLast() {
            Node last = tail.prev;
            Node prev = last.prev;
            prev.next = tail;
            tail.prev = prev;
            return last.key;
        }

        class Node{
            Node prev;
            Node next;
            int key;
            int val;
            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }

    // Cheating way: linkedHashMap
    class LRUCache3 extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache3(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }
}
