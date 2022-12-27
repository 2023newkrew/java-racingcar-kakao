package racingcar;

import java.util.List;

public class RacingCarGame {

    IOSystem ioSystem;
    CarList carList;

    public RacingCarGame() {
        ioSystem = new IOSystem();
        carList = new CarList();
    }

    public void start() {
        List<String> carNamesInput = ioSystem.getCarNamesInput();
        int trialNumber = ioSystem.getTrialNumber();
        for (String carName : carNamesInput) {
            carList.add(new Car(carName));
        }
        System.out.println("실행 결과");
        ioSystem.printGameResult(carList);
        for (int i = 0; i < trialNumber; i++) {
            carList.moveAll();
            ioSystem.printGameResult(carList);
        }
        ioSystem.printWinners(carList.selectWinners());
    }
}
