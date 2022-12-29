package numberCalculator;

import numberCalculator.exceptions.NegativeArgumentException;
import numberCalculator.exceptions.NonIntegerArgumentException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    SeparatorParser separatorParser;

    public Calculator() {
        this.separatorParser = new SeparatorParser();
    }

    public List<Integer> splitNumbers(String originalString, String seperator) {
        if (originalString.isEmpty()) return Collections.emptyList();
        String[] splitStr = originalString.split(seperator);

        return Arrays.stream(splitStr)
                .map(this::validateInputNumber)
                .collect(Collectors.toList());
    }

    private Integer validateInputNumber(String inputString)
            throws NonIntegerArgumentException, NegativeArgumentException {
        Integer inputNumber;

        try {
            inputNumber = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new NonIntegerArgumentException();
        }

        if (inputNumber < 0) {
            throw new NegativeArgumentException();
        }

        return inputNumber;
    }

    public Integer summarizeNumbers(String s, String separator) {
        List<Integer> numbers = splitNumbers(s, separator);
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public Integer summarizeNumbers(String s) {
        String separator = separatorParser.extract(s);
        if (!separator.equals(",|:")) {
            s = s.substring(s.indexOf("\n") + 1);
        }
        List<Integer> numbers = splitNumbers(s, separator);
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
