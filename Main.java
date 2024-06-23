import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Box> boxes = ListReader.readFile("./casosT10/teste500.txt");

        Graph<Box> G = new Graph<>();

        for(Box i : boxes)
            for (Box j : boxes)
                if (i.fitsIn(j) && !i.equals(j)) {
                    G.addEdge(j, i);
                    //System.out.println("Adding " + j + " inside " + i);
                }

        LinkedList<Box> longest = new LinkedList<>();

        for (Box v : G.getVerts()) {
            System.out.println("Getting longest path for box " + v);

            LongestPathSearch<Box> lps = new LongestPathSearch<>(G, v);

            LinkedList<Box> path = lps.longestPath();
            
            if (path.size() > longest.size()) {
                longest = path;
            }
        }

        System.out.println("Caminho mais longo:");

        for (Box v : longest) {
            System.out.println(v);
        }
    }
}