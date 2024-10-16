import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
//    * Test of kosaraju and DFS works (needs some modifications)
//         Create the graph
        try {
            // Create a graph with 9 vertices
            Graph<String> graph1 = new Graph<>();

            // Add arcs to the graph
            graph1.addArc(0, 1, "a");
            graph1.addArc(1, 0, "b");
            graph1.addArc(1, 2, "b");
            graph1.addArc(0, 2, "c");
            graph1.addArc(4, 3, "d");
            graph1.addArc(3, 4, "e");
            graph1.addArc(-2, -4, "g");
            graph1.addArc(-3, -4, "h");
            graph1.addArc(-3, -2, "i");
            graph1.addArc(-4, -3, "j");

            // Print the graph for visual inspection
            System.out.println("Original Graph:");
            System.out.println(graph1);

            // Create an instance of Kosaraju with the graph
            Kosaraju<String> kosaraju = new Kosaraju<>(graph1);

            // Run Kosaraju's algorithm to get the SCCs
            List<Set<Integer>> SCCs = kosaraju.findStronglyConnectedComponents();
            TwoSatSolver twoSatSolver = new TwoSatSolver(graph1, 5);
            boolean satisfiable = twoSatSolver.checkSatisfiability();

            // Output the SCCs
            System.out.println("\nStrongly Connected Components (SCCs):");
            for (Set<Integer> scc : SCCs) {
                System.out.println(scc);
            }
            if (satisfiable) {
                System.out.println("Formula " + ": satisfiable");
            } else {
                System.out.println("Formula " + ": unsatisfiable");
            }


        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }





//        ? test of parser current state
//        String filename = "formulas/formule-2-sat.txt";
//        Parser cnfParser = new CNFParser();
//        cnfParser.parse(filename);
//        Graph<String> graph = cnfParser.getImplicationGraph();
//
//        // Print the graph
//        System.out.println(graph);
//        Kosaraju<String> kosaraju = new Kosaraju<>(graph);
//        List<Set<Integer>> SCCs = kosaraju.findStronglyConnectedComponents();
//        System.out.println("\nStrongly Connected Components (SCCs):");
//        for (Set<Integer> scc : SCCs) {
//            System.out.println(scc);
//        }
//        TwoSatSolver twoSatSolver = new TwoSatSolver(graph, cnfParser.getNumVariables());
//        boolean satisfiable = twoSatSolver.checkSatisfiability();
//        if (satisfiable) {
//            System.out.println("Formula " + filename + ": satisfiable");
//        } else {
//            System.out.println("Formula " + filename + ": unsatisfiable");
//        }
//        ! given code from tp initial state
//        Parser parser = new Parser();
//        Graph<String> graph = parser.parse(filename);
//        System.out.println(graph.toString());
//        Kosaraju k = new Kosaraju(graph);
//        int[] composantes = k.sccs();
//
//        if (TwoSat.checkConsistency(composantes)) {
//            System.out.println("Formula " + filename + ": satisfiable");
//            exit(0);
//        } else {
//            System.out.println("Formula " + filename + ": unsatisfiable");
//            exit(-1);
//        }
//        exit(0);

    }

}
