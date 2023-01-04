package racing.controller;

import racing.domain.Cars;
import racing.service.RacingService;
import racing.view.RacingView;

public class RacingController {
    private final RacingView racingView;
    private final RacingService racingService;
    private Cars cars;
    private int attempt;

    public RacingController() {
        racingView = new RacingView();
        racingService = new RacingService();
    }

    public void initRace() {
        String carNamesInput = racingView.inputCarName();
        cars = racingService.createCarsByNames(carNamesInput);
        attempt = racingView.inputAttempt();
    }

    public void startRace() {
        racingView.printResultString();
        racingView.printRacingStatus(cars);

        for (int i = 0; i < attempt; i++) {
            racingService.turn(cars);
            racingView.printRacingStatus(cars);
        }

        racingView.printWinners(racingService.getWinnerNames(cars));
    }
}
