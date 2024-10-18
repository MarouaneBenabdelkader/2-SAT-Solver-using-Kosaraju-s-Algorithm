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
        Stack<Integer> finishStack = new Stack<>();
        performFirstPass(finishStack);

        // Step 2: Transpose the graph (reverse all edges)
        transposedGraph = GraphUtils.getTransposedGraph(graph);

        // Step 3: Perform the second DFS pass on the transposed graph to find SCCs
        List<Set<Integer>> SCCs = new ArrayList<>();
        performSecondPass(finishStack, SCCs);

        return SCCs;  // Return the list of strongly connected components
    }

    // Perform the first pass of Kosaraju's algorithm
    private void performFirstPass(Stack<Integer> finishStack) {
        dfs.resetVisited();  // Reset visited set before first pass
        for (Integer vertex : graph.getVertices()) {
            if (!dfs.isVisited(vertex)) {
                dfs.performDFS(vertex, finishStack, null);  // Perform DFS and collect finishing times
            }
        }
    }

    // Perform the second pass of Kosaraju's algorithm (finding SCCs)
    private void performSecondPass(Stack<Integer> finishStack, List<Set<Integer>> SCCs) {
        dfs = new DFS<>(transposedGraph);  // Create a new DFS object for the transposed graph
        dfs.resetVisited();  // Reset visited set before second pass

        while (!finishStack.isEmpty()) {
            Integer vertex = finishStack.pop();  // Process nodes in the order of finishing times
            if (!dfs.isVisited(vertex)) {
                Set<Integer> currentSCC = new HashSet<>();  // Create a new SCC set
                dfs.performDFS(vertex, null, currentSCC);  // Perform DFS on the transposed graph
                SCCs.add(currentSCC);  // Add the collected SCC to the list of SCCs
            }
        }
    }
}
