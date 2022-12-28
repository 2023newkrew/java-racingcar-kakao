package StringCalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSum {

    private String formula;
    private String delimiter;

    public StringSum(String formula) {
        this.formula = formula;
        delimiter = ",|:";
    }

    public boolean textException(String inputString) {
        if(inputString == null) return true;
        if(inputString.isEmpty()) return true;
        return false;
    }

    public String customDelimiter() {
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

    public Integer stringToInteger(String element) {
        Integer num;
        try {
            num = Integer.parseInt(element);
        } catch (RuntimeException e) {
            throw new RuntimeException("숫자를 입력해주세요.");
        }
        if (num < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return num;
    }

    public int[] stringsToIntegers(String[] input) {
        int[] integers = new int[input.length];
        for (int index = 0; index < input.length; index++) {
            integers[index] = stringToInteger(input[index]);
        }
        return integers;
    }

    public int summation(int[] numbers) {
        int numbersSum = Arrays.stream(numbers).sum();
        return numbersSum;
    }

    public int calculate() {
        if(textException(formula)) {
            return 0;
        }
        customDelimiter();
        String tokens[] = splitByDelimiter();
        int numbers[] = stringsToIntegers(tokens);
        return summation(numbers);
    }
}
