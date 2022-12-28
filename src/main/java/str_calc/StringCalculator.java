package str_calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    static final List<String> defaultDelimiters = List.of(",", ":");
    static final String REGEX_DELIMITER = "//(.)\n(.*)";
    private final List<String> delimiters;

    public StringCalculator() {
        this.delimiters = new ArrayList<>(StringCalculator.defaultDelimiters);
    }

    public void addDelimiter(String delimiter) {
        this.delimiters.add(delimiter);
    }

    public String extractDelimiter(String text) {
        Matcher m = Pattern.compile(StringCalculator.REGEX_DELIMITER).matcher(text);
        if (m.find()) {
            this.addDelimiter(m.group(1));
            return m.group(2);
        }
        return text;
    }

    public List<String> splitText(String text) {
        return Arrays.asList(text.split(String.join("|",delimiters)));
    }

    public int toInt(String token) {
        if("".equals(token) || token==null){
            return 0;
        }
        int intValue = Integer.parseInt(token);
        if(intValue<0) throw new RuntimeException("음수를 입력할 수 없습니다.");
        return  intValue;
    }

    public List<Integer> toIntList(String text) {
        List<Integer> intList = new ArrayList<>();
        for (String token : this.splitText(text)) {
            intList.add(toInt(token));
        }
        return intList;
    }

    public int sum(List<Integer> intList) {
        int sum = 0;
        for (int elem : intList) {
            sum += elem;
        }
        return sum;
    }

    public int sum(String text) {
        return this.sum(this.toIntList(text));
    }
}
