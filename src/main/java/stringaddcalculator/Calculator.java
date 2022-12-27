package stringaddcalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Calculator {

    private String[] tokens;

    public Calculator(String[] tokens) {
        this.tokens = tokens;
    }

    public int cal() {
        int sum = 0;

        isInteger();

        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }

        return sum;
    }

    public void isInteger() {
        for (int i = 0; i < tokens.length ; i++) {
            isNumeric(tokens, i);
        }
    }

    private void isNumeric(String[] tokens, int index) {
        int num;
        if(Objects.equals(tokens[index], "")){
            tokens[index] = "0";
        }
        try {
            num = Integer.parseInt(tokens[index]);
        } catch (NumberFormatException e){
            System.out.println((index + 1) + "번째 인자 : " + tokens[index] + "은 숫자가 아닙니다.");
            throw new RuntimeException();
        }
        if (num < 0){
            System.out.println((index + 1) + "번째 인자 : " + tokens[index] + "은 음수 입니.");
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws IOException {

        while (!stringAddCalculator()) {}

    }

    public static boolean stringAddCalculator() throws IOException {
        String[] str_arr;
        str_arr = stringToSplit(StringInput());
        Calculator calculator = new Calculator(str_arr);
        try {
            System.out.println(calculator.cal());
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public static String StringInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text;
        System.out.print("Enter positive integer : ");
        text = reader.readLine().replace("\\n","\n");
        return text;
    }
    public static String[] stringToSplit(String text){
        String[] str_arr;
        String split = ",|;";

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            split += "|" + m.group(1);
            text = m.group(2);
        }

        str_arr = text.split(split);
        return str_arr;
    }
}
