package racingcar.view.condition;

import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    private static final int CAR_NAME_MAX_LENGTH = 5;

    public List<String> splitNames(String inputString){
        List<String> nameList = List.of(inputString.split(","));
        return nameList.stream()
                .filter(this::checkCarNameLength)
                .collect(Collectors.toList());
    }

    public boolean checkCarNameLength(String testString) {
        return testString.length() <= CAR_NAME_MAX_LENGTH;
    }
}
