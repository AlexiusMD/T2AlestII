import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Box> boxes = ListReader.readFile("./casosT10/teste10.txt");

        Graph<Box> G = new Graph<>();

        for(Box i : boxes)
            for (Box j : boxes)
                G.addEdge(i, j);

        
    }
}