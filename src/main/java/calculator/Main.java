package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println("계산식을 입력하세요");
        String input = br.readLine();
        Calculator calculator = new Calculator(input);
        System.out.println("= " + calculator.run());
    }
}