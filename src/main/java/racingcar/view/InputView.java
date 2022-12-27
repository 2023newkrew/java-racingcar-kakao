package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final int MAXIMUM_LENGTH = 5;
    private static final Scanner scanner = new Scanner(System.in);

    public InputView() {
    }
    public String[] inputName() {
        String[] names = scanner.nextLine().split(",");
        for (String name : names) {
            validate(name);
        }
        return names;
    }

    public int inputRunCount(){
        return scanner.nextInt();
    }
    private void validate(String name) {
        if(name.length() > MAXIMUM_LENGTH)
            throw new RuntimeException();
    }
}
