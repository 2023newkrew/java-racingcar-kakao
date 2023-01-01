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
    public String[] getNamesArray() {
        printStream.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return getNamesArray(scanner.nextLine());
    }
    public String[] getNamesArray(String names){ // inputStream을 거치지 않고 직접 입력
        String[] stringArray = parseNames(names);
        validateEachString(stringArray);
        validateDuplication(stringArray);
        validateArrayLength(stringArray);
        return stringArray;
    }

    public int getTrialCount() {
        printStream.println("시도할 회수는 몇회인가요?");
        return getTrialCount(scanner.nextLine());
    }

    public int getTrialCount(String input) { // inputStream을 거치지 않고 직접 입력
        int trialCount = parseStringToInt(input);
        validateTrialCount(trialCount);
        return trialCount;
    }

    private String[] parseNames(String stringInput) {
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

    private int parseStringToInt(String input){
        return Integer.parseInt(input);
    }
    private void validateTrialCount(int trialCount) {
        if (trialCount < 1) {
            throw new InvalidInputException("4 : Trial count must be over 0.");
        }
    }
}
