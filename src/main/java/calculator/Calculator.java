package calculator;

import java.util.Objects;

public class Calculator {

    StringParser stringParser;

    public Calculator(StringParser stringParser) {
        this.stringParser = stringParser;
    }

    public Integer calc(String inputString) {
        /*
        System.out.println("Before");
        if (Objects.equals(null, "")) System.out.println("OK");     // 이건 잘 돌아가는데
        System.out.println("After");
        if (Objects.equals(inputString, "")) {      // 이건 Test에서 inputString에 null을 보내도 NPE가 납니다.
            return 0;
        }
        */
        if (Objects.equals("", inputString) || Objects.isNull(inputString)) {
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
