package lvc.cds.hashtables;

import com.sun.javafx.css.StyleCacheEntry;

import java.util.ArrayList;

public class BubbaHashMap<K, V> implements Map<K, V> {
    private ArrayList<Pair<K,V>> table;
    private int[] bucketData;
    private int size;
    private final int BUCKET_SIZE;

    public BubbaHashMap(int sz) {
        table = new ArrayList<Pair<K,V>>(sz);
        size = 0;
        for (int i=0; i<sz; ++i)
            table.add(null);

        bucketData = new int[sz];
        BUCKET_SIZE = 4;
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
        //find initial hash location
        int hash = Math.abs(key.hashCode() % table.size());

        //see if the key is in the map already
        int pos=find(key, hash);
        if(pos != -1){

        }

        int index = hash;
        while(table.get(index) != null)
            index = (index + 1) % table.size();

        while(dist(hash, index) >= BUCKET_SIZE){
            int candidate = index - BUCKET_SIZE + 1;
            for(int i = 0; i < BUCKET_SIZE; i++){
                int candidate = Math.abs(table, get())
            }
        }
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

    private int find(K key, int hash){
        return -1;
    }

    // return the distance between b and s in the table. That is,
    // how far do you have to move to get FROM b TO s.
    private int dist(int b, int s) {
        return 0;
    }

    // update bookkeeping to reflect that this slot in that bucket is occupied
    private void markSlot(int bucket, int slot) {}

    // update bookkeeping to reflect that this slot in that bucket is unoccupied
    private void clearSlot(int bucket, int slot) {}

    // ask bookkeeping if this slot in that bucket is occupied
    private boolean isOccupied(int bucket, int slot) {return false;}
}
