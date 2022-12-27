package car_racing.view;

import car_racing.common.exception.InvalidInputFormatException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    Scanner sc = new Scanner(System.in);

    public List<String> getPlayerNames() {
        String inputString = sc.nextLine();
        List<String> splitStrings = List.of(inputString.split(",", -1));
        splitStrings.forEach(this::verifyName);

        return splitStrings;
    }

    public Integer getNumberOfTurns() {
        int turn = sc.nextInt();

        if (turn <= 0) {
            throw new InvalidInputFormatException("Invalid number for turns");
        }

        return turn;
    }

    private void verifyName(String name) {
        if (name.length() == 0 || name.length() > 5) {
            throw new InvalidInputFormatException("Invalid Name");
        }
    }
}
