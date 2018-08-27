package projects.graph;

import java.util.List;
import java.util.Set;

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
    public List<Integer> shortestPath() {
        return null;
    }

    /* Methods specific to this class follow. */

    public SparseAdjacencyMatrixGraph toSparseAdjacencyMatrixGraph(){
        return null;
    }

    public AdjacencyListGraph toAdjacencyListGraph(){
        return null;
    }
}
