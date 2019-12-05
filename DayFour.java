import java.util.*;
import java.io.*;

public class DayFour {
    public static void main(String[] args) {
        try {
            File file = new File("data.txt");
            Scanner scanner = new Scanner(file);
            int goodPasses = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String passes[] = line.split(" ");
                boolean goodPass = true;
                for (String pass : passes) {
                    int oneTime = 1;
                    for (String other : passes) {
                        if (pass.equals(other) && oneTime == 1)
                            oneTime--;
                        else if (pass.equals(other) && oneTime < 1)
                            goodPass = false;
                    }
                }
                if (goodPass)
                    goodPasses++;
            }
            System.out.println(goodPasses);
        } catch (Exception ex) {
            System.out.println (ex);
        }
    }
}