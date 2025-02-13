/*
 Implement a Custom Hash Map
Problem: Design and implement a basic hash map class with operations for insertion, deletion, and retrieval.
Hint: Use an array of linked lists to handle collisions using separate chaining.
 */
import java.util.*;

class CustomHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 10; // Initial size of the array
    private List<Entry<K, V>>[] buckets; // Array of LinkedLists
    private int size; // Number of elements in the hash map

    // Entry class to store key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor
    public CustomHashMap() {
        buckets = new LinkedList[DEFAULT_CAPACITY];
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // Hash function to determine the index
    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    // Insert or update key-value pair
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        List<Entry<K, V>> bucket = buckets[index];

        // Check if key already exists, update value
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        // If key not found, add a new entry
        bucket.add(new Entry<>(key, value));
        size++;
    }

    // Retrieve value by key
    public V get(K key) {
        int index = getBucketIndex(key);
        List<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // Key not found
    }

    // Remove key-value pair
    public void remove(K key) {
        int index = getBucketIndex(key);
        List<Entry<K, V>> bucket = buckets[index];

        Iterator<Entry<K, V>> iterator = bucket.iterator();
        while (iterator.hasNext()) {
            Entry<K, V> entry = iterator.next();
            if (entry.key.equals(key)) {
                iterator.remove();
                size--;
                return;
            }
        }
    }

    // Get current size of the HashMap
    public int size() {
        return size;
    }

    // Print the HashMap (for debugging)
    public void printMap() {
        for (int i = 0; i < buckets.length; i++) {
            System.out.print("Bucket " + i + ": ");
            for (Entry<K, V> entry : buckets[i]) {
                System.out.print("[" + entry.key + " -> " + entry.value + "] ");
            }
            System.out.println();
        }
    }

    // Main method to test
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        // Inserting key-value pairs
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("cherry", 30);

        // Retrieving values
        System.out.println("apple: " + map.get("apple")); // 10
        System.out.println("banana: " + map.get("banana")); // 20
        System.out.println("grape: " + map.get("grape")); // null (not present)

        // Updating a value
        map.put("banana", 25);
        System.out.println("Updated banana: " + map.get("banana")); // 25

        // Removing a key
        map.remove("apple");
        System.out.println("apple after removal: " + map.get("apple")); // null

        // Print the entire HashMap
        map.printMap();
    }
}
