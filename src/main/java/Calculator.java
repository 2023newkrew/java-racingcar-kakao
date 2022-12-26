import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private final List<String> delimiters = Arrays.asList(",", ":");
    private final String equation;


    public Calculator(String equation) {
        String customDelimiter = separateCustomDelimiter(equation);
        Optional.ofNullable(customDelimiter).map(delimiters::add);

        this.equation = separatePureEquation(equation);
    }

    public String[] separate(String testString) {
        String[] tokens = testString.split(",|:");
        return tokens;
    }

    private String separateCustomDelimiter(String equation) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(equation);
        if (m.find()) {
            return m.group(1);
        }
        return null;
    }

    private String separatePureEquation(String equation) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(equation);
        if (m.find()) {
            return m.group(2);
        }
        return equation;
    }
}
