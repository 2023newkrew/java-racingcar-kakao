package str_calc;

import java.util.Scanner;

public class IOView {
    private Scanner scanner;

    public IOView() {
        this.scanner = new Scanner(System.in);
    }

    public String inputText() {
        System.out.print("텍스트를 입력해주세요 : ");
        String text = scanner.nextLine();
        if(text.matches("//.*")) {
            text += "\n";
            text += scanner.nextLine();
        }
        return text;
    }

    public void printSum(int sum) {
        System.out.println("결과 : " + sum);
    }
}
