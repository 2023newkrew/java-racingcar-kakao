package stringAdder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringProcessor stringProcessor = new StringProcessor(input);
        StringProcessResult stringProcessResult = stringProcessor.getStringProcessResult();
        int[] numbers = stringProcessResult.split();
        System.out.printf("결과: %d\n", NumAdder.add(numbers));
    }
}
