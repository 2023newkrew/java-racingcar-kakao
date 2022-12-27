package racingcar.view;

import java.util.Scanner;

public class InputView {

    public Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String[] inputName() {
        String[] names = scanner.nextLine().split(" ,");
        for (String name : names) {
            validate(name);
        }
        return names;
    }

    public int inputRunCount(){
        return scanner.nextInt();
    }
    private void validate(String name) {
        if(name.length() >5)
            throw new RuntimeException();
    }
}
