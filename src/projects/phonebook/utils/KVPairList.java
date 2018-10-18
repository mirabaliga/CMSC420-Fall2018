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

        Node(String first, String second, Node next){
            pair = new KVPair(first, second);
            this.next = next;
        }

        Node(String first, String second){
            this(first, second, null);
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
     * @param first The first {@link String} in the pair.
     * @param second The second {@link String} in the pair.
     */
    public KVPairList(String first, String second){
        head = tail = new Node(first, second);
        count = 1;
    }

    /**
     *
     * @param first The first {@link String} in the pair.
     * @param second The second {@link String} in the pair.
     */
    public void addBack(String first, String second){
        if(tail == null){
            assert head == null : "Head and tail can only be null together";

            head = tail = new Node(first, second);
        } else {
            tail.next = new Node(first, second);
            tail = tail.next;
        }
        count++;
    }

    /**
     *
     * @param first The first {@link String} in the pair.
     * @param second The second {@link String} in the pair.
     */
    public void addFront(String first, String second){
        if(head == null){
            assert tail == null : "Head and tail can only be null together";
            head = tail = new Node(first, second);
        } else {
            head = new Node(first, second, head);
        }
        count++;
    }

    /**
     * Deletes the <b>first</b> occurrence of the pair &lt; first, second &gt; from the {@link KVPairList}. Linear - time operation.
     * If &lt; first, second &gt; does <b>not</b> belong in the {@link KVPairList}, this method has <b>no effect</b>.
     * @param first The first {@link String} in the pair.
     * @param second The second {@link String} in the pair.
     * @see #contains(String, String)
     */
    public void delete(String first, String second){
        Node current = head;
        Node previous = null;
        while(current != null){
            if(current.pair.getKey().equals(first) && current.pair.getValue().equals(second)){ // Found it
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
     * Searches the {@link KVPairList} for the pair &lt; first, second &gt; and reports if it found it. There might be
     * more than one occurrences of &lt; first, second &gt; in the list: this method searches for <b>at least one</b>.
     * @param first The first {@link String} in the pair.
     * @param second The second {@link String} in the pair.
     * @return <tt>true</tt> if, and only if, the pair &lt; first, second &gt; exists at least once in the {@link KVPairList},
     *              <tt>false</tt> otherwise.
     */
    public boolean contains(String first, String second){
        Node current = head;
        while(current != null){
            if(current.pair.getKey().equals(first) && current.pair.getValue().equals(second))
                return true;
            current = current.next;
        }
        return false;
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
