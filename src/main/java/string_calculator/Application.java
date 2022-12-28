package string_calculator;

import string_calculator.model.Calculator;
import string_calculator.model.Parser;
import string_calculator.model.Validator;

public class Application {
    public static void main(String[] args) {
        String testString =  "//:\n9:2,-8,4";

        Parser parser = new Parser(testString);
        String[] parseResult = parser.parse();

        Validator.validate(parseResult);

        Calculator calc = new Calculator();
        int result = calc.sumAll(parseResult);

        System.out.println(result);
    }
}
