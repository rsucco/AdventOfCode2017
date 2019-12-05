/* This one was a little harder than day 1 but gave some good experience with checksums*/

import java.util.Scanner;
import java.io.File;

public class DayTwo {

    public static void main(String[] args) {
	    File file = new File("data.txt");
	    int checksum = 0;
	    try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine())
                checksum += getLineSum(scan.nextLine());
        } catch (Exception exception) {
	        System.out.println (exception.toString());
        }
        System.out.println (checksum);
    }

    public static int getLineSum (String input) {
        Scanner lineScan = new Scanner(input);
        int[] vals = new int[256];
        int count = 0;
        int biggest = 0;
        int smallest = 60000;
        while (lineScan.hasNextInt()) {
            vals[count] = lineScan.nextInt();
            count++;
        }
        for (int val : vals) {
            if (val > biggest) {
                biggest = val;
            }
            if (val < smallest && val != 0) {
                smallest = val;
            }
        }
        return biggest - smallest;
    }
}