package racingcar.model;

import racingcar.exception.RacingException;
import racingcar.exception.RacingExceptionCode;
import racingcar.util.Movable;
import racingcar.util.RandomMovable;

import java.util.List;


public class RacingService {
    private static final String DELIMITER = ",";
    private static final int RANDOM_THRESHOLD = 10;
    private static final int RANDOM_BOUND = 4;
    private final Movable movable = new RandomMovable(RANDOM_THRESHOLD, RANDOM_BOUND);
    private final int totalRounds;
    private int trialCount = 0;
    private final RacingCarGroup racingCars;

    public RacingService(String carNames, String trialNumberStr) {

        if (carNames == null || trialNumberStr == null) {
            throw new RacingException(RacingExceptionCode.INVALID_RACING_ARGUMENT);
        }

        int trialNumber = parseIntTrialNumber(trialNumberStr);
        validateTrialNumber(trialNumber);

        this.racingCars = new RacingCarGroup(carNames.split(DELIMITER));
        this.totalRounds = trialNumber;
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

    public List<RacingCar> getCarsForPrintRoundResult() {
        return racingCars.getCarsList();
    }

    public  void validateTrialNumber(int trialNumber) {
        if (trialNumber < 1) {
            throw new RacingException(RacingExceptionCode.INVALID_TRIAL_NUMBER);
        }
    }

    public  int parseIntTrialNumber(String trialNumberStr) {
        int parsedTrialNumber;
        try {
            parsedTrialNumber = Integer.parseInt(trialNumberStr);
        } catch (NumberFormatException e) {
            throw new RacingException(RacingExceptionCode.TRIAL_NOT_NUMBER);
        }
        return parsedTrialNumber;
    }
}