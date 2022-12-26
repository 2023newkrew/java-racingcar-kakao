import java.util.Arrays;
import java.util.Scanner;

public class CalculatorRunner {
    private StringParser parser;

    public CalculatorRunner(StringParser parser) {
        this.parser = parser;
    }

    public void run() {
        String input = receiveInput();
        Integer result;
        try {
            result = calculate(input);
        } catch(RuntimeException e) {
            System.out.println(e.getLocalizedMessage());
            return;
        }
        printResult(result);
    }

    private String receiveInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("문자열을 입력해주세요.");
        return sc.nextLine();
    }

    private Integer calculate(String input) {
        Character splitter = parser.parseSplitter(input);
        String targetString = parser.parseTargetString(input);
        String[] targetStringArray = parser.splitTargetString(targetString, splitter);
        Integer[] targetIntegerArray =Arrays.stream(targetStringArray)
                    .map(parser::castStringToInteger)
                    .toArray(Integer[]::new);
        return Calculator.add(targetIntegerArray);
    }

    private void printResult(Integer result) {
        System.out.printf("Result : %d\n", result);
    }

}
