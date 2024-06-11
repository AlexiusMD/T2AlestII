import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {
  protected Map<String, List<String>> graph;

  public Graph() {
    graph = new HashMap<>();
  }

  public void addEdge(String v, String w) {
    addToList(v, w);
    addToList(w, v);
  }

  public Iterable<String> getAdj(String v) {
    return graph.get(v);
  }

  public Set<String> getVerts() {
    return graph.keySet();
  }

  // Adiciona um vértice adjacente a outro, criando a lista
  // de adjacências caso ainda não exista no dicionário
  protected List<String> addToList(String v, String w) {
    List<String> list = graph.get(v);

    if (list == null)
      list = new LinkedList<>();

    list.add(w);
    graph.put(v, list);

    return list;
  }
}
