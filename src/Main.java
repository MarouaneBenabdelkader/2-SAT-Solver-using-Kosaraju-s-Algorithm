import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        // Check if at least one file is passed as a command line argument
        if (args.length == 0) {
            System.out.println("Usage: java Main <file1> <file2> ...");
            System.out.println("Please provide at least one file as input.");
            return;
        }

        // Loop through each provided file path
        for (String filename : args) {
            try {
                System.out.println("Processing file: " + filename);

                // Initialize parser and read the CNF file
                Parser cnfParser = new CNFParser();
                cnfParser.parse(filename);

                // Get the implication graph from the parsed CNF
                Graph<String> graph = cnfParser.getImplicationGraph();

                // Run Kosaraju's algorithm to find SCCs
                Kosaraju<String> kosaraju = new Kosaraju<>(graph);
                List<Set<Integer>> SCCs = kosaraju.findStronglyConnectedComponents();

                // Check the satisfiability using the TwoSatSolver
                TwoSatSolver twoSatSolver = new TwoSatSolver(graph);
                boolean satisfiable = twoSatSolver.checkSatisfiability();

                // Print result for the current file
                if (satisfiable) {
                    System.out.println("Formula " + filename + ": satisfiable");
                } else {
                    System.out.println("Formula " + filename + ": unsatisfiable");
                }

            } catch (Exception e) {
                // Print any error that occurs during processing
                System.out.println("An error occurred while processing file " + filename + ": " + e.getMessage());
            }
        }
    }
}