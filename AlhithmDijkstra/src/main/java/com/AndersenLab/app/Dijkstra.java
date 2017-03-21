package com.AndersenLab.app;

import com.AndersenLab.components.Edge;
import com.AndersenLab.components.Vertex;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * Class Dijkstra implements algorithm Dijkstra
 * and finding minimal path between two vertexes
 *
 * @author Vlad Badilovskii
 * @version 1.0
 */
public class Dijkstra {
    private static final Logger LOGGER = Logger.getLogger(Dijkstra.class.getSimpleName());
    private Path path = new Path();

    public Dijkstra() {
    }

    /**
     * Method for traversing vertices and values between them
     *
     * @param source is starting vertex
     */
    public Path execute(Graph graph, Vertex source) {
        path.setEdges(new ArrayList<>(graph.getEdges()));
        LOGGER.info("Starting sort vertexes");
        path.setSettledNodes(new HashSet<Vertex>());
        path.setUnSettledNodes(new HashSet<Vertex>());
        path.setPredecessors(new HashMap<Vertex, Vertex>());
        path.setDistance(new HashMap<Vertex, Integer>());
        path.getDistance().put(source, 0);
        path.getUnSettledNodes().add(source);
        while (path.getUnSettledNodes().size() > 0) {
            Vertex node = getMinimum(path.getUnSettledNodes());
            path.getSettledNodes().add(node);
            path.getUnSettledNodes().remove(node);
            findMinimalDistances(node);
        }
        return path;
    }

    private void findMinimalDistances(Vertex node) {
        LOGGER.info("Start searching for minimal distances.");
        List<Vertex> adjacentNodes = getNeighbors(node);
        for (Vertex target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node)
                    + getDistance(node, target)) {
                path.getDistance().put(target, getShortestDistance(node)
                        + getDistance(node, target));
                path.getPredecessors().put(target, node);
                path.getUnSettledNodes().add(target);
            }
        }
    }

    private int getDistance(Vertex node, Vertex target) {
        for (Edge edge : path.getEdges()) {
            if (edge.getSource().equals(node)
                    && edge.getDestination().equals(target)) {
                return edge.getWeight();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    private List<Vertex> getNeighbors(Vertex node) {
        List<Vertex> neighbors = new ArrayList<>();
        for (Edge edge : path.getEdges()) {
            if (edge.getSource().equals(node)
                    && !isSettled(edge.getDestination())) {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

    private Vertex getMinimum(Set<Vertex> vertexes) {
        Vertex minimum = null;
        for (Vertex vertex : vertexes) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(Vertex vertex) {
        return path.getSettledNodes().contains(vertex);
    }

    private int getShortestDistance(Vertex destination) {
        Integer d = path.getDistance().get(destination);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

    /**
     * Method for finding the shortest path
     *
     * @param target is endpoint
     * @return way is a list with vertexes
     */
    public LinkedList<Vertex> getPath(Vertex target) {
        LinkedList<Vertex> way = new LinkedList<>();
        Vertex step = target;

        if (path.getPredecessors().get(step) == null) {
            LOGGER.warn("Path with source data does not exist");
            return null;
        }
        way.add(step);
        while (path.getPredecessors().get(step) != null) {
            step = path.getPredecessors().get(step);
            way.add(step);
        }
        Collections.reverse(way);
        return way;
    }
}
