package stringcalculator;

import java.util.Objects;
import java.util.*;
import java.util.stream.Collectors;

public class StringCalculator {

    private Set<String> delimiters;

    public StringCalculator(Set<String> baseDelimiters) {
        delimiters = baseDelimiters;
    }

    public int play(String input) {
        if (!Objects.isNull(input) && input.length() == 1) {
            return Integer.parseInt(input);
        }

        return 0;
    }

    public String[] splitByDelimiter(String input) {
        String[] strings = input.split(delimiterToString());
        return strings;
    }

    public String delimiterToString() {
        return delimiters
                .stream()
                .collect(Collectors.joining("|"))
                .toString();
    }


}
