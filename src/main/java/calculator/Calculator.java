package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public List<Integer> numbers;
    private String text;
    private String delimiters;

    public Calculator(String text) {
        this.numbers = new ArrayList<>();
        this.text = text;
        delimiters = "[,:]";
    }

    public void setDelimiters(String delimiters) {
        this.delimiters = delimiters;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int run() throws RuntimeException {
        if (isEmptyOrNull()) {
            return 0;
        }
        if (doesEndWithNumber()) {
            throw new RuntimeException();
        }

        handleCustomDelimiter();
        splitText();

        return addIntegerElements();
    }

    private boolean doesEndWithNumber() {
        return '0' > text.charAt(text.length() - 1) || text.charAt(text.length() - 1) > '9';
    }

    private int toIntegerIfPositive(String possibleNumber) throws RuntimeException {
        int number = Integer.parseInt(possibleNumber);

        if (number < 0) {
            throw new RuntimeException();
        }

        return number;
    }

    public boolean isEmptyOrNull() {
        return text == null || text.equals("");
    }

    public void splitText() {
        String[] numbers = this.text.split(this.delimiters);

        Arrays.stream(numbers).forEach(e -> this.numbers.add(toIntegerIfPositive(e)));
    }

    public Matcher checkCustomDelimiter() {
        Matcher m = Pattern.compile("^//(.)\n(.*)").matcher(text);

        if (!m.find()) {
            return null;
        }
        return m;
    }

    public void handleCustomDelimiter() {
        Matcher m = checkCustomDelimiter();

        if (m != null) {
            setDelimiters(buildDelimiters(m.group(1)));
            setText(m.group(2));
        }
    }

    public static String buildDelimiters(String customDelimiter) {
        return "[,:" + customDelimiter + "]";
    }

    public int addIntegerElements() {
        return this.numbers.stream().reduce(0, Integer::sum);
    }
}
