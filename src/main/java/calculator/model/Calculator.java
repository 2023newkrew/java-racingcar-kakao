package calculator.model;

import java.util.Arrays;

public class Calculator {

    private int sumAll(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    private int[] convertAll(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public int sumAll(String[] numbers) {
        return sumAll(convertAll(numbers));
    }
}
