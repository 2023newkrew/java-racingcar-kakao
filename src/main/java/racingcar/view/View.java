package racingcar.view;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class View {

    private final PrintStream printStream;
    private final Scanner scanner;

    public View(PrintStream printStream, InputStream inputStream) {
        this.printStream = printStream;
        this.scanner = new Scanner(inputStream);
    }

    public List<String> inputCarNames() {
        List<String> names = getCarNames();

        if (hasOverLengthName(names)) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 넘을 수 없습니다.");
        }

        if (hasDuplicatedName(names)) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }

        return names;
    }

    private List<String> getCarNames() {
        printStream.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
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
                .anyMatch(name -> name.length() > 5);
    }
}
