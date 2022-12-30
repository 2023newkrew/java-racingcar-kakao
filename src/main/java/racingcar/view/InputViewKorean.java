package racingcar.view;

import racingcar.domain.InvalidInputException;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class InputViewKorean implements InputView{
    private static final String DELIMITER = ",";

    private final Scanner scanner;
    private final PrintStream printStream;

    public InputViewKorean(InputStream inputStream, PrintStream printStream){
        scanner = new Scanner(inputStream);
        this.printStream = printStream;
    }
    public String[] scanNames() {
        printStream.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
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
        printStream.println("시도할 회수는 몇회인가요?");
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
            throw new InvalidInputException("1 : Name should be between 1 and 5.");
        }
    }


    private void validateArrayLength(String[] inputStr) {
        if (inputStr.length<=1){
            throw new InvalidInputException("2 : Cars must be over 2");
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
            throw new InvalidInputException("3 : Duplicated car names.");
        }
    }

    private int validateTrialCount(String trialCount) {
        int result = Integer.parseInt(trialCount);
        if (result < 1) {
            throw new InvalidInputException("4 : Trial count must be over 0.");
        }
        return result;
    }
}
