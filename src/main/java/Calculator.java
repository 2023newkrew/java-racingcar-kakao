import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    StringUtil stringUtil;

    public Calculator(StringUtil stringUtil) {
        this.stringUtil = stringUtil;
    }

    public Integer calc(String inputstring) {
        if (Objects.equals(inputstring, "") || inputstring == null) {
            return 0;
        }

        Matcher m = Pattern.compile("//(.+)\n(.*)").matcher(inputstring);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] numbers = stringUtil.split(m.group(2), customDelimiter);
            return stringArraySum(numbers);
        }
        String[] numbers = stringUtil.split(inputstring);

        return stringArraySum(numbers);
    }

    public int stringArraySum(String[] stringArray) {
        int sum = 0;
        for (String number : stringArray) {
            int temp = Integer.parseInt(number);
            checkNegative(temp);
            sum += temp;
        }
        return sum;
    }

    public void checkNegative(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }
}
