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

    public void validateLength(String inputStr) {
        if (inputStr.length() > 5 || inputStr.length() == 0) {
            throw new InvalidInputException();
        }
    }


    public void validateArrayLength(String[] inputStr) {
        if (inputStr.length<=1){
            throw new InvalidInputException();
        }
    }

    public void validateEachString(String[] inputStr) {
        for (String string:inputStr){
            validateLength(string);
        }
    }

    public void validateDuplication(String[] inputStr) {
        Set<String> carNames = new HashSet<>(Arrays.asList(inputStr));
        if (carNames.size() != inputStr.length) {
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
