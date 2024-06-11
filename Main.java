import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Box> boxes = ListReader.readFile("./casosT10/teste10.txt");

        for(int i = 0; i < boxes.size(); i++){
            System.out.println(boxes.get(i));
        }
    }
}