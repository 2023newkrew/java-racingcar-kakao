package racingcar.util;

import racingcar.exception.RacingException;
import racingcar.exception.RacingExceptionCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RacingCarsValidator {
    private static final int CARS_SIZE_LOWER_LIMIT = 2;
    private static final int CAR_NAME_LENGTH_LIMIT = 5;

    public static void validateCarNames(String[] carNames) {
        validateCarNumber(carNames);
        for (String carName : carNames) {
            validateLength(carName);
        }
        validateDuplication(carNames);
    }

    public static void validateTrialNumber(String trialNumberInput) {
        int trialNumber;
        try {
            trialNumber = Integer.parseInt(trialNumberInput);
        } catch (NumberFormatException e) {
            throw new RacingException(RacingExceptionCode.TRIAL_NOT_NUMBER);
        }
        if (trialNumber < 1) {
            throw new RacingException(RacingExceptionCode.INVALID_TRIAL_NUMBER);
        }
    }

    private static void validateCarNumber(String[] carNames) {
        if (carNames.length < CARS_SIZE_LOWER_LIMIT) {
            throw new RacingException(RacingExceptionCode.INVALID_CARS_SIZE);
        }
    }

    private static void validateLength(String inputStr) {
        if (inputStr.length() > CAR_NAME_LENGTH_LIMIT || inputStr.length() == 0) {
            throw new RacingException(RacingExceptionCode.INVALID_CAR_LENGTH);
        }
    }

    private static void validateDuplication(String[] inputStr) {
        Set<String> carNames = new HashSet<>(Arrays.asList(inputStr));
        if (carNames.size() != inputStr.length) {
            throw new RacingException(RacingExceptionCode.CAR_NAME_DUPLICATION);
        }
    }


}
