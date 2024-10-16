import java.util.*;

public class DFS<Label> {
    private Graph<Label> graph;  // The graph on which DFS is performed
    private Set<Integer> visited;  // Tracks visited nodes during DFS

    // Constructor to initialize DFS with a graph
    public DFS(Graph<Label> graph) {
        this.graph = graph;
        this.visited = new HashSet<>();
    }

    // Resets the visited set to allow fresh DFS traversal
    public void resetVisited() {
        visited.clear();
    }

    /**
     * General DFS method that can either push vertices into a finishStack (first pass)
     * or collect them into a currentSCC set (second pass) based on the provided arguments.
     *
     * @param vertex The starting vertex for DFS.
     * @param finishStack A stack to collect vertices based on finishing times (used in the first pass).
     * @param currentSCC A set to collect vertices that belong to the current SCC (used in the second pass).
     */
    public void performDFS(Integer vertex, Stack<Integer> finishStack, Set<Integer> currentSCC) {
        visited.add(vertex);

        // If we're collecting an SCC, add the vertex to the current SCC set
        if (currentSCC != null) {
            currentSCC.add(vertex);
        }

        // Recursively visit neighbors
        for (Edge<Label> neighbor : graph.getNeighbors(vertex)) {
            if (!visited.contains(neighbor.destination)) {
                performDFS(neighbor.destination, finishStack, currentSCC);  // Recursive DFS
            }
        }

        // If we're calculating finishing times, push the vertex onto the finish stack
        if (finishStack != null) {
            finishStack.push(vertex);
        }
    }

    // Check if a vertex is visited
    public boolean isVisited(Integer vertex) {
        return visited.contains(vertex);
    }
}
