package lvc.cds.hashtables;

import java.util.ArrayList;

public class HashTable<K, V> implements Map<K, V> {
    private ArrayList<Pair<K,V>> table;
    private int size;

    public HashTable(int sz) {
        table = new ArrayList<Pair<K,V>>(sz);
        size = 0;
        for (int i=0; i<sz; ++i)
            table.add(null);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void put(K key, V value) {

    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }
}
