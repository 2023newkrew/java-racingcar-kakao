package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {


    public List<String> splitNames(String inputString){
        List<String> names = List.of(inputString.split(","));
        return names;
    }


}
