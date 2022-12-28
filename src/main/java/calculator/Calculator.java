package calculator;

import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private String delimiters = ",:";
    private String input;
    private String[] splitedNum;

    public Calculator(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public String[] getSplitedNum() {
        return splitedNum;
    }

    public int run() {
        checkDelimiter();
        splitString();
        return addNum();
    }

    private void checkDelimiter() {
        Parser parser = new Parser(input);
        Optional<String> customDelimiter = parser.getCustomDelimiter();
        customDelimiter.ifPresent(cd -> {
            delimiters += cd;
            input = parser.getContent();
        });
    }

    private void splitString() {
        splitedNum = this.input.split(String.format("[%s]", delimiters));
        for (String s : splitedNum) {
            checkInvalidInput(s);
        }
    }

    private void checkInvalidInput(String s) {
        Matcher m = Pattern.compile("(\\d*)").matcher(s);
        if (!m.matches()) {
            throw new RuntimeException("0부터 9 사이의 수만 입력할 수 있습니다.");
        }
    }

    private int addNum() {
        return Arrays.stream(splitedNum)
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue)
                .sum();
    }
}