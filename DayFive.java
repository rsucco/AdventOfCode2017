import java.io.*;
import java.util.*;

public class DayFive {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        try {
            File file = new File("data.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                list.add(Integer.parseInt(scanner.nextLine()));
            }
            System.out.println(list.toString());
        } catch (Exception ex) {
            System.out.println(ex);
        }
        int steps = 0;
        int index = 0;
        while (index < list.size() && index >= 0) {
            steps++;
            list.set(index, list.get(index) + 1);
            index += list.get(index) -1;
        }
        System.out.println (steps);
    }
}
