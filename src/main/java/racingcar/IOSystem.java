package racingcar;

import java.util.Scanner;

public class IOSystem {

    private final Scanner sc;

    public IOSystem() {
        sc = new Scanner(System.in);
    }

    public String[] getCarNamesInput() {
        String carNames = sc.next();
        return carNames.split(",");
    }

    public int getTrialNumber() {
        return Integer.parseInt(sc.next());
    }
}
