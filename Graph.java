import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph<T> {
  protected Map<T, List<T>> graph;

  public Graph() {
    graph = new HashMap<>();
  }

  public void addEdge(T v, T w) {
    addToList(v, w);
  }

  public Iterable<T> getAdj(T v) {
    return graph.get(v);
  }

  public Set<T> getVerts() {
    return graph.keySet();
  }

  protected List<T> addToList(T v, T w) {
    List<T> list = graph.get(v);

    if (list == null)
      list = new LinkedList<>();

    list.add(w);
    graph.put(v, list);

    return list;
  }
}
