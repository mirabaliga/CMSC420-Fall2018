package projects.graph;

import java.util.List;
import java.util.Set;

/**
 * <p>{@link AdjacencyMatrixGraph} is a {@link Graph} implemented as an <b>adjacency matrix</b>. An adjacency matrix
 * is a V x V matrix where M(i, j) is the weight of the edge from i to j. If there is no edge between i and j,
 * the weight should be zero. </p>
 *
 * <p>Adjacency matrices answer {@link #isConnected(int, int)} in O(1) time. Insertion and deletion of edges, as well
 * as retrieval of the weight of a given edge  are all O(1) operations as well. Retrieval of all neighbors of a given node
 * happens in O(V) time. </p>
 *
 * <p>The main drawbacks of adjacency matrices are: </p>
 *  <ol>
 *      <li>They occupy O(V^2) <b>contiguous</b> memory space, which for sparse graphs can be a significant memory footprint. </li>
 *      <li>addNode() runs in O(V^2) time, since new array storage needs to be allocated for the extra row and column,
 *      and the old data need be copied to the new array. </li>
 *  </ol>
 *
 * @author --- YOUR NAME HERE! ---
 * @see Graph
 * @see SparseAdjacencyMatrixGraph
 * @see AdjacencyListGraph
 */
public class AdjacencyMatrixGraph implements Graph {

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
     * <p>Returns a sparsified representation of the adjacency matrix, i.e a linked list of its non-null elements (non-zero,
     * in this case) and their coordinates. The matrix should be scanned in <b>row-major order</b> to populate
     * the elements of the list (<b>and we test for proper element insertion order!</b>). </p>
     *
     * @return A {@link SparseAdjacencyMatrixGraph} instance.
     */
    public SparseAdjacencyMatrixGraph toSparseAdjacencyMatrixGraph(){
        return null;
    }

    /**
     * <p>Returns a representation of the {@link Graph} as an {@link AdjacencyListGraph}. Remember that an {@link AdjacencyListGraph}
     * is implemented as an array of linked lists, where A(i) is a linked list containing the neighbors of node i.  Remember that an
     * {@link AdjacencyListGraph} is implemented as an array of linked lists, where A(i) is a linked list containing the neighbors of node i.
     *
     * @return  An {@link AdjacencyListGraph} instance.
     */
    public AdjacencyListGraph toAdjacencyListGraph(){
        return null;
    }
}