public interface Parser {
    void parse(String filename) throws Exception;  // Parses the input file
    Graph<String> getImplicationGraph();  // Returns the constructed graph
    int getNumVariables();  // Returns the number of variables
    int getNumClauses();  // Returns the number of clauses
}
