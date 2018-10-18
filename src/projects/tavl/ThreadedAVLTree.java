package projects.tavl;
import java.util.Iterator;     // You need this import because of the interface method inorderTraversal()'s return type.

/**<p> {@link ThreadedAVLTree} implements threaded <a href="https://en.wikipedia.org/wiki/AVL_tree">Adelson-Velsky-Landis (AVL) trees</a>
 * (shorthand: TAVL trees). These trees:</p>
 * <ol>
 *      <li> Allow for efficient lookup, insertion and deletion in <em>O(logn)</em> time, by virtue
 *       of being AVL trees.</li>
 *       <li>Perform a full inorder traversal in <em>O(n)</em> time, by virtue of being threaded trees.</li>
 * </ol>
 * <p>Hence, two powerful ideas that we have talked about in lecture will now be combined in one data structure. </p>
 *
 *  <p>To get more than 50&#37; credit for this project, you <b>must</b> attempt to implement your tree as a <b>threaded</b>
 * tree, as discussed in lecture. We have access to your source code after submission and we <b>will</b> be checking to
 * make sure that you have been appropriately updating the tree's threads every time you must! You are also required to
 * implement a method for generating the inorder traversal over such a tree, and this method needs to be functioning
 * <b>entirely stacklessly!</b>Read the project description for more in-depth information.</p>
 *
 * <p>Finally, for this project, <b>we assume that there are no duplicate keys in your data structure. </b> This means that, in our unit tests,
 * whenever we delete a key from your tree, <b>we expect it to no longer be found in the tree.</b> You may deal with this
 * invariant in any way you please, e.g. throw an exception if a duplicate is inserted, or delete all instances of a key when we ask for a deletion.</p>
 *
 * @author ------- PUT YOUR NAME HERE! ------
 * @see #inorderTraversal()
 * @see StudentTests
 * @param <T> The {@link java.lang.Comparable} type held by the data structure.
 */
public class ThreadedAVLTree<T extends Comparable<T>> {


    private static final String UNIMPL_MSG = "Implement this method!";

    /* ***************************************************************************
     * PLACE YOUR PRIVATE, PACKAGE-PRIVATE AND PROTECTED MEMBERS  AND METHODS HERE:
     * *************************************************************************** */



    /* ******************************************
     * IMPLEMENT THE CLASS' PUBLIC METHODS BELOW:
     * ****************************************** */


    /**
     * Default constructor. Your code should allow for one, since the unit tests
     * depend on the presence of a default constructor.
     */
    public ThreadedAVLTree(){
        /*
         *  Fill-in the code here!
         */
        throw new RuntimeException(UNIMPL_MSG); // <---- When done implementing your method, erase this line!

        /* Note: Depending on how you handle things. it might be completely ok
         * to have nothing in your constructor. That is, the only thing you'd need to do
         * here is erase the application of throw() above. Your code, your choice ! */
    }

    /**
     * Insert <tt>key</tt> in the tree.
     * @param key The key to insert in the tree.
     */
    public void insert(T key){
        /*
         *  Fill-in the code here!
         */
        throw new RuntimeException(UNIMPL_MSG); // <---- When done implementing your method, erase this line!
    }

    /**
     * Delete the key from the data structure and return it to the caller. Note that it is assumed that there are no
     * duplicate keys in the tree. That is, if a key is deleted from the tree, it should no longer be found in it.
     * @param key The key to deleteRec from the structure.
     * @return The key that was removed, or <tt>null</tt> if the key was not found.
     */
    public T delete(T key){
        /*
         *  Fill-in the code here!
         */
        throw new RuntimeException(UNIMPL_MSG); // <---- When done implementing your method, erase this line!
    }

    /**
     * Search for <tt>key</tt> in the tree. Return a reference to it if it's in there,
     * or <tt>null</tt> otherwise.
     * @param key The key to look for in the tree.
     * @return <tt>key</tt> if <tt>key</tt> is in the tree, or <tt>null</tt> otherwise.
     */
    public T search(T key){
        /*
         *  Fill-in the code here!
         */
        throw new RuntimeException(UNIMPL_MSG); // <---- When done implementing your method, erase this line!
    }


    /**
     * Return the height of the tree. The height of the tree is defined as the length of the
     * longest path between the root and the leaf level. By definition of path length, a
     * stub tree has a height of 0, and we define an empty tree to have a height of -1.
     * @return The height of the tree.
     */
    public int height(){
        /*
         *  Fill-in the code here!
         */
        throw new RuntimeException(UNIMPL_MSG); // <---- When done implementing your method, erase this line!
    }

    /**
     * Query the tree for emptiness. A tree is empty iff it has zero keys stored.
     * @return <tt>true</tt> if the tree is empty, <tt>false</tt> otherwise.
     */
    public boolean isEmpty(){
        /*
         *  Fill-in the code here!
         */
        throw new RuntimeException(UNIMPL_MSG); // <---- When done implementing your method, erase this line!
    }

    /**
     * Return the key at the tree's root node.
     * @return The key at the tree's root node, or <tt>null</tt> if the tree is empty.
     */
    public T getRoot(){
        /*
         *  Fill-in the code here!
         */
        throw new RuntimeException(UNIMPL_MSG); // <---- When done implementing your method, erase this line!
    }

    /**
     * Generate an inorder traversal over the tree's stored keys. This should be done
     * by using the tree's threads, to be able to find every inorder successor in amortized constant
     * time. TO GET MORE THAN 50&#37; CREDIT IN THIS PROJECT, YOU <b>MUST</b> IMPLEMENT YOUR TREE AS A THREADED TREE.
     * IN PARTICULAR, TO GET ANY CREDIT FOR THIS METHOD, YOUR CODE <b>MUST</b> PASS THE RELEVANT UNIT TESTS AND
     * YOU MUST BE MAKING NO CALLS TO ANY STACK, YOURS OR THE SYSTEM'S!
     *
     * @return An {@link Iterator} over <tt>T</tt>s, which exposes the elements in
     * ascending order. If the tree is empty, the {@link Iterator}'s first call to {@link Iterator#hasNext()}
     * will return <tt>false</tt>. The behavior of {@link Iterator#remove()} is <b>undefined</b>; we do <b>not</b> test
     * for removal of elements through the returned {@link Iterator}, so you can implement {@link Iterator#remove()} in
     * <b>any way you please</b>.
     */
    public Iterator<T> inorderTraversal(){
        /*
         *  Fill-in the code here!
         */
        throw new RuntimeException(UNIMPL_MSG); // <---- When done implementing your method, erase this line!
    }
}