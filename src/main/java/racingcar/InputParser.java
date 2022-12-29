package racingcar;

import java.util.List;

public class InputParser {
    private static final int CAR_NAME_MAX_LENGTH = 5;

    public List<String> splitNames(String inputString){
        return List.of(inputString.split(","));
    }

    public boolean checkCarNameLength(String testString) {
        return testString.length() <= CAR_NAME_MAX_LENGTH;
    }
}
