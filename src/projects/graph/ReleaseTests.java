package projects.graph;

import org.junit.Test;

import static org.junit.Assert.fail;


/**
 * <p>A testing framework for {@link Graph} instances.</p>
 * @author <a href="mailto:jason.filippou@gmail.com">Jason Filippou</a>
 * @see Graph
 * @see AdjacencyMatrixGraph
 * @see SparseAdjacencyMatrixGraph
 * @see AdjacencyListGraph
 */
public class ReleaseTests { 

    /* ********************************************************************************************/
    /* *************************************** PRIVATE METHODS ************************************/
    /* ********************************************************************************************/
    
    private static String format(RuntimeException re){
        return "Caught a " + re.getClass()+ " with message: " + re.getMessage() + ".";
    }

    /* We will make calls to the same helper methods, defined below, from all of our possible
     * Graph instances.
     */

    private void testAddNode(Graph graph){

    }

    private void testAddEdge(Graph graph){

    }


    private void testDeleteEdge(Graph graph){

    }

    private void testIsConnected(Graph graph){

    }

    private void testGetEdgeWeight(Graph graph){

    }

    private void testGetNumNodes(Graph graph){

    }

    private void testGetNumEdges(Graph graph){

    }

    private void testGetNeighbors(Graph graph){

    }

    private void testShortestPath(Graph graph){

    }

    private void runMutatingTests(Graph graph){
        testAddNode(graph);
        testAddEdge(graph);
        testDeleteEdge(graph);
    }

    private void runAccessingTests(Graph graph){
        testIsConnected(graph);
        testGetEdgeWeight(graph);
        testGetNumNodes(graph);
        testGetNumEdges(graph);
        testGetNeighbors(graph);
        testShortestPath(graph);
    }

    private void runAllTests(Graph graph){
        runMutatingTests(graph);
        runAccessingTests(graph);
    }

    /* First, tests specific to adjacency matrix representation. */

    @Test
    public void testAddNodeAdjacencyMatrix(){
        try {
            testAddNode(new AdjacencyMatrixGraph());
        } catch(RuntimeException re){
            fail(format(re));
        }
    }

    @Test
    public void testAddEdgeAdjacencyMatrix(){
        try {
            testAddEdge(new AdjacencyMatrixGraph());
        } catch(RuntimeException re){
            fail(format(re));
        }
    }

    @Test
    public void testDeleteEdgeAdjacencyMatrix(){
        try {
            testDeleteEdge(new AdjacencyMatrixGraph());
        } catch(RuntimeException re){
            fail(format(re));
        }
    }

    @Test
    public void testIsConnectedAdjacencyMatrix(){
        try {
            testIsConnected(new AdjacencyMatrixGraph());
        } catch(RuntimeException re){
            fail(format(re));
        }
    }

    @Test
    public void testGetEdgeWeightAdjacencyMatrix() {
        try {
            testGetEdgeWeight(new AdjacencyMatrixGraph());
        } catch(RuntimeException re){
            fail(format(re));
        }
    }

    @Test
    public void testNumNodesAdjacencyMatrix(){
        try {
            testGetNumNodes(new AdjacencyMatrixGraph());
        } catch(RuntimeException re){
            fail(format(re));
        }
    }

    @Test
    public void testNumEdgesAdjacencyMatrix(){
        try {
            testGetNumEdges(new AdjacencyMatrixGraph());
        } catch(RuntimeException re){
            fail(format(re));
        }
    }

    @Test
    public void testGetNeighborsAdjacencyMatrix(){
        try {
            testGetNeighbors(new AdjacencyMatrixGraph());
        } catch(RuntimeException re){
            fail(format(re));
        }
    }

    @Test
    public void testShortestPathAdjacencyMatrix(){
        try {
            testShortestPath(new AdjacencyMatrixGraph());
        } catch(RuntimeException re){
            fail(format(re));
        }
    }

    /* Second, tests specific to sparse adjacency matrix representation. */

    @Test
    public void testAddNodeSparseAdjacencyMatrix(){
        try {
            testAddNode(new SparseAdjacencyMatrixGraph());
        } catch(RuntimeException re){
            fail(format(re));
        }
    }

    @Test
    public void testAddEdgeSparseAdjacencyMatrix(){
        try {
            testAddEdge(new SparseAdjacencyMatrixGraph());
        } catch(RuntimeException re){
            fail(format(re));
        }
    }

    @Test
    public void testDeleteEdgeSparseAdjacencyMatrix(){
        try {
            testDeleteEdge(new SparseAdjacencyMatrixGraph());
        } catch(RuntimeException re){
            fail(format(re));
        }
    }

    @Test
    public void testIsConnectedSparseAdjacencyMatrix(){
        try {
            testIsConnected(new SparseAdjacencyMatrixGraph());
        } catch(RuntimeException re){
            fail(format(re));
        }
    }

    @Test
    public void testGetEdgeWeightSparseAdjacencyMatrix(){
        try {
            testGetEdgeWeight(new SparseAdjacencyMatrixGraph());
        } catch(RuntimeException re){
            fail(format(re));
        }
    }

    @Test
    public void testNumNodesSparseAdjacencyMatrix(){
        try {
            testGetNumNodes(new SparseAdjacencyMatrixGraph());
        } catch(RuntimeException re){
            fail(format(re));
        }
    }

    @Test
    public void testNumEdgesSparseAdjacencyMatrix(){
        try {
            testGetNumEdges(new SparseAdjacencyMatrixGraph());
        } catch(RuntimeException re){
            fail(format(re));
        }
    }

