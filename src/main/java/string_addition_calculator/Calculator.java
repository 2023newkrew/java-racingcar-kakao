package string_addition_calculator;

import string_addition_calculator.validator.NonNegativeValidator;
import string_addition_calculator.validator.PrefixValidator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public int calculate(String input) {
        PrefixValidator prefixValidator = new PrefixValidator();
        Addition addition = new Addition();
        Splitter splitter = new Splitter();
        StringConverter converter = new StringConverter();
        NonNegativeValidator nonNegativeValidator = new NonNegativeValidator();

        prefixValidator.validate(input);
        String[] split = splitter.split(input);
        List<Integer> numbers = new ArrayList<>();
        for (String s : split) {
            converter.convertString(s);
            int v = converter.getResult();
            nonNegativeValidator.validate(v);
            numbers.add(v);
        }
        AdditionResult result = addition.addAll(numbers.toArray(new Integer[numbers.size()]));

        return result.getValue();
    }
}
