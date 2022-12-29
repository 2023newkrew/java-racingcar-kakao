package calculator.domain;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Interpreter {


    public Command decode(String input) {
        if (isEmptyInput(input)) {
            return new Command("0");
        }
        return getParsingCommand(input);
    }

    public boolean isEmptyInput(String input) {
        return input.isBlank() || input == null;
    }



    private Command getParsingCommand(String input) {
        Matcher customDelimiterMatcher = getCustomDelimiterMatcher(input);
        if(customDelimiterMatcher.find()) {
            List<Character> delimiters = parsingDelimiters(customDelimiterMatcher);
            String stringNumbers = parsingStringNumbers(customDelimiterMatcher);
            return new Command(stringNumbers, delimiters);
        }
        return new Command(input);
    }


    private Matcher getCustomDelimiterMatcher(String input) {
        return Pattern.compile("//(.)\n(.*)").matcher(input);
    }

    private String parsingStringNumbers(Matcher matcher) {
        return matcher.group(2);
    }

    private List<Character> parsingDelimiters(Matcher matcher) {
        String delimiters = matcher.group(1);
        return delimiters.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.toList());
    }

}
