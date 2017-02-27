import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Vlad Badilovskii on 24.02.2017.
 */
public class Graph {
    private final List<Vertex> vertexes;
    private final List<Edge> edges;

    public List<Edge> getEdges() {
        return edges;
    }
    public List<Vertex> getVertexes(){
        return vertexes;
    }

    public static class Builder {
        private List<Vertex> vertexes = new ArrayList<Vertex>();
        private List<Edge> edges = new ArrayList<Edge>();

        public Builder addVertex(Vertex vertex) {
            this.vertexes.add(vertex);
            return this;
        }

        public Builder addVertexes(List<Vertex> vertexes) {
            this.vertexes.addAll(vertexes);
            return this;
        }

        public Builder addEdge(int sourceLocNo, int destLocNo, int duration) {
            vertexCheckAvailability(sourceLocNo);
            vertexCheckAvailability(destLocNo);
            Edge lane = new Edge("", vertexes.get(sourceLocNo), vertexes.get(destLocNo), duration);
            edges.add(lane);
            return this;
        }

        private void vertexCheckAvailability(int id) {
            //или добавлять или выбрасывать ошибку
            while(vertexes.size() < id + 1 ){
                vertexes.add(new Vertex(vertexes.size()));
            }
        }

        public Graph build() {
            return new Graph(vertexes, edges);
        }
    }

    private Graph(List<Vertex> vertexes, List<Edge> edges) {
        this.vertexes = Collections.unmodifiableList(vertexes);
        this.edges = Collections.unmodifiableList(edges);
    }


}
