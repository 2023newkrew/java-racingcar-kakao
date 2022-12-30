package racingcar.service;

import racingcar.model.RacingCar;
import racingcar.repository.RacingCars;
import racingcar.util.Movable;
import racingcar.util.RacingCarsValidator;

import java.util.ArrayList;
import java.util.List;


public class RacingService {
    private static final String DELIMITER = ",";
    private final Movable movable;
    private final int totalRounds;
    private int trialCount = 0;
    private final RacingCars cars;

    public RacingService(String carNames, int totalRounds, Movable movable) {
        this.cars = new RacingCars(carNames.split(DELIMITER));
        this.totalRounds = totalRounds;
        this.movable = movable;
    }


    public boolean isRacingEnd() {
        return trialCount >= totalRounds;
    }

    public void proceedRound() {
        cars.moveCars(movable);
        trialCount++;
    }

    public List<RacingCar> getWinners() {
        return cars.getWinners();
    }

    public static void validateCarNames(String carNames) {
        RacingCarsValidator.validateCarNames(carNames.split(DELIMITER));
    }

    public static void validateTrialNumber(String trialNumber) {
        RacingCarsValidator.validateTrialNumber(trialNumber);
    }

    public ArrayList<RacingCar> getCarsForPrintRoundResult() {
        return cars.getCars();
    }

}