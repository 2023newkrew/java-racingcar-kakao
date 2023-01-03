package racingcar.view;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static final String NAME_SPLIT_REGEX = ",";
    private final PrintStream printStream;
    private final Scanner scanner;

    public InputView(PrintStream printStream, InputStream inputStream) {
        this.printStream = printStream;
        this.scanner = new Scanner(inputStream);
    }

    public List<String> inputCarNames() {
        printStream.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String names = scanner.nextLine();
        return trim(split(names));
    }

    private List<String> split(String names) {
        return List.of(names.split(NAME_SPLIT_REGEX));
    }

    private List<String> trim(List<String> names) {
        return names.stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public int inputMaxRound() {
        printStream.println("시도할 회수는 몇회인가요?");
        String maxRound = scanner.nextLine();
        if(!isInteger(maxRound)){
            throw new IllegalArgumentException("시도할 횟수는 정수여야합니다.");
        }
        return Integer.parseInt(maxRound);
    }

    public boolean isInteger(String value){
        return value.matches("[-+]?\\d+");
    }
}
