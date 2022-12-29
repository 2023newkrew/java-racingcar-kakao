package calculator.domain.calculator.prompt;

import calculator.constant.RegexConstant;
import calculator.util.RegexUtils;
import calculator.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.constant.RegexConstant.*;
import static calculator.util.RegexUtils.getMatcherForInput;

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

    public String[] split(String regex) {
        return input.split(regex);
    }

    public Matcher getMatcher() {
        return getMatcherForInput(ADD_CUSTOM_DELIMITER, input);
    }
}
