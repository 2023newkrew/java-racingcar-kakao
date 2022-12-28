package calculator;

import java.util.Objects;

public class Calculator {

    StringParser stringParser;

    public Calculator(StringParser stringParser) {
        this.stringParser = stringParser;
    }

    public Integer calc(String inputstring) {
        if (Objects.equals("", inputstring) || Objects.isNull(inputstring)) {
            return 0;
        }

        return stringArraySum(stringParser.toStringArray(inputstring));
    }

    public int stringArraySum(String[] stringArray) {
        int sum = 0;
        for (String number : stringArray) {
            sum += stringParser.parseInt(number);
        }
        return sum;
    }

}
