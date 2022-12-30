package stringadder;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import stringutils.StringUtils;

public class StringAdder {

    public static final String PRIMITIVE_DELIMITER = ",|;";

    public int add(String text) {
        if (StringUtils.checkNullOrBlankReturnBoolean(text)) {
            return StringAdderConstant.IS_NULL_OR_BLANK;
        }
        List<Integer> numbers = stringToInts(split(text));
        isValid(numbers);
        return sum(numbers);
    }


    private DelimiterAndText getDelimiterAndText(String text) {
        StringBuilder stringBuilder = new StringBuilder(PRIMITIVE_DELIMITER);
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            stringBuilder.append("|").append(m.group(1));
            return new DelimiterAndText(stringBuilder.toString(), m.group(2));
        }
        return new DelimiterAndText(stringBuilder.toString(), text);

    }

    public String[] split(String text) {
        DelimiterAndText delimiterAndText = getDelimiterAndText(text);
        return delimiterAndText.getText().split(delimiterAndText.getDelimiter());
    }

    public void isValid(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 0)) {
            throw new RuntimeException("negative value");
        }
    }

    private Integer parseInt(String number) {
        if (StringUtils.checkNullOrBlankReturnBoolean(number)) {
            return 0;
        }
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 입력되어야 합니다.");
        }
    }

    public List<Integer> stringToInts(String[] numbers) {
        return Arrays.stream(numbers).map(this::parseInt).collect(Collectors.toList());
    }

    public int sum(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }


}
