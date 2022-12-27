package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final String DELIMITER_REGEX = "//(.)\n(.*)";

    private final List<String> delimiters = new ArrayList<>(Arrays.asList(",", ":"));

    private final String equation;

    public Parser(String inputString) {
        inputString = checkNullOrEmpty(inputString);
        String customDelimiter = extractCustomDelimiter(inputString);
        Optional.ofNullable(customDelimiter).map(delimiters::add);
        this.equation = inputString;
    }

    public String[] parse() {
        return separateByDelimiter(extractPureEquation(equation));
    }

    private String checkNullOrEmpty(String inputString) {

        return inputString == null || inputString.isEmpty() ? "0" : inputString;
    }

    private String[] separateByDelimiter(String equation) {
        String regex = String.join("|", delimiters);

        return equation.split(regex);
    }

    private String extractCustomDelimiter(String inputString) {
        Matcher m = Pattern.compile(DELIMITER_REGEX).matcher(inputString);

        return m.find() ? m.group(1) : null;
    }

    private String extractPureEquation(String inputString) {
        Matcher m = Pattern.compile(DELIMITER_REGEX).matcher(inputString);

        return m.find() ? m.group(2) : inputString;
    }
}
