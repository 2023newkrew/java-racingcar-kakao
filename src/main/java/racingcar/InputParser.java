package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    private static final int CAR_NAME_MAX_LENGTH = 5;

    public List<String> splitNames(String inputString){
        List<String> names = List.of(inputString.split(","));
        for (String name : names) {
            checkCarNameLength(name);
        }
        return names;
    }

    public void checkCarNameLength(String testString) {
        if (testString.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
