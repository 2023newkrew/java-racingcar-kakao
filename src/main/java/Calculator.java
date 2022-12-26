import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private String text;
    public Calculator(String text) {
        this.text = text;
    }

    public int run() throws RuntimeException {
        if(this.isEmptyOrNull()) return 0;
        List<Integer> arr = splitText();

        return arr.get(0);
    }

    private int toInteger (String possibleNumber) throws RuntimeException {
        try {
            int number = Integer.parseInt(possibleNumber);

            if(number<0) throw new RuntimeException();

            return number;
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }

    public boolean isEmptyOrNull() {
        return text==null || text.equals("");
    }

    public List<Integer> splitText() {
        String[] numbers = this.text.split("[,:]");
        List<Integer> arr = new ArrayList<>();

        Arrays.stream(numbers).forEach(e-> arr.add(toInteger(e)));

        return arr;
    }

    public String getCustomDelimiter() {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

        if(!m.find()) return null;
        return m.group(1);
    }


    public static String buildDelimiters(String customDelimiter) {
        StringBuilder delimiters = new StringBuilder();

        delimiters.append("[,:");

        if(customDelimiter != null) {
            delimiters.append(customDelimiter);
        }

        delimiters.append("]");
        return delimiters.toString();
    }
}
