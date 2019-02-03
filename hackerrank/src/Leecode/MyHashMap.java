package Leecode;


import utils.AssertUtils;

public class MyHashMap {
    private Entry[] values = new Entry[2000];

    static class Entry{
        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        int key,value;
        Entry next;
    }

    /** Initialize your data structure here. */
    public MyHashMap() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        Entry entry = getValue(key);
        if(entry != null) {
            entry.value = value;
        } else {
            int index = getKeyIndex(key);
            Entry head = values[index];
            Entry current = new Entry(key, value);
            values[index] = current;
            current.next = head;
        }
    }

    private Entry getValue(int key) {
        int index = getKeyIndex(key);
        if(values[index] == null) return null;

        Entry current = values[index];

        while (current!= null) {
            if(current.key == key) return current;
            current = current.next;
        }
        return null;
    }


    private int getKeyIndex(int key) {
        return key % values.length;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        Entry entry = getValue(key);
        if(entry == null) return -1;

        return entry.value;

    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getKeyIndex(key);

        Entry head = values[index];
        if (head == null) return;
        if(head.key == key) {
            values[index] = head.next;
            return;
        }

        while (head.next != null)  {
            if (head.next.key == key) {
                head.next = head.next.next;
                return;
            }
            head = head.next;
        }

    }


    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
//        map.remove(2);
        map.put(3, 11);
        AssertUtils.equals(-1, map.get(2));
        AssertUtils.equals(11, map.get(3));
        map.put(4, 13);
        map.put(4, 12);
        AssertUtils.equals(12, map.get(4));
        map.remove(4);
        AssertUtils.equals(-1, map.get(4));
        map.put(4, 14);
        map.put(2004, 15);
        map.put(4004, 16);
        map.put(6004, 16);
        AssertUtils.equals(14, map.get(4));
        AssertUtils.equals(15, map.get(2004));
        AssertUtils.equals(16, map.get(4004));
        AssertUtils.equals(16, map.get(6004));
        map.remove(4);
        AssertUtils.equals(-1, map.get(4));
        AssertUtils.equals(15, map.get(2004));
        AssertUtils.equals(16, map.get(4004));
        AssertUtils.equals(16, map.get(6004));

        map.remove(4004);
        AssertUtils.equals(15, map.get(2004));
        AssertUtils.equals(16, map.get(6004));

        map.remove(2004);
        AssertUtils.equals(16, map.get(6004));

        map.remove(6004);

        AssertUtils.equals(-1, map.get(6004));

    }
}


