package string_add_calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Calculator {

    private String[] tokens;

    public Calculator(String[] tokens) {
        this.tokens = tokens;
    }

    public int cal() {
        int sum = 0;

        isInteger();

        for (String token : tokens) {
            sum += parseInt(token);
        }

        return sum;
    }

    public void isInteger() {
        for (String token : tokens) {
            isNumeric(token);
        }
    }

    private void isNumeric(String token) {
        int num;
        try {
            num = Integer.parseInt(token);
        } catch (NumberFormatException e){
            throw new RuntimeException();
        }
        if (num < 0){
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws IOException {
        String text;
        String[] str_arr;

        System.out.print("Enter positive integer : ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        text = reader.readLine().replace("\\n","\n");

        str_arr = text.split(",|;");
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            str_arr = m.group(2).split(customDelimiter);
        }
        if (str_arr[0].isEmpty()){
            System.out.println(0);
            return;
        }
        Calculator calculator = new Calculator(str_arr);
        System.out.println(calculator.cal());
    }
}
