package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.constant.MessageConstant.*;
import static java.lang.Character.isDigit;

public class Prompt {

    private String input;
    private Delimiters delimiters;

    public Prompt(String input) {
        this.input = input.replaceAll(" ", "");
        this.delimiters = new Delimiters();
    }

    public boolean isEmptyInput() {
        return input.isBlank() || input == null;
    }

    public void changePromptIfExistCustomDelimiter() {
        Matcher matcher = getMatcher();
        if(isExistCustomDelimiter(matcher)) {
            changeInput(matcher);
            addDelimiter(matcher);
        }
    }

    private boolean isExistCustomDelimiter(Matcher matcher) {
        return matcher.find();
    }


    private Matcher getMatcher() {
        return Pattern.compile("//(.)\n(.*)").matcher(input);
    }

    private void changeInput(Matcher matcher) {
        input = matcher.group(2);
    }

    private void addDelimiter(Matcher matcher) {
        String group = matcher.group(1);
        validateDelimiter(group);
        delimiters.add(matcher.group(1));
    }

    private  void validateDelimiter(String group) {
        if (group.length() > 1) {
            throw new RuntimeException(DELIMITER_LENGTH_EXCEPTION);
        }
        if (isDigit(group.charAt(0))) {
            throw new RuntimeException(DELIMITER_FORMAT_EXCEPTION);
        }
    }

    public String getDelimiterRegex() {
        return delimiters.getRegex();
    }

    public String[] getStringNumbers() {
        return input.split(getDelimiterRegex());
    }
}
