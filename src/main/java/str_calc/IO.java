package str_calc;

import java.util.Scanner;

public class IO {
    private Scanner scanner;

    public IO() {
        this.scanner = new Scanner(System.in);
    }

    public String inputText() {
        final String REGEX_DELIMITER = "//.";
        System.out.print("텍스트를 입력해주세요 : ");
        String text = scanner.nextLine();
        if(text.matches(REGEX_DELIMITER)) {
            text += "\n";
            text += scanner.nextLine();
        }
        return text;
    }

    public void printSum(int sum) {
        System.out.println("결과 : " + sum);
    }
}
