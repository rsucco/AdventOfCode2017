import java.util.*;
import java.io.*;

public class DayNine {

    public static void main(String[] args) throws Exception {
        File file = new File("data.txt");
        Scanner scanner = new Scanner(file);
        String data = new String();
        while (scanner.hasNextLine()) {
            data = data + scanner.nextLine();
        }
        int result = parseChars(data.toCharArray());
        System.out.println (result);
    }

    public static int parseChars(char[] data) {
        int score = 0;
        boolean processNext = true;
        boolean inBrackets = false;
        int groupsDeep = 0;
        boolean processed = true;
        for (char datum : data) {
            if (processNext) {
                if (datum == '!') {
                    processNext = false;
                } else if (datum == '{' && !inBrackets) {
                    groupsDeep++;
                } else if (datum == '<') {
                    inBrackets = true;
                } else if (datum == '>') {
                    inBrackets = false;
                } else if (datum == '}' && !inBrackets) {
                    score += groupsDeep;
                    groupsDeep--;
                }
                processed = true;
            } else {
                processed = false;
            }
            if (!processed)
                processNext = true;
        }
        return score;
    }
}
