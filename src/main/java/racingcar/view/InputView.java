/**
 * 사용자의 입력을 받아 검증하고, 형태를 바꿔서 반환한다
 * 게임의 결과를 출력한다
 */
package racingcar.view;

import racingcar.utils.Parser;
import racingcar.utils.Validate;

import java.util.Scanner;
import java.util.List;

public class InputView {

    public static List<String> inputCarNames() {
        Scanner sc = new Scanner(System.in);
        String nameInput;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            nameInput = sc.nextLine();
        } while (!Validate.validateCarNames(nameInput));
        return Parser.stringArrayToStringList(nameInput.split(","));
    }

    public static int inputRoundNum() {
        Scanner sc = new Scanner(System.in);
        String roundNumInput;
        do {
            System.out.println("시도할 회수는 몇회인가요?");
            roundNumInput = sc.nextLine();
        } while (!Validate.validateRoundNumber(roundNumInput));
        return Parser.stringToInt(roundNumInput);
    }

}