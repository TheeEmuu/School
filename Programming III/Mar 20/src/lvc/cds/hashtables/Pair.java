package lvc.cds.hashtables;

class Pair<K, V> {
    K key;
    V value;
    boolean reserved;

    Pair(K k) {
        this(k, null);
    }

    Pair(K k, V v) {
        this.key = k;
        this.value = v;
        reserved = false;
    }
}
