package racingcar.step2.view;

import java.util.Scanner;

public class RacingInputView {

    private final Scanner scanner;

    public RacingInputView(){
        this(new Scanner(System.in));
    }

    public RacingInputView(Scanner scanner){
        this.scanner = scanner;
    }
    public String getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public int getTryNo(){
        System.out.println("시도할 횟수는 몇회인가요?");
        return isNumeric(scanner.nextLine());
    }


    public int isNumeric(String turn) {
        int num;
        try {
            num = Integer.parseInt(turn);
        } catch (NumberFormatException e){
            throw new RuntimeException("턴 횟수는 숫자로 입력해야 합니다.");
        }
        if (num < 0){
            throw new RuntimeException("턴 횟수는 음수이면 안됩니다.");
        }
        return num;
    }

}
