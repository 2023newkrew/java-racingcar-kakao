package racingcar.service;

import racingcar.model.RacingCar;
import racingcar.repository.RacingRepository;
import racingcar.util.Movable;
import racingcar.util.RacingCarsGenerator;
import racingcar.util.RacingCarsValidator;
import racingcar.util.RandomMovable;

import java.util.List;


public class RacingService {
    private static final String DELIMITER = ",";
    private static final int RANDOM_THRESHOLD = 10;
    private static final int RANDOM_BOUND = 4;
    private final Movable movable;
    private final int totalRounds;
    private int trialCount = 0;
    private final RacingRepository racingRepository;

    public RacingService(String carNames, int totalRounds) {
        this.racingRepository = new RacingRepository(RacingCarsGenerator.generate(carNames.split(DELIMITER)));
        this.totalRounds = totalRounds;
        this.movable = new RandomMovable(RANDOM_THRESHOLD, RANDOM_BOUND);
    }


    public boolean isRacingEnd() {
        return trialCount >= totalRounds;
    }

    public void proceedRound() {
        racingRepository.getCars().moveCars(movable);
        trialCount++;
    }

    public List<RacingCar> getWinners() {
        return racingRepository.getCars().getWinners();
    }

    public static void validateCarNames(String carNames) {
        RacingCarsValidator.validateCarNames(carNames.split(DELIMITER));
    }

    public static void validateTrialNumber(String trialNumber) {
        RacingCarsValidator.validateTrialNumber(trialNumber);
    }

    public List<RacingCar> getCarsForPrintRoundResult() {
        return racingRepository.getCars().getCarsList();
    }

}