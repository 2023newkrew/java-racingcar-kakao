package racingcar;

import java.util.List;

public class RacingCarModel {

    private static final int MAX_CAR_COUNT = 100;
    public static List<String> parseNames(String nameLine) {
        List<String> names = List.of(nameLine.split(","));
        if (names.size() > MAX_CAR_COUNT)
            throw new RuntimeException("car too many. current car count: " + names.size());
        return names;
    }

}
