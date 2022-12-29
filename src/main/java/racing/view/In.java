package racing.view;

import java.util.Scanner;

public class In {

    static Scanner scanner = new Scanner(System.in);
    public static String inputNames() {
        String names = scanner.nextLine();
        return names;
    }

    public static int inputCount() {
        String count = scanner.nextLine();
        return Integer.parseInt(count);
    }

}
