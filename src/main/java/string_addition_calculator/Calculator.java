package string_addition_calculator;

import string_addition_calculator.validator.NonNegativeValidator;
import string_addition_calculator.validator.PrefixValidator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final PrefixValidator prefixValidator;
    private final NonNegativeValidator nonNegativeValidator;
    private final Addition addition;
    private final Splitter splitter;
    private final StringConverter stringConverter;

    public Calculator() {
        prefixValidator = new PrefixValidator();
        nonNegativeValidator = new NonNegativeValidator();
        addition = new Addition();
        splitter = new Splitter();
        stringConverter = new StringConverter();
    }

    public int calculate(String input) {
        prefixValidator.validate(input);
        List<Integer> numbers = convertInputToNumbers(input);
        AdditionResult result = addition.addAll(numbers);
        return result.getValue();
    }

    private List<Integer> convertInputToNumbers(String input) {
        String[] tokens = splitter.split(input);
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            int value = convertTokenToInteger(token);
            nonNegativeValidator.validate(value);
            numbers.add(value);
        }
        return numbers;
    }

    private int convertTokenToInteger(String token) {
        stringConverter.convertString(token);
        return stringConverter.getResult();
    }
}
