import java.util.*;

public class LongestPathSearch <T> {
    private LinkedList<LinkedList<T>> paths;

    private LinkedList<T> longest;

    public LongestPathSearch(Graph<T> G, T s) {
        //this.paths = new LinkedList<>();

        longest = lps(G, s);
    }

    public LinkedList<T> longestPath() {
        LinkedList<T> longest = paths.getFirst();

        for (LinkedList<T> p : paths) {
            if (p.size() > longest.size()) {
                longest = p;
            }
        }

        return longest;
    }

    public LinkedList<T> lps(Graph<T> G, T v) {
        LinkedList<T> longest = new LinkedList<>();

        for (T w : G.getAdj(v)) {
            LinkedList<T> path = lps(G, w);
            if (path.size() > longest.size()) {
                longest = path;
            }
        }

        longest.add(v);

        return longest;
    }

    public void lps2(Graph<T> G, T v, LinkedList<T> path) {
        boolean ended = true;
        
        for (T w : G.getAdj(v)) {
            System.out.println("iterating through " + w);

            if (!path.contains(w)) {
                System.out.println(w + " was not in the linked list " + path);

                ended = false;

                LinkedList<T> currentPath = new LinkedList<T>(path);
                currentPath.add(w);

                //System.out.println("linked list " + currentPath);

                lps2(G, w, currentPath);
            }
        }

        if (ended) {
            paths.add(path);
        }
    }
}
