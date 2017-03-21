package com.AndersenLab.components;

/**
 * Class for creating edge object
 *
 * @author Vlad Badilovskii
 * @version 1.0
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
     * Getter for property id
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Getter for property destination
     *
     * @return
     */
    public Vertex getDestination() {
        return destination;
    }

    /**
     * Getter for property source
     *
     * @return
     */
    public Vertex getSource() {
        return source;
    }

    /**
     * Getter for property weight
     *
     * @return
     */
    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return source + " " + destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (weight != edge.weight) return false;
        if (!id.equals(edge.id)) return false;
        if (!source.equals(edge.source)) return false;
        return destination.equals(edge.destination);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + source.hashCode();
        result = 31 * result + destination.hashCode();
        result = 31 * result + weight;
        return result;
    }
}
