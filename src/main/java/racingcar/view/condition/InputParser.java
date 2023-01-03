package racingcar.view.condition;

import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    private static final int CAR_NAME_MAX_LENGTH = 5;

    public List<String> splitNames(String inputString){
        List<String> nameList = List.of(inputString.split(","));
        return nameList.stream()
                .filter(this::carNameLimitLength)
                .collect(Collectors.toList());
    }

    public boolean carNameLimitLength(String carName) {
        return carName.length() <= CAR_NAME_MAX_LENGTH;
    }
}
