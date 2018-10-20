package projects.phonebook.utils;

/**
 * <p>{@link KVPairList} is a simple linked list storing pairs of {@link String}s. It offers <b>constant-time</b>
 * insertion in the front and the back of the list, linear-time search and deletion and constant-time size querying for size and
 * emptiness. To achieve constant-time insertions, it keeps track of both the first and the last node in the list. To achieve constant-time
 * size querying, it keeps track of the list's count while insertions and deletions are made.</p>
 *
 * <p>Duplicate entries <b>are</b> possible in {@link KVPairList}. Additionally, {@link KVPairList}s are
 * <b>not</b> sorted.</p>
 *
 * @author <a href="mailto:jason.filippou@gmail.com">Jason Filippou</a>
 *
 * @see KVPair
 * @see KVPairListTests
 */
public class KVPairList {

    private class Node {
        KVPair pair;
        Node next;

        Node(String key, String value, Node next){
            pair = new KVPair(key, value);
            this.next = next;
        }

        Node(String key, String value){
            this(key, value, null);
        }

    }

    private Node head, tail;
    private int count;

    /**
     * Default constructor. Initializes an empty {@link KVPairList}.
     */
    public KVPairList(){
        head = tail = null;
        count = 0;
    }

    /**
     * Non-default constructor which initializes a {@link KVPairList} with a single node with provided values.
     * @param key The key {@link String} in the pair.
     * @param value The value {@link String} in the pair.
     */
    public KVPairList(String key, String value){
        head = tail = new Node(key, value);
        count = 1;
    }

    /**
     *
     * @param key The &quot;key&quot; {@link String} in the pair.
     * @param value The &quot;value&quot; {@link String} in the pair.
     */
    public void addBack(String key, String value){
        if(tail == null){
            assert head == null : "Head and tail can only be null together";

            head = tail = new Node(key, value);
        } else {
            tail.next = new Node(key, value);
            tail = tail.next;
        }
        count++;
    }

    /**
     *
     * @param key The &quot;key&quot; {@link String} in the pair.
     * @param value The &quot;value&quot; {@link String} in the pair.
     */
    public void addFront(String key, String value){
        if(head == null){
            assert tail == null : "Head and tail can only be null together";
            head = tail = new Node(key, value);
        } else {
            head = new Node(key, value, head);
        }
        count++;
    }

    /**
     * Updates the value of the pair &lt; key, value &gt; based on the provided <tt>key</tt>. If <tt>key</tt> does not exist
     * in <tt>this</tt>, this method has <b>no effect</b>.
     * @param key The &quot;key&quot; {@link String} that we are searching for.
     * @param value The new &quot;value&quot; {@link String} to update the old value {@link String} with.
     */
    public void updateValue(String key, String value){
        Node current = head;
        while(current != null){
            if(current.pair.getKey().equals(key))
                current.pair.setValue(value);
            current = current.next; // Keep updating other possible entries.
        }
    }

    /**
     * Updates the key of the pair &lt; key, value &gt; based on the provided <tt>value</tt>. If <tt>value</tt> does not exist
     * in <tt>this</tt>, this method has <b>no effect</b>.
     * @param key The &quot;key&quot; {@link String} that we are searching for.
     * @param value The new &quot;value&quot; {@link String} to update the old value {@link String} with.
     */
    public void updateKey(String key, String value){
        Node current = head;
        while(current != null){
            if(current.pair.getValue().equals(value))
                current.pair.setKey(key);
            current = current.next; // Keep updating other possible entries.
        }
    }

    /**
     * Deletes the <b>first</b> occurrence of the pair &lt; key, value &gt; from the {@link KVPairList}. Linear - time operation.
     * If &lt; key, value &gt; does <b>not</b> belong in the {@link KVPairList}, this method has <b>no effect</b>.
     * @param key The key {@link String} in the pair.
     * @param value The value {@link String} in the pair.
     * @see #containsKVPair(String, String)
     */
    public void delete(String key, String value){
        Node current = head;
        Node previous = null;
        while(current != null){
            if(current.pair.getKey().equals(key) && current.pair.getValue().equals(value)){ // Found it
                if(previous != null)
                    previous.next = current.next;
                if(current == head) {
                    assert previous == null : "If we find the element at the beginning of the list, previous should be null.";
                    head = head.next;
                }
                if(current == tail){
                    assert tail.next == null : "If we find the element at the end of the list, the next element should be null.";
                    tail = tail.next;
                }
                count--;
                break;
            }
            previous = current;
            current = current.next;
        }
    }

    /**
     * Searches the {@link KVPairList} for the pair &lt; key, value &gt; and reports if it found it. There might be
     * more than one occurrences of &lt; key, value &gt; in the list: this method searches for <b>at least one</b>.
     * @param key The key {@link String} in the pair.
     * @param value The value {@link String} in the pair.
     * @return <tt>true</tt> if, and only if, the pair &lt; key, value &gt; exists at least once in the {@link KVPairList},
     *              <tt>false</tt> otherwise.
     */
    public boolean containsKVPair(String key, String value){
        Node current = head;
        while(current != null){
            if(current.pair.getKey().equals(key) && current.pair.getValue().equals(value))
                return true;
            current = current.next;
        }
        return false;
    }



    /**
     * Simple getter for values based on keys.
     * @param key the &quot;value&quot; {@link String}
     * @return The &quot;key&quot; {@link String} or <tt>null</tt> if <tt>key</tt> could not be found in <tt>this</tt>.
     */
    public String getValue(String key){
        Node current = head;
        while(current != null) {
            if (current.pair.getKey().equals(key)){
                return current.pair.getValue();
            }
            current = current.next;
        }
        return null;
    }

    /**
     * Simple getter for keys based on values.
     * @param value the value {@link String}
     * @return The &quot; key &quot; {@link String} or <tt>null</tt> if <tt>value</tt> could not be found in <tt>this</tt>.
     */
    public String getKey(String value){
        Node current = head;
        while(current != null) {
            if (current.pair.getValue().equals(value)){
                return current.pair.getKey();
            }
            current = current.next;
        }
        return null;
    }


    /**
     * Returns the number of nodes in the {@link KVPairList}. Constant-time operation because of inner variable that keeps track of the count.
     * @return the number of nodes in the {@link KVPairList}.
     */
    public int size(){
        return count;
    }

    /**
     * Queries the {@link KVPairList} for emptiness.
     * @return <tt>true</tt> if, and only if, the {@link KVPairList} has a {@link #size()} of 0 (zero), <tt>false</tt> otherwise.
     */
    public boolean isEmpty(){
        return size() == 0;
    }

}
