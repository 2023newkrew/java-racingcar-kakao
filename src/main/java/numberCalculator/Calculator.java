package numberCalculator;

import numberCalculator.exceptions.InvalidFormatException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static numberCalculator.SeparatorParser.DEFAULT_STRING_SEPARATOR;

public class Calculator {
    SeparatorParser separatorParser;

    public Calculator() {
        this.separatorParser = new SeparatorParser();
    }

    public List<Integer> splitNumbers(String originalString, String separator) {
        if (originalString.isEmpty()) return Collections.emptyList();
        String[] splittedString = originalString.split(separator);
        return Arrays.stream(splittedString).map(str -> {
            try {
                int res = Integer.parseInt(str);
                if (res < 0) throw new InvalidFormatException("음수가 입력되었습니다.");
                return res;
            } catch (NumberFormatException e) {
                throw new InvalidFormatException("숫자가 아닌 값이 입력되었습니다.", e);
            }
        }).collect(Collectors.toList());
    }

    public Integer summarizeNumbers(String s, String separator) {
        List<Integer> numbers = splitNumbers(s, separator);
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public Integer summarizeNumbers(String s) {
        String separator = separatorParser.extract(s);
        if (!separator.equals(DEFAULT_STRING_SEPARATOR)) {
            s = s.substring(s.indexOf("\n") + 1);
        }
        List<Integer> numbers = splitNumbers(s, separator);
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
