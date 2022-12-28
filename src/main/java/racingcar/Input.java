package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Input {
    private final String delimiter = ",";

    private final Scanner scanner = new Scanner(System.in);

    public String[] scanNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return split(scanner.nextLine());
    }

    public int scanTrialNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        return validateTrialCount(scanner.nextLine());

    }

    public String[] split(String stringInput) {
        return  stringInput.split(delimiter);
    }

    public void validate(String[] parsedString) {
        validateDuplication(parsedString);
        validateArrayLength(parsedString);
        validateEachString(parsedString);
    }

    private void validateLength(String inputStr) {
        if (inputStr.length() > 5 || inputStr.length() == 0) {
            throw new InvalidInputException("자동차 이름의 길이는 5글자 이하여야 합니다.");
        }
    }


    private void validateArrayLength(String[] inputStr) {
        if (inputStr.length<=1){
            throw new InvalidInputException("경주에 참여할 자동차는 2대 이상이어야 합니다.");
        }
    }

    private void validateEachString(String[] inputStr) {
        for (String string:inputStr){
            validateLength(string);
        }
    }

    private void validateDuplication(String[] inputStr) {
        Set<String> carNames = new HashSet<>(Arrays.asList(inputStr));
        if (carNames.size() != inputStr.length) {
            throw new InvalidInputException("경주에 참여하는 자동차의 이름에 중복이 있습니다.");
        }
    }

    private int validateTrialCount(String trialCount) {
        int result = Integer.parseInt(trialCount);
        if (result < 1) {
            throw new InvalidInputException("시도 횟수는 1회 이상이여야합니다.");
        }
        return result;
    }
}
