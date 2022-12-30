package addcal;

import java.util.Scanner;

public class Calculator {
    public AddCal addCal;

    public String CalculatorInput() { //사용자 입력을 받는다
        // 스캐너에서 받기
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

    public void CalculatorOutput() {
        addCal.printResult();
        System.out.println("End");
    }

    public boolean Run(String input) { //addCal객체에 입력을 전달하고, 실행 결과 1, 0 //계산결과도 반환한다.
        //String input = CalculatorInput();
        addCal = new AddCal(input);
        addCal.Add();
        CalculatorOutput();
        return true; //이따 해야함
        //결과반환해서 리턴해주기
    }

    private Boolean inputValid(String input) {
        //자세한 구현은 나중에
        return false;
    }

    //사용자 입력이 유효한 문자열인지 확인?하는 함수
}