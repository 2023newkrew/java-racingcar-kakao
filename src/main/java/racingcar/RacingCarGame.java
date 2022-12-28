package racingcar;

import java.util.List;

/**
 * Racing Game을 실제로 구동시키는 클래스입니다.
 * 구현한 모든 클래스가 조합되어 사용되는 부분
 */
public class RacingCarGame {

    Service service;

    public RacingCarGame() {
        service = new Service();
    }

    public void start() {
        List<String> carNamesInput = service.carNameUserInputService();
        int trialNumber = service.trialUserInputService();

        service.addCarsInCarListService(carNamesInput);

        service.playRacingGameAndResultService(trialNumber);

        service.printWinnersService();
    }
}
