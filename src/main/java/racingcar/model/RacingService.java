package racingcar.model;

import racingcar.exception.RacingException;
import racingcar.exception.RacingExceptionCode;
import racingcar.util.Movable;
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
    private final RacingCarGroup racingCars;

    public RacingService(String carNames, String trialNumberStr) {

        validateCarNames(carNames);

        int trialNumber = parseIntTrialNumber(trialNumberStr);
        validateTrialNumber(trialNumber);

        this.racingCars = new RacingCarGroup(carNames.split(DELIMITER));
        this.totalRounds = trialNumber;
        this.movable = new RandomMovable(RANDOM_THRESHOLD, RANDOM_BOUND);
    }


    public boolean isRacingEnd() {
        return trialCount >= totalRounds;
    }

    public void proceedRound() {
        if (isRacingEnd()) {
            throw new RacingException(RacingExceptionCode.ALREADY_RACING_END);
        }
        racingCars.moveCars(movable);
        trialCount++;
    }

    public List<RacingCar> getWinners() {
        return racingCars.getWinners();
    }

    public static void validateCarNames(String carNames) {
        if (carNames == null) {
            throw new RacingException(RacingExceptionCode.INVALID_RACING_ARGUMENT);
        }
        RacingCarsValidator.validateCarNames(carNames.split(DELIMITER));
    }

    public static int parseIntTrialNumber(String trialNumberInput) {
        return RacingCarsValidator.parseIntTrialNumber(trialNumberInput);
    }

    public static void validateTrialNumber(int trialNumber) {
        RacingCarsValidator.validateTrialNumber(trialNumber);
    }

    public List<RacingCar> getCarsForPrintRoundResult() {
        return racingCars.getCarsList();
    }

}