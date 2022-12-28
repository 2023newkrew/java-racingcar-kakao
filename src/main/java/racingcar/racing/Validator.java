package racingcar.racing;

import racingcar.car.Car;

import java.util.List;

public class Validator {
    public static boolean isValidNames(List<String> names) {
        if (names.size() != names.stream().distinct().count()) return false;

        return names.stream().allMatch(Car::isValidSingleName);
    }

    public static boolean isValidTurn(String turn) {
        int parsedTurn;

        try {
            parsedTurn = Integer.parseInt(turn);
        } catch (NumberFormatException e) {
            return false;
        }

        return parsedTurn > 0;
    }
}
