package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Input {
    private final String delimiter = ",";

    private final Scanner scanner = new Scanner(System.in);
    private static final int NAME_BOUND = 5;

    public String[] scanNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] stringArray = split(scanner.nextLine());

        validateDuplication(stringArray);
        validateArrayLength(stringArray);
        validateEachString(stringArray);

        return stringArray;
    }

    public int scanTrialNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        return validateTrialCount(scanner.nextLine());
    }

    public String[] split(String stringInput) {
        return  stringInput.split(delimiter);
    }

    public void validateLength(String carName) {
        if (carName.length() > NAME_BOUND || carName.length() == 0) {
            throw new InvalidInputException();
        }
    }

    public void validateArrayLength(String[] inputCarNameArray) {
        if (inputCarNameArray.length<=1){
            throw new InvalidInputException();
        }
    }

    public void validateEachString(String[] inputCarNameArray) {
        for (String carName : inputCarNameArray){
            validateLength(carName);
        }
    }

    public void validateDuplication(String[] inputCarNameArray) {
        Set<String> carNames = new HashSet<>(Arrays.asList(inputCarNameArray));
        if (carNames.size() != inputCarNameArray.length) {
            throw new InvalidInputException();
        }
    }

    public int validateTrialCount(String trialCount) {
        int result = Integer.parseInt(trialCount);
        if (result < 1) {
            throw new InvalidInputException();
        }
        return result;
    }
}