    @Test
    public void testGetNeighborsSparseAdjacencyMatrix(){
        try {
            testGetNeighbors(new SparseAdjacencyMatrixGraph());
        } catch(RuntimeException re){
            fail(format(re));
        }
    }

    @Test
    public void testShortestPathSparseAdjacencyMatrix(){
        try {
            testShortestPath(new SparseAdjacencyMatrixGraph());
        } catch(RuntimeException re){
            fail(format(re));
        }
    }

    /* Third, tests specific to adjacency list representation. */

    @Test
    public void testAddNodeAdjacencyList(){
        try {
            testAddNode(new AdjacencyListGraph());
        } catch(RuntimeException re){
            fail(format(re));
        }
    }

    @Test
    public void testAddEdgeAdjacencyList(){
        try {
            testAddEdge(new AdjacencyListGraph());
        } catch(RuntimeException re){
            fail(format(re));
        }
    }

    @Test
    public void testDeleteEdgeAdjacencyList(){
        try {
            testDeleteEdge(new AdjacencyListGraph());
        } catch(RuntimeException re){
            fail(format(re));
        }
    }

    @Test
    public void testIsConnectedAdjacencyList(){
        try {
            testIsConnected(new AdjacencyListGraph());
        } catch(RuntimeException re){
            fail(format(re));
        }

    }

    @Test
    public void testGetEdgeWeightAdjacencyList(){
        try {
            testGetEdgeWeight(new AdjacencyListGraph());
        } catch(RuntimeException re){
            fail(format(re));
        }
    }

    @Test
    public void testNumNodesAdjacencyList(){
        try {
            testGetNumNodes(new AdjacencyListGraph());
        } catch(RuntimeException re){
            fail(format(re));
        }
    }

    @Test
    public void testNumEdgesAdjacencyList(){
        try {
            testGetNumEdges(new AdjacencyListGraph());
        } catch(RuntimeException re){
            fail(format(re));
        }
    }

    @Test
    public void testGetNeighborsAdjacencyList(){
        try {
            testGetNeighbors(new AdjacencyListGraph());
        } catch(RuntimeException re){
            fail(format(re));
        }
    }

    @Test
    public void testShortestPathAdjacencyList(){
        try {
            testShortestPath(new AdjacencyListGraph());
        } catch(RuntimeException re){
            fail(format(re));
        }
    }

    @Test
    public void testFromAdjMatToSparseAdjMat(){
        Graph graph = new AdjacencyMatrixGraph();
        try {
            runMutatingTests(graph);
        } catch(RuntimeException re){
            fail(format(re));
        }
        graph = ((AdjacencyMatrixGraph)graph).toSparseAdjacencyMatrixGraph();
        try {
            runAccessingTests(graph);
        } catch(RuntimeException re){
            fail("Transformation from AdjacencyMatrixGraph to SparseAdjacencyMatrixGraph: " + format(re));
        }
    }

    @Test
    public void testFromAdjMatToAdjList() {
        Graph graph = new AdjacencyMatrixGraph();
        try {
            runMutatingTests(graph);
        } catch(RuntimeException re){
            fail(format(re));
        }
        graph = ((AdjacencyMatrixGraph)graph).toSparseAdjacencyMatrixGraph();
        try {
            runAccessingTests(graph);
        } catch(RuntimeException re){
            fail("Transformation from AdjacencyMatrixGraph to AdjacencyListGraph: " + format(re));
        }
    }

    @Test
    public void testFromSparseAdjMatToAdjMat(){
        Graph graph = new SparseAdjacencyMatrixGraph();
        try {
            runMutatingTests(graph);
        } catch(RuntimeException re){
            fail(format(re));
        }
        graph = ((SparseAdjacencyMatrixGraph)graph).toAdjacencyMatrixGraph();
        try {
            runAccessingTests(graph);
        } catch(RuntimeException re){
            fail("Transformation from SparseAdjacencyMatrixGraph to AdjacencyMatrixGraph: " + format(re));
        }
    }

    @Test
    public void testFromSparseAdjMatToAdjList(){
        Graph graph = new SparseAdjacencyMatrixGraph();
        try {
            runMutatingTests(graph);
        } catch(RuntimeException re){
            fail(format(re));
        }
        graph = ((SparseAdjacencyMatrixGraph)graph).toAdjacencyListGraph();
        try {
            runAccessingTests(graph);
        } catch(RuntimeException re){
            fail("Transformation from SparseAdjacencyMatrixGraph to AdjacencyListGraph: " + format(re));
        }
    }

    @Test
    public void testFromAdjListToAdjMat(){
        Graph graph = new AdjacencyListGraph();
        try {
            runMutatingTests(graph);
        } catch(RuntimeException re){
            fail(format(re));
        }
        graph = ((AdjacencyListGraph)graph).toAdjacencyMatrixGraph();
        try {
            runAccessingTests(graph);
        } catch(RuntimeException re){
            fail("Transformation from AdjacencyListGraph to AdjacencyMatrixGraph: " + format(re));
        }
    }


    @Test
    public void testFromAdjListToSparseAdjMat(){
        Graph graph = new AdjacencyListGraph();
        try {
            runMutatingTests(graph);
        } catch(RuntimeException re){
            fail(format(re));
        }
        graph = ((AdjacencyListGraph)graph).toSparseAdjacencyMatrixGraph();
        try {
            runAccessingTests(graph);
        } catch(RuntimeException re){
            fail("Transformation from AdjacencyListGraph to SparseAdjacencyMatrixGraph: " + format(re));
        }
    }

}
