public class Edge<Label> {
    public int source;  // Sommet source de l'arête
    public int destination;  // Sommet destination de l'arête
    public Label label;  // Étiquette (label) de l'arête

    // Constructeur pour créer une arête avec une source, une destination et un label
    public Edge(int from, int to, Label label) {
        this.source = from;
        this.destination = to;
        this.label = label;
    }

    // Affiche l'arête au format source -> destination, étiquette : label
    @Override
    public String toString() {
        return source + " -> " + destination + ", étiquette : " + label;
    }
}
