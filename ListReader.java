import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public abstract class ListReader {
    public static ArrayList<Box> readFile(String path) {
        ArrayList<Box> boxes = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));

            String line = null;

            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(" ");
                int[] sizes = new int[splitLine.length];
                for (int i = 0; i < sizes.length; i++) {
                    sizes[i] = Integer.parseInt(splitLine[i]);
                }

                Box box = new Box(sizes[0], sizes[1], sizes[2]);
                boxes.add(box);
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("Agustini nos ajuda");
            System.err.format(e.getMessage());
        }

        return boxes;
    }
}
