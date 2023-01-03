package racingcar.domain.car;

import java.util.Arrays;
import java.util.List;

public class RacingCarName {
    private final String name;

    public RacingCarName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static List<String> parseCarNames(String carNamesInput) {
        List<String> carNames = Arrays.asList(carNamesInput.split(","));
        for (String carName : carNames) {
            validateCarName(carName);
        }
        return carNames;
    }

    private static void validateCarName(String carName) {
        if (carName.isEmpty() || carName.length() > 5)
            throw new IllegalArgumentException("차 이름은 1~5 글자로 입력해주세요.");
    }
}
