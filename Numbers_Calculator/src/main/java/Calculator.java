import exceptions.InvalidFormatException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {
    SeperatorParser seperatorParser;

    public Calculator() {
        this.seperatorParser = new SeperatorParser();
    }

    public List<Integer> splitNumbers(String originalString, String seperator) {
        if (originalString.isEmpty()) return Collections.emptyList();
        String[] splittedStr = originalString.split(seperator);
        return Arrays.stream(splittedStr).map(str -> {
            try {
                Integer res = Integer.parseInt(str);
                if (res < 0) throw new InvalidFormatException();
                return res;
            } catch (NumberFormatException e) {
                throw new InvalidFormatException();
            }
        }).collect(Collectors.toList());
    }

    public Integer summarizeNumbers(String s, String seperator) {
        List<Integer> numbers = splitNumbers(s, seperator);
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public Integer summarizeNumbers(String s) {
        String seperator = seperatorParser.extract(s);
        if (!seperator.equals(",|:")) {
            s = s.substring(s.indexOf("\n") + 1);
        }
        List<Integer> numbers = splitNumbers(s, seperator);
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
