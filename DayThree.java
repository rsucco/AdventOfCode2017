import java.util.Scanner;
import java.lang.*;

public class DayThree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number to determine distance:");
        int num = scanner.nextInt();
        int width = 2;
        int height = 1;
        int x = 0;
        int y = 0;
        char dir = 'r';
        int i=1;
        while (i < num) {
                switch (dir) {
                    case 'r':
                        for (int j = 0; j < width-1; j++) {
                            x++;
                            i++;
                            if (i == num)
                                break;
                        }
                        dir = 'u';
                        height++;
                        break;
                    case 'u':
                        for (int j = 0; j < height-1; j++) {
                            y++;
                            i++;
                            if (i == num)
                                break;
                        }
                        dir = 'l';
                        width++;
                        break;
                    case 'l':
                        for (int j = 0; j < width-1; j++) {
                            x--;
                            i++;
                            if (i == num)
                                break;
                        }
                        dir = 'd';
                        height++;
                        break;
                    case 'd':
                        for (int j = 0; j < height-1; j++) {
                            y--;
                            i++;
                            if (i == num)
                                break;
                        }
                        dir = 'r';
                        width++;
                        break;
                }
        }
        int distance = Math.abs(x) + Math.abs(y);
        System.out.println("Distance: " + distance);
    }
}
