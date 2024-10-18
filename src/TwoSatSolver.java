import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSatSolver {
    private List<Set<Integer>> SCCs;

    // Constructor
    public TwoSatSolver(List<Set<Integer>> SCCs ) {
        this.SCCs = SCCs;
    }

    // Method to check if the formula is satisfiable
    public boolean checkSatisfiability() {

        // Loop over each SCC to check for a literal and its negation
        for (Set<Integer> scc : this.SCCs) {
            Set<Integer> trackedLiterals = new HashSet<>();  // Track the literals we see in this SCC

            // Check if both a literal and its negation exist in this SCC
            for (Integer literal : scc) {
                int negation = -literal;

                // If we already saw the negation of the current literal, it's unsatisfiable
                if (trackedLiterals.contains(negation)) {
                    return false;  // UNSATISFIABLE: found literal and its negation in the same SCC
                }

                // Track this literal
                trackedLiterals.add(literal);
            }
        }

        return true;  // SATISFIABLE: no literal and its negation were found in the same SCC
    }
}
