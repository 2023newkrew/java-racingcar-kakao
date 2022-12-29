package calculator;

import java.util.List;

public class Calculator {
    private final Splitter splitter;
    private final Validator validator;

    public Calculator(){
        this.splitter = new Splitter();
        this.validator = new Validator();
    }

    public Integer calculate(String expression) {
        if (expression.isBlank()){
            return 0;
        }
        if (validator.isOneNumber(expression)){
            return Integer.parseInt(expression);
        }

        return calcSum(splitter.split(expression));
    }

    private Integer calcSum(List<Integer> numbers){
        return numbers.stream().reduce(0, Integer::sum);
    }
}
