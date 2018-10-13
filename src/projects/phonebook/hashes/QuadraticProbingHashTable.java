package projects.phonebook.hashes;

public class QuadraticProbingHashTable<K, V> implements HashTable<K, V>{


    private static final RuntimeException UNIMPL_METHOD = new RuntimeException("Implement this method!");

    private Object[] table;

    private int hash(K key){
        return key.hashCode() % table.length;
    }

    /** Non-default constructor.
     * @param startSize The size to initialize our inner storage with. Must be a strictly positive integer.
     * @throws RuntimeException if <tt>startSize</tt> is not a positive integer.
     */
    public QuadraticProbingHashTable(int startSize){
        if(startSize < 1 )
            throw new RuntimeException("Provided startSize=" + startSize + ". Only strictly positive sizes are allowed.");
        table = new Object[startSize];
    }
    /**
     *  Default constructor. Initializes the internal storage with a size equal to {@link #DEFAULT_STARTING_SIZE}
     */
    public QuadraticProbingHashTable(){
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
