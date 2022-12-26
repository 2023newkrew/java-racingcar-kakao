package calculator;

public class Calculator {
    public Integer calculate(String expression) {
        if (expression.isBlank()){
            return 0;
        }
        if (expression.length() == 1 && Character.isDigit(expression.charAt(0))){
            return Integer.parseInt(expression);
        }

        return 1;
    }

}
