/*Had some issues comparing chars to ints, realized that just because they both output 1 in their
toString() doesn't mean that they're actually the same. Casting types properly is important.*/

import java.util.Scanner;

public class DayOne {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int result = reviewSequence(scan.next());
        System.out.println(result);
    }

    public static int reviewSequence(String inputS) {
        char[] input = inputS.toCharArray();
        int currentChar = 0;
        int lastChar = 0;
        int counter = 0;
        for (char charTemp : input){
            lastChar = currentChar;
            currentChar = Integer.parseInt(String.valueOf(charTemp));
            if (lastChar == currentChar)
                counter += currentChar;
        }
        if (currentChar == Integer.parseInt(String.valueOf(input[0])))
            counter += currentChar;
        return counter;
    }
}
