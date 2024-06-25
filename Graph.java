import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph <T> {
  protected Map<T, List<T>> graph;
  public int numOps = 0;

  public Graph() {
    graph = new HashMap<>();
  }

  public void addEdge(T v, T w) {
    addToList(v, w, graph);
  }

  public Iterable<T> getAdj(T v) {
    return graph.get(v);
  }

  public Set<T> getVerts() {
    return graph.keySet();
  }

  // Adiciona um vértice adjacente a outro, criando a lista
  // de adjacências caso ainda não exista no dicionário
  protected List<T> addToList(T v, T w, Map<T, List<T>> graph) {
    List<T> list = graph.get(v);

    if (list == null)
      list = new LinkedList<>();

    list.add(w);
    graph.put(v, list);

    return list;
  }

  public int longestNesting() {
        Map<T, Integer> longestPathMap = new HashMap<>();
        for (T v : getVerts()) {
            dfs(v, longestPathMap);
        }
        return Collections.max(longestPathMap.values());
    }

  private int dfs(T v, Map<T, Integer> longestPathMap) {
      if (longestPathMap.containsKey(v)) {
          return longestPathMap.get(v);
      }
      int maxDepth = 1;
      if(getAdj(v) != null){
        for (T w : getAdj(v)) {
          numOps++;
          int depth = 1 + dfs(w, longestPathMap);
          maxDepth = Math.max(maxDepth, depth);
        }
      }
      longestPathMap.put(v, maxDepth);
      return maxDepth;
  }
}
