package calculator;

import java.util.Objects;

public class Calculator {

    StringParser stringParser;

    public Calculator(StringParser stringParser) {
        this.stringParser = stringParser;
    }

    public Integer calc(String inputString) {

        if (Objects.isNull(inputString) || Objects.equals(inputString, "")) {
            return 0;
        }

        return stringArraySum(stringParser.toStringArray(inputString));
    }

    public int stringArraySum(String[] stringArray) {
        int sum = 0;
        for (String number : stringArray) {
            sum += stringParser.parseInt(number);
        }
        return sum;
    }

}
