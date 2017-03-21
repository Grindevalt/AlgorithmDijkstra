package com.AndersenLab.app;

import com.AndersenLab.components.Edge;
import com.AndersenLab.components.Vertex;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Class for saving graph data for algorithm
 *
 * @author Vlad Badilovskii
 * @version 1.0
 */
public class Path {
    private List<Edge> edges;
    private Set<Vertex> settledNodes;
    private Set<Vertex> unSettledNodes;
    private Map<Vertex, Vertex> predecessors;
    private Map<Vertex, Integer> distance;


    /**
     * Getter for property 'edges'.
     *
     * @return Value for property 'edges'.
     */
    public List<Edge> getEdges() {
        return edges;
    }

    /**
     * Setter for property 'edges'.
     *
     * @param edges Value to set for property 'edges'.
     */
    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    /**
     * Getter for property 'settledNodes'.
     *
     * @return Value for property 'settledNodes'.
     */
    public Set<Vertex> getSettledNodes() {
        return settledNodes;
    }

    /**
     * Setter for property 'settledNodes'.
     *
     * @param settledNodes Value to set for property 'settledNodes'.
     */
    public void setSettledNodes(Set<Vertex> settledNodes) {
        this.settledNodes = settledNodes;
    }

    /**
     * Getter for property 'unSettledNodes'.
     *
     * @return Value for property 'unSettledNodes'.
     */
    public Set<Vertex> getUnSettledNodes() {
        return unSettledNodes;
    }

    /**
     * Setter for property 'unSettledNodes'.
     *
     * @param unSettledNodes Value to set for property 'unSettledNodes'.
     */
    public void setUnSettledNodes(Set<Vertex> unSettledNodes) {
        this.unSettledNodes = unSettledNodes;
    }

    /**
     * Getter for property 'predecessors'.
     *
     * @return Value for property 'predecessors'.
     */
    public Map<Vertex, Vertex> getPredecessors() {
        return predecessors;
    }

    /**
     * Setter for property 'predecessors'.
     *
     * @param predecessors Value to set for property 'predecessors'.
     */
    public void setPredecessors(Map<Vertex, Vertex> predecessors) {
        this.predecessors = predecessors;
    }

    /**
     * Getter for property 'distance'.
     *
     * @return Value for property 'distance'.
     */
    public Map<Vertex, Integer> getDistance() {
        return distance;
    }

    /**
     * Setter for property 'distance'.
     *
     * @param distance Value to set for property 'distance'.
     */
    public void setDistance(Map<Vertex, Integer> distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Path path = (Path) o;

        if (edges != null ? !edges.equals(path.edges) : path.edges != null) return false;
        if (settledNodes != null ? !settledNodes.equals(path.settledNodes) : path.settledNodes != null) return false;
        if (unSettledNodes != null ? !unSettledNodes.equals(path.unSettledNodes) : path.unSettledNodes != null)
            return false;
        if (predecessors != null ? !predecessors.equals(path.predecessors) : path.predecessors != null) return false;
        return distance != null ? distance.equals(path.distance) : path.distance == null;
    }

    @Override
    public int hashCode() {
        int result = edges != null ? edges.hashCode() : 0;
        result = 31 * result + (settledNodes != null ? settledNodes.hashCode() : 0);
        result = 31 * result + (unSettledNodes != null ? unSettledNodes.hashCode() : 0);
        result = 31 * result + (predecessors != null ? predecessors.hashCode() : 0);
        result = 31 * result + (distance != null ? distance.hashCode() : 0);
        return result;
    }

}
