import java.util.*;

public class Kosaraju<Label> {
    private Graph<Label> graph;  // The original graph
    private Graph<Label> transposedGraph;  // The transposed graph (reversed edges)
    private DFS<Label> dfs;  // The DFS object to perform depth-first search

    // Constructor
    public Kosaraju(Graph<Label> graph) {
        this.graph = graph;
        this.dfs = new DFS<>(graph);  // Initialize DFS for the original graph
    }

    // Main method to run Kosaraju's algorithm and find SCCs
    public List<Set<Integer>> findStronglyConnectedComponents() throws Exception {
        // Step 1: Perform the first DFS pass on the original graph to calculate finishing times
        dfs.dfsFirstPass();

        // Step 2: Transpose the graph (reverse all edges)
        transposedGraph = GraphUtils.getTransposedGraph(graph);

        // Step 3: Perform the second DFS pass on the transposed graph to find SCCs
        List<Set<Integer>> SCCs = new ArrayList<>();
        dfs.dfsSecondPass(transposedGraph, SCCs);

        return SCCs;  // Return the list of strongly connected components
    }
}