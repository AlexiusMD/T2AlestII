import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> casosT10 = new HashMap<>();
        HashMap<Integer, String> casosT11 = new HashMap<>();
        HashMap<Integer, HashMap<Integer, String>> turmas = new HashMap<>();

        turmas.put(1, casosT10);
        turmas.put(2, casosT11);

        casosT10.put(1, "teste10");
        casosT10.put(2, "teste20");
        casosT10.put(3, "teste50");
        casosT10.put(4, "teste100");
        casosT10.put(5, "teste200");
        casosT10.put(6, "teste300");
        casosT10.put(7, "teste500");
        casosT10.put(8, "teste1000");
        casosT10.put(9, "teste2000");

        casosT11.put(1, "caso00010");
        casosT11.put(2, "caso00020");
        casosT11.put(3, "caso00050");
        casosT11.put(4, "caso00100");
        casosT11.put(5, "caso00200");
        casosT11.put(6, "caso00300");
        casosT11.put(7, "caso00500");
        casosT11.put(8, "caso01000");
        casosT11.put(9, "caso02000");
        casosT11.put(10, "caso05000");
        casosT11.put(11, "caso10000");

        Scanner input = new Scanner(System.in);

        System.out.println("Digite qual dos arquivos de caso deseja acessar:\n1. casosT10\n2. casosT11");

        Integer escolhaCasos = input.nextInt();

        System.out.println("Digite o caso de teste desejado: ");

        HashMap<Integer, String> casos = turmas.get(escolhaCasos);

        for (Integer i : casos.keySet()) {
            System.out.println(i + ": " + casos.get(i));
        }

        Integer caso = input.nextInt();
    
        input.close();

        ArrayList<Box> boxes = ListReader.readFile("./casos/" + casos.get(caso) + ".txt");

        Graph<Box> G = new Graph<>();

        for(Box i : boxes)
            for (Box j : boxes)
                if (i.fitsIn(j) && !i.equals(j)) {
                    G.addEdge(j, i);
                    //System.out.println("Adding " + j + " inside " + i);
                }

        System.out.println("Maior caminho é: " + G.longestNesting());
        System.out.println("Número de operações: " + G.numOps);
    }
}