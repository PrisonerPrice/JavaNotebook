package LeetCodeProblems;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// LFU Cache
public class LC460 {

    private int capacity;
    private Map<Integer, Integer> keyValueMap;
    private Map<Integer, Integer> keyFreqMap;
    private Map<Integer, ModifiedLRUCache> lruMap;
    private int minFreq = 1;

    public LC460(int capacity) {
        this.capacity = capacity;
        keyValueMap = new HashMap<>();
        keyFreqMap = new HashMap<>();
        lruMap = new HashMap<>();
    }

    public int get(int key) {
        // if no value match or capacity is 0, returns -1
        if (!keyValueMap.containsKey(key) || capacity == 0)
            return -1;

        // get the curr freq of the given key
        int freq = keyFreqMap.get(key);

        // remove curr key from the given freq-lruCache
        ModifiedLRUCache lowerFreqLRUCache = lruMap.get(freq);
        lowerFreqLRUCache.remove(key);

        // if this level's size == 0 and this level's freq == minFreq, minFreq++
        if (freq == minFreq && lowerFreqLRUCache.size() == 0) {
            minFreq++;
        }

        // go to next level freq-lruCache
        freq++;
        ModifiedLRUCache higherFreqLRUCache = lruMap.getOrDefault(freq, new ModifiedLRUCache());

        // put key here and update the freq for this key
        higherFreqLRUCache.put(key);
        lruMap.put(freq, higherFreqLRUCache);
        keyFreqMap.put(key, freq);
        return keyValueMap.get(key);
    }

    public void put(int key, int value) {
        // if capacity is 0, do nothing
        if (capacity == 0)
            return;
        // because of we are putting something new, minFreq will be set to 1
        if (!keyValueMap.containsKey(key)) {
            // LFU is full, need to do evict
            if (keyValueMap.size() == capacity) {
                ModifiedLRUCache lruCache = lruMap.get(minFreq);
                if (lruCache != null && lruCache.size() > 0) {
                    int removedKey = lruCache.removeLast();
                    keyValueMap.remove(removedKey);
                    keyFreqMap.remove(removedKey);
                }
            }
            keyValueMap.put(key, value);
            keyFreqMap.put(key, 1);
            minFreq = 1;
            ModifiedLRUCache freq1LruCache = lruMap.getOrDefault(1, new ModifiedLRUCache());
            freq1LruCache.put(key);
            lruMap.put(1, freq1LruCache);
        }
        // update existed key-value pair
        else {
            keyValueMap.put(key, value);

            // get the curr freq of the given key
            int freq = keyFreqMap.get(key);

            // remove curr key from the given freq-lruCache
            ModifiedLRUCache lowerFreqLRUCache = lruMap.get(freq);
            //System.out.println("Before removing: " + lruMap.toString());
            lowerFreqLRUCache.remove(key);
            //System.out.println("After removing: " + lruMap.toString());

            // if this level's size == 0 and this level's freq == minFreq, minFreq++
            if (freq == minFreq && lowerFreqLRUCache.size() == 0)
                minFreq++;

            // go to next level freq-lruCache
            freq++;
            ModifiedLRUCache higherFreqLRUCache = lruMap.getOrDefault(freq, new ModifiedLRUCache());

            // put key here and update the freq for this key
            higherFreqLRUCache.put(key);
            lruMap.put(freq, higherFreqLRUCache);
            keyFreqMap.put(key, freq);
        }
    }

    class ModifiedLRUCache {
        private Map<Integer, Node> nodeMap;
        private Node head;
        private Node tail;

        public ModifiedLRUCache() {
            nodeMap = new HashMap<>();
            head = new Node(-1);
            tail = new Node(-1);
            head.next = tail;
            tail.prev = head;
        }

        public void put(int key) {
            Node curr = new Node(key);
            nodeMap.put(key, curr);
            addToHead(curr);
        }

        public void remove(int key) {
            Node removed = nodeMap.get(key);
            nodeMap.remove(key);
            removeANode(removed);
        }

        public int size() {
            return nodeMap.size();
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

        public int removeLast() {
            Node last = tail.prev;
            Node prev = last.prev;
            prev.next = tail;
            tail.prev = prev;
            nodeMap.remove(last.key);
            return last.key;
        }

        class Node {
            Node prev;
            Node next;
            int key;
            public Node(int key) {
                this.key = key;
            }
        }

        @Override
        public String toString() {
            String returnString = "[Head], ";
            Node node = head.next;
            while (node != tail) {
                returnString += "[" + node.key + "], ";
                node = node.next;
            }
            returnString += "[Tail]";
            return returnString;
        }
    }
}
