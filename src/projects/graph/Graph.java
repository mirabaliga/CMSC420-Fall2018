package projects.graph;

import java.util.Set;
import java.util.List;

public interface Graph {


    void addNode();

    void addEdge(int source, int target, int weight);

    void deleteEdge(int source, int target);

    boolean isConnected(int source, int target);

    int getEdgeWeight(int source, int target);

    Set<Integer> getNeighbors(int node);

    int getNumNodes();

    int getNumEdges();

    List<Integer> shortestPath();

}
