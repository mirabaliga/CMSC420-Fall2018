package projects.graph;

import java.util.List;
import java.util.Set;

/**
 * <p>{@link AdjacencyListGraph} is a {@link Graph} implemented as an adjacency list, i.e a one-dimensional array of linked lists,
 * where A(i) is a linked list containing the neighbors of node i and the corresponding edges' weights. <b>The neighbors of a given node are defined as the nodes it  points to</b> (if any). </p>
 *
 * <p>Other implementations besides linked lists are possible (e.g BSTs over the weight of the edge), yet for this project we
 * will keep it simple and stick to that basic implementation. One of its advantages is that, because the lists do not need
 * to be sorted in any way, the insertion of a new edge is a O(1) operation (find the list corresponding to the source node in O(1)
 * and add the new list node up front.</p>
 *
 * @author --- YOUR NAME HERE! ---
 *
 * @see Graph
 * @see AdjacencyMatrixGraph
 * @see SparseAdjacencyMatrixGraph
 */
public class AdjacencyListGraph implements Graph {

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
     * <p>Transforms <tt>this</tt> into an instance of {@link AdjacencyMatrixGraph}. This is an O(E) operation. </p>
     *
     * @return An instance of {@link AdjacencyMatrixGraph}.
     */
    public AdjacencyMatrixGraph toAdjacencyMatrixGraph(){
        return null;
    }

    /**
     * <p>Transforms <tt>this</tt> into an instance of {@link AdjacencyMatrixGraph}. This is an O(E) operation. </p>
     *
     * @return An instance of {@link AdjacencyMatrixGraph}.
     */
    public SparseAdjacencyMatrixGraph toSparseAdjacencyMatrixGraph(){
        return null;
    }
}
