package projects.phonebook;

/**
 * <p>{@link HashTable} is an abstraction over hash tables. Implementing classes
 * should offer <em>amortized constant</em> insertion, search and deletion. The method
 * names that you have to implement are the namesakes of {@link java.util.Hashtable}.</p>
 *
 * @param <K> The key type. It is <b>IMPERATIVE</b> that this is an <em>immutable</em> type!
 * @param <V> The value type. This can be any {@link Object}.
 */
public interface HashTable<K, V> {

    int STARTING_SIZE = 13;

    void put (K key, V value);

    V get(K key);

    V remove(K key);

    boolean containsKey(K key);

    boolean containsValue(V value);

    int size();
}
