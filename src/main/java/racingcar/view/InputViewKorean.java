package racingcar.view;

import racingcar.domain.InvalidInputException;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputViewKorean implements InputView{
    private static final String DELIMITER = ",";

    private final Scanner scanner;

    public InputViewKorean(InputStream inputStream){
        scanner = new Scanner(inputStream);
    }
    public String[] scanNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanNames(scanner.nextLine());
    }
    public String[] scanNames(String names){ // inputStream을 거치지 않고 직접 입력
        String[] stringArray = split(names);
        validateDuplication(stringArray);
        validateArrayLength(stringArray);
        validateEachString(stringArray);
        return stringArray;
    }

    public int scanTrialCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return validateTrialCount(scanner.nextLine());
    }

    public int scanTrialCount(String input) { // inputStream을 거치지 않고 직접 입력
        return validateTrialCount(input);
    }

    private String[] split(String stringInput) {
        return stringInput.split(DELIMITER);
    }

    private void validateLength(String inputStr) {
        if (inputStr.length() > 5 || inputStr.length() == 0) {
            throw new InvalidInputException("자동차의 길이는 1~5 사이어야 합니다.");
        }
    }


    private void validateArrayLength(String[] inputStr) {
        if (inputStr.length<=1){
            throw new InvalidInputException("두 개 이상의 자동차를 입력해 주세요");
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
            throw new InvalidInputException("중복된 이름의 자동차를 입력하지 마세요.");
        }
    }

    private int validateTrialCount(String trialCount) {
        int result = Integer.parseInt(trialCount);
        if (result < 1) {
            throw new InvalidInputException("시도 회수는 1 이상이여야 합니다.");
        }
        return result;
    }
}
