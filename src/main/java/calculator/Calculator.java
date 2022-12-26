package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
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
        checkEmptyInput();
        checkDelimiter();
        splitString();
        return addNum();
    }

    private void checkEmptyInput() {
        if (input == null || input.isEmpty()) {
            input = "0";
        }
    }

    private void splitString() {
        splitedNum = this.input.split("[,:]");
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

    private void checkDelimiter() {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            input = m.group(2);
            replaceDelimiter(customDelimiter);
        }
    }

    private void replaceDelimiter(String delimiter) {
        input = input.replace(delimiter, ",");
    }

    private int addNum() {
        return Arrays.stream(splitedNum)
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue)
                .sum();
    }
}