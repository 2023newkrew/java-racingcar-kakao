package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Splitter {
    public List<Integer> split(String expression){
        Matcher m = Pattern.compile("//(.*)\n(.*)").matcher(expression);
        String customDelimiter = "";
        String delimiters;

        if (m.find()) {
            expression = expression.split("\n")[1];
            customDelimiter = m.group(1);
        }

        delimiters = "[,;" + customDelimiter + "]";

        return expressionToNumbers(expression, delimiters);
    }

    private List<Integer> expressionToNumbers(String expression, String delimiters){
        try{
            return Arrays.stream(expression.split(delimiters))
                    .mapToInt(e -> Integer.parseInt(e.trim()))
                    .boxed()
                    .collect(Collectors.toList());
        }catch (NumberFormatException numberFormatException){
            throw new RuntimeException("숫자가 아닌 문자가 포함되어있습니다.");
        }
    }
}
