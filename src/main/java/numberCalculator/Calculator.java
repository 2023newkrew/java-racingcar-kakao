package numberCalculator;

import numberCalculator.exceptions.InvalidFormatException;

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
        return Arrays.stream(splitStr).map(str -> {
            try {
                Integer res = Integer.parseInt(str);
                if (res < 0) throw new InvalidFormatException();
                return res;
            } catch (NumberFormatException e) {
                throw new InvalidFormatException();
            }
        }).collect(Collectors.toList());
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
