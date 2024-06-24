import java.util.*;

public class LongestPathSearch <T> {
    private LinkedList<T> longest;

    public LongestPathSearch(Graph<T> G, T s) {
        //this.paths = new LinkedList<>();

        longest = lps(G, s);
    }

    public LinkedList<T> longestPath() {
        return longest;
    }

    public LinkedList<T> lps(Graph<T> G, T v) {
        LinkedList<T> longest = new LinkedList<>();

        if (G.getAdj(v) != null) {
            for (T w : G.getAdj(v)) {
                LinkedList<T> path = lps(G, w);
                if (path.size() > longest.size()) {
                    longest = path;

                    //System.out.println("Best path is now " + longest);
                }
            }
        }

        longest.add(v);

        return longest;
    }
}
