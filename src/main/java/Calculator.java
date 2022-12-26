import java.text.ParseException;
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

    public int run() throws RuntimeException {
        if (this.isEmptyOrNull()) return 0;

        setDelimiters(buildDelimiters(getCustomDelimiter()));

        splitText();

        return addIntegerElements();
    }

    private int toInteger(String possibleNumber) throws RuntimeException {
        try {
            int number = Integer.parseInt(possibleNumber);

            if (number < 0) throw new RuntimeException();

            return number;
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }

    public boolean isEmptyOrNull() {
        return text == null || text.equals("");
    }

    public void splitText() {
        String[] numbers = this.text.split(this.delimiters);

        Arrays.stream(numbers).forEach(e -> this.numbers.add(toInteger(e)));
    }

    public String getCustomDelimiter() {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (!m.find()) return null;
        this.text = m.group(2);
        return m.group(1);
    }


    public static String buildDelimiters(String customDelimiter) {
        StringBuilder delimiters = new StringBuilder();

        delimiters.append("[,:");

        if (customDelimiter != null) {
            delimiters.append(customDelimiter);
        }

        delimiters.append("]");

        return delimiters.toString();
    }

    public int addIntegerElements() {
        return this.numbers.stream().reduce(0, Integer::sum);
    }
}
