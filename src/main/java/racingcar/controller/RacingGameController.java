package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Scanner;

/**
 * Racing Game을 실제로 구동시키는 클래스입니다.
 * 구현한 모든 클래스가 조합되어 사용되는 부분
 */
public class RacingGameController {

    private final static String COMMA = ",";
    OutputView outputView;
    Scanner sc;

    public RacingGameController() {
        outputView = new OutputView();
        sc = new Scanner(System.in);
    }

    public void start() {
        List<String> carNamesInput = carNamesUserInput();

        Cars cars = new Cars(carNamesInput);

        int trialNumber = trialNumberUserInput();

        playRacingGame(cars, trialNumber);

        printFinalResult(cars);
    }

    public List<String> carNamesUserInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = sc.next();

        List<String> carNameList = SplitCarNames(carNames);

        return carNameList;
    }

    private List<String> SplitCarNames(String carNames) {
        return List.of(carNames.split(COMMA));
    }

    public int trialNumberUserInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        int trialNumber = Integer.parseInt(sc.next());

        return trialNumber;
    }

    private void playRacingGame(Cars cars, int trialNumber) {
        outputView.printInitialGameStatus(cars.getCarList());
        for (int round = 0; round < trialNumber; round++) {
            cars.moveAll();
            outputView.printGameResult(cars.getCarList());
        }
    }

    private void printFinalResult(Cars cars) {
        outputView.printWinners(cars.getWinners());
    }
}
