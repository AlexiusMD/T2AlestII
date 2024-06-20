import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DepthFirstSearch<T> {
    private Set<T> marked;
    private Map<T, T> edgeTo;
    private T s;

    public DepthFirstSearch(Graph<T> g, T s) {
        this.s = s;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
        dfs(g, s);
    }

    public boolean hasPathTo(T v) {
        return marked.contains(v);
    }

    public Iterable<T> pathTo(T v) {
        List<T> path = new LinkedList<>();
        if (hasPathTo(v)) {
            while (!v.equals(s)) {
                path.add(0, v);
                v = edgeTo.get(v);
            }
            path.add(0, s);
        }
        return path;
    }

    private void dfs(Graph<T> g, T v) {
        marked.add(v);
        for (T w : g.getAdj(v)) {
            if (!marked.contains(w)) {
                edgeTo.put(w, v);
                dfs(g, w);
            }
        }
    }
}
