package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.CarService;
import racingcar.service.IOService;
import racingcar.service.ValidationService;

import java.util.List;

/**
 * Racing Game을 실제로 구동시키는 클래스입니다.
 * 구현한 모든 클래스가 조합되어 사용되는 부분
 */
public class RacingCarGame {

    ValidationService validationService;
    IOService ioService;
    CarService carService;

    public RacingCarGame() {
        validationService = new ValidationService();
        ioService = new IOService();
        carService = new CarService();
    }

    public void start() {
        List<String> carNamesInput = getValidatedCarNames();

        makeRacingCarList(carNamesInput);

        int trialNumber = getValidatedTrialNumber();

        playRacingGame(trialNumber);

        printFinalResult();
    }

    private List<String> getValidatedCarNames() {
        List<String> carNamesInput = ioService.carNamesUserInput();
        validationService.validateInputCarNames(carNamesInput);
        return carNamesInput;
    }

    private void makeRacingCarList(List<String> carNamesInput) {
        for (String carName : carNamesInput) {
            carService.add(new Car(carName));
        }
    }

    private int getValidatedTrialNumber() {
        int trialNumber = ioService.trialNumberUserInput();
        validationService.validateTrialUserInput(trialNumber);
        return trialNumber;
    }

    private void playRacingGame(int trialNumber) {
        ioService.printInitialGameStatus(carService);
        for (int round = 0; round < trialNumber; round++) {
            carService.moveAll();
            ioService.printGameResult(carService);
        }
    }

    private void printFinalResult() {
        ioService.printWinners(carService.getWinners());
    }
}
