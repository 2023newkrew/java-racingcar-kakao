package racingcar.view;

import java.util.Scanner;

public class InputView {

    public static final int MAXIMUM_LENGTH = 5;
    public Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
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
