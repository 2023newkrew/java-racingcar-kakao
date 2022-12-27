package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IOView {

    private Scanner scanner;

    public IOView() {
        this.scanner = new Scanner(System.in);
    }
    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return parseCarNames(scanner.nextLine());
    }

    public List<String> parseCarNames(String s) {
        List<String> carNames = Arrays.asList(s.split(","));
        for(int i=0; i<carNames.size(); i++) {
            carNames.set(i,(carNames.get(i)+"     ").substring(0,5));
        }
        return carNames;
    }
}
