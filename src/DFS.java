import java.util.*;

public class DFS {

    // Perform DFS starting from vertex `v`
    public static void dfs(Graph<String> graph, int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;

        for (Edge<String> edge : graph.getNeighbors(v)) {
            if (!visited[edge.destination]) {
                dfs(graph, edge.destination, visited, stack);
            }
        }

        // After visiting all neighbors, add the vertex to the stack
        stack.push(v);
    }

    // Another DFS function to explore the graph for Kosaraju's second pass
    public static void dfsForComponent(Graph<String> graph, int v, boolean[] visited, List<Integer> component) {
        visited[v] = true;
        component.add(v);

        for (Edge<String> edge : graph.getNeighbors(v)) {
            if (!visited[edge.destination]) {
                dfsForComponent(graph, edge.destination, visited, component);
            }
        }
    }
}
