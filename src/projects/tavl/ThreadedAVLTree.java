package projects.tavl;
import java.util.*;     // You need this import because of the interface method inorderTraversal()'s return type.

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

    private Node root;

        /**
     * Default constructor. Your code should allow for one, since the unit tests
     * depend on the presence of a default constructor.
     */
    public ThreadedAVLTree(){

    }

    public int getBalance(Node curr) {
        if (curr == null)
            return 0;
        int leftSide;
        int rightSide;
        if (!curr.leftThread) {
            leftSide = heightAux(curr.left);
        }
        else {
            leftSide = -1;
        }
        if (!curr.rightThread) {
            rightSide = heightAux(curr.right);
        }
        else {
            rightSide = -1;
        }

        return leftSide - rightSide;
    }

    public Node leftRotate(Node curr) {
        Node a = curr.right;
        Node b = a.left;
        boolean flag = false;
        if (!a.leftThread) {
            flag = true;
        }
        a.left = curr;
        a.leftThread = false;
        if (flag) {
            curr.right = b;
            curr.rightThread = false;
            curr.height ++;
        }
        else {
            curr.rightThread = true;
        }
        if (!a.rightThread) {
            curr.height = curr.height - 2;
        }
        else {
            curr.height = curr.height - 1;
            a.height = a.height + 1;
        }
        return a;
    }

    public Node rightRotate(Node curr) {
        Node a = curr.left;
        Node b = a.right;
        boolean flag = false;
        if (!a.rightThread) {
            flag = true;
        }
        a.right = curr;
        a.rightThread = false;
        if (flag) {
            curr.left = b;
            curr.leftThread = false;
            if (!curr.rightThread) {
                curr.height = 1 + Math.max(heightAux(curr.left), heightAux(curr.right));
            }
            else {
                curr.height = 1 + heightAux(curr.left);
            }
        }
        else {
            curr.leftThread = true;
        }
        if (!a.leftThread) {
            curr.height = curr.height - 2;
        }
        else {
            curr.height = curr.height - 1;
            a.height = a.height + 1;
        }
        return a;
    }

    /**
     * Insert <tt>key</tt> in the tree.
     * @param key The key to insert in the tree.
     */
    public void insert(T key){
        if (isEmpty()) {
            root = new Node(key, null, null, true, true);
        }
        else if (search(key) == null){
            Node curr = root;
            Stack<Node> parents = new Stack<Node>();
            while (true) {
                if (key.compareTo(curr.data) < 0) {
                    if (curr.leftThread) {
                        Node prev = curr.left;
                        curr.left = new Node(key, prev, curr, true, true);
                        curr.leftThread = false;
                        parents.push(curr);
                        while (!parents.isEmpty()) {
                            curr = parents.pop();
                            if (!curr.leftThread && !curr.rightThread) {
                                curr.height = 1 + Math.max(heightAux(curr.left), heightAux(curr.right));
                            }
                            else if (!curr.leftThread) {
                                curr.height = 1 + heightAux(curr.left);
                            }
                            else if (!curr.rightThread) {
                                curr.height = 1 + heightAux(curr.right);
                            }
                            int balance = getBalance(curr);
                            if (balance > 1) {
                                if (key.compareTo(curr.left.data) > 0) {
                                    curr.left = leftRotate(curr.left);
                                    curr.leftThread = false;
                                    if (curr.left.right.equals(curr)) {
                                        curr.left.rightThread = true;
                                    }
                                }
                                curr = rightRotate(curr);
                                //curr.right.height -= 2;
                                if (parents.isEmpty()) {
                                    root = curr;
                                }
                                else {
                                    Node myPos = parents.pop();
                                    if (curr.data.compareTo(myPos.data) < 0) {
                                        myPos.left = curr;
                                    }
                                    else {
                                        myPos.right = curr;
                                    }
                                }
                                break;
                            }
                            else if (balance < -1){
                                if (key.compareTo(curr.right.data) < 0) {
                                    curr.right = rightRotate(curr.right);
                                    curr.rightThread = false;
                                    if (curr.right.left.equals(curr)) {
                                        curr.right.leftThread = true;
                                    }
                                }
                                curr = leftRotate(curr);
                                //curr.left.height -= 2;
                                if (parents.isEmpty()) {
                                    root = curr;
                                }
                                else {
                                    Node myPos = parents.pop();
                                    if (curr.data.compareTo(myPos.data) < 0) {
                                        myPos.left = curr;
                                    }
                                    else {
                                        myPos.right = curr;
                                    }
                                }
                                break;
                            }
                        }
                        break;
                    }
                    else {
                        parents.push(curr);
                        curr = curr.left;
                    }
                }
                else if (key.compareTo(curr.data) > 0){
                    if (curr.rightThread) {
                        Node prev = curr.right;
                        curr.right = new Node(key, curr, prev, true, true);
                        curr.rightThread = false;
                        parents.push(curr);
                        while (!parents.isEmpty()) {
                            curr = parents.pop();
                            if (!curr.leftThread && !curr.rightThread) {
                                curr.height = 1 + Math.max(heightAux(curr.left), heightAux(curr.right));
                            }
                            else if (!curr.leftThread) {
                                curr.height = 1 + heightAux(curr.left);
                            }
                            else if (!curr.rightThread) {
                                curr.height = 1 + heightAux(curr.right);
                            }
                            else {
                                curr.height = 1;
                            }
                            int balance = getBalance(curr);
                            if (balance > 1) {
                                if (key.compareTo(curr.left.data) > 0) {
                                    curr.left = leftRotate(curr.left);
                                    curr.leftThread = false;
                                    if (curr.left.right.data.equals(curr.data)) {
                                        curr.left.rightThread = true;
                                    }
                                }
                                curr = rightRotate(curr);
                                //curr.right.height -= 2;
                                if (parents.isEmpty()) {
                                    root = curr;
                                }
                                else {
                                    Node myPos = parents.pop();
                                    if (curr.data.compareTo(myPos.data) < 0) {
                                        myPos.left = curr;
                                    }
                                    else {
                                        myPos.right = curr;
                                    }
                                }
                            }
                            else if (balance < -1){
                                if (key.compareTo(curr.right.data) < 0) {
                                    curr.right = rightRotate(curr.right);
                                    curr.rightThread = false;
                                    if (curr.right.left.data.equals(curr.data)) {
                                        curr.right.leftThread = true;
                                    }
                                }
                                curr = leftRotate(curr);
                                //curr.left.height -= 2;
                                if (parents.isEmpty()) {
                                    root = curr;
                                }
                                else {
                                    Node myPos = parents.pop();
                                    if (curr.data.compareTo(myPos.data) < 0) {
                                        myPos.left = curr;
                                    }
                                    else {
                                        myPos.right = curr;
                                    }
                                }
                            }
                        }
                        break;
                    }
                    else {
                        parents.push(curr);
                        curr = curr.right;
                    }
                }
                else {
                    return;
                }
            }
        }
    }

    /**
     * Delete the key from the data structure and return it to the caller. Note that it is assumed that there are no
     * duplicate keys in the tree. That is, if a key is deleted from the tree, it should no longer be found in it.
     * @param key The key to deleteRec from the structure.
     * @return The key that was removed, or <tt>null</tt> if the key was not found.
     */
    public T delete(T key){
        if (isEmpty() || search(key) == null) {
            return null;
        }
        else {
            Node curr = root;
            Stack<Node> parents = new Stack<Node>();
            while (true) {
                if (key.equals(curr.data)) {
                    T returnVal = curr.data;
                    if (curr.leftThread || curr.rightThread) {
                        Node temp = null;
                        if (!curr.rightThread) {
                            temp = curr.right;
                            if (!parents.isEmpty()) {
                                curr = parents.pop();
                                if (key.compareTo(curr.data) > 0) {
                                    if (!curr.right.leftThread) {
                                        curr.rightThread = false;
                                    }
                                    else {
                                        curr.rightThread = curr.right.rightThread;
                                    }

                                    curr.right = temp;
                                    if (curr.right != null && (curr.right.right == null) && curr.right.leftThread) {
                                        curr.right.left = curr.right.left.left;
                                    }
                                    else if (curr.right != null && curr.right.right != null && (curr.right.right.right == null || (curr.right.right.left != null && curr.right.right.left.equals(curr.right)))) {
                                        curr.right.right = curr.right.right.right;
                                    }
                                    /*if (!curr.right.leftThread) {
                                        curr.right.left = curr.right.left.left;
                                    }
                                    if (!curr.right.rightThread) {
                                        curr.right.right = curr.right.right.right;
                                    }*/

                                }
                                else {
                                    if (!curr.left.rightThread) {
                                        curr.leftThread = false;
                                    }
                                    else {
                                        curr.leftThread = curr.left.leftThread;
                                    }
                                    curr.left = temp;
                                    if (curr.left != null && (curr.left.left == null) && curr.left.rightThread) {
                                        curr.left.right = curr.left.right.right;
                                    }
                                    else if (curr.left != null && curr.left.left != null && (curr.left.left.left == null || (curr.left.left.right != null && curr.left.left.right.equals(curr.left)))) {
                                        curr.left.left = curr.left.left.left;
                                    }
                                    /*if (!curr.left.rightThread) {
                                        curr.left.right = curr.left.right.right;
                                    }
                                    if (!curr.left.leftThread) {
                                        curr.left.left = curr.left.left.left;
                                    }*/
                                }
                            } else {
                                root = temp;
                                return returnVal;
                            }
                        }
                        else if (!curr.leftThread) {
                            temp = curr.left;
                            if (!parents.isEmpty()) {
                                curr = parents.pop();
                                if (key.compareTo(curr.data) > 0) {
                                    if (!curr.right.leftThread) {
                                        curr.rightThread = false;
                                    }
                                    else {
                                        curr.rightThread = curr.right.rightThread;
                                    }
                                    curr.right = temp;
                                    if (curr.right != null && (curr.right.right == null) && curr.right.leftThread) {
                                        curr.right.left = curr.right.left.left;
                                    }
                                    else if (curr.right != null && curr.right.right != null && (curr.right.right.right == null ||  (curr.right.right.left != null && curr.right.right.left.equals(curr.right)))) {
                                        curr.right.right = curr.right.right.right;
                                    }
                                    /*if (!curr.right.rightThread) {
                                        curr.right.right = curr.right.right.right;
                                    }
                                    if (curr.right.left != null) {
                                        curr.right.left = curr.right.left.left;
                                    }*/
                                }
                                else {
                                    if (!curr.left.rightThread) {
                                        curr.leftThread = false;
                                    }
                                    else {
                                        curr.leftThread = curr.left.leftThread;
                                    }
                                    curr.left = temp;
                                    if (curr.left != null && (curr.left.left == null) && curr.left.rightThread) {
                                        curr.left.right = curr.left.right.right;
                                    }
                                    else if (curr.left != null && curr.left.left != null && (curr.left.left.left == null || (curr.left.left.right != null && curr.left.left.right.equals(curr.left)))) {
                                        curr.left.left = curr.left.left.left;
                                    }
                                    /*if (curr.left.left != null) {
                                        curr.left.left = curr.left.left.left;
                                    }
                                    if (curr.left.right != null) {
                                        curr.left.right = curr.left.right.right;
                                    }*/
                                }

                            }
                            else {
                                root = temp;
                                return returnVal;
                            }
                        }

                        if (temp == null) {
                            temp = curr;
                            curr = null;
                        }
                    }
                    else {
                        Node temp = curr.right;
                        while (!temp.leftThread) {
                            temp = temp.left;
                        }
                        T val = temp.data;
                        delete(val);
                        curr.data = val;
                    }
                    if (curr == null) {
                        if (parents.isEmpty()) {
                            root = null;
                            return returnVal;
                        }
                        else {
                            curr = parents.pop();
                            if (key.compareTo(curr.data) < 0) {
                                curr.leftThread = curr.left.leftThread;
                                curr.left = curr.left.left;

                            }
                            else {
                                curr.rightThread = curr.right.rightThread;
                                curr.right = curr.right.right;
                            }
                        }
                    }
                    do {
                        if (!curr.leftThread && !curr.rightThread) {
                            curr.height = 1 + Math.max(heightAux(curr.left), heightAux(curr.right));
                        }
                        else if (!curr.leftThread) {
                            curr.height = 1 + heightAux(curr.left);
                        }
                        else if (!curr.rightThread) {
                            curr.height = 1 + heightAux(curr.right);
                        }
                        else {
                            curr.height = 0;
                        }
                        int balance = getBalance(curr);
                        if (balance > 1) {
                            int balanceSub = getBalance(curr.left);
                            if (balanceSub < 0) {
                                curr.left = leftRotate(curr.left);
                                curr.leftThread = false;
                                if (curr.left.right.data.equals(curr.data)) {
                                    curr.left.rightThread = true;
                                }
                            }
                            curr = rightRotate(curr);
                            if (!curr.leftThread && !curr.rightThread) {
                                if (!curr.right.leftThread && !curr.right.rightThread) {
                                    curr.right.height = 1 + Math.max(heightAux(curr.right.left), heightAux(curr.right.right));
                                }
                                else if (!curr.right.leftThread) {
                                    curr.right.height = 1 + heightAux(curr.right.left);
                                }
                                else if (!curr.right.rightThread) {
                                    curr.right.height = 1 + heightAux(curr.right.right);
                                }
                                curr.height = 1 + Math.max(heightAux(curr.left), heightAux(curr.right));
                            }
                            else if (!curr.leftThread) {
                                curr.height = 1 + heightAux(curr.left);
                            }
                            else if (!curr.rightThread) {
                                if (!curr.right.leftThread && ! curr.right.rightThread) {
                                    curr.right.height = 1 + Math.max(heightAux(curr.right.left), heightAux(curr.right.right));
                                }
                                else if (!curr.right.leftThread) {
                                    curr.right.height = 1 + heightAux(curr.right.left);
                                }
                                else if (!curr.right.rightThread) {
                                    curr.right.height = 1 + heightAux(curr.right.right);
                                }
                                curr.height = 1 + heightAux(curr.right);
                            }
                            if (parents.isEmpty()) {
                                root = curr;
                            }
                            else {
                                Node myPos = parents.pop();
                                if (curr.data.compareTo(myPos.data) < 0) {
                                    myPos.left = curr;
                                }
                                else {
                                    myPos.right = curr;
                                }
                                curr = myPos;
                            }
                        }
                        else if (balance < -1){
                            int balanceSub = getBalance(curr.right);
                            if (balanceSub > 0) {
                                curr.right = rightRotate(curr.right);
                                curr.rightThread = false;
                                if (curr.right.left.data.equals(curr.data)) {
                                    curr.right.leftThread = true;
                                }
                            }
                            curr = leftRotate(curr);
                            if (!curr.leftThread && !curr.rightThread) {
                                if (!curr.left.leftThread && ! curr.left.rightThread) {
                                    curr.left.height = 1 + Math.max(heightAux(curr.left.left), heightAux(curr.left.right));
                                }
                                else if (!curr.left.leftThread) {
                                    curr.left.height = 1 + heightAux(curr.left.left);
                                }
                                else if (!curr.left.rightThread) {
                                    curr.left.height = 1 + heightAux(curr.left.right);
                                }
                                curr.height = 1 + Math.max(heightAux(curr.left), heightAux(curr.right));
                            }
                            else if (!curr.leftThread) {
                                if (!curr.left.leftThread && ! curr.left.rightThread) {
                                    curr.left.height = 1 + Math.max(heightAux(curr.left.left), heightAux(curr.left.right));
                                }
                                else if (!curr.left.leftThread) {
                                    curr.left.height = 1 + heightAux(curr.left.left);
                                }
                                else if (!curr.left.rightThread) {
                                    curr.left.height = 1 + heightAux(curr.left.right);
                                }
                                curr.height = 1 + heightAux(curr.left);
                            }
                            else if (!curr.rightThread) {
                                curr.height = 1 + heightAux(curr.right);
                            }
                            if (parents.isEmpty()) {
                                root = curr;
                                return returnVal;
                            }
                            else {
                                Node myPos = parents.pop();
                                if (curr.data.compareTo(myPos.data) < 0) {
                                    myPos.left = curr;
                                }
                                else {
                                    myPos.right = curr;
                                }
                                curr = myPos;
                                continue;
                            }
                        }
                        if (!parents.isEmpty()) {
                            curr = parents.pop();
                        }
                        else {
                            break;
                        }

                    } while (true);
                    return returnVal;

                }
                else if (key.compareTo(curr.data) < 0) {
                    if (!curr.leftThread) {
                        parents.push(curr);
                        curr = curr.left;
                    }
                    else {
                        return null;
                    }
                }
                else {
                    if (!curr.rightThread) {
                        parents.push(curr);
                        curr = curr.right;
                    }
                    else {
                        return null;
                    }
                }
            }
        }
    }

    /**
     * Search for <tt>key</tt> in the tree. Return a reference to it if it's in there,
     * or <tt>null</tt> otherwise.
     * @param key The key to look for in the tree.
     * @return <tt>key</tt> if <tt>key</tt> is in the tree, or <tt>null</tt> otherwise.
     */
    public T search(T key){
        Node curr = root;
        while (curr != null) {
            if (key.compareTo(curr.data) < 0) {
                if (!curr.leftThread) {
                    curr = curr.left;
                }
                else {
                    return null;
                }
            }
            else if (key.compareTo(curr.data) > 0) {
                if (!curr.rightThread) {
                    curr = curr.right;
                }
                else {
                    return null;
                }
            }
            else {
                return key;
            }
        }
        return null;
    }


    /**
     * Return the height of the tree. The height of the tree is defined as the length of the
     * longest path between the root and the leaf level. By definition of path length, a
     * stub tree has a height of 0, and we define an empty tree to have a height of -1.
     * @return The height of the tree.
     */
    public int height(){
        return heightAux(root);
    }

    public int heightAux(Node curr) {
        if (curr == null) {
            return -1;
        }
        else {
            return curr.height;
        }
    }

    /**
     * Query the tree for emptiness. A tree is empty iff it has zero keys stored.
     * @return <tt>true</tt> if the tree is empty, <tt>false</tt> otherwise.
     */
    public boolean isEmpty(){
        return root == null;
    }

    /**
     * Return the key at the tree's root node.
     * @return The key at the tree's root node, or <tt>null</tt> if the tree is empty.
     */
    public T getRoot(){
        if (isEmpty()) {
            return null;
        }
        else {
            return root.data;
        }
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
        return new ThreadedAVLTreeIterator();
    }

    protected class ThreadedAVLTreeIterator implements java.util.Iterator<T>{
        protected Node curr;
        public ThreadedAVLTreeIterator() {
            curr = root;
            if (curr != null) {
                while (!curr.leftThread) {
                    curr = curr.left;
                }
            }
        }
        public boolean hasNext() {
            return curr != null;
        }
        public T next() {
            if (hasNext()) {
                T returnVal = curr.data;
                if (!curr.rightThread) {
                    curr = curr.right;
                    while (!curr.leftThread) {
                        curr = curr.left;
                    }
                }
                else {
                    curr = curr.right;
                }
                return returnVal;
            }
            else {
                return null;
            }
        }
    }

    protected class Node {
        protected T data;
        protected int height;
        protected Node left, right;
        protected boolean leftThread, rightThread;
        public Node(T element, Node left, Node right, boolean leftThread, boolean rightThread) {
            this.data = element;
            this.left = left;
            this.right = right;
            this.leftThread = leftThread;
            this.rightThread = rightThread;
            this.height = 0;
        }
    }
}