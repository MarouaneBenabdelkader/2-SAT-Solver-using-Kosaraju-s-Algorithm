import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TwoSatSolver {
    private Graph<String> implicationGraph;
    private int numVariables;
    private Kosaraju<String> kosaraju;

    // Constructor
    public TwoSatSolver(Graph<String> implicationGraph, int numVariables) {
        this.numVariables = numVariables;
        this.kosaraju = new Kosaraju<>(implicationGraph);
    }

    // Method to check if the formula is satisfiable
    public boolean checkSatisfiability() throws Exception {
        // Run Kosaraju's algorithm to get the SCCs
        List<Set<Integer>> SCCs = kosaraju.findStronglyConnectedComponents();

        // Create a map to track which SCC each vertex belongs to
        Map<Integer, Integer> vertexToSCC = new HashMap<>();
        for (int i = 0; i < SCCs.size(); i++) {
            for (Integer vertex : SCCs.get(i)) {
                vertexToSCC.put(vertex, i);
            }
        }

        // Check if any literal and its negation are in the same SCC
        for (int i = 1; i <= numVariables; i++) {
            Integer literal = i;
            Integer negLiteral = -i;
            if (vertexToSCC.containsKey(literal) && vertexToSCC.containsKey(negLiteral)) {
                if (vertexToSCC.get(literal).equals(vertexToSCC.get(negLiteral))) {
                    return false;  // UNSATISFIABLE
                }
            }
        }

        return true;
    }
}
