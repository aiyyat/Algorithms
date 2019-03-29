package com.aiyyatti.algorithms.ctci;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class LRUCache {
    private static final Map<Integer, String> db = new Hashtable<>();

    @BeforeClass
    public static void initDB() {
        db.put(1, "Apples");
        db.put(2, "Bananas");
        db.put(3, "Coconuts");
        db.put(4, "Cherries");
        db.put(5, "Strawberries");
        db.put(6, "Avacados");
        db.put(7, "Black Berries");
        db.put(8, "Blue Berries");
        db.put(9, "Raspberries");
        db.put(10, "Lichie");
        db.put(11, "Peanuts");
        db.put(12, "Pumpkin");
        db.put(13, "Carrot");
    }

    @Test
    public void testSimple() {
        TestCase.assertEquals(Source.DB, findFromLRUCache(3).sourceOfData);
        TestCase.assertEquals(Source.DB, findFromLRUCache(1).sourceOfData);
        TestCase.assertEquals(Source.DB, findFromLRUCache(2).sourceOfData);
        TestCase.assertEquals(Source.CACHE, findFromLRUCache(3).sourceOfData);
        TestCase.assertEquals(Source.DB, findFromLRUCache(4).sourceOfData);
        TestCase.assertEquals(Source.CACHE, findFromLRUCache(2).sourceOfData);
        TestCase.assertEquals(Source.DB, findFromLRUCache(6).sourceOfData);
        TestCase.assertEquals(Source.DB, findFromLRUCache(1).sourceOfData);
    }

    private final Cache cache = new Cache(3);

    public Response findFromLRUCache(int id) {
        return cache.get(id);
    }

    /**
     * Use DoubleLinkedList and get O(1) deletion time complexity
     */
    class Cache {
        int size;
        Map<Integer, Node> map = new HashMap<>();
        Node head = null;
        Node tail = null;
        int headToTail = 0;

        public Cache(int size) {
            this.size = size;
        }

        public Response get(int id) {
            System.out.println(map);
            Source source = Source.DB;
            Node node = map.get(id);
            if (node == null) {
                node = new Node(id, db.get(id));
                map.put(id, node);
                if (head == null) {
                    head = tail = node;
                    headToTail = 1;
                    return new Response(source, node);
                } else {
                    headToTail++;
                    if (headToTail > size) {
                        map.remove(tail.id);
                        if (tail.prev != null) tail.prev.next = null;
                        tail = tail.prev;
                    }
                }
            } else {
                Node prev = node.prev;
                if (prev != null) prev.next = node.next;
                source = Source.CACHE;
            }
            node.next = head;
            head.prev = node;
            head = node;
            return new Response(source, node);
        }
    }

}

class Node {
    int id;
    Node next;
    Node prev;
    String value;

    public Node(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public void next(Node next) {
        this.next = next;
    }

    public void prev(Node prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return id + "->" + value;
    }
}

class Response {
    Source sourceOfData;
    int id;
    String item;

    public Response(Source sourceOfData, Node node) {
        this(sourceOfData, node.id, node.value);
    }

    public Response(Source sourceOfData, int id, String item) {
        this.sourceOfData = sourceOfData;
        this.id = id;
        this.item = item;
    }

    public Source getSourceOfData() {
        return sourceOfData;
    }

    public int getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    @Override
    public String toString() {
        return sourceOfData + "&" + item;
    }
}

enum Source {
    CACHE, DB
}
