package racing.controller;

import racing.service.RacingService;
import racing.service.CarNameSplitter;
import racing.view.RacingView;
import racing.repository.CarRepository;

public class RacingController {
    private final RacingService racingService;
    private final CarNameSplitter carNameSplitter;
    private final RacingView racingView;
    CarRepository carRepository;

    public RacingController() {
        racingService = new RacingService();
        carNameSplitter = new CarNameSplitter();
        racingView = new RacingView();
    }

    public void startRace() {
        String carNames = racingView.inputCarName();
        Integer attempt = racingView.inputAttempt();
        carRepository = new CarRepository(carNameSplitter.split(carNames));

        racingView.printResultString();
        racingView.printCurrentStatus(carRepository.getCarsAll());

        for (int i = 0; i < attempt; i++) {
            racingService.turn(carRepository.getCarsAll());
            racingView.printCurrentStatus(carRepository.getCarsAll());
        }

        racingView.printWinners(carRepository.getCarsAll());
    }
}
