class Association<K extends Comparable<K>, V> implements Comparable<Association<K, V>> {
    K key = null;
    V value = null;

    public Association(K k, V v){
        key = k;
        value = v;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public int compareTo(Association<K, V> o) {
        return this.key.compareTo(o.getKey());
    }
}
