package str_calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private List<String> seperators;

    public StringCalculator() {
        this.seperators = new ArrayList<>();
        this.seperators.add(",");
        this.seperators.add(":");
    }

    public List<String> splitText(String text) {
        return Arrays.asList(text.split(String.join("|",seperators)));
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

    public int sumIntList(List<Integer> intList) {
        int sum = 0;
        for (int elem : intList) {
            sum += elem;
        }
        return sum;
    }

    public int sumText(String text) {
        return this.sumIntList(this.toIntList(text));
    }

    public void addSeperator(String seperator) {
        this.seperators.add(seperator);
    }

    public String extractSeperator(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            this.addSeperator(m.group(1));
            return m.group(2);
        }
        return text;
    }
}
