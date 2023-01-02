package racing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_REPEAT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String INPUT_REPEAT_FORMAT_EXCEPTION_MESSAGE = "[ERROR] 반복 횟수는 정수여야 합니다.";


    public List<String> readCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String input = scanner.nextLine();
        return splitInputCarNames(input);
    }

    private List<String> splitInputCarNames(String input) {
        String[] splittedCarNames = input.split(DELIMITER);
        return Arrays.asList(splittedCarNames);
    }

    public int readGameRepeat() {
        System.out.println(INPUT_REPEAT_MESSAGE);
        try {
            String input = scanner.nextLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_REPEAT_FORMAT_EXCEPTION_MESSAGE);
        }
    }
}
