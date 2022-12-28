package racingcar.view;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {

    public static final int MAX_TRY_COUNT = 99;
    public static final int MAX_NAME_LENGTH = 5;
    private final PrintStream printStream;
    private final Scanner scanner;

    public InputView(PrintStream printStream, InputStream inputStream) {
        this.printStream = printStream;
        this.scanner = new Scanner(inputStream);
    }

    public List<String> inputCarNames() {
        printStream.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<String> names = getCarNames();

        if (hasOverLengthName(names) || hasDuplicatedName(names)) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_NAME_LENGTH + "글자 이하의 유일한 이름이어야 합니다.");
        }

        return names;
    }

    private List<String> getCarNames() {
        String names = scanner.nextLine();
        return trim(split(names));
    }

    private boolean hasDuplicatedName(List<String> names) {
        Set<String> set = new HashSet<>(names);
        return set.size() != names.size();
    }

    private List<String> split(String names) {
        return List.of(names.split(","));
    }

    private List<String> trim(List<String> names) {
        return names.stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private boolean hasOverLengthName(List<String> trimmedNames) {
        return trimmedNames.stream()
                .anyMatch(name -> name.length() > MAX_NAME_LENGTH);
    }

    public int inputMaxTryCount() {
        printStream.println("시도할 회수는 몇회인가요?");
        String value = scanner.nextLine();

        if (isInvalidTryCount(value)) {
            throw new IllegalArgumentException("시도 회수는 " + MAX_TRY_COUNT + "이하의 숫자여야합니다.");
        }

        return Integer.parseInt(value);
    }

    private static boolean isInvalidTryCount(String value) {
        return !(value.matches("\\d+") && Integer.parseInt(value) <= MAX_TRY_COUNT);
    }
}
