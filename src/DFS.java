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

}
