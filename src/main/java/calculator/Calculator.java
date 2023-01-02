package calculator;

import java.util.Arrays;

public class Calculator {
    static Integer add(Integer[] inputs) {
        return Arrays.stream(inputs).reduce(0, Integer::sum);
    }
}
