package numberCalculator;

import numberCalculator.exceptions.InvalidFormatException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static numberCalculator.SeparatorParser.DEFAULT_STRING_SEPARATOR;

public class Calculator {
    SeparatorParser SeparatorParser;

    public Calculator() {
        this.SeparatorParser = new SeparatorParser();
    }

    public List<Integer> splitNumbers(String originalString, String Separator) {
        if (originalString.isEmpty()) return Collections.emptyList();
        String[] splittedStr = originalString.split(Separator);
        return Arrays.stream(splittedStr).map(str -> {
            try {
                int res = Integer.parseInt(str);
                if (res < 0) throw new InvalidFormatException();
                return res;
            } catch (NumberFormatException e) {
                throw new InvalidFormatException();
            }
        }).collect(Collectors.toList());
    }

    public Integer summarizeNumbers(String s, String Separator) {
        List<Integer> numbers = splitNumbers(s, Separator);
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public Integer summarizeNumbers(String s) {
        String Separator = SeparatorParser.extract(s);
        if (!Separator.equals(DEFAULT_STRING_SEPARATOR)) {
            s = s.substring(s.indexOf("\n") + 1);
        }
        List<Integer> numbers = splitNumbers(s, Separator);
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
