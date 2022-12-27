package calculator.domain;

import calculator.constant.MessageConstant;
import calculator.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.util.StringUtils.isEmpty;

public class Prompt {
    private String input;
    private final Delimiters delimiters;

    public Prompt(String input) {
        this.input = input.replaceAll(" ", "");
        this.delimiters = new Delimiters();
    }

    public boolean isEmptyInput() {
        return isEmpty(input);
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
        delimiters.add(matcher.group(1));
    }

    public String getDelimiterRegex() {
        return delimiters.getRegex();
    }

    public String[] getStringNumbers() {
        return input.split(getDelimiterRegex());
    }
}
