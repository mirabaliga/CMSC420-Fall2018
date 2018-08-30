package projects.graph;

import java.util.Set;
import java.util.List;

/**
 * <p>{@link Graph} is an abstraction over directed and weighted graphs. It supports insertion of nodes, insertion
 * and removal of edges, queries of connectedness, simple accessors, as well as shortest path computation using
 * Dijkstra's algorithm. </p>
 * <p>Nodes in {@link Graph} are simplistic in that they are characterized just by an increasing index. So, the first node
 * inserted would be considered node 0 (zero), the second one node 1 and so on and so forth. For this reason, removal
 * of <b>nodes</b> from a {@link Graph} instance is <b>not</b> supported, otherwise inconsistencies with the internal
 * representation of the instance could occur. For example, if we have 8 nodes and we remove the first one inserted,
 * should we consider a new node to have index 9 or 8? It's unclear, so we just let go of the requirement. </p>
 *
 * @see AdjacencyMatrixGraph
 * @see SparseAdjacencyMatrixGraph
 * @see AdjacencyListGraph
 *
 * @author <a href ="mailto:jason.filippou@gmail.com">Jason Filippou</a>
 */
public interface Graph {

    /**
     * <p>Add a new node to the graph. The node will be characterized by its index of insertion, such that the first
     * time this method is called, a node with index &#39; 0 &#39; is stored in the graph, the second one we will
     * store a node with index 1, etc, etc.</p>
     */
    void addNode();

    /**
     * <p>Adds an edge from node <tt>source</tt> to node <tt>target</tt> in the graph, attaching to it weight <tt>weight</tt>.
     * In this implementation, we <b>don't allow</b> weights to be negative. If a negative weight is provided,
     * the method should throw a {@link RuntimeException}. If the edge already exists, <b>its weight should be updated to the parameter value.</b></p>
     *
     * <p>If either <tt>source</tt> or <tt>target</tt> don't exist in the graph, the behavior is <i>undefined</i>. This
     * means that you can do <b>whatever</b> you want, as long as you don't store extra edges or nodes in the graph. You
     * can throw a {@link RuntimeException}, return null, print a message, anything. We do <b>not</b> test for this case.</p>
     *
     * @param source The source node of the edge.
     * @param target The &quot;sink&quot; node of the edge.
     * @param weight  The weight of the edge.
     */
    void addEdge(int source, int target, int weight) throws RuntimeException;

    /**
     * <p>Delete the edge from <tt>source</tt> to <tt>target</tt>. If the edge does not exist, or if either node does <b>not</b> exist
     * in the graph, no action should be performed.</p>
     * <p>We would like to particularly stress that <b>removing an edge does not in any way imply removing its constituent nodes,
     * even if the nodes end up being singleton disconnected components!</b></p>
     * @param source The source node of the edge.
     * @param target The &quot;sink&quot; node of the edge.
     */
    void deleteEdge(int source, int target);

    /**
     * <p>Queries the graph about the existence of an edge from <tt>source</tt> to <tt>target</tt>. If either <tt>source</tt>
     * or <tt>target</tt> are not contained by the graph, then the edge itself cannot possibly exist.</p>
     * @param source The source  node of the edge.
     * @param target The &quot; sink &quot; of the edge.
     * @return <tt>true</tt> if, and only if, <tt>source</tt>, <tt>target</tt> and the edge <tt>source</tt>-&gt;<tt>target</tt>
     * <b>all</b> exist in the graph, <tt>false</tt> otherwise.
     */
    boolean isConnected(int source, int target);

    /**
     * Returns the weight of the edge <tt>source</tt>-&gt;<tt>target</tt>
     * @param source The source  node of the edge.
     * @param target The &quot; sink &quot; of the edge.
     * @return the weight of the edge <tt>source</tt>-&gt;<tt>target</tt>
     */
    int getEdgeWeight(int source, int target);

    /**
     * <p>Retrieves the &quot;neighbor&quot; nodes of the provided node, i.e all the nodes to which it is connected. If the node does <b>not</b>
     * exist in the graph,* the behavior is <b>undefined</b>; you can do whatever you want (and that helps you debug!) and we don't test for it.
     * If the node <b>does</b> exist in the graph but it has no neighbors, the returned {@link Set} should be
     * non-<tt>null</tt>, but <b>empty (size 0)</b>.</p>
     * @param node The node to retrieve the neighbors of.
     * @return A {@link Set} of all nodes to which <tt>node</tt> is incident.
     */
    Set<Integer> getNeighbors(int node);

    /**
     * <p>Retrieves the number of nodes in the graph.</p>
     * @return the number of nodes in the graph.
     */
    int getNumNodes();

    /**
     * <p>Retrieves the number of edges in the graph. </p>
     * @return the number of edges in the graph.
     */
    int getNumEdges();

    /** <p>Returns the shortest path between <tt>source</tt> and <tt>target</tt> in the graph, as defined
     * by the sum of the weights of all edges that connect <tt>source</tt> and <tt>target</tt>. Since we don't allow
     * negative edges, you can implement this with either Dijkstra's or the Bellman-Ford algorithm, whichever one
     * you prefer! The code, of course, will have to be <b>your own</b> (no taking ready-made libraries out there, whether they
     * are part of Oracle's standard library or not).</p>
     *
     * <p>If either <tt>source</tt> or <tt>target</tt> are not part of the graph, the behavior is <b>undefined</b>
     * (we don't test for this case).</p>
     *
     * <p><b>An important note</b>: since this class represents <b>directed graphs</b>, if <tt>source == target</tt>, there <b>may
     * not even exist</b> a path that connects <tt>source</tt> and <tt>target</tt>.</p>
     *
     * @param source The source  node of the edge.
     * @param target The &quot; sink &quot; of the edge.
     * @return A {@link List}
     */
    List<Integer> shortestPath(int source, int target);

}
