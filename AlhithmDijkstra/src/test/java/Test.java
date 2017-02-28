import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by Vlad Badilovskii on 24.02.2017.
 */
public class Test {

    public static void main(String[] args) {

    }

    @org.junit.Test
    public void testExecute() {
        Graph graph = new Graph.Builder()
                .addEdge(0, 1, 70)
                .addEdge(0, 2, 140)
                .addEdge(0, 3, 120)
                .addEdge(1, 4, 130)
                .addEdge(2, 3, 80)
                .addEdge(2, 5, 100)
                .addEdge(3, 4, 140)
                .addEdge(3, 5, 100)
                .addEdge(3, 7, 150)
                .addEdge(4, 6, 150)
                .addEdge(5, 6, 170)
                .addEdge(5, 7, 70)
                .addEdge(6, 7, 90)
                .build();

        Dijkstra dijkstra = new Dijkstra(graph);
        dijkstra.execute(new Vertex(0));
        LinkedList<Vertex> path = dijkstra.getPath(new Vertex(6));
        System.out.println(path);
        assertNotNull(path);
        assertTrue(path.size() > 0);

    }

    @org.junit.Test
    public void testExecuteEmptyGraph() {
        Graph graph = new Graph.Builder().build();
        Dijkstra dijkstra = new Dijkstra(graph);
        dijkstra.execute(new Vertex(1));
        LinkedList<Vertex> path = dijkstra.getPath(new Vertex(8));
        System.out.println(path);
        assertNull(path);
    }

    @org.junit.Test
    public void testExecuteSingleVertex() {
        Graph graph = new Graph.Builder().addEdge(0, 1, 85).build();
        Dijkstra dijkstra = new Dijkstra(graph);
        dijkstra.execute(new Vertex(0));
        LinkedList<Vertex> path = dijkstra.getPath(new Vertex(0));
        System.out.println(path);
        assertNull(path);
    }

    @org.junit.Test
    public void testExecuteHappyPath() {
        Graph graph = new Graph.Builder().addEdge(0, 1, 85).build();
        Dijkstra dijkstra = new Dijkstra(graph);
        dijkstra.execute(new Vertex(0));
        LinkedList<Vertex> path = dijkstra.getPath(new Vertex(1));
        System.out.println(path);
        assertNotNull(path);
        assertTrue(path.size() > 0);
    }

    @org.junit.Test
    public void testExecuteApartGraphs() {
        Graph graph = new Graph.Builder()
                .addEdge(0, 1, 85)
                .addEdge(1, 2, 99)
                .addEdge(2, 0, 44)
                .addEdge(7, 8, 99)
                .addEdge(8, 9, 44)
                .addEdge(9, 7, 66)
                .build();
        Dijkstra dijkstra = new Dijkstra(graph);
        dijkstra.execute(new Vertex(0));
        LinkedList<Vertex> path = dijkstra.getPath(new Vertex(9));
        System.out.println(path);
        assertNull(path);
    }
}