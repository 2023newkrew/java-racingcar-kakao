package racingcar;

import java.util.List;

public class RacingCarGame {

    RacingCarView racingCarView;
    CarListManager carListManager;

    public RacingCarGame() {
        racingCarView = new RacingCarView();
        carListManager = new CarListManager();
    }

    public void start() {
        List<String> carNamesInput = racingCarView.receiveCarNamesInput();
        int runNumber = racingCarView.receiveRunNumber();
        for (String carName : carNamesInput) {
            carListManager.add(new Car(carName));
        }
        System.out.println("실행 결과");
        racingCarView.printGameResult(carListManager);
        for (int i = 0; i < runNumber; i++) {
            carListManager.moveAll();
            racingCarView.printGameResult(carListManager);
        }
        racingCarView.printWinners(carListManager.selectWinners());
    }
}
