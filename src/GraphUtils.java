public class GraphUtils {

    // Returns the transposed graph
    public static Graph<String> getTransposedGraph(Graph<String> graph) throws Exception {
        Graph<String> transposedGraph = new Graph<>(graph.getVertices().size());

        for (Integer vertex : graph.getVertices()) {
            for (Edge<String> edge : graph.getNeighbors(vertex)) {
                // Reverse the edge direction
                transposedGraph.addArc(edge.destination, edge.source, edge.label);
            }
        }

        return transposedGraph;
    }
}
