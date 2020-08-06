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

    // hashMap + hashMap of nodes
    class LRUCache2{
        private int capacity;
        private Map<Integer, Integer> keyValueMap; // <key, value>
        private Map<Integer, Node> nodeMap; // <key, node>
        private Node head;
        private Node tail;

        /*
        head -- newestNode -- someNodes -- oldestNode -- tail
         */
        public LRUCache2(int capacity) {
            this.capacity = capacity;
            keyValueMap = new HashMap<>();
            nodeMap = new HashMap<>();
            head = new Node(-1);
            tail = new Node(-1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!keyValueMap.containsKey(key)) {
                return -1;
            }
            Node updatedNode = nodeMap.get(key);
            removeANode(updatedNode);
            addToHead(updatedNode);
            return keyValueMap.get(key);
        }

        public void put(int key, int value) {
            if (!keyValueMap.containsKey(key)) {
                if (keyValueMap.size() == capacity) {
                    int removedKey = removeLast();
                    keyValueMap.remove(removedKey);
                    nodeMap.remove(removedKey);
                }
                Node insertedNode = new Node(key);
                keyValueMap.put(key, value);
                nodeMap.put(key, insertedNode);
                addToHead(insertedNode);
            } else {
                Node updatedNode = nodeMap.get(key);
                keyValueMap.put(key, value);
                removeANode(updatedNode);
                addToHead(updatedNode);
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
            return last.val;
        }

        class Node{
            Node prev;
            Node next;
            int val;
            public Node(int val) {
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
