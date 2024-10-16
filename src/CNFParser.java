import java.io.File;
import java.util.Scanner;

public class CNFParser implements Parser {
    private Graph<String> implicationGraph;  // Stores the graph of implications
    private int numVariables;  // Number of variables in the problem
    private int numClauses;  // Number of clauses in the file
    private int counter = 0;

    // Constructor initializes the graph and other attributes
    public CNFParser() {
        this.implicationGraph = new Graph<>();
        this.numVariables = 0;
        this.numClauses = 0;
    }

    // Parse the .cnf file and build the implication graph
    @Override
    public void parse(String filename) throws Exception {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (line.startsWith("c") || line.isEmpty()) {
                    continue;
                }

                if (line.startsWith("p cnf")) {
                    String[] tokens = line.split("\\s+");
                    this.numVariables = Integer.parseInt(tokens[2]);
                    this.numClauses = Integer.parseInt(tokens[3]);
                    System.out.println("Number of variables: " + numVariables);
                    System.out.println("Number of clauses: " + numClauses);
                    continue;
                }

                // Process each clause and add implications
                String[] literals = line.split("\\s+");
                if (literals.length == 3 && literals[literals.length - 1].equals("0")) {
                    int literalA = Integer.parseInt(literals[0]);
                    int literalB = Integer.parseInt(literals[1]);

                    addImplications(literalA, literalB);
                } else {
                    throw new IllegalArgumentException("Invalid clause format in line: " + line);
                }
            }
        }
    }

    // Adds implications to the graph based on the clause literals
    private void addImplications(int literalA, int literalB) throws Exception {
        int notA = -literalA;
        implicationGraph.addArc(notA, literalB, "Implication " + ++counter);
        int notB = -literalB;
        counter++;
        implicationGraph.addArc(notB, literalA, "Implication" + ++counter);
    }

    // Getter for the implication graph
    @Override
    public Graph<String> getImplicationGraph() {
        return implicationGraph;
    }

    // Getter for the number of variables
    @Override
    public int getNumVariables() {
        return numVariables;
    }

    // Getter for the number of clauses
    @Override
    public int getNumClauses() {
        return numClauses;
    }
}
