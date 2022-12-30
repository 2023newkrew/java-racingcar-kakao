package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final int MAXIMUM_LENGTH = 5;
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] inputName() {
        String[] names = scanner.nextLine()
                .split(",");
        for (String name : names) {
            validate(name);
        }
        return names;
    }

    public static int inputRunCount() {
        return scanner.nextInt();
    }

    private static void validate(String name) {
        if (name.length() > MAXIMUM_LENGTH) {
            throw new RuntimeException();
        }
    }
}
