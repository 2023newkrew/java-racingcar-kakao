package stringCalculator.domain;

import java.util.Arrays;
import java.util.stream.Stream;

public class Summation {

    private String inputString;

    public Summation(String inputString) {
        this.inputString = inputString;
    }

    private Stream<String> handleDelimiterEscapeException(String delimiterRegex) {
        try {
            return Arrays.stream(inputString.split(delimiterRegex));
        } catch (Exception e) {
            StringBuffer sb = new StringBuffer("\\" + delimiterRegex);
            return Arrays.stream(inputString.split(sb.toString()));
        }
    }

    public int calculate(String delimiterRegex) {
        try {
            return handleDelimiterEscapeException(delimiterRegex)
                    .mapToInt(element -> {
                        if (Integer.parseInt(element) < 0) {
                            throw new IllegalArgumentException("양수를 입력해주세요");
                        }
                        return Integer.parseInt(element);
                    })
                    .sum();
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해주세요");
        }
    }

}
