import java.util.*;

public class Kosaraju {

    private Graph<String> graph;
    private Stack<Integer> stack;
    private boolean[] visited;
    private List<List<Integer>> stronglyConnectedComponents;

    public Kosaraju(Graph<String> graph) {
        this.graph = graph;
        this.stack = new Stack<>();
        this.visited = new boolean[graph.getVertices().size()];
        this.stronglyConnectedComponents = new ArrayList<>();
    }

    public List<List<Integer>> findStronglyConnectedComponents() throws Exception {
        // Step 1: Perform DFS on the original graph and fill the stack
        for (Integer vertex : graph.getVertices()) {
            if (!visited[vertex]) {
                DFS.dfs(graph, vertex, visited, stack);
            }
        }

        // Step 2: Get the transposed graph
        Graph<String> transposedGraph = GraphUtils.getTransposedGraph(graph);

        // Step 3: Perform DFS on the transposed graph in the order of the stack
        Arrays.fill(visited, false);  // Reset visited array
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                List<Integer> component = new ArrayList<>();
                DFS.dfsForComponent(transposedGraph, v, visited, component);
                stronglyConnectedComponents.add(component);
            }
        }

        return stronglyConnectedComponents;
    }
}
