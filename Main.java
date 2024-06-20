import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Box> boxes = ListReader.readFile("./casosT10/teste10.txt");

        Graph<Box> G = new Graph<>();

        for(Box b : boxes){
            for (Box c : boxes) {
                if (b.fitsIn(c)) {
                    G.addEdge(b, c);
                }
            }
        }

        ArrayList<LinkedList<Box>> caminhos = new ArrayList<>(G.getVerts().size());

        for(Box b : G.getVerts()) {
            CaminhamentoCaixas<Box> dfs = new CaminhamentoCaixas<>(G, b);

            for (Box c : G.getVerts()) {
                LinkedList<Box> caminho = dfs.pathTo(c);
                caminhos.add(caminho);
            }
        }

        CaminhamentoCaixas<Box> maior = null;
        int tamanho = 0;
        for (LinkedList<Box> caminho : caminhos) {
            if ()
        }
    }
}