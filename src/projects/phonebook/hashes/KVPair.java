package projects.phonebook.hashes;

/**
 * <p>{@link KVPair} is a simple abstraction of a  &lt;K, V&lt; pair. It allows accessing the associated value of a key
 * with a single pointer assignment.</p>
 *
 * <p>You do <b>NOT</b> have to use this class, and, if you do, feel free to edit it to your liking.</p>
 *
 * @param <K> The type of key. <b>THIS TYPE *MUST* BE IMMUTABLE/</b>
 * @param <V> The type of value.
 *
 * @author <a href = "mailto:jason.filippou@gmail.com">jason.filippou@gmail.com</a>
 */
public class KVPair<K, V> {

    private K key;
    private V value;

    /**
     * Simple constructor.
     * @param key The key of the entry.
     * @param value The value of the entry.
     */
    public KVPair(K key, V value){
        this.key = key;
        this.value = value;
    }

    /**
     * Simple accessor.
     * @return The key associated with the entry.
     */
    public K getKey() {
        return key;
    }

    /**
     * Simple accessor.
     * @return The value associated with the entry.
     */
    public V getValue() {
        return  value;
    }

    /**
     * Simple mutator.
     * @param key The new key to provide to this entry. Useful in UPDATE queries.
     */
    public void setKey(K key){
        this.key = key;
    }

    /**
     * Simple mutator.
     * @param value The new value to provide to this entry. Useful in UPDATE queries.
     */
    public void setValue(V value){
        this.value = value;
    }

    @Override
    public boolean equals(Object other){
        if(other == null)
            return false;
        KVPair otherCasted = null;
        try {
            otherCasted = (KVPair)other;
        } catch(ClassCastException ignored){
                return  false;
        }
        return otherCasted.key.equals(key) && otherCasted.value.equals(value);
    }
}
