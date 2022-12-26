package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Splitter {

    public List<Integer> split(String input){
        return Arrays.stream(input.split("[,;]"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
