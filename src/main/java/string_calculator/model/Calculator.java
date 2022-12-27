package string_calculator.model;

import java.util.Arrays;

public class Calculator {

    private int sumAll(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    private int[] convertAll(String[] numbers) {
        int[] results = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            results[i] = Integer.parseInt(numbers[i]);
        }
        return results;
    }

    public int sumAll(String[] numbers) {
        return sumAll(convertAll(numbers));
    }
}
