import com.AndersenLab.app.Dijkstra;
import com.AndersenLab.app.Graph;
import com.AndersenLab.components.Vertex;
import com.AndersenLab.config.Config;
import org.apache.log4j.Logger;

import java.util.LinkedList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Testing class for project
 *
 * @author Vlad Badilovskii
 * @version 1.0
 */
public class DijkstraTest {

    private static final String LOG_PROPERTIES_FILE = "C:/Users/Vlad Badilovskii/IdeaProjects/AlhithmDijkstra/src/main/java/resources/log4j.properties";
    private static Logger logger = org.apache.log4j.Logger.getLogger(DijkstraTest.class);

    public static void main(String[] args) {
    }

    @org.junit.Test
    public void testExecute() {
        Config config = new Config(LOG_PROPERTIES_FILE);
        config.init();
        logger.info("Starting Main test");
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

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.execute(graph, new Vertex(0));
        LinkedList<Vertex> path = dijkstra.getPath(new Vertex(6));
        System.out.println(path);
        assertNotNull(path);
        assertTrue(path.size() > 0);

    }

//    @org.junit.DijkstraTest
//    public void testExecuteEmptyGraph() {
//        Graph graph = new Graph.Builder().build();
//        Dijkstra dijkstra = new Dijkstra(graph);
//        dijkstra.execute(new Vertex(1));
//        LinkedList<Vertex> path = dijkstra.getPath(new Vertex(8));
//        System.out.println(path);
//        assertNull(path);
//    }
//
//    @org.junit.DijkstraTest
//    public void testExecuteSingleVertex() {
//        Graph graph = new Graph.Builder().addEdge(0, 1, 85).build();
//        Dijkstra dijkstra = new Dijkstra(graph);
//        dijkstra.execute(new Vertex(0));
//        LinkedList<Vertex> path = dijkstra.getPath(new Vertex(0));
//        System.out.println(path);
//        assertNull(path);
//    }
//
//    @org.junit.DijkstraTest
//    public void testExecuteHappyPath() {
//        Graph graph = new Graph.Builder().addEdge(0, 1, 85).build();
//        Dijkstra dijkstra = new Dijkstra(graph);
//        dijkstra.execute(new Vertex(0));
//        LinkedList<Vertex> path = dijkstra.getPath(new Vertex(1));
//        System.out.println(path);
//        assertNotNull(path);
//        assertTrue(path.size() > 0);
//    }
//
//    @org.junit.DijkstraTest
//    public void testExecuteApartGraphs() {
//        Graph graph = new Graph.Builder()
//                .addEdge(0, 1, 85)
//                .addEdge(1, 2, 99)
//                .addEdge(2, 0, 44)
//                .addEdge(7, 8, 99)
//                .addEdge(8, 9, 44)
//                .addEdge(9, 7, 66)
//                .build();
//        Dijkstra dijkstra = new Dijkstra(graph);
//        dijkstra.execute(new Vertex(0));
//        LinkedList<Vertex> path = dijkstra.getPath(new Vertex(9));
//        System.out.println(path);
//        assertNull(path);
//    }
}