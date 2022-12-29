package racingcar.view;

import racingcar.exception.InvalidInputException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int NAME_BOUND = 5;

    public static String[] scanCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String[] carNames = split(scanner.nextLine());
        validateCarNames(carNames);

        return carNames;
    }

    public static int scanTrialCount() {
        System.out.println("시도할 회수는 몇회인가요?");

        String trialCount = scanner.nextLine();
        validateTrialCount(trialCount);

        return toInt(trialCount);
    }

    private static void validateCarNames(String[] stringArray) {
        validateEachLengthOfCarNames(stringArray);
        validateDuplicationOfCarNames(stringArray);
        validateCountOfCars(stringArray);
    }

    private static int toInt(String string) {
        return Integer.parseInt(string);
    }

    private static String[] split(String stringInput) {
        return  stringInput.split(",");
    }

    public static void validateCarNameLength(String carName) {
        if (carName.length() > NAME_BOUND || carName.length() == 0) {
            throw new InvalidInputException("자동차의 이름의 길이는 1 이상 5 이하여야 합니다.");
        }
    }

    public static void validateCountOfCars(String[] inputCarNameArray) {
        if (inputCarNameArray.length<=1){
            throw new InvalidInputException("자동차는 2대 이상 입력해야 합니다.");
        }
    }

    public static void validateEachLengthOfCarNames(String[] inputCarNameArray) {
        for (String carName : inputCarNameArray){
            validateCarNameLength(carName);
        }
    }

    public static void validateDuplicationOfCarNames(String[] inputCarNameArray) {
        Set<String> carNames = new HashSet<>(Arrays.asList(inputCarNameArray));
        if (carNames.size() != inputCarNameArray.length) {
            throw new InvalidInputException("자동차의 이름은 중복되지 않아야 합니다.");
        }
    }

    public static void validateTrialCount(String trialCount) {
        if (Integer.parseInt(trialCount) < 1) {
            throw new InvalidInputException("시도 회수는 2번 이상이어야 합니다.");
        }
    }
}
