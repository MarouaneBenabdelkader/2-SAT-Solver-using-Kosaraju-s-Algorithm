public class Edge<Label> {
    public int source;  // Arc source
    public int destination;  // Desintation source
    public Label label;  //

    public Edge(int from, int to, Label label) {
        this.source = from;
        this.destination = to;
        this.label = label;
    }

    // Print of Objects
    @Override
    public String toString() {
        return source + " -> " + destination + ", étiquette : " + label;
    }
}
