package racingcar;

import java.util.Scanner;

public class StandardConsole implements Console {
    private final Scanner scanner = new Scanner(System.in);

    public String input(String message) {
        printOutput(message);
        return scanner.nextLine();
    }

    public void printOutput(String message) {
        System.out.println(message);
    }

    public void printError(String message) {
        System.out.println("[ERROR] " + message);
    }
}
