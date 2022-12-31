package calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("문자열을 입력하세요: ");

        String input = scanner.nextLine();
        NumberParser numberParser = new NumberParser(input, generateDefaultDelimiters());

        numberParser.parseNumbersStr();
        int[] intArr = numberParser.convertParsedNumbersToIntArr();
        int result = Adder.run(intArr);

        System.out.println("결과: " + result);

    }

    private static ArrayList<String> generateDefaultDelimiters() {
        ArrayList<String> delimiters = new ArrayList<>();

        delimiters.add(",");
        delimiters.add(";");

        return delimiters;
    }
}
