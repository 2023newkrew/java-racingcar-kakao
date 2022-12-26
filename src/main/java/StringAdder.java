import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAdder {
    public int add(String text) {
        int result = -1;
        if (isNullOrBlank(text)) {
            return 0;
        }
        try {
            String[] numbers = split(text);
            result = summation(numbers);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            throw e;
        }
        return result;
    }

    public boolean isNullOrBlank(String text) {
        return text == null || text.isBlank();
    }


    public String[] split(String text) {
        StringBuilder stringBuilder = new StringBuilder(",|;");
        String customDelimiter = null;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            customDelimiter = m.group(1);
            stringBuilder.append("|" + customDelimiter);
            return m.group(2).split(stringBuilder.toString());
        }
        return text.split(stringBuilder.toString());
    }

    public void isValid(String[] numbers) {
        if (Arrays.stream(numbers).anyMatch(number -> Integer.parseInt(number) < 0)) {
            throw new RuntimeException("negative");
        }
    }

    public int summation(String[] numbers) {
        return Arrays.stream(numbers).map(Integer::parseInt).reduce(0, Integer::sum);
    }
}
