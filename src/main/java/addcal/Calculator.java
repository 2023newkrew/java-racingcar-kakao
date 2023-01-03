package addcal;

import java.util.Scanner;

public class Calculator {

    public String getCalculatorInput() {
        System.out.println("입력하세요: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void printCalculatorOutput(AddCal addCal) {
        addCal.printResult();
        System.out.println("End");
    }

}
