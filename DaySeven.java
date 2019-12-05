import java.io.*;
import java.util.*;

public class DaySeven {

    public static void main(String[] args) throws FileNotFoundException {
            File file = new File("data.txt");
	        Scanner scanner = new Scanner(file);
	        ArrayList<String> list = new ArrayList<String>();
	        while (scanner.hasNextLine()){
	            list.add(scanner.nextLine(  ));
            }
            list = removeTops(list);
            String notBottom = getNotBottom(list);

            System.out.println(notBottom);

    }

    public static ArrayList<String> removeTops(ArrayList<String> list) {
        ArrayList<String> newList = new ArrayList<String>();
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).contains("->"))
                newList.add(list.get(i));
        }
        return newList;
    }

    public static String getNotBottom(ArrayList<String> list) {
        String bottom = new String();
        ArrayList<String> potentials = new ArrayList<String>();
        ArrayList<String> notBottoms = new ArrayList<String>();
        for (String item : list) {
            potentials.add(item.substring(0, item.indexOf(" ")));
        }
        for (String item : list) {
            for (String potential : potentials) {
                if (item.substring(item.indexOf(" "), item.length()).contains(potential)) {
                    notBottoms.add(potential);
                }
            }
        }
        for (String potential : potentials) {
            if (!notBottoms.contains(potential))
                bottom = potential;
        }
        return bottom;
    }
}
