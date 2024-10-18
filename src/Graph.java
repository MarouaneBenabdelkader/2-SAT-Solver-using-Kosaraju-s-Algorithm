import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Graph<Label> {

    private HashMap<Integer, ArrayList<Edge<Label>>> incidenceList;  // HashMap for incidence lists
    private int maxSize;  // Maximum number of vertices allowed
    private Set<Integer> uniqueVertices;  // Set to track unique vertices

    // Default constructor: Initializes an empty graph with no size limit
    public Graph() {
        incidenceList = new HashMap<>();
        uniqueVertices = new HashSet<>();
        maxSize = Integer.MAX_VALUE;  // No limit by default
    }

    // Constructor to initialize graph with a specified size (max number of vertices)
    public Graph(int size) {
        incidenceList = new HashMap<>(size);
        uniqueVertices = new HashSet<>();
        maxSize = size;
    }

    // Method to add an arc between two vertices, source and dest, with a label
    public void addArc(int source, int dest, Label label) throws Exception {
        // Check if the vertices would exceed the maximum number allowed
        if (!uniqueVertices.contains(source)) {
            if (uniqueVertices.size() >= maxSize) {
                throw new Exception("Maximum number of vertices reached. Cannot add more.");
            }
            uniqueVertices.add(source);
        }

        if (!uniqueVertices.contains(dest)) {
            if (uniqueVertices.size() >= maxSize) {
                throw new Exception("Maximum number of vertices reached. Cannot add more.");
            }
            uniqueVertices.add(dest);
        }

        // Ensure the source vertex has a list of edges in the adjacency list
        incidenceList.putIfAbsent(source, new ArrayList<>());

        // Add the new edge to the adjacency list for the source vertex
        incidenceList.get(source).add(new Edge<>(source, dest, label));

        // Ensure destination exists even if it has no outgoing edges
        incidenceList.putIfAbsent(dest, new ArrayList<>());
    }

    // Method to get the neighbors of a vertex
    public ArrayList<Edge<Label>> getNeighbors(int vertex) {
        return incidenceList.get(vertex);
    }

    public Set<Integer> getVertices() {
        return uniqueVertices;
    }

    // Override the toString method for a more detailed output of the graph
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Graph adjacency list:\n");
        for (Integer vertex : incidenceList.keySet()) {
            result.append("Vertex ").append(vertex).append(": ").append(incidenceList.get(vertex).toString()).append("\n");
        }
        return result.toString();
    }

}
