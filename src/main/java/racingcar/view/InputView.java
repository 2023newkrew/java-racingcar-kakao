package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final int MAXIMUM_LENGTH = 5;
    private static final Scanner scanner = new Scanner(System.in);


    public String[] inputName() {
        String[] names = scanner.nextLine().split(",");
        for (String name : names) {
            validate(name);
        }
        return names;
    }

    public int inputRunCount() {
        return scanner.nextInt();
    }

    private void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 널이거나, 공백일수 없습니다.");
        }
        if (name.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자가 넘을 수 없습니다.");
        }
    }
}
