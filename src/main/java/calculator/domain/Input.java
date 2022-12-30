package calculator.domain;

import calculator.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
    String input;
    public Input(String input) {
        this.input = input;
    }
    public boolean isEmpty() {
        return StringUtils.isEmpty(input);
    }

    public void change(String newValue) {
        input = newValue;
    }

    public Matcher getMatcher() {
        return Pattern.compile("//(.)\n(.*)").matcher(input);
    }

    public String[] split(String regex) {
        return input.split(regex);
    }
}
