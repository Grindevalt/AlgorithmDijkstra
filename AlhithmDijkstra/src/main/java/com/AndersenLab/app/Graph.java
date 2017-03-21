package com.AndersenLab.app;

import com.AndersenLab.components.Edge;
import com.AndersenLab.components.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class for creating graph object
 *
 * @author Vlad Badilovskii
 * @version 1.0
 */
public class Graph {

    private final List<Vertex> vertexes;
    private final List<Edge> edges;

    private Graph(List<Vertex> vertexes, List<Edge> edges) {
        this.vertexes = Collections.unmodifiableList(vertexes);
        this.edges = Collections.unmodifiableList(edges);
    }

    /**
     * Getter for property 'edges'
     *
     * @return Value for property 'edges'
     */
    public List<Edge> getEdges() {
        return edges;
    }

    /**
     * Getter for property 'vertexes'
     *
     * @return Value for property 'vertexes'
     */
    public List<Vertex> getVertexes() {
        return vertexes;
    }

    public static class Builder {
        private List<Vertex> vertexes = new ArrayList<>();
        private List<Edge> edges = new ArrayList<>();

        /**
         * Realisation of builder pattern
         *
         * @param sourceLocNo
         * @param destLocNo
         * @param duration
         * @return
         */
        public Builder addEdge(int sourceLocNo, int destLocNo, int duration) {
            vertexCheckAvailability(sourceLocNo);
            vertexCheckAvailability(destLocNo);
            Edge lane = new Edge("", vertexes.get(sourceLocNo), vertexes.get(destLocNo), duration);
            edges.add(lane);
            return this;
        }

        private void vertexCheckAvailability(int id) {
            while (vertexes.size() < id + 1) {
                vertexes.add(new Vertex(vertexes.size()));
            }
        }

        /**
         * R
         *
         * @return
         */
        public Graph build() {
            return new Graph(vertexes, edges);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Graph graph = (Graph) o;

        if (!vertexes.equals(graph.vertexes)) return false;
        return edges.equals(graph.edges);
    }

    @Override
    public int hashCode() {
        int result = vertexes.hashCode();
        result = 31 * result + edges.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "vertexes=" + vertexes +
                ", edges=" + edges +
                '}';
    }
}
