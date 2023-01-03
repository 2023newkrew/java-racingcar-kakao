/*
사용자의 입력을 가장 처음 받는 것이 여기임
뷰는.. 모델이 변화되었을 때 보여주는 것만 기능하고..

모델: 레이싱 객체를 가진다.
뷰: 레이싱 상태가 변경될 때 마다 화면에 출력하는 역할을 한다.
컨트롤러: 입력에 대한 응답으로 모델 이나 뷰를 업데이트 한다.

 */
package racingcar.controller;

import racingcar.model.Racing;
import racingcar.dto.InputDto;
import racingcar.utils.Utils;
import racingcar.utils.Validate;
import racingcar.view.View;

import java.util.List;
import java.util.Scanner;

public class RacingController {
    private final Racing racing;
    private final View view;
    public RacingController() {
        view = new View();
        racing = settings();

        while (!racing.isEnd()) {
            racing.round();
            printRoundResult();
        }
        printWinnerResult();
    }
    private Racing settings() { //유저 입력을 받으며 게임 시작
        InputDto inputDto = creatInput();
        return new Racing(inputDto.getCarNames(), inputDto.getRoundNum());
    }

    private void printRoundResult() { //라운드 진행 후, 결과를 출력한다
        view.printRoundResult(racing.returnCarState().getCarState());
    }

    private void printWinnerResult() { //우승자를 출력한다
        view.printWinner(racing.returnWinners().getWinners());
    }

    private List<String> inputCarNames() { //사용자의 입력을 받는다(자동차 이름)
        Scanner sc = new Scanner(System.in);
        view.printInputNameMessage();
        String nameInput = sc.nextLine();

        while(!Validate.validateCarNames(nameInput)) {
            view.printLengthErrorMessage();
            nameInput = sc.nextLine();
        }

        return Utils.stringToStringList(nameInput);
    }

    private int inputRoundNum() { //사용자의 입력을 받는다(라운드 횟수)
        Scanner sc = new Scanner(System.in);
        view.printInputRoundNumberMessage();
        String roundNumInput = sc.nextLine();

        while(!Validate.validateCarNames(roundNumInput)) {
            view.printIntegerErrorMessage();
            roundNumInput = sc.nextLine();
        }
        return Utils.stringToInt(roundNumInput);
    }

    public InputDto creatInput() { //입력받는 메서드를 호출하고, dto를 리턴한다
        List<String> carNames = inputCarNames();
        int roundNum = inputRoundNum();
        return new InputDto(carNames, roundNum);
    }

}