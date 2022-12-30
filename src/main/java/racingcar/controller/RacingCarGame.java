package racingcar.controller;

import racingcar.service.CarService;
import racingcar.service.IOService;

import java.util.List;

/**
 * Racing Game을 실제로 구동시키는 클래스입니다.
 * 구현한 모든 클래스가 조합되어 사용되는 부분
 */
public class RacingCarGame {

    IOService ioService;
    CarService carService;

    public RacingCarGame() {
        ioService = new IOService();
        carService = new CarService();
    }

    public void start() {
        List<String> carNamesInput = ioService.carNamesUserInput();

        carService.addAll(carNamesInput);

        int trialNumber = ioService.trialNumberUserInput();

        playRacingGame(trialNumber);

        printFinalResult();
    }

    private void playRacingGame(int trialNumber) {
        ioService.printInitialGameStatus(carService.getCarList());
        for (int round = 0; round < trialNumber; round++) {
            carService.moveAll();
            ioService.printGameResult(carService.getCarList());
        }
    }

    /*
    private void playRacingGame_v2(int trialNumber) {
        ioService.printInitialGameStatus(carService.getCarList());
        carService.moveAllWithTrial(trialNumber);
    }
    */
    private void printFinalResult() {
        ioService.printWinners(carService.getWinners());
    }
}
