package projects.phonebook.hashes;

public class LinearProbingHashTable<K, V> implements HashTable<K, V>{

    private static final RuntimeException UNIMPL_METHOD = new RuntimeException("Implement this method!");

    private int hash(K key){
        return key.hashCode() % table.length;
    }

    private Object[] table;

    /** Non-default constructor.
     * @param startSize The size to initialize our inner storage with. Must be a strictly positive integer.
     * @throws RuntimeException if <tt>startSize</tt> is not a positive integer.
     */
    public LinearProbingHashTable(int startSize){
        if(startSize < 1 )
            throw new RuntimeException("Provided startSize=" + startSize + ". Only strictly positive sizes are allowed.");
        table = new Object[startSize];
    }
    /**
     *  Default constructor. Initializes the internal storage with a size equal to {@link #DEFAULT_STARTING_SIZE}
     */
    public LinearProbingHashTable(){
        this(DEFAULT_STARTING_SIZE);
    }

    @Override
    public void put(K key, V value) {
        throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!
    }

    @Override
    public V get(K key) {
        throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!
    }

    @Override
    public V remove(K key) {
        throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!
    }

    @Override
    public boolean containsKey(K key) {
        throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!
    }

    @Override
    public boolean containsValue(V value) {
        throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!
    }

    @Override
    public int size() {
        throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!
    }

    @Override
    public int capacity() {
        throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!

    }
}
