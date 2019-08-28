package lvc.cds.hashtables;

public interface Map<K, V> {

    int size();
    boolean isEmpty();

    V put(K key, V value);
    boolean containsKey(K key);
    V get(K key);
    V remove(K key);
}
