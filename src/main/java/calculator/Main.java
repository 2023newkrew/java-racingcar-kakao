package calculator;

import calculator.domain.Calculator;
import calculator.domain.Command;
import calculator.domain.Interpreter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Interpreter interpreter = new Interpreter();
        Scanner scanner = new Scanner(System.in);
        Command command = interpreter.decode(scanner.nextLine());
        System.out.println(calculator.calculate(command));
    }

}
