package racingcar.view;

import racingcar.dto.InputDto;
import racingcar.utils.Parser;
import racingcar.utils.Validate;

import java.util.Scanner;
import java.util.List;

public class InputView {

    private static List<String> inputCarNames() { //사용자의 입력을 받는다(자동차 이름)
        Scanner sc = new Scanner(System.in);
        String nameInput;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            nameInput = sc.nextLine();
        } while (!Validate.validateCarNames(nameInput));
        return Parser.stringArrayToStringList(nameInput.split(","));
    }

    private static int inputRoundNum() { //사용자의 입력을 받는다(라운드 횟수)
        Scanner sc = new Scanner(System.in);
        String roundNumInput;
        do {
            System.out.println("시도할 회수는 몇회인가요?");
            roundNumInput = sc.nextLine();
        } while (!Validate.validateRoundNumber(roundNumInput));
        return Parser.stringToInt(roundNumInput);
    }

    public static InputDto creatInput() { //입력받는 메서드를 호출하고, dto를 리턴한다
        List<String> carNames = inputCarNames();
        int roundNum = inputRoundNum();
        return new InputDto(carNames, roundNum);
    }
}