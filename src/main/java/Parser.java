import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private final List<String> delimiters = new ArrayList<>(Arrays.asList(",", ":"));

    private final String equation;

    public Parser(String inputString) {
        inputString = emptyNull(inputString);
        String customDelimiter = extractCustomDelimiter(inputString);
        Optional.ofNullable(customDelimiter).map(delimiters::add);
        this.equation = inputString;
    }

    public String[] parse() {
        return separateByDelimiter(extractPureEquation(equation));
    }

    private String emptyNull(String inputString) {
        if (inputString == null) {
            return "0";
        }
        if (inputString.length() == 0) {
            return "0";
        }
        return inputString;
    }

    private String[] separateByDelimiter(String equation) {
        String regex = String.join("|", delimiters);
        return equation.split(regex);
    }

    private String extractCustomDelimiter(String inputString) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputString);
        if (m.find()) {
            return m.group(1);
        }
        return null;
    }

    private String extractPureEquation(String inputString) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputString);
        if (m.find()) {
            return m.group(2);
        }
        return inputString;
    }
}
