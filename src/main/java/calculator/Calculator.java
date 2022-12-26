package calculator;

import java.util.List;

public class Calculator {
    private final Splitter splitter;

    public Calculator(){
        this.splitter = new Splitter();
    }
    public Integer calculate(String expression) {
        if (expression.isBlank()){
            return 0;
        }
        if (expression.length() == 1 && Character.isDigit(expression.charAt(0))){
            return Integer.parseInt(expression);
        }

        return calcSum(splitter.split(expression));
    }

    private Integer calcSum(List<Integer> numbers){
        return numbers.stream().reduce(0, Integer::sum);
    }

}
