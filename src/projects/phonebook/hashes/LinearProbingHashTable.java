package projects.phonebook.hashes;
import projects.phonebook.utils.KVPair;

public class LinearProbingHashTable implements HashTable{

    private static final RuntimeException UNIMPL_METHOD = new RuntimeException("Implement this method!");

    private int hash(String key){
        return key.hashCode() % table.length;
    }

    private KVPair[] table;


    /** Non-default constructor.
     * @param startSize The size to initialize our inner storage with. Must be a strictly positive integer.
     * @throws RuntimeException if <tt>startSize</tt> is not a positive integer.
     */
    public LinearProbingHashTable(int startSize){
        if(startSize < 1 )
            throw new RuntimeException("Provided startSize=" + startSize + ". Only strictly positive sizes are allowed.");
        table = new KVPair[startSize];
    }
    /**
     *  Default constructor. Initializes the internal storage with a size equal to {@link #DEFAULT_STARTING_SIZE}
     */
    public LinearProbingHashTable(){
        this(DEFAULT_STARTING_SIZE);
    }

    @Override
    public void put(String key, String value) {
        throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!
    }

    @Override
    public String get(String key) {
        throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!
    }

    @Override
    public String remove(String key) {
        throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!
    }

    @Override
    public boolean containsKey(String key) {
        throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!
    }

    @Override
    public boolean containsValue(String value) {
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
