import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> casos = new HashMap<>();

        casos.put(1, "teste10");
        casos.put(2, "teste20");
        casos.put(3, "teste50");
        casos.put(4, "teste100");
        casos.put(5, "teste200");
        casos.put(6, "teste300");
        casos.put(7, "teste500");
        casos.put(8, "teste1000");
        casos.put(9, "teste2000");

        System.out.println("Digite o caso de teste desejado (recomendo um pc quantico caso queira rodar o caso 7 pra cima (só deus sabe o resultado))");

        for (Integer i : casos.keySet()) {
            System.out.println(i + ": " + casos.get(i));
        }

        Scanner input = new Scanner(System.in);

        Integer caso = input.nextInt();

        input.close();

        ArrayList<Box> boxes = ListReader.readFile("./casosT10/" + casos.get(caso) + ".txt");

        Graph<Box> G = new Graph<>();

        for(Box i : boxes)
            for (Box j : boxes)
                if (i.fitsIn(j) && !i.equals(j)) {
                    G.addEdge(j, i);
                    //System.out.println("Adding " + j + " inside " + i);
                }

        LinkedList<Box> longest = new LinkedList<>();

        float count = 1;

        Set<Box> verts = G.getVerts();
        int size = verts.size();
        for (Box v : verts) {
            if (G.getAdjRev(v) == null) { //se n tiver caixa acima (elegivel a ser o caminho mais longo)
                System.out.println("Loading " + (100 * count/size) + "%");

                LongestPathSearch<Box> lps = new LongestPathSearch<>(G, v);

                LinkedList<Box> path = lps.longestPath();
                
                if (path.size() > longest.size()) {
                    longest = path;
                }
            }
            
            count++;
        }

        count = 0;

        System.out.println("Caminho mais longo:");

        for (Box v : longest) {
            System.out.println(v);
            count++;
        }

        System.out.println("O caminho mais longo é composto por " + count + " caixas");
    }
}