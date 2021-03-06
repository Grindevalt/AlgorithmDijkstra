/**
 * Created by Vlad Badilovskii on 24.02.2017.
 */
public class Vertex {
    final private int id;
    final private String name;

    public Vertex(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Vertex(int id) {
        this.id = id;
        this.name = "unnamed";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        if (id != vertex.id) return false;
        return name != null ? name.equals(vertex.name) : vertex.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
