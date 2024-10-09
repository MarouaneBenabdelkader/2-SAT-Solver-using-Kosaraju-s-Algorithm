import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {

    // Parses a CNF file and constructs the implication graph
    public static Graph<String> parse(String filename) throws Exception {
        Graph<String> graph = new Graph<>();  // Initialize an empty graph

        try (Scanner scanner = new Scanner(new File(filename))) {
            // Read the header
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                // Ignore comments and empty lines
                if (line.startsWith("c") || line.isEmpty()) {
                    continue;
                }

                // Process the "p cnf" header (we can ignore it, but we ensure it exists)
                if (line.startsWith("p cnf")) {
                    String[] tokens = line.split("\\s+");
                    int numVariables = Integer.parseInt(tokens[2]);
                    int numClauses = Integer.parseInt(tokens[3]);
                    System.out.println("Number of variables: " + numVariables);
                    System.out.println("Number of clauses: " + numClauses);
                    continue;
                }

                // Process each clause (lines containing literals and ending with 0)
                String[] literals = line.split("\\s+");
                if (literals.length >= 3 && literals[literals.length - 1].equals("0")) {
                    // Extract the two literals from the clause
                    int literalA = Integer.parseInt(literals[0]);
                    int literalB = Integer.parseInt(literals[1]);

                    // Add arcs to the graph based on each clause literals
                    addArcs(graph, literalA, literalB);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
            throw new Exception("Unable to open file.");
        }

        return graph;
    }

    // Add arcs to the graph based on each clause literals
    private static void addArcs(Graph<String> graph, int literalA, int literalB) throws Exception {
        // Arc: ¬A -> B
        int notA = -literalA;  // ¬A
        graph.addArc(notA, literalB, "arc");  // ¬A -> B

        // Arc: ¬B -> A
        int notB = -literalB;  // ¬B
        graph.addArc(notB, literalA, "arc");  // ¬B -> A
    }

}
