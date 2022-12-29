package stringadder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("계산식을 입력하세요: ");
        String input = sc.nextLine();
        StringProcessor stringProcessor = new StringProcessor(input);
        int[] numbers = stringProcessor.getStringProcessResult().split();
        System.out.printf("결과: %d\n", NumAdder.add(numbers));
    }
}
