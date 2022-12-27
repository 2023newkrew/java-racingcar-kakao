package racing.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private final String DELIMITER = ",";
    private final String CAR_NAME_DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 이름이 중복되었습니다.";
    private final String CAR_NAME_LENGTH_EXCEPTION_MESSAGE = "[ERROR] 이름은 5자 이하여야 합니다.";
    private final String INPUT_REPEAT_FORMAT_EXCEPTION_MESSAGE = "[ERROR] 반복 횟수는 정수여야 합니다.";
    private final String INPUT_REPEAT_RANGE_EXCEPTION_MESSAGE = "[ERROR] 반복 횟수는 양수여야 합니다.";
    private final int CAR_NAME_MAX_LENGTH = 5;
    private Set<String> carNameSet;

    public List<String> validateCarNames(String inputCarNames) {
        carNameSet = new HashSet<>();
        List<String> carNames = Arrays.asList(inputCarNames.split(DELIMITER));
        carNames.forEach(this::validateSingleCarName);
        return carNames;
    }

    private void validateSingleCarName(String carName) {
        if (carNameSet.contains(carName)) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_EXCEPTION_MESSAGE);
        }
        carNameSet.add(carName);
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    public int validateGameRepeat(String inputRepeat) {
        int repeat;
        try {
            repeat = Integer.parseInt(inputRepeat);
            validatePositive(repeat);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_REPEAT_FORMAT_EXCEPTION_MESSAGE);
        }
        return repeat;
    }

    private void validatePositive(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException(INPUT_REPEAT_RANGE_EXCEPTION_MESSAGE);
        }
    }
}
