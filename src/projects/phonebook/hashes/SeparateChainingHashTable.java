package projects.phonebook.hashes;
import java.util.LinkedList;

public class SeparateChainingHashTable<K, V> implements HashTable<K, V>{


    /* ******************************************** */
    /* PRIVATE FIELDS PROVIDED TO YOU: DO NOT EDIT! */
    /* ******************************************** */


    private LinkedList[] table;


    /**
     * @param startSize
     */
    public SeparateChainingHashTable(int startSize){
        table = new LinkedList[startSize];
    }

    /**
     *
     */
    public SeparateChainingHashTable(){
        this(DEFAULT_STARTING_SIZE);
    }

    @Override
    public void put(K key, V value) {

    }
    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    /**
     *
     */
    public void enlarge() {

    }
}
