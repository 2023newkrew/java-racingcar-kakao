package racingcar;

import java.util.List;
import java.util.Scanner;

/**
 * 프로그램의 UI로직을 담당하는 클래스입니다.
 * UI로직과 validation로직이 모두 들어가 있습니다.
 */
public class IOSystem {
    private final Scanner sc;
    final static String COMMA = ",";
    final static String SPACE = " ";

    public IOSystem() {
        sc = new Scanner(System.in);
    }

    public List<String> carNamesUserInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = sc.next();

        List<String> carNameList = SplitCarNames(carNames);
        return carNameList;
    }

    private static List<String> SplitCarNames(String carNames) {
        return List.of(carNames.split(COMMA));
    }

    public void printWinners(List<Car> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car winner : winners) {
            stringBuilder.append(winner.getName() + COMMA + SPACE);
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append("가 최종 우승했습니다.");
        System.out.println(stringBuilder.toString());
    }

    public void printGameResult(CarList carList) {
        System.out.println(carList);
    }

    public int trialNumberUserInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        int trialNumber = Integer.parseInt(sc.next());

        return trialNumber;
    }
}
