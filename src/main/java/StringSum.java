import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSum {

    private String formula;
    private String delimiter;

    public StringSum(String formula) {
        this.formula = formula;
        delimiter = ",|:";
    }

    public String customDelimiter() {
        // java.util.regex 패키지의 Matcher, Pattern import
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(formula);
        String customDelimiter = null;
        if (m.find()) {
            customDelimiter = m.group(1);
            formula =  m.group(2);
            delimiter += "|" + customDelimiter;
        }
        return customDelimiter;
    }

    public String[] splitByDelimiter() {
        String[] tokens = formula.split(delimiter);
        return tokens;
    }

    public Integer stringToInteger(String s) throws RuntimeException {
        Integer num = Integer.parseInt(s);
        if (num < 0) {
            throw new RuntimeException();
        }
        return num;
    }
}
