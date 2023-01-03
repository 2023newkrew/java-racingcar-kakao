package racingcar.controller;

import racingcar.model.Racing;
import racingcar.dto.InputDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    public RacingController() {
        Racing racing = settings();

        while (!racing.isEnd()) {
            racing.round();
            printRoundResult(racing);
        }
        printWinnerResult(racing);
    }
    private Racing settings() { // 게임에 필요한 정보를 받아오고, 레이싱 객체를 생성한다
        InputDto inputDto = InputView.creatInput();

        List<String> carNames = inputDto.getCarNames();
        int roundNum = inputDto.getRoundNum();

        return new Racing(carNames, roundNum);
    }

    private void printRoundResult(Racing racing) { //라운드 진행 후, 결과를 출력한다
        OutputView.printRoundResult(racing.returnCarState().getCarState());
    }

    private void printWinnerResult(Racing racing) { //우승자를 출력한다
        OutputView.printWinner(racing.returnWinners().getWinners());
    }

}