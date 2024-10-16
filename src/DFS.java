import java.util.*;

public class DFS<Label> {
    private Graph<Label> graph;  // The graph on which DFS is performed
    private Set<Integer> visited;  // Tracks visited nodes during DFS
    private Stack<Integer> finishStack;  // Stores nodes based on their finishing times (used in first pass)

    // Constructor to initialize DFS with a graph
    public DFS(Graph<Label> graph) {
        this.graph = graph;
        this.visited = new HashSet<>();
        this.finishStack = new Stack<>();
    }

    // First pass DFS to calculate finishing times
    public void dfsFirstPass() {
        for (Integer vertex : graph.getVertices()) {
            if (!visited.contains(vertex)) {
                dfsVisitFirstPass(vertex);  // Visit vertex and explore its neighbors
            }
        }
    }

    // Helper method to perform DFS for the first pass
    private void dfsVisitFirstPass(Integer vertex) {
        visited.add(vertex);
        for (Edge<Label> neighbor : graph.getNeighbors(vertex)) {
            if (!visited.contains(neighbor.destination)) {
                dfsVisitFirstPass(neighbor.destination);  // Recursive DFS
            }
        }
        finishStack.push(vertex);  // When fully explored, push vertex onto the finish stack
    }

    // Second pass DFS to collect SCCs
    public void dfsSecondPass(Graph<Label> transposedGraph, List<Set<Integer>> SCCs) {
        visited.clear();  // Reset visited set for the second DFS pass

        while (!finishStack.isEmpty()) {
            Integer vertex = finishStack.pop();  // Process nodes in the order of finishing times
            if (!visited.contains(vertex)) {
                Set<Integer> currentSCC = new HashSet<>();  // Create a new SCC set
                dfsVisitSecondPass(transposedGraph, vertex, currentSCC);
                SCCs.add(currentSCC);  // Add the collected SCC to the list of SCCs
            }
        }
    }

    // Helper method to perform DFS for the second pass and collect nodes into an SCC
    private void dfsVisitSecondPass(Graph<Label> transposedGraph, Integer vertex, Set<Integer> currentSCC) {
        visited.add(vertex);
        currentSCC.add(vertex);  // Add the vertex to the current SCC
        for (Edge<Label> neighbor : transposedGraph.getNeighbors(vertex)) {
            if (!visited.contains(neighbor.destination)) {
                dfsVisitSecondPass(transposedGraph, neighbor.destination, currentSCC);  // Recursive DFS
            }
        }
    }

    // Returns the finish stack after the first pass DFS (used for second pass ordering)
    public Stack<Integer> getFinishStack() {
        return finishStack;
    }

}
