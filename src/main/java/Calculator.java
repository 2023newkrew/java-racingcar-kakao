import java.util.Objects;

public class Calculator {
    public Integer calc(String inputstring) {
        if (Objects.equals(inputstring, "") || inputstring == null) {
            return 0;
        }

        String[] numbers = inputstring.split(",");
        return stringArraySum(numbers);
    }

    public int stringArraySum(String[] stringArray) {
        int sum = 0;
        for (String number : stringArray) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
