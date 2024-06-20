import java.util.*;

public class CaminhamentoCaixas <T> {
    private Set<T> marked;
    private Map<T, T> edgeTo;
    private T s;

    public CaminhamentoCaixas (Graph<T> G, T s) {
        this.s = s;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();

        dfs(G, s);
    }

    public boolean hasPathTo(T v) {
        return marked.contains(v);
    }

    public LinkedList<T> pathTo(T v) {
        LinkedList<T> path = new LinkedList<>();
        if (hasPathTo(v)) {
            while (!v.equals(s)) {
                path.add(0, v);
                v = edgeTo.get(v);
            }
            path.add(0, s);
        
        }
        return path;
    }

    private void dfs(Graph<T> G, T v) {
        marked.add(v);
        for (T w : G.getAdj(v)) {
            if (! marked.contains(w)) {
                edgeTo.put(w, v);
                dfs(G, w);
            }
        }
    }
}