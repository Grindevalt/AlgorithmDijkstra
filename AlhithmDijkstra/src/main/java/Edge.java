/**
 *
 */

public class Edge {
    private final String id;
    private final Vertex source;
    private final Vertex destination;
    private final int weight;

    public Edge(String id, Vertex source, Vertex destination, int weight) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public Vertex getDestination() {
        return destination;
    }

    /**
     *
     * @return
     */
    public Vertex getSource() {
        return source;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return source + " " + destination;
    }
}
