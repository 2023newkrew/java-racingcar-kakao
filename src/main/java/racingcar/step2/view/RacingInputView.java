package racingcar.step2.view;

import java.util.Scanner;

public class RacingInputView {
    public String getCarNames(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int getTryNo(){
        Scanner scanner = new Scanner(System.in);
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
