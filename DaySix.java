import java.io.*;
import java.util.*;

public class DaySix {

    public static void main(String[] args) {
	    try {
            File file = new File("data.txt");
            Scanner scanner = new Scanner(file);
            ArrayList<Integer> list = new ArrayList<Integer>();
            ArrayList<String> seenBefore = new ArrayList<String>();
            while (scanner.hasNextInt()) {
                list.add(scanner.nextInt());
            }

            do {
                seenBefore.add(list.toString());
                list = redistribute(list);
            } while (!seenBefore.contains(list.toString()));

            System.out.println(seenBefore.size());
        } catch (Exception ex) {
	        System.out.println (ex);
        }
    }

    public static ArrayList<Integer> redistribute(ArrayList<Integer> list) {
        int biggest = 0;
        for (int i=0; i < list.size(); i++) {
            if (list.get(i) > list.get(biggest))
                biggest = i;
        }

        int nextItem = 0;
        if (biggest != list.size() - 1)
            nextItem = biggest + 1;

        int toRedistribute = list.get(biggest);
        list.set(biggest, 0);
        for (int i = toRedistribute; i > 0; i--) {
            list.set(nextItem, list.get(nextItem) + 1);
            if (nextItem == list.size() - 1) {
                nextItem = 0;
            } else {
                nextItem++;
            }
        }
        System.out.println(list);
        return list;
    }
}
