import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

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

    public int[] stringsToIntegers(String[] s) {
        int[] integers = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            integers[i] = stringToInteger(s[i]);
        }
        return integers;
    }

    public int summation(int[] numbers) {
        int numbersSum = Arrays.stream(numbers).sum();
        return numbersSum;
    }

    public int calculate() {
        customDelimiter();
        String tokens[] = splitByDelimiter();
        int numbers[] = stringsToIntegers(tokens);
        return summation(numbers);
    }
}
