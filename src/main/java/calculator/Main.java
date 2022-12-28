package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("계산식을 입력하세요");
        String input = br.readLine();
        if (input == null || input.isBlank()) {
            System.out.println("= 0");
            return;
        }

        Calculator calculator = new Calculator(input);
        System.out.println("= " + calculator.run());
    }
}