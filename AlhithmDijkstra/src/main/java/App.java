import java.util.LinkedList;

/**
 * Created by Vlad Badilovskii on 26.02.2017.
 */
public class App {
    public static void main(String[] args) {
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
    }
}
