package calculator;

import java.util.List;
import java.util.stream.Collectors;

public class Validator {
    public static void hasNegative(List<Integer> numbers){
        List<Integer> list =
                numbers.stream()
                        .filter(num -> num < 0)
                        .collect(Collectors.toList());

        if(list.size() > 0) throw new RuntimeException();
    }
}
