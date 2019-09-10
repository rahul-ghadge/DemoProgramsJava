package com.demo.program.datastructure;


import java.util.HashMap;

class Entry {
    int value;
    int key;
    Entry left;
    Entry right;
}

public class LRUCache {

    HashMap<Integer, Entry> hashmap;
    Entry start, end;
    int LRU_SIZE = 4;
    // Here i am setting 4 to test the LRU cache
    // implementation, it can make be dynamic


    public LRUCache() {
        hashmap = new HashMap<Integer, Entry>();
    }


    public static void main(String[] args) {
        // your code goes here
        LRUCache lrucache = new LRUCache();
        lrucache.putEntry(1, 1);
        lrucache.putEntry(10, 15);
        lrucache.putEntry(15, 10);
        lrucache.putEntry(10, 16);
        lrucache.putEntry(12, 15);
        lrucache.putEntry(18, 10);
        lrucache.putEntry(13, 16);

        System.out.println(lrucache.getEntry(1));
        System.out.println(lrucache.getEntry(10));
        System.out.println(lrucache.getEntry(15));

    }

    public int getEntry(int key) {
        if (hashmap.containsKey(key)) // Key Already Exist, just update the
        {
            Entry entry = hashmap.get(key);
            removeNode(entry);
            addAtTop(entry);
            return entry.value;
        }
        return -1;
    }

    public void putEntry(int key, int value) {
        if (hashmap.containsKey(key))
            // Key Already Exist, just update the value and move it to top
        {
            Entry entry = hashmap.get(key);
            entry.value = value;
            removeNode(entry);
            addAtTop(entry);
        } else {

            Entry newnode = new Entry();

            newnode.left = null;
            newnode.right = null;
            newnode.value = value;
            newnode.key = key;
            if (hashmap.size() > LRU_SIZE)
                // We have reached maximum size so need to make room for new element.
            {
                hashmap.remove(end.key);
                removeNode(end);
                addAtTop(newnode);

            } else {
                addAtTop(newnode);
            }

            hashmap.put(key, newnode);
        }
    }

    public void addAtTop(Entry node) {
        node.right = start;
        node.left = null;
        if (start != null)
            start.left = node;
        start = node;
        if (end == null)
            end = start;
    }

    public void removeNode(Entry node) {

        if (node.left != null) {
            node.left.right = node.right;
        } else {
            start = node.right;
        }

        if (node.right != null) {
            node.right.left = node.left;
        } else {
            end = node.left;
        }
    }
}