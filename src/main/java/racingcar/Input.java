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
            throw new InvalidInputException("자동차의 이름의 길이는 1 이상 5 이하여야 합니다.");
        }
    }

    public void validateArrayLength(String[] inputCarNameArray) {
        if (inputCarNameArray.length<=1){
            throw new InvalidInputException("자동차는 2대 이상 입력해야 합니다.");
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
            throw new InvalidInputException("자동차의 이름은 중복되지 않아야 합니다.");
        }
    }

    public int validateTrialCount(String trialCount) {
        int result = Integer.parseInt(trialCount);
        if (result < 1) {
            throw new InvalidInputException("시도 회수는 2번 이상이어야 합니다.");
        }
        return result;
    }
}
