package racingcar;

import java.util.List;

/**
 * Racing Game을 실제로 구동시키는 클래스입니다.
 * 구현한 모든 클래스가 조합되어 사용되는 부분
 */
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

        setUpCarList(carNamesInput);

        playRacingGameAndResult(trialNumber);

        ioSystem.printWinners(carList.getWinners());
    }

    private void playRacingGameAndResult(int trialNumber) {
        System.out.println("실행 결과");
        ioSystem.printGameResult(carList);
        for (int i = 0; i < trialNumber; i++) {
            carList.moveAll();
            ioSystem.printGameResult(carList);
        }
    }

    private void setUpCarList(List<String> carNamesInput) {
        for (String carName : carNamesInput) {
            carList.add(new Car(carName));
        }
    }
}
