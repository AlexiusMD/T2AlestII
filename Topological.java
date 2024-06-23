import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Topological<T> {
    private Set<T> marked;
    private List<T> verts;

    public Topological(Digraph<T> g) {
        marked = new HashSet<>();
        verts = new LinkedList<>();
        for (T v : g.getVerts()) {
            if (!marked.contains(v)) {
                System.out.println("Start: " + v);
                dfs(g, v);
            }
        }
    }

    public Iterable<T> getTopological() {
        return verts;
    }

    private void dfs(Graph<T> g, T v) {
        marked.add(v);
        System.out.println("Estou em " + v);
        Iterable<T> adj = g.getAdj(v);
        if (adj != null) {
            for (T w : adj) {
                if (!marked.contains(w)) {
                    dfs(g, w);
                }
            }
        }
        System.out.println("Add: " + v);
        // Pós-ordem reversa:
        verts.add(0, v); // insere no inicio da lista
    }
}