public class GraphUtils {

    // Method to get the transposed (reversed) graph
    public static <Label> Graph<Label> getTransposedGraph(Graph<Label> originalGraph) throws Exception {
        // Create a new empty graph to store the transposed graph
        Graph<Label> transposedGraph = new Graph<>(originalGraph.getVertices().size());

        // Iterate through all vertices and reverse their edges
        for (Integer vertex : originalGraph.getVertices()) {
            for (Edge<Label> edge : originalGraph.getNeighbors(vertex)) {
                // Add the reversed edge to the transposed graph
                transposedGraph.addArc(edge.destination, edge.source, edge.label);
            }
        }

        return transposedGraph;  // Return the newly constructed transposed graph
    }
}
