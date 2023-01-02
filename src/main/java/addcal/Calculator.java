package addcal;

import java.util.Scanner;

public class Calculator {
    public AddCal addCal;

    public String getCalculatorInput() {
        System.out.println("입력하세요: ");
        Scanner sc = new Scanner(System.in);
        String input = "";

        do {
            input = sc.nextLine();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (inputValid(input));
        return input;
    }

    public void printCalculatorOutput() {
        addCal.printResult();
        System.out.println("End");
    }

    public boolean run(String input) {
        addCal = new AddCal(input);
        addCal.add();
        printCalculatorOutput();
        return true;
    }

    private Boolean inputValid(String input) {
        return false;
    }

}
