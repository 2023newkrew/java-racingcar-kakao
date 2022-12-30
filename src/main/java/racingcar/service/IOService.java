package racingcar.service;

import racingcar.model.Car;

import java.util.List;
import java.util.Scanner;

/**
 * 프로그램의 UI로직을 담당하는 클래스입니다.
 * 사용자 input도 여기에서 담당합니다.
 */
public class IOService {
    private final Scanner sc;
    private final ValidationService validationService = new ValidationService();
    private final static String COMMA = ",";
    private final static String SPACE = " ";
    final static String NEW_LINE = "\n";

    public IOService() {
        sc = new Scanner(System.in);
    }

    public List<String> carNamesUserInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = sc.next();

        List<String> carNameList = SplitCarNames(carNames);

        validationService.validateInputCarNames(carNameList);

        return carNameList;
    }

    private List<String> SplitCarNames(String carNames) {
        return List.of(carNames.split(COMMA));
    }

    public int trialNumberUserInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        int trialNumber = Integer.parseInt(sc.next());

        validationService.validateTrialUserInput(trialNumber);

        return trialNumber;
    }

    public void printInitialGameStatus(List<Car> cars) {
        System.out.println("실행 결과");
        printGameResult(cars);
    }

    public void printGameResult(List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car.toString() + NEW_LINE);
        }
        System.out.println(stringBuilder.toString());
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
}
