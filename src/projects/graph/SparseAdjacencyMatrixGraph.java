package projects.graph;

import java.util.List;
import java.util.Set;

/**
 * <p>{@link SparseAdjacencyMatrixGraph} is a {@link Graph} implemented as a <b>sparse adjacency matrix</b>, i.e a
 * linked list of the matrix's non-null (or, in this case, non-zero) elements.</p>
 *
 * <p>Inserting a new node has no influence in the inner storage of this class, because the only storage it provides
 * is for <b>edges</b>. This does not mean that you should neglect to store information about a new node having
 * been inserted: it just means that a new node needs to be connected to an existing one if it is to appear as a new
 * node <b>in the list</b>. Think about the (dense) adjacency matrix representation: there, if we add a new node,
 * we have to pay O(V^2) to re-allocate the space of the old array to the new array and add a new row and column
 * of zeroes. There is no <b>novel</b> assignment in the matrix! In the case of the sparsified representation, the inner
 * representation does not have to change at all! But you will <b>still</b> need to make note of the fact that a new node was
 * inserted. After all, we want {@link #getNumNodes()} to work correctly, don't we? </p>
 *
 * <p>Adding a new edge is also O(1), because there's no need to keep the list ordered; we can just add the element in the
 * front without any further hassle. If you are having trouble understanding why the list can be unordered, check the docs
 * of {@link #toAdjacencyMatrixGraph()}.</p>
 *
 *
 *<p>{@link #isConnected(int, int)}, {@link #deleteEdge(int, int)}, {@link #getEdgeWeight(int, int)} and
 * {@link #getNeighbors(int)} all run in O(E) time.</p>
 *
 * <p>The space occupied by an instance of {@link SparseAdjacencyMatrixGraph} is O(E). </p>
 *
 * @author --- YOUR NAME HERE! ---
 *
 * @see Graph
 * @see AdjacencyMatrixGraph
 * @see AdjacencyListGraph
 */
public class SparseAdjacencyMatrixGraph implements Graph {

    @Override
    public void addNode() {

    }

    @Override
    public void addEdge(int source, int target, int weight) {

    }

    @Override
    public void deleteEdge(int source, int target) {

    }

    @Override
    public boolean isConnected(int source, int target) {
        return false;
    }

    @Override
    public int getEdgeWeight(int source, int target) {
        return 0;
    }

    @Override
    public Set<Integer> getNeighbors(int node) {
        return null;
    }

    @Override
    public int getNumNodes() {
        return 0;
    }

    @Override
    public int getNumEdges() {
        return 0;
    }

    @Override
    public List<Integer> shortestPath(int source, int target) {
        return null;
    }

    /* Methods specific to this class follow. */

    /**
     * <p>Creates the dense representation of the matrix, corresponding to an instance of {@link AdjacencyMatrixGraph}. The adjacency
     * matrix will occupy O(V^2) space. Since every node in the list that makes up the sparsified representation contains a triple (i, j, weight), simply
     * looping through the list in O(E) and assigning the corresponding cell of the matrix to the appropriate weight is sufficient. For this
     * reason, it is not important whether the list is sorted in any way, <b>except for the special case of having been immediately created
     * by {@link AdjacencyMatrixGraph#toSparseAdjacencyMatrixGraph()}, where we want you to create the adjacency list following row-major
     * order.</b> However, because of this simple iterative algorithm we just explained, addEdge() in this class is an O(1) operation: we can just insert
     * a new node as the "head" of the list, and we are done. </p>
     *
     * @return An {@link AdjacencyMatrixGraph} instance.
     */
    public AdjacencyMatrixGraph toAdjacencyMatrixGraph(){
        return null;
    }

    /**
     * <p>Transforms <tt>this</tt> to an {@link AdjacencyListGraph}</p> instance.  Remember that an {@link AdjacencyListGraph}
     * is implemented as an array of linked lists, where A(i) is a linked list containing the neighbors of node i.
     * @return An {@link AdjacencyListGraph} instance.
     */
    public AdjacencyListGraph toAdjacencyListGraph(){
        return null;
    }



}