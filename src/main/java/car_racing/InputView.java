package car_racing;

import java.util.Scanner;

public class InputView {
    Scanner sc = new Scanner(System.in);

    public String[] getPlayerNames() {
        String inputString = sc.nextLine();
        String[] splitStrings = inputString.split(",", -1);
        for (String name : splitStrings) {
            verifyName(name);
        }
        return splitStrings;
    }

    public Integer getNumberOfTurns() {
        int turn = sc.nextInt();
        if (turn <= 0) {
            throw new RuntimeException("Invalid number for turns");
        }
        return turn;
    }

    private void verifyName(String name) {
        if (name.length() == 0 || name.length() > 5) {
            throw new RuntimeException("Invalid Name");
        }
    }
}
