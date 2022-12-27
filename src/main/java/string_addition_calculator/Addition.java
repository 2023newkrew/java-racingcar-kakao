package string_addition_calculator;

import java.util.List;

public class Addition {
    public AdditionResult addThree(int num1, int num2, int num3) {
         int result = num1 + num2 + num3;
         return new AdditionResult(result);
    }

    public AdditionResult addTwo(int num1, int num2) {
        int result = num1 + num2;
        return new AdditionResult(result);
    }

    public AdditionResult addNull() {
        int result = 0;
        return new AdditionResult(result);
    }

    public AdditionResult addAll(Integer...numbers) {
        return addAll(List.of(numbers));
    }

    public AdditionResult addAll(List<Integer> numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return new AdditionResult(result);
    }
}
