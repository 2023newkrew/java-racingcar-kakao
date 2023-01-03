package racingcar.view;

import racingcar.domain.car.RacingCarName;
import racingcar.domain.game.RacingGameTurnInfo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static List<String> inputCarNames() {
        List<String> carNames = null;
        while (carNames == null) {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            carNames = tryInputCarNames();
        }
        return carNames;
    }

    private static List<String> tryInputCarNames() {
        try {
            return parseCarNames(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static List<String> parseCarNames(String carNamesInput) {
        List<String> carNames = Arrays.asList(carNamesInput.split(","));
        for (String carName : carNames) {
            validateCarName(carName);
        }
        return carNames;
    }

    private static void validateCarName(String carName) {
        if (carName == null || carName.isEmpty() || carName.length() > 5)
            throw new IllegalArgumentException("차 이름은 1~5 글자로 입력해주세요.");
    }

    public static Integer inputFinalTurn() {
        Integer finalTurn = null;
        while (finalTurn == null) {
            System.out.println("시도할 회수는 몇회인가요?");
            finalTurn = tryInputFinalTurn();
        }
        return finalTurn;
    }

    private static Integer tryInputFinalTurn() {
        try {
            Integer finalTurn = Integer.parseInt(scanner.nextLine());
            RacingGameTurnInfo.validateFinalTurnNumber(finalTurn);
            return finalTurn;
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
