package calculator.domain;

import java.util.regex.Matcher;
public class Prompt {
    private final Input input;
    private final Delimiters delimiters;

    public Prompt(String input) {
        this.input = new Input(input);
        this.delimiters = new Delimiters();
    }

    public boolean isEmptyInput() {
        return input.isEmpty();
    }

    public void changePromptIfExistCustomDelimiter() {
        Matcher matcher = input.getMatcher();
        if(isExistCustomDelimiter(matcher)) {
            input.change(matcher.group(2));
            delimiters.add(new Delimiter(matcher.group(1)));
        }
    }

    private boolean isExistCustomDelimiter(Matcher matcher) {
        return matcher.find();
    }

    public String[] getParsedStringNumbers() {
        return input.split(delimiters.getRegex());
    }
}
